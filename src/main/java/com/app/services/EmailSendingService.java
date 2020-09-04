package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class EmailSendingService {

    private final  JavaMailSender emailSender;

    private static final Logger LOGGER = LogManager.getLogger(EmailSendingService.class);

    private  static int noOfQuickServiceThreads = 20;

    private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads);
    public EmailSendingService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMail(String receiver) {
        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            messageHelper.setText("Welcome to Study Buddy. You will find here a community ready to help you. ");
            messageHelper.setSubject("Welcome to Study Buddy");
            messageHelper.setTo(receiver);
            quickService.submit(new Runnable() {
                @Override
                public void run() {
                    try{
                        emailSender.send(message);
                    }catch(Exception e){
                        LOGGER.error("Error occurred during email sending", e);
                    }
                }
            });
        } catch (MessagingException e) {
            LOGGER.error("Error occurred during email sending", e);

        }
    }

}
