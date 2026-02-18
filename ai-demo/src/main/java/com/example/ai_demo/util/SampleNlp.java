package com.example.ai_demo.util;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

public class SampleNlp {
    public static void main(String[] args) {
        //设置APPID/AK/SK
        String APP_ID = "122003317";
        String API_KEY = "9QOZL6VY7CvyFi1DNKuyJG6q";
        String SECRET_KEY = "h49USi3elXxI52Q78ytQ0W0fnirc8urm";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        String text = "百度是一家人工只能公司";
        JSONObject res = client.ecnet(text, null);
        System.out.println(res.toString(2));

    }
}
