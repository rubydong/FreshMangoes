package com.freshmangoes.app.email.service;

public interface EmailService {
  Boolean sendEmail(String recipient, String subject, String body);
}
