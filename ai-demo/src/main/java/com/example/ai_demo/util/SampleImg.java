package com.example.ai_demo.util;


import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.util.HashMap;

public class SampleImg {

    public static void main(String[] args) {
        //设置APPID/AK/SK
        String APP_ID = "122003156";
        String API_KEY = "dIk8yLV51JVetrdssWObW8ZG";
        String SECRET_KEY = "Sm7X51lSSPVdSASWGVFhXHeEOtzdMSMx";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        String path = "C:\\Users\\xiaoxiangzzz\\Desktop\\learning\\project\\ai-demo\\test\\星夜山.png";
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}

