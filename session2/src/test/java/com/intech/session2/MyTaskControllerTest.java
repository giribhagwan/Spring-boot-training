package com.intech.session2;

import com.intech.session2.domain.MyTask;
import com.intech.session2.servier.MyTaskServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest
public class MyTaskControllerTest {
    @LocalServerPort
    private int port;

    @Test
    public void getHello() throws Exception {
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<MyTask> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/api/v1/task").toString(), MyTask.class);
        System.out.println(response.getBody());
        assertNotNull(response.getBody());

    }
}
