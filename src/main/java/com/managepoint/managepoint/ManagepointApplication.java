package com.managepoint.managepoint;

import com.managepoint.managepoint.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
 public class ManagepointApplication {

    @Autowired
    private EmailSenderService senderService;
    public static void main(String[] args) {
        SpringApplication.run(ManagepointApplication.class, args);
    }
//    @EventListener(ApplicationReadyEvent.class)
//    public void sendEMail(){
//        senderService.sendSimpleEmail("csangya@gmail.com",
//                "This is email body",
//                "This is email subject");
//
//    }
}