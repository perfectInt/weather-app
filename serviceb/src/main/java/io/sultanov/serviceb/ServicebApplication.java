package io.sultanov.serviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableFeignClients(basePackages = "io.sultanov.feignclients")
@PropertySources({
        @PropertySource("classpath:clients-default.properties")
})
public class ServicebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicebApplication.class, args);
    }

}
