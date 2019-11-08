/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emmerich.HelpdeskApp.util;

import br.com.emmerich.HelpdeskApp.bean.Chamado;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author estagiodev
 */
public class SendEmail {

    private final String emailUser = "email";
    private final String emailPasswd = "senha";

    public boolean send(Chamado chamado) throws UnsupportedEncodingException {

        if (chamado != null) {

            Properties props = new Properties();
            /**
             * Parâmetros de conexão com servidor Gmail
             */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(emailUser, emailPasswd);
                        }
                    });

            /**
             * Ativa Debug para sessão
             */
            session.setDebug(true);

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(emailUser));
                //Remetente

                //Address[] toUser = InternetAddress.parse(usuario.getEmail());
                
                message.setRecipient(Message.RecipientType.TO, new InternetAddress("email to"));
                 message.setSubject("Chamado - HelpDesk");
                 message.setText(chamado.toString()); // as "text/plain"
                 message.setSentDate(new Date());
                /**
                 * Método para enviar a mensagem criada
                 */
                Transport.send(message);

                System.out.println("Feito!!!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
