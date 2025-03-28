package com.rodalm.interfaceWeb4Linux;

import com.jcraft.jsch.JSch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aplicacao {
    public static void main(String[] args) {

        SpringApplication.run(Aplicacao.class,args);

    }
    @Bean
    public JSch jsch(){
        return new JSch();
    }
}
