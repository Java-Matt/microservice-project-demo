package com.demo.mailservice.service;

import com.demo.mailservice.dto.NotificationDto;
import com.demo.mailservice.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final static String SUBJECT = "EXCHANGE CONFIRMATION";

    private final JavaMailSender mailSender;

    @Async("taskExecutor")
    public void sendMail(NotificationDto notificationDto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(notificationDto.getEmail());
        mailMessage.setSubject(SUBJECT);
        mailMessage.setText(buildContent(notificationDto.getResultDto()));
        mailSender.send(mailMessage);
    }

    private String buildContent(ResultDto resultDto) {
        return MessageFormat.format("""
                        Hello,
                        This is your exchange confirmation
                        You have converted {0} to {1}.
                        Your result is:
                            {2}
                            
                        THANK YOU!
                        """,
                resultDto.getFrom(),
                resultDto.getTo(),
                resultDto.getResult()
        );
    }
}
