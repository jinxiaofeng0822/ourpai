package com.jxf.ourpai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OurpaiApplication extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(OurpaiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OurpaiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        log.info("在容器中启动ing---");
        return builder.sources(OurpaiApplication.class);
    }

}
