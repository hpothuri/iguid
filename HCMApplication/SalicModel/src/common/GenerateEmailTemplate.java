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


public class GenerateEmailTemplate {
    public GenerateEmailTemplate() {
        super();
    }

    private static String FROM_USER = "salic.paasadmn@gmail.com";
    private static String FROM_USER_PASSWORD = "Admin1234";
    
//    private static String FROM_USER = "";
//    private static String FROM_USER_PASSWORD = "";

    public static Map<String, String> prepareEmailTemplate(EmailRequestPojo emailReq, DBTransaction dbTrans) {
        Map<String, String> emailHapmap = new HashMap<String, String>();
        Statement statement = dbTrans.createStatement(0);
        try {
            String message = null;
            String linebodyInfo = "";
            String linedetailsQuery = emailReq.getDetailsQuery();
//                "select OVERTIME_DATE,OVERTIME_TYPE,OVERTIME_HOURS,CALCULATED_HOURS,MISSIONS from XXHCM_OVERTIME_DETAILS_ALL where REQ_ID=" +
//                emailReq.getRequestId();


            String emailSubject = emailReq.getSubject();
//                "Overtime request (" + emailReq.getRequestNo() +
//                ") is submitted for approval, Pending for HR varification.";

            message = prepareStylizedBodyMessage(emailReq.getMessage(),emailReq.getToEmpName());
            
//            message =
//                "<div style='background-image:url()'" +
//                "<div style='margin-left:80px;margin-top:20px;font-size:14px;font-family:arial;font-weight:bolder;'>Dear <b>" +
//                emailReq.getEmpName() + "</b>,</div>" +
//                "<div style='margin-top:20px;font-size:14px;font-family:arial;'>Your <b> overtime request </b> is submitted and pending for HR varification with hereunder information: </div><br>";

            String lineheaderinfo = "<table style='width:800px;height:150px;border:2px solid black;font-size:14px;font-family:arial;border-collapse:collapse' border=1 ><tr style='background-color:#D6EAF8;'><th style='font-weight:bolder;'>sr.#</th>";
            for(String headerCol : emailReq.getTableContentColumns()){
                 lineheaderinfo = lineheaderinfo + "<th  style='font-weight:bolder'>"+headerCol+"</th>";               
            }
            lineheaderinfo= lineheaderinfo + "</tr>";
           
//            String lineheaderinfo =
//                           "<table style='width:800px;height:150px;border:2px solid black;font-size:14px;font-family:arial;border-collapse:collapse' border=1 ><tr style='background-color:#D6EAF8;'><th style='font-weight:bolder;'>sr.#</th><th  style='font-weight:bolder'>Ovetime Date</th><th style='font-weight:bolder;'>Ovetime Type</th><th style='font-weight:bolder;'>Overtime Hours</th><th style='font-weight:bolder;'>Calculated  Hours</th><th style='font-weight:bolder;'>Description</th></tr>";

            ResultSet resultSet1 = statement.executeQuery(linedetailsQuery);

            int i = 1;
            while (resultSet1.next()) {
                linebodyInfo +=
                    "<tr><td align='center'>" + i + "</td>";
                for(Map.Entry<String, String> entry : emailReq.getTableColumnDatatypes().entrySet()){
                    if(entry.getValue() != null && "DATE".equalsIgnoreCase(entry.getValue())){
                        linebodyInfo += "<td align='center'>" + resultSet1.getDate(entry.getKey()) +
                                            "</td>";
                    }
                    else if(entry.getValue() != null && "STRING".equalsIgnoreCase(entry.getValue())){
                        linebodyInfo += "<td align='center'>" + resultSet1.getString(entry.getKey()) +
                                            "</td>";
                    }
                    else if(entry.getValue() != null && "NUMBER".equalsIgnoreCase(entry.getValue())){
                        linebodyInfo += "<td align='center'>" + resultSet1.getBigDecimal(entry.getKey()) +
                                            "</td>";
                    }
                }
                linebodyInfo += "</tr>";
//                linebodyInfo +=
//                    "<tr><td align='center'>" + i + "</td><td align='center'>" + resultSet1.getDate("OVERTIME_DATE") +
//                    "</td><td align='center'>" + resultSet1.getString("OVERTIME_TYPE") + "</td><td align='center'>" +
//                    resultSet1.getString("OVERTIME_HOURS") + "</td><td align='center'>" +
//                    resultSet1.getString("CALCULATED_HOURS") + "</td><td align='center'>" +
//                    resultSet1.getString("MISSIONS") + "</td></tr>";
                i++;
            }

            linebodyInfo = lineheaderinfo + linebodyInfo + "</table>" + "<br>" + "<br>";

            String actionBody = prepareActionBodyMessage(emailReq.getActionButtons());
//                "<button style='font-weight:bolder;background-color: #F39C12;color:white;height:40px;width:100px'>More Info</button>" +
//                "</div>";

            String body = message + linebodyInfo + actionBody;
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
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_USER, FROM_USER_PASSWORD);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from-email@gmail.com"));

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
            "<div style='margin-left:80px;margin-top:20px;font-size:14px;font-family:arial;font-weight:bolder;'>Dear <b>" +
            toEmpName + "</b>,</div>" +
            "<div style='margin-top:20px;font-size:14px;font-family:arial;'>"+message+"</div><br>";  
        
        return msg;
    }
    
    private static String prepareActionBodyMessage(LinkedHashMap<String, String> actionButtons){
        String msg = "";
        for(Map.Entry<String, String> entry  : actionButtons.entrySet()){
            msg+= "<button style='font-weight:bolder;background-color: #F39C12;color:white;height:30px'>"+entry.getKey()+"</button>";
        }
        msg+= "</div>";
        
        return msg;
    }
}
