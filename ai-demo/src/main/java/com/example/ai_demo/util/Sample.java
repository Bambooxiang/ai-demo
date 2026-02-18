package com.example.ai_demo.util;

import java.util.*;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
public class Sample {

    public static void main(String[] args) {
        //设置APPID/AK/SK
        String APP_ID = "122002931";
        String API_KEY = "HzAEkJtY7kYQY1BpmZfsQRLD";
        String SECRET_KEY = "CJCrJO0cDPks1NGh3KmRKNoNcY84sTOi";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        String path = "C:\\Users\\xiaoxiangzzz\\Desktop\\learning\\project\\ai-demo\\test\\伊蕾娜聊天 (1).png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}