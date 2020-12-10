package com.muse.email.service;

import com.muse.email.config.EmailSendThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.concurrent.Callable;

import static com.muse.email.model.Constants.SUCCESS;

/**
 * 邮件发送实现类
 * * @Author: RyouA
 * * @Date: 2020/10/6
 **/
@Component
public class IMailServiceImpl implements IMailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setSubject(subject);
                    message.setFrom(from);
                    message.setTo(to);
                    message.setText(content);
                    mailSender.send(message);
                    return SUCCESS;
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Override
    public void sendSimpleMail(String to, String subject, String content, String... cc) {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setFrom(from);
                    message.setTo(to);
                    message.setCc(cc);
                    message.setSubject(subject);
                    message.setText(content);
                    mailSender.send(message);
                    return SUCCESS;
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    MimeMessage message = mailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    helper.setText(content, true);
                    mailSender.send(message);
                    return SUCCESS;
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content, String... cc) throws MessagingException {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    MimeMessage message = mailSender.createMimeMessage();
                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    helper.setText(content, true);
                    helper.setCc(cc);
                    mailSender.send(message);
                    return SUCCESS;
                } catch (MessagingException e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    MimeMessage message = mailSender.createMimeMessage();

                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    helper.setText(content, true);

                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                    helper.addAttachment(fileName, file);

                    mailSender.send(message);
                    return SUCCESS;
                } catch (MessagingException e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath, String... cc) throws MessagingException {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    MimeMessage message = mailSender.createMimeMessage();

                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    helper.setText(content, true);
                    helper.setCc(cc);

                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                    helper.addAttachment(fileName, file);

                    mailSender.send(message);
                    return SUCCESS;
                } catch (MessagingException e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Override
    public void sendResourceMail(String to, String subject, String content, String rscPath, String rscId) throws MessagingException {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    MimeMessage message = mailSender.createMimeMessage();

                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    helper.setText(content, true);

                    FileSystemResource res = new FileSystemResource(new File(rscPath));
                    helper.addInline(rscId, res);

                    mailSender.send(message);
                    return SUCCESS;
                } catch (MessagingException e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Override
    public void sendResourceMail(String to, String subject, String content, String rscPath, String rscId, String... cc) throws MessagingException {
        EmailSendThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    MimeMessage message = mailSender.createMimeMessage();

                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    helper.setText(content, true);
                    helper.setCc(cc);

                    FileSystemResource res = new FileSystemResource(new File(rscPath));
                    helper.addInline(rscId, res);

                    mailSender.send(message);
                    return SUCCESS;
                } catch (MessagingException e) {
                    return e.getMessage();
                }
            }
        });
    }
}
