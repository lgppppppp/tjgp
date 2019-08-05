package cn.com.taiji.security.securitydemo1;

import org.junit.Test;

import java.util.Base64;

/**
 * @program: securitydemo1
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-01 11:42
 **/
public class TestBase64 {
    public static void main(String[] args) {
        String a="aaa";
        Base64.getEncoder().encode((a+"bbb").getBytes());
    }
}
