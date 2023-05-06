package com.cy.soul.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 初始情绪及参数
 */
@Data
public class Talent {

    //初始情绪坐标x
    private BigDecimal emoX;
    //初始情绪坐标y
    private BigDecimal emoY;

    //情绪平复时间速率 以分钟为单位平复率0~1
    private BigDecimal timeCurvature;
    //情绪增长速率 0~1 输入情绪因子对应现有情绪因子转换率
    private BigDecimal emoUpCurvature;


}
