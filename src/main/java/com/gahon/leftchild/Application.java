package com.gahon.leftchild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Gahon
 * @date 2018/11/17.
 */
@SpringBootApplication
@EnableSwagger2
@CrossOrigin
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

