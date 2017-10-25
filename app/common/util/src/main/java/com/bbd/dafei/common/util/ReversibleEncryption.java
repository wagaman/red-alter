package com.bbd.dafei.common.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * 可逆加解密
 * @author Ian.Su
 * @version ReversibleEncryption.java, v 0.1 2017/7/31 11:17 Ian.Su Exp $
 **/
public class ReversibleEncryption {

    private static final Logger logger = LoggerFactory.getLogger(ReversibleEncryption.class);


    private static final String AESTYPE = "AES/ECB/PKCS5Padding";
    private static final String encoding = "UTF-8";
    public static final String defaultKey = "123456qwerty1111";


    /**
     *
     * 加密
     * @param content  要加密的内容
     *
     *
     * */
    public static String encrypt(String content, String key){
        if(content.length() < 1){
            return "";
        }
        byte[] encrypt = null;
        try{
            Key rekey = generateKey(key);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, rekey);
            encrypt = cipher.doFinal(content.getBytes(encoding));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(encrypt));
    }




    public static String decrypt(String content, String key){
        if(content.length() < 1){
            return "";
        }
        byte[] decrypt = null;
        try{
            Key rekey = generateKey(key);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, rekey);
            decrypt = cipher.doFinal(Base64.decodeBase64(content.getBytes(encoding)));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(decrypt).trim();
    }




    private static Key generateKey(String key) throws Exception{
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(encoding),"AES");
            return keySpec;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }








    public static void main(String [] agrs){

        // String key = "123456qwerty1111";

        String key = "123456qwerty1111";

        String encr = encrypt("我是fadsf",key);

        System.out.println(encr);

        System.out.println( decrypt(encr,key) );



    }

}
