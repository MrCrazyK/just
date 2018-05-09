package com.just.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 11253 on 2018/3/26.
 */
public class FastJson_All {
    public static void toJson(Object obj,HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("utf-8");
        String jsonStr = JSON.toJSONString(obj,
                SerializerFeature.DisableCircularReferenceDetect);
        // 设置禁止json循环引用
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.write(jsonStr);
        out.flush();
    }
}
