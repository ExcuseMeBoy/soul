package com.cy.soul.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 情绪增长模型
 */
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

    //初始情绪坐标x
    private BigDecimal emoX;
    //初始情绪坐标y
    private BigDecimal emoY;


    public void setEmo(String tag) {
        switch (tag) {
            case "anger":
                angerActsNum += 1;
                break;
            case "cheerful":
                happyActsNum += 1;
                break;
            case "happy":
                cheerfulActsNum += 1;
                break;
            case "sorrow":
                sorrowActsNum += 1;
                break;
            default:
                break;
        }
    }

}
