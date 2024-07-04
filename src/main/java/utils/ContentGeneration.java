package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContentGeneration {

    public static String createUser() {

        return new SimpleDateFormat("SSS").format(new Date()) + "skiloTest";
    }

    public static String createEmail() {

        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "@abv.bg";
    }

    public static String createInvalidEmail() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "!";
    }

    public static String createPassword() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "@abv.bg";
    }

    public static String createPasswordFor() {
        return new SimpleDateFormat("mmssSSS").format(new Date()) + "_skiloTest";
    }
}
