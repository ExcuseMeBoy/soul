package com.cy.soul.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Talent
{
    private String id;

    //初始情绪 喜 节点
    private BigDecimal happyEmoPoint;
    //初始情绪 怒 节点
    private BigDecimal angerEmoPoint;
    //初始情绪 哀(啊~雪莉~) 节点
    private BigDecimal sorrowEmoPoint;
    //初始情绪 乐 节点
    private BigDecimal cheerfulEmoPoint;

    //情绪平复时间速率 以分钟为单位平复率0~1
    private BigDecimal timeCurvature;
    //情绪增长速率 0~1 输入情绪因子对应现有情绪因子转换率
    private BigDecimal emoUpCurvature;




}
