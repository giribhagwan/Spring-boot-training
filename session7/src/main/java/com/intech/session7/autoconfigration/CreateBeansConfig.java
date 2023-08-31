package com.intech.session7.autoconfigration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass(name = "com.intech.session7.autoconfigration.ApplicationInfo")
public class CreateBeansConfig {
    @Bean()
//    @ConditionalOnClass(name = "com.intech.session7.EmailServices")
    public ApplicationInfo applicationInfo(){
        return new ApplicationInfo();
    }
}
