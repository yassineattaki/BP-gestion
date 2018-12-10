package org.sid.metier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.sid.entities.Users;



@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("yassineattaki@gmail.com");
        mailMessage.setSubject("Validation de mouvement");
        mailMessage.setText("il y a des mouvements qui neccéssitent la validation , Svp va voir l'applicaton");
       // mailMessage.setFrom("yassineattaki@gmail.com");
        javaMailSender.send(mailMessage);
    }

}
