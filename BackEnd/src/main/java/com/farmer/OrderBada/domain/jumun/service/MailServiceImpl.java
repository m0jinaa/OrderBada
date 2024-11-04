package com.farmer.OrderBada.domain.jumun.service;

import com.farmer.OrderBada.domain.jumun.model.dto.MailDto;
import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${example.emailSender}")
    String emailSender;
    @Override
    public boolean sendMail(MailDto mailDto) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try{

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");

            String filename = mailDto.getFromName().concat(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))).concat(".xlsx");

            mimeMessageHelper.setSubject(filename);
            mimeMessageHelper.setTo(mailDto.getTo());
            mimeMessageHelper.setFrom(emailSender, mailDto.getFromName());
            mimeMessageHelper.setText(mailDto.getContent());

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            mailDto.getWb().write(bos);

            DataSource dataSource = new ByteArrayDataSource(bos.toByteArray(),"application/vnd.ms-excel");

            mimeMessageHelper.addAttachment(filename,dataSource);

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("이메일 전송 과정에서 실패 : {}", e);
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
