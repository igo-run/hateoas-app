package io.igorun.demo.hateoasapp.util;

import java.util.UUID;

public class Utils {
    private Utils(){
        //private default constructor because it's utils class
    }

    public static String fooString(){
        return UUID.randomUUID().toString();
    }
}
