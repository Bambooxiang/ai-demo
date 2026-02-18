package com.example.ai_demo.controller;

import com.baidu.aip.ocr.AipOcr;
import com.example.ai_demo.dto.OcrContent;
import com.example.ai_demo.mapper.OcrContentMapper;
import com.example.ai_demo.util.AiUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@RestController
public class AiController {

    @Autowired
    private OcrContentMapper ocrContentMapper;

    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public String img(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AiUtils.img(file);
        OcrContent ocrContent = new OcrContent();
        ocrContent.setContent(res);
        ocrContent.setType(1);
        //查询数据库里面最大ID
        //set id+1
        long i=ocrContentMapper.selectCount(null);
        ocrContent.setId((int) (i+1));
        ocrContent.setCreateTime(new Date(System.currentTimeMillis()));
        ocrContent.setModifyTime(new Date(System.currentTimeMillis()));
        ocrContentMapper.insert(ocrContent);
        return res;
    }

    @RequestMapping(value = "/word",method = RequestMethod.POST)
    public String word(@RequestParam("file") MultipartFile file) throws IOException {
//      return AiUtils.word(file);

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
        OcrContent ocrContent = new OcrContent();
        ocrContent.setContent(sb.toString());
        ocrContent.setType(2);
        //查询数据库里面最大ID
        //set id+1
        long i=ocrContentMapper.selectCount(null);
        ocrContent.setId((int) (i+1));
        ocrContent.setCreateTime(new Date(System.currentTimeMillis()));
        ocrContent.setModifyTime(new Date(System.currentTimeMillis()));
        ocrContentMapper.insert(ocrContent);
        return sb.toString();
    }

    @RequestMapping(value = "/nlp",method = RequestMethod.GET)
    public String nlp(@RequestParam("text")String text) {
        String nlpRes = AiUtils.nlp(text);
        OcrContent ocrContent = new OcrContent();
        ocrContent.setContent(nlpRes);
        ocrContent.setType(3);
        //查询数据库里面最大ID
        //set id+1
        long i=ocrContentMapper.selectCount(null);
        ocrContent.setId((int) (i+1));
        ocrContent.setCreateTime(new Date(System.currentTimeMillis()));
        ocrContent.setModifyTime(new Date(System.currentTimeMillis()));
        ocrContentMapper.insert(ocrContent);
        return nlpRes;
    }
}
