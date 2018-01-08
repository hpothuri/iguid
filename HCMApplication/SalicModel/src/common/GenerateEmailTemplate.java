package common;

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

import java.util.ArrayList;


public class GenerateEmailTemplate {
    public GenerateEmailTemplate() {
        super();
    }

    private static String FROM_USER = "paas.user@salic.com";
    private static String FROM_USER_PASSWORD = "Salic@123";
    
//    private static String FROM_USER = "muralikona.oracle@gmail.com";
//    private static String FROM_USER_PASSWORD = "k1m2k3k1";

    public static Map<String, String> prepareEmailTemplate(EmailRequestPojo emailReq, DBTransaction dbTrans) {
        Map<String, String> emailHapmap = new HashMap<String, String>();
        Statement statement = dbTrans.createStatement(0);
        try {
            String message = null;

            ArrayList<EmailTableDetailsPojo> tableDetails = emailReq.getTableDetails();
            String emailSubject = emailReq.getSubject();
            String emailBody = "";

            if (tableDetails != null && tableDetails.size() > 0) {
                for (EmailTableDetailsPojo tableDetail : tableDetails) {
                    String linedetailsQuery = tableDetail.getDetailsQuery();
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

            String bestRegardsmessage = "<br><br>Best Regards";

            String body = message + emailBody + actionBody + bestRegardsmessage;
            emailHapmap.put("subject", emailSubject);
            emailHapmap.put("body", body);

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

    public static void sendFromGMail(String[] to, String subject, String body) {

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
            message.setContent(body, "text/html");

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
            msg+= "<a href=\""+entry.getValue()+"\" target=\"_parent\"><button style='font-weight:bolder;background-color: #F39C12;color:white;height:40px;width:100px'>"+entry.getKey()+"</button></a>";
        }
        msg+= "</div>";
        
        return msg;
    }
}
