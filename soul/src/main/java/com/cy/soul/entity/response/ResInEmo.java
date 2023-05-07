package com.cy.soul.entity.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 输入情绪
 */
@Data
public class ResInEmo {

    //初始情绪坐标x
    private BigDecimal emoX;
    //初始情绪坐标y
    private BigDecimal emoY;


}
