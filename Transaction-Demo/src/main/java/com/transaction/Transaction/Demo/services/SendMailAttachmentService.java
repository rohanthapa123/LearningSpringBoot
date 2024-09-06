package com.transaction.Transaction.Demo.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SendMailAttachmentService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmailId;

    public void sendMail(String receipt , String body, String subject) throws MessagingException {

        String attachmentPath = "src/main/resources/static/image.png";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(fromEmailId);
        helper.setTo(receipt);
        helper.setText(body);
        helper.setSubject(subject);

        FileSystemResource file = new FileSystemResource(new File(attachmentPath));
        if (file.exists()) {
            helper.addAttachment("image.png", file);
            System.out.println("Attachment added successfully.");
        } else {
            System.out.println("Attachment file not found.");
        }

        javaMailSender.send(mimeMessage);
    }

}
