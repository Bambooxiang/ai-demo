package com.example.ai_demo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`ocr_content`")

public class OcrContent
{
    private Integer id;
    private String content;
    private Integer type;
    private Date createTime;
    private Date modifyTime;
}
