package com.lrsoluciones.services;

import com.lrsoluciones.models.Mail;
import com.lrsoluciones.repositories.MailRepository;
import com.lrsoluciones.resources.request.MailRequest;
import com.lrsoluciones.resources.response.MailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServices {

    private MailRepository mailRepository;
    @Autowired
    public JavaMailSender javaMailSender;
    @Autowired
    public MailServices(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public MailRepository getMailRepository() {
        return mailRepository;
    }


    // (LOGICA DEL POST)
    public ResponseEntity<?> saveMail(MailRequest mailRequest) {// va a recibir el ItemRequest
        ResponseEntity<?> responseEntity;
        Mail mail;

        if (mailRequest != null) { // hacer validaciones
            mail = Mail.from(mailRequest);
            getMailRepository().save(mail);

           SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo("adrianmelano213@gmail.com");// me manda al mi mail
            simpleMailMessage.setSubject(mailRequest.getMail());// me dice a que mail me tengo que comunicar
            simpleMailMessage.setText("Nombre y Apellido: "+mailRequest.getNomAp()+"\n"+
                                       "Telefono: "+mailRequest.getTel()+"\n"+
                                        "Localidad: "+mailRequest.getLocalidad()+"\n"+
                                        "Provincia: "+mailRequest.getProvincia()+"\n"+
                                        "Comentario: "+mailRequest.getComentario());
            javaMailSender.send(simpleMailMessage);
            responseEntity = new ResponseEntity<>(MailResponse.from(mail), HttpStatus.OK);

        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return responseEntity;
        // devuelve un ItemResponse, porque siempre que guardo algo en la bbdd necesito obtener un objeto de respuesta
    }
}
