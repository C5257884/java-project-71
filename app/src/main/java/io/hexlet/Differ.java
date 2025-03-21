package io.hexlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


public class Differ {
    Map<String, Object> map1;
    Map<String, Object> map2;

    public void generate(String fileContent1, String fileContent2) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        map1 = objectMapper.readValue(fileContent1, new TypeReference<>() {
        });
        map2 = objectMapper.readValue(fileContent2, new TypeReference<>() {
        });
    }
}
