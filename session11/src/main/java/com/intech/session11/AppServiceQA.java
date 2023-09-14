package com.intech.session11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("AppServiceQA")
public class AppServiceQA implements AppService{

    @Value("${app.name}")
    String appName;
    @Value("${app.version}")
    String version;
    @Value("${app.activated.server}")
    String serviceName;

    @Override
    public void getAppInfo() {
        System.out.println("QA service is to server");
        System.out.println("App Name: "+appName);
        System.out.println("App Version: "+version);
        System.out.println("App profile: "+ serviceName);
    }
}
