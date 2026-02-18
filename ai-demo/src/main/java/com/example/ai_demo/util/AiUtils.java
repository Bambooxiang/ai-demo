package com.example.ai_demo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AiUtils {

    public static String img(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "122003156";
        String API_KEY = "dIk8yLV51JVetrdssWObW8ZG";
        String SECRET_KEY = "Sm7X51lSSPVdSASWGVFhXHeEOtzdMSMx";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        JSONObject result = res.getJSONArray("result").getJSONObject(0);

        String s = "这张图"+result.getDouble("score")*100+"%是"+result.getString("root") + "-" + result.getString("keyword");
        return s;
    }

    public static String word(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "122002931";
        String API_KEY = "HzAEkJtY7kYQY1BpmZfsQRLD";
        String SECRET_KEY = "CJCrJO0cDPks1NGh3KmRKNoNcY84sTOi";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.basicGeneral(file.getBytes(),new HashMap<String, String>());
        JSONArray jsonArray = res.getJSONArray("words_result");
        StringBuffer sb= new StringBuffer();
        for(int i=0;i< jsonArray.length();i++){
            sb.append(jsonArray.getJSONObject(i).getString("words"))
                    .append("\n");
        }
        return sb.toString();
    }

    public static String nlp(String text){
        //设置APPID/AK/SK
        String APP_ID = "122003317";
        String API_KEY = "9QOZL6VY7CvyFi1DNKuyJG6q";
        String SECRET_KEY = "h49USi3elXxI52Q78ytQ0W0fnirc8urm";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.ecnet(text, null);
        String res1 = res.getJSONObject("item").getString("correct_query");
        return res1;
    }

    public static void main(String[] args) {
        String text = "百度是一家人工只能公司!!!!";
        System.out.println(nlp(text));
    }
}
