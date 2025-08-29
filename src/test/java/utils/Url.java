package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;

public class Url {
    public static final String JSON_FILE = System.getProperty("user.dir") + "/resources/testing-urls.json";
    public static String currentTestUrl(String testPage) {
        ObjectMapper objectMapper = new ObjectMapper();
        String finalUrl;

        try {
            FileInputStream fileInputStream = new FileInputStream(JSON_FILE);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Map<String, Map<String, Object>> urlData = objectMapper.readValue(bufferedReader, new TypeReference<>() {
            });
            String sitePath = (String) urlData.getOrDefault(testPage, Collections.emptyMap()).get("url");;
            finalUrl = Config.baseUrl + sitePath;

            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ERR | issue when reading the url in file config");
        }

        return finalUrl;
    }
}
