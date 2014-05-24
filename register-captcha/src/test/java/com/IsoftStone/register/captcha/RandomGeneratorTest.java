package com.IsoftStone.register.captcha;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;

/**
 * Created by Bachelor Wang on 2014/5/23.
 */
public class RandomGeneratorTest {
    @Test
    public void testGetRandomString() throws  Exception{
        Set<String> randoms = new HashSet<String>(100);

        for ( int i = 0; i < 100; i++ )
        {
            String random = RandomGenerator.getRandomString();

            assertFalse( randoms.contains( random ) );

            randoms.add( random );
        }
    }
}
