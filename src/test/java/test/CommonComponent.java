package test;

import io.github.cdimascio.dotenv.Dotenv;
import utils.Url;

public class CommonComponent {
    public static void main(String[] args) {

        System.out.printf(Url.currentTestUrl("LOGIN_PAGE"));
    }
}
