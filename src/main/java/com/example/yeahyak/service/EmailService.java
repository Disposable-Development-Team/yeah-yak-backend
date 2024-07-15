package com.example.yeahyak.service;




import com.example.yeahyak.dto.ReservationForm;
import com.example.yeahyak.dto.StatusForm;
import com.example.yeahyak.entity.Reservation;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;


@Service
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;
    private  static String[] receiveList = {"wjd199786@naver.com", "kyj960802@gmail.com"};
    public void sendReservationEmail(ReservationForm dto) throws MessagingException, IOException {
        // 예약 관련 이메일 전송 로직
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(receiveList);
        helper.setSubject("예약 신청이 발생했습니다.");

        Context context = new Context();
        context.setVariable("name" , dto.getName());
        context.setVariable("phoneNumber",dto.getPhoneNumber());

        String html = templateEngine.process("createMailing",context);
        helper.setText(html,true);

        javaMailSender.send(message);



    }

    public void sendCancellationEmail(Reservation entity) throws MessagingException, IOException {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(receiveList);
            helper.setSubject("예약이 취소되었습니다.");

            Context context = new Context();
            context.setVariable("name", entity.getName());
            context.setVariable("phoneNumber", entity.getPhoneNumber());

            String html = templateEngine.process("deleteMailing", context);
            helper.setText(html, true);

            javaMailSender.send(message);
        }
}
