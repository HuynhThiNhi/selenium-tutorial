package utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

import java.lang.reflect.Field;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Config {
    @JsonProperty("BASE_URL")
    public static String baseUrl;

    static {
        loadEnvVariables();
    }

    /**
     * this method not working because Jackson does not set static fields when converting objects.
     * */

//    private static void loadEnvVariables() {
//        Dotenv dotenv = Dotenv.load();
//        Map<String, String> envMap = dotenv.entries().stream()
//                .collect(java.util.stream.Collectors.toMap(
//                        DotenvEntry::getKey, DotenvEntry::getValue
//                ));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.convertValue(envMap, Config.class);
//
//    }


    private static void loadEnvVariables() {
        Dotenv dotenv = Dotenv.load(); // Load .env file

        /**
         * In Java, static fields belong to the class itself, not an instance.
         * The Field.set(Object obj, Object value) method sets the value of a field.
         * When a field is static, the obj parameter should be null because there's no instance needed.
         * */
        for (Field field : Config.class.getDeclaredFields()) {
            String envValue = dotenv.get(field.getName());
            if (null != envValue) {
                try {
                    field.set(null, envValue); // Set static field dynamically
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
