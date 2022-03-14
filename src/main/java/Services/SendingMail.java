/*package Services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author amine
 */
/*public class SendingMail {

    public static  String mailUsername ;
    public static  String mailPassword;
    public static String contenu ;
    public static String destination ;
    public static String subject ;

    public SendingMail() {
    }

    public SendingMail(String contenu, String destination , String subject) {
        mailUsername = "aminezarrouk96@gmail.com";
        mailPassword = "Amine@96";
        this.contenu=contenu ;
        this.destination=destination ;
        this.subject=subject ;
    }

    public static void setContenu(String contenu) {
        SendingMail.contenu = contenu;
    }

    public static void setDestination(String destination) {
        SendingMail.destination = destination;
    }

    public static void setSubject(String subject) {
        SendingMail.subject = subject;
    }

    public static void envoyer () {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailUsername, mailPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sabri-b-m@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destination));
            message.setSubject(subject);
            message.setText(contenu);

            Transport.send(message);

            System.out.println("email sent ");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}

*/
