package com.cy.soul.entity.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 输出情绪
 */
@Data
public class ResInEmoAnswer {

    //移动步长
    private BigDecimal step;

    //移动方向标识
    private String emoTag;


}
