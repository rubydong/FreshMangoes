package com.freshmangoes.app.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
  @Autowired
  private MailSender mailSender;

  @Override
  public Boolean sendEmail(final String recipient, final String subject, final String body) {
    try {
      final SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(recipient);
      message.setSubject(subject);
      message.setText(body);
      mailSender.send(message);
      return true;
    } catch (MailException mailException) {
      return false;
    }
  }
}
