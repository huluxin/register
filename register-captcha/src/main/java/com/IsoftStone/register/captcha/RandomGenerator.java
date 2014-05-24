package com.IsoftStone.register.captcha;

import java.util.Random;

/**
 * Created by Bachelor Wang on 2014/5/23.
 */
public class RandomGenerator {
    private static String range = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static synchronized String getRandomString(){
        Random random = new Random();
        StringBuffer result = new StringBuffer();

        for ( int i = 0; i < 8; i++ )
        {
            result.append( range.charAt( random.nextInt( range.length() ) ) );
        }

        return result.toString();
    }
}
