package com.transaction.Transaction.Demo.controller;

import com.transaction.Transaction.Demo.services.SendMailAttachmentService;
import com.transaction.Transaction.Demo.services.SendMailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private SendMailAttachmentService sendMailService;



    @GetMapping
    public String sendEmail() throws MessagingException {
        sendMailService.sendMail("rohanthapa@gmail.com","Hello this is rohan rigtt?","Just a test");
        return "Send ";
    }
}
