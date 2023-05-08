package com.cy.soul.content.service;

import com.cy.soul.entity.response.ResInEmo;

import java.math.BigDecimal;

public interface EmoService {

    /**
     * @param x      当前坐标x
     * @param y      当前坐标y
     * @param EmoVal 移动步长
     * @return
     */
    default ResInEmo changeEmo(BigDecimal x, BigDecimal y, BigDecimal EmoVal) {
        return null;
    }

}
