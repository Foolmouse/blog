package com.hanslaser.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.inject.Inject;

@Configuration
public class EmailConfiguration {

    @Inject
    private Environment env;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        boolean isEmailEnabled = env.getProperty("email.enabled", Boolean.class, false);
        if (isEmailEnabled) {
            sender.setHost(env.getRequiredProperty("email.host"));
            sender.setPort(env.getRequiredProperty("email.port", Integer.class));
        }

        Boolean useCredentials = env.getProperty("email.useCredentials", Boolean.class);
        if (Boolean.TRUE.equals(useCredentials)) {
            sender.setUsername(env.getProperty("email.username"));
            sender.setPassword(env.getProperty("email.password"));
        }

        Boolean emailTLS = env.getProperty("email.tls", Boolean.class);
        if (emailTLS != null) {
            sender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", emailTLS.toString());
        }

        return sender;
    }

    /*@Bean
    public FreeMarkerConfigurationFactoryBean freeMarkerConfig() {
        Properties props = new Properties();
        props.setProperty("number_format", "0.##");
        props.setProperty("locale", "en-US");

        FreeMarkerConfigurationFactoryBean factory = new FreeMarkerConfigurationFactoryBean();
        factory.setFreemarkerSettings(props);
        factory.setTemplateLoaderPath("classpath:/email-templates/");
        return factory;
    }*/
}
