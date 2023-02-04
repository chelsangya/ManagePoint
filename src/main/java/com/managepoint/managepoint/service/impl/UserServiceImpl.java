package com.managepoint.managepoint.service.impl;

import com.managepoint.managepoint.config.PasswordEncoderUtil;
import com.managepoint.managepoint.exception.AppException;
import com.managepoint.managepoint.entity.User;
import com.managepoint.managepoint.pojo.UserPojo;
import com.managepoint.managepoint.repo.EmailCredRepo;
import com.managepoint.managepoint.repo.UserRepo;
import com.managepoint.managepoint.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final JavaMailSender getJavaMailSender;
    private final EmailCredRepo emailCredRepo;
    private final ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;
    @Override
    public void sendEmail() {
        try {
            Map<String, String> model = new HashMap<>();

            MimeMessage message = getJavaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Template template = emailConfig.getTemplate("emailTemp.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            mimeMessageHelper.setTo("sendfrom@yopmail.com");
            mimeMessageHelper.setText(html, true);
            mimeMessageHelper.setSubject("Registration");
            mimeMessageHelper.setFrom("sendTo@yopmail.com");

            taskExecutor.execute(new Thread() {
                public void run() {
                    getJavaMailSender.send(message);
                }
            });
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public UserPojo save(UserPojo userPojo) {
        User user = new User();
        if(userPojo.getId()!=null){
            user.setId(userPojo.getId());
        }
        user.setEmail(userPojo.getEmail());
        user.setName(userPojo.getName());
        user.setAddress(userPojo.getAddress());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        user.setPhone(userPojo.getPhone());
        userRepo.save(user);
        return new UserPojo();
    }
    @Override
    public String update(UserPojo userPojo) {
        User user = new User();
        if(userPojo.getId()!=null){
            user.setId(userPojo.getId());
        }
        user.setEmail(userPojo.getEmail());
        user.setName(userPojo.getName());
        user.setAddress(userPojo.getAddress());
        user.setPhone(userPojo.getPhone());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "updated";
    }
    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

//    @Override
//    public void changePassword(PasswordChangePojo passwordChangePojo) {
//        Optional<User> optionalUser = userRepo.findByEmail(passwordChangePojo.getEmail());
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            if (PasswordEncoderUtil.getInstance().matches(passwordChangePojo.getOldPassword(), user.getPassword())) {
//                if (passwordChangePojo.getNewPassword().equals(passwordChangePojo.getRepeatPassword())) {
//                    user.setU_password(PasswordEncoderUtil.getInstance().encode(passwordChangePojo.getNewPassword()));
//                    userRepo.save(user);
//                } else {
//                    throw new AppException("New Password doesn't match.", HttpStatus.BAD_REQUEST);
//                }
//
//            } else {
//                throw new AppException("Old Password doesn't match existing password.", HttpStatus.BAD_REQUEST);
//            }
//        }
//
//    }

    @Override
    public UserPojo findByEmail(String email) {
        System.out.println(1);
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        System.out.println(2);
        return new UserPojo(user);
    }
    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepo.findByName(username);
    }
    @Override
    public void processPasswordResetRequest(String email) {
        Optional<User> optionalUser = userRepo.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String OTP = generateOTP();
            user.setOTP(OTP);
            userRepo.save(user);
            sendOTPEmail(email, OTP);
        }
    }

    @Override
    public void resetPassword(String email, String OTP, String password) {
        User user = userRepo.findByEmailAndOTP(email, OTP);
        if (user != null) {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            user.setOTP(null);
            userRepo.save(user);
        } else {
            throw new RuntimeException();
        }
    }

    private String generateOTP() {
        return String.format("%06d", new Random().nextInt(1000000));
    }

    private void sendOTPEmail(String email, String OTP) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP for resetting your password is: " + OTP);
        getJavaMailSender.send(message);
    }

}
