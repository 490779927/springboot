package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:constant.properties")
public class ConstantProperties {

    @Value("${constant.test.name}")
    private String testName;
}
