package com.bbd.dafei.test;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ian.Su
 * @version $Id: RegTest.java, v 0.1 2017/5/14 15:51 Ian.Su Exp $
 */
public class RegTest {

    public static void main(String [] agrs){


        System.out.println(0.1+0.2-0.3);

        String  a = "https://mail.huawei.com ";
        Pattern p = Pattern.compile(".+(?=:)");
        Matcher m = p.matcher(a);
        while (m.find ())
        {
            String group = m.group ();
            System.out.println (group);
        }

    }
}
