/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.util;

import java.util.Optional;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author evin
 */
public class UtileriaMensajes {
    public static void generarAlertaInfo(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alerta.setTitle(titulo.toUpperCase());
        alerta.setHeaderText(null);
        alerta.show();
    }
    
    public static void generarAlertaError(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR, mensaje);
        alerta.setTitle(titulo.toUpperCase());
        alerta.setHeaderText(null);
        alerta.show();
    }
    
    public static boolean generarAlertaConfirmacion(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, mensaje);
        alerta.setTitle(titulo.toUpperCase());
        alerta.setHeaderText(null);
        Optional<ButtonType> decisionBtn = alerta.showAndWait();
        if(decisionBtn.isPresent()){
            if(decisionBtn.get() == ButtonType.OK)
                return true;  
            else if (decisionBtn.get() == ButtonType.CANCEL)
                return false;
            else if (decisionBtn.get() == ButtonType.CLOSE)
                return false;
        }       
        return false;   
    }
    
    public static void sendMensaje(String comprador, String asunto, String cuerpo) {
        String remitente = "vendemosttv@gmail.com";
        String claveemail = "frupcoheitutbiza";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(comprador));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
