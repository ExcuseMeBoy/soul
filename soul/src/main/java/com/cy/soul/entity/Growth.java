package com.cy.soul.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Growth {

    //喜 行为次数
    private Integer happyActsNum;
    //怒 行为次数
    private Integer angerActsNum;
    //哀 行为次数
    private Integer sorrowActsNum;
    //乐 行为次数
    private Integer cheerfulActsNum;

    //初始情绪 喜 节点
    private BigDecimal happyEmoPoint;
    //初始情绪 怒 节点
    private BigDecimal angerEmoPoint;
    //初始情绪 哀(啊~雪莉~) 节点
    private BigDecimal sorrowEmoPoint;
    //初始情绪 乐 节点
    private BigDecimal cheerfulEmoPoint;


}
