package com.deafoodservice.app.reviewservice.service;

import com.deafoodservice.app.reviewservice.model.Review;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendNotification(Review review) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("customer@example.com"); // Customer's email
        message.setSubject("New Review Submitted");
        message.setText("A new review has been submitted by customer " + review.getCustomerId());
        mailSender.send(message);
    }


}
