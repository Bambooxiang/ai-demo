package com.example.ai_demo.controller;

import com.example.ai_demo.dto.OcrContent;
import com.example.ai_demo.mapper.OcrContentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {
    @Autowired
    private OcrContentMapper ocrContentMapper;

    @RequestMapping(value = "getAllContent",method = RequestMethod.GET)
    public List<OcrContent> getAllContent(){
        return ocrContentMapper.selectList(null);
    }

    @RequestMapping(value = "deleteContent",method = RequestMethod.DELETE)
    public Integer deleteContent(@Param("id") Integer id){
        return ocrContentMapper.deleteById(id);
    }
}
