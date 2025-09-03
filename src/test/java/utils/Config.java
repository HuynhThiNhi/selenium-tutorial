package utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.cdimascio.dotenv.Dotenv;
import java.lang.reflect.Field;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Config {
    public static String baseUrl;

    static {
        loadEnvVariables();
    }

    /**
     * this method not working because Jackson does not set static fields when converting objects.
     * */

    private static void loadEnvVariables() {
        Dotenv dotenv = Dotenv.load(); // Load .env file

        /**
         * In Java, static fields belong to the class itself, not an instance.
         * The Field.set(O  abject obj, Object value) method sets the value of a field.
         * When a field is static, the obj parameter should be null because there's no instance needed.
         * */
        for (Field field : Config.class.getDeclaredFields()) {
            String envValue = dotenv.get(StringUtils.camelToSnake(field.getName()));
            if (null != envValue) {
                try {
                    field.set(null, envValue); // Set static field dynamically
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("Base URL: " + baseUrl);
    }

}
