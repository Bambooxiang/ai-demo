package com.example.ai_demo;


import com.example.ai_demo.controller.ContentController;
import com.example.ai_demo.dto.OcrContent;
import com.example.ai_demo.dto.User;
import com.example.ai_demo.mapper.OcrContentMapper;
import com.example.ai_demo.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class QuickStartTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OcrContentMapper ocrContentMapper;
    @Autowired
    private ContentController contentController;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);

//        for(User user : userList) {
//            System.out.println(user);
//        }

        for(int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }

        for(int i = 0; i < userList.size(); i++) {
            User user= userList.get(i);
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getEmail());
            System.out.println("==================================");
        }
//        Assertions.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectOcr() {
        System.out.println(("----- selectAll method test ------"));
        List<OcrContent> ocrContents = ocrContentMapper.selectList(null);


        for(int i = 0; i < ocrContents.size(); i++) {
            System.out.println(ocrContents.get(i));
        }

        for(int i = 0; i < ocrContents.size(); i++) {
            OcrContent ocrContent = ocrContents.get(i);
            System.out.println(ocrContent.getId());
            System.out.println(ocrContent.getContent());
            System.out.println("==================================");
        }
    }

    @Test
    public void testInsertOcr() {
        System.out.println(("----- Insert method test ------"));
        OcrContent ocrContent2 = new OcrContent();
        ocrContent2.setId(2);
        ocrContent2.setContent("xiang");
        ocrContent2.setType(1);
        ocrContent2.setCreateTime(new Date());
        ocrContent2.setModifyTime(new Date());
        int successNum = ocrContentMapper.insert(ocrContent2);
        System.out.println("成功插入  " + successNum + "条");

    }

    @Test
    public void deleteInsertOcr() {
        System.out.println(("----- deleteInsertOcr method test ------"));
        int successNum = ocrContentMapper.deleteById(2);
        System.out.println("成功删除  " + successNum + "条");
    }

    @Test
    public void updateInsertOcr() {
        System.out.println(("----- updateInsertOcr method test ------"));
        OcrContent ocrContent2 = new OcrContent();
        ocrContent2.setId(1);
        ocrContent2.setContent("xiangzzz");
        ocrContent2.setType(1);
        ocrContent2.setCreateTime(new Date());
        ocrContent2.setModifyTime(new Date());
        int successNum = ocrContentMapper.updateById(ocrContent2);
        System.out.println("成功更新  " + successNum + "条");

    }

    @Test
    public void ContentControllerTest(){
        System.out.println(("----- ContentControllerTest method test ------"));
        List<OcrContent> OcrContents = contentController.getAllContent();
        for(int i = 0; i < OcrContents.size(); i++) {
            OcrContent user= OcrContents.get(i);
            System.out.println(user.getId());
            System.out.println(user.getContent());
            System.out.println("==================================");
        }

    }
}

