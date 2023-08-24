package com.intech.session4.config;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonFileToJsonObject {
    public JSONObject read() throws IOException {
        String file="src/main/resources/openapi/response.json";
        String content=new String(Files.readAllBytes(Paths.get(file)));
        return new JSONObject(content);
    }
}
