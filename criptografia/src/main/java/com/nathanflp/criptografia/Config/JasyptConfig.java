package com.nathanflp.criptografia.Config;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {


    @Bean
    public AES256TextEncryptor aes256TextEncryptor() {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(System.getenv("chave_criptografia"));
        return textEncryptor;
    }
}
