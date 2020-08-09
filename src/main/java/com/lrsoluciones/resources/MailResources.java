package com.lrsoluciones.resources;

import com.lrsoluciones.resources.request.FooterRequest;
import com.lrsoluciones.resources.request.MailRequest;
import com.lrsoluciones.resources.response.RecaptchaResponse;
import com.lrsoluciones.services.MailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("mail")
public class MailResources {

    private MailServices mailServices;

    @Autowired
    public MailResources(MailServices mailServices) {
        this.mailServices = mailServices;
    }

    public MailServices getMailServices() {
        return mailServices;
    }

    // recapcha
    @Autowired
    private RestTemplate restTemplate;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public @ResponseBody
    ResponseEntity<?> saveMail(@RequestBody MailRequest mailRequest, @RequestParam(name = "g-recaptcha-response") String captchaResponse){
        String url = "https://www.google.com/recaptcha/api/siteverify"; // para verificar capcha
        String params = "?secret=6Lezgv0UAAAAAMz8LB8UfbzruYvKaRo_RAUngW4V&response="+captchaResponse;
        System.out.println(captchaResponse);
        ResponseEntity <?> responseEntity;

        RecaptchaResponse recaptchaResponse = restTemplate.exchange(url+params, HttpMethod.POST, null, RecaptchaResponse.class ).getBody();
        assert recaptchaResponse != null;
        if (recaptchaResponse.isSuccess()) {
            responseEntity = getMailServices().saveMail(mailRequest);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
