package common;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import oracle.jbo.server.DBTransaction;

import common.pojo.EmailRequestPojo;
import common.pojo.EmailTableDetailsPojo;

import java.io.BufferedInputStream;

import java.io.ByteArrayOutputStream;

import java.sql.Blob;

import java.util.ArrayList;

import javax.activation.DataHandler;

import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;


public class GenerateEmailTemplate {
    public GenerateEmailTemplate() {
        super();
    }

    private static String FROM_USER = "paas.user@salic.com";
    private static String FROM_USER_PASSWORD = "Salic@123";
    
    public static Map<String, Object> prepareEmailTemplate(EmailRequestPojo emailReq, DBTransaction dbTrans) {
        Map<String, Object> emailHapmap = new HashMap<String, Object>();
        Statement statement = dbTrans.createStatement(0);
        try {
            String message = null;

            ArrayList<EmailTableDetailsPojo> tableDetails = emailReq.getTableDetails();
            String emailSubject = emailReq.getSubject();
            String emailBody = "";

            if (tableDetails != null && tableDetails.size() > 0) {
                for (EmailTableDetailsPojo tableDetail : tableDetails) {
                    String linedetailsQuery = tableDetail.getDetailsQuery();
                    if (linedetailsQuery != null) {
                        ResultSet resultSet2 = statement.executeQuery("select count(*) from ("+linedetailsQuery+")");
                        int size= 0;
                        if (resultSet2 != null)   
                        { 
                            resultSet2.next();
                            size = resultSet2.getInt(1);
                        }
                        if(size == 0){
                            continue;
                        }
                    }
                    String tableLabel = tableDetail.getTableLabel();
                    emailBody = emailBody + (tableLabel != null ? "<b>"+tableLabel+"</b>" + "<br>" : "") + 
                        "<table style='width:800px;height:150px;border:2px solid black;font-size:14px;font-family:arial;border-collapse:collapse' border=1 ><tr style='background-color:#D6EAF8;'><th style='font-weight:bolder;'>Sr.#</th>";
                    for (String headerCol : tableDetail.getTableContentColumns()) {
                        emailBody = emailBody + "<th  style='font-weight:bolder'>" + headerCol + "</th>";
                    }
                    emailBody = emailBody + "</tr>";

                    if (linedetailsQuery != null) {
                        ResultSet resultSet1 = statement.executeQuery(linedetailsQuery);

                        int i = 1;
                        while (resultSet1.next()) {
                            emailBody += "<tr><td align='center'>" + i + "</td>";
                            for (Map.Entry<String, String> entry : tableDetail.getTableColumnDatatypes().entrySet()) {
                                if (entry.getValue() != null && "DATE".equalsIgnoreCase(entry.getValue())) {
                                    emailBody +=
                                        "<td align='center'>" +
                                        (resultSet1.getDate(entry.getKey()) != null ?
                                         resultSet1.getDate(entry.getKey()) : "") + "</td>";
                                } else if (entry.getValue() != null && "STRING".equalsIgnoreCase(entry.getValue())) {
                                    emailBody +=
                                        "<td align='center'>" +
                                        (resultSet1.getString(entry.getKey()) != null ?
                                         resultSet1.getString(entry.getKey()) : "") + "</td>";
                                } else if (entry.getValue() != null && "NUMBER".equalsIgnoreCase(entry.getValue())) {
                                    emailBody +=
                                        "<td align='center'>" +
                                        (resultSet1.getBigDecimal(entry.getKey()) != null ?
                                         resultSet1.getBigDecimal(entry.getKey()) : "") + "</td>";
                                }
                            }
                            emailBody += "</tr>";

                            i++;
                        }

                        emailBody = emailBody + "<br>" + "<br>" + "</table><br>";
                    }
                }
            }


            message = prepareStylizedBodyMessage(emailReq.getMessage(), emailReq.getToEmpName());


            String actionBody = prepareActionBodyMessage(emailReq.getActionButtons());
            
             ArrayList<MimeBodyPart> bodyParts = fetchAttachments(emailReq.getRequestId()+"", dbTrans);

            String bestRegardsmessage = "<br><br>Best Regards";

            String body = message + emailBody + actionBody + bestRegardsmessage;
            emailHapmap.put("subject", emailSubject);
            emailHapmap.put("body", body);
            emailHapmap.put("bodyParts", bodyParts);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emailHapmap;
    }

    public static void sendFromGMail(String[] to, String subject, String body, ArrayList<MimeBodyPart> bodyParts) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host","smtp.office365.com");
        props.put("mail.smtp.port", "587");
        
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_USER, FROM_USER_PASSWORD);
            }
        });

        try {

            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("from-email@gmail.com"));
            message.setFrom(new InternetAddress("paas.user@salic.com"));

            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setRecipients(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
//            message.setContent(body, "text/html");
            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
            if(bodyParts != null && bodyParts.size() > 0){
                for(MimeBodyPart bodyPart : bodyParts){
                    if(bodyPart != null)
                        multipart.addBodyPart(bodyPart);
                }
            }
            
            message.setContent(multipart);

            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static String prepareStylizedBodyMessage(String message, String toEmpName){
        String msg =
            "<div style='background-image:url()'" +
            "<div style='margin-top:20px;font-size:14px;font-family:arial;font-weight:bolder;'>Dear <b>" +
            toEmpName + "</b>,</div>" +
            "<div style='margin-top:20px;font-size:14px;font-family:arial;'>"+message+"</div><br>";  
        
        return msg;
    }
    
    private static String prepareActionBodyMessage(LinkedHashMap<String, String> actionButtons){
        String msg = "";
        for(Map.Entry<String, String> entry  : actionButtons.entrySet()){
            if(!entry.getKey().equalsIgnoreCase("More Info"))
            msg+= "<a href=\""+entry.getValue()+"\" target=\"_parent\"><button style='font-weight:bolder;background-color: #F39C12;color:white;height:40px;width:100px'>"+entry.getKey()+"</button></a>";
        }
        msg+= "</div>";
        
        return msg;
    }
    
    private static ArrayList<MimeBodyPart> fetchAttachments(String reqId, DBTransaction dbTrans) {
        ArrayList<MimeBodyPart> bodyParts = new ArrayList<MimeBodyPart>();
        if (reqId != null) {
            Statement statement = dbTrans.createStatement(0);
            try {
                String query =
                    "select file_name, file_type, attachment from xxhcm_master_attachment where master_ref_id = " +
                    reqId;
                ResultSet resultSet1 = statement.executeQuery(query);
                while (resultSet1.next()) {
                    String fileName = resultSet1.getString(1);
                    String fileType = resultSet1.getString(2);
                    java.sql.Blob file = resultSet1.getBlob(3);
                    MimeBodyPart att = fetchBodyPartFromBlob(file, fileType, fileName);
                    if(att != null){
                        bodyParts.add(att);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            Statement statement1 = dbTrans.createStatement(0);
            try {
                String query =
                    "select d.attribute1,d.attach_file_type,d.attach_file from xxhcm_overtime_headers_all a, xxhcm_overtime_details_all b, xxhcm_other_expense c, xxhcm_attachment d\n" + 
                    "where a.req_id = b.req_id and b.req_dtls_id = c.req_dtls_id and c.expense_id = d.expense_id and a.req_id =  " +
                    reqId;
                ResultSet resultSet1 = statement1.executeQuery(query);
                while (resultSet1.next()) {
                    String fileName = resultSet1.getString(1);
                    String fileType = resultSet1.getString(2);
                    java.sql.Blob file = resultSet1.getBlob(3);
                    MimeBodyPart att = fetchBodyPartFromBlob(file, fileType, fileName);
                    if(att != null){
                        bodyParts.add(att);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
        }
        return bodyParts;
    }
    
    
    private static ArrayList<MimeBodyPart> fetchbtcAttachments(String reqId, DBTransaction dbTrans) {
        ArrayList<MimeBodyPart> bodyParts = new ArrayList<MimeBodyPart>();
        if (reqId != null) {
            Statement statement = dbTrans.createStatement(0);
            try {
                String query =
                    "select d.attribute1,d.attach_file_type,d.attach_file from xxhcm_overtime_headers_all a, xxhcm_overtime_details_all b, xxhcm_other_expense c, xxhcm_attachment d\n" + 
                    "where a.req_id = b.req_id and b.req_dtls_id = c.req_dtls_id and c.expense_id = d.expense_id and a.req_id =  " +
                    reqId;
                ResultSet resultSet1 = statement.executeQuery(query);
                while (resultSet1.next()) {
                    String fileName = resultSet1.getString(1);
                    String fileType = resultSet1.getString(2);
                    java.sql.Blob file = resultSet1.getBlob(3);
                    MimeBodyPart att = fetchBodyPartFromBlob(file, fileType, fileName);
                    if(att != null){
                        bodyParts.add(att);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bodyParts;
    }
    
    private static MimeBodyPart fetchBodyPartFromBlob(Blob blob, String fileType, String fileName){
        byte[] bytearray = null; 
        MimeBodyPart att = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(blob.getBinaryStream());
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int length = 0;
            while ((length = bis.read(buffer)) != -1) {
                bao.write(buffer, 0, length);
            }
            bao.close();
            bis.close();
            bytearray = bao.toByteArray();
            
            ByteArrayDataSource bds = new ByteArrayDataSource(bytearray, fileType);
            
            att = new MimeBodyPart();  
            att.setDataHandler(new DataHandler(bds)); 
            att.setFileName(fileName); 
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
        return att;
    }
}
