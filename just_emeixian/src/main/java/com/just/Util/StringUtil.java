package com.just.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
    /**
     * md5简单加密工具
     * @param title
     * @return
     */
    public static String getMdf(String title) {
        //用于将字节转换成16进制字符
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try{
            //获取消息摘要的实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            //更新实例，处理需要转换的字符串为字节数组
            md.update(title.getBytes());
            //获得摘要字节数组
            byte[] encryptStr=md.digest();
            //存放结果字符的数组
            char str[]=new char[32];
            //转换结果对应字符串中位置
            int k=0;
            //每个字节转换成16进制字符
            for(int i=0;i<16;i++){
                byte byte0=encryptStr[i];
                //取字节高4位
                str[k++]=hexDigits[byte0>>>4&0xf];
                //取字节低4位
                str[k++]=hexDigits[byte0&0xf];
            }
            //字符数组转换为字符串并返回给结果
            return new String(str);
        }catch (NoSuchAlgorithmException ex) {
            System.out.println("md5加密失败");
        }
        return null;
    }
}
