package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
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
            FileInputStream inputStream = new FileInputStream(new File(
                    "src\\main\\resources\\mail_template.html"));
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
                sb.append(str);
            }
            messageHelper.setText(sb.toString(),true);
            messageHelper.setSubject("Study Buddy");
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
        } catch (MessagingException | IOException e) {
            LOGGER.error("Error occurred during email sending", e);

        }
    }

}
