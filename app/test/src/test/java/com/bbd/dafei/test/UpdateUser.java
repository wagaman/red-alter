package com.bbd.dafei.test;

import com.bbd.dafei.biz.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Ian.Su
 * @version $Id: UpdateUser.java, v 0.1 2017/5/31 9:12 Ian.Su Exp $
 */
public class UpdateUser {


    public static void main(String[] agrs)  {

        Logger logger = LoggerFactory.getLogger(UpdateUser.class);

        UserServiceImpl ser = new UserServiceImpl();

        String[] users = {
                "admin",
                "beijing",
                "tianjing",
                "shanghai",
                "chongqing",
                "hebei",
                "shanxi",
                "liaoning",
                "jilin",
                "heilongjiang",
                "jiangsu",
                "zhejiang",
                "anhui",
                "fujian",
                "jiangxi",
                "shandong",
                "henan",
                "hubei",
                "hunan",
                "guangdong",
                "hainan",
                "sichuan",
                "guizhou",
                "yunnan",
                "shanxi1",
                "gansu",
                "qinghai",
                "neimenggu",
                "guangxi",
                "xizang",
                "ningxia",
                "xinjiang",
                "jiangsu1",
                "guangdong1",
                "jiangsu2",
                "guangdong2",
                "anhui1",
                "anhui2",
                "beijing1",
                "beijing2"};

        String a_z_1_9 = "qwertyuioipasdfghjklzxcvbnmqwer1234567890";

        FileWriter sqlfw = null;
        FileWriter userfw = null;
        BufferedWriter sql = null;
        BufferedWriter userPwd = null;
        try {
            sqlfw = new FileWriter(new File("F:/updatePwd.sql"));
            sql= new BufferedWriter(sqlfw);

            userfw = new FileWriter(new File("F:/userPwd.txt"));
            userPwd = new BufferedWriter(userfw);

            for (int k = 0; k < users.length; k++) {

                Random r = new Random();
                String pwd = "";

                for (int len = 0; len < 8; len++) {
                    pwd = pwd + a_z_1_9.charAt(r.nextInt(a_z_1_9.length()));
                }

                String sqlPwd = ser.getPasswrodForMD5(pwd, "MD5");
                sql.write(String.format("update ra_user set password='%s' , salt='%s' where username='%s' ;", sqlPwd, "MD5", users[k]));
                sql.newLine();
                userPwd.write(users[k] + "   " + pwd);
                userPwd.newLine();

            }
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }finally {



            try {

                if( null != sql){
                    sql.flush();
                    sql.close();
                }

            } catch (Exception e) {
                throw  new RuntimeException(e);
            }
            try {
                if(null != userPwd){
                    userPwd.flush();
                    userPwd.close();
                }
            } catch (Exception e) {
                throw  new RuntimeException(e);
            }
        }
    }

}
