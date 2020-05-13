package com.example.letscode.demoletscode;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SimpleTest {
    @Test
    public void test(){
        int x = 2;
        int y = 3;
        Assert.assertEquals(5, x+y);
        Assert.assertEquals(6, x*y);
    }

    @Test
    public void encode(){
        PasswordEncoderForTest passwordEncoderForTest = new PasswordEncoderForTest();
        Assert.assertEquals("secret: 'mypwd'", passwordEncoderForTest.encode("mypwd"));
        Assert.assertThat(passwordEncoderForTest.encode("mypwd"), Matchers.containsString("mypwd"));
    }
}
