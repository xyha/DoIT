package com.ahhh.sreamdeepinto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author ahhh
 * @title: MailService
 * @projectName eureka-server
 * @description: 发送邮件
 * @date 2020/12/25
 */
@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendHtmlMail(String from, String to, String subject, String content) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("发送失败");
        }

    }
}
