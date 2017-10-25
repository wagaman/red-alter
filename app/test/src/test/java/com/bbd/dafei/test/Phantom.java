package com.bbd.dafei.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ian.Su
 * @version $Id: Phantom.java, v 0.1 2017/5/12 15:54 Ian.Su Exp $
 */
public class Phantom {

    public static void main(String [] agrs){



        String [] p = {
                "/opt/apache-tomcat-8.5.9/webapps/ROOT/sysplugins/phantomjs",
                "/opt/apache-tomcat-8.5.9/webapps/ROOT/sysplugins/rasterize.js",
                "http://192.168.20.72:8080/pdfMaps?companyId=029542e0c73e41dca589b70e9021a39a&degree=2&province=四川省",
                "/opt/apache-tomcat-8.5.9/webapps/ROOT/sysplugins/1.png",
                "A4"
        };

        Process process = null;
        StringBuilder msg = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(p);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        } catch (IOException e) {
            msg.append("error");
        }
        System.out.println(msg);

    }


}
