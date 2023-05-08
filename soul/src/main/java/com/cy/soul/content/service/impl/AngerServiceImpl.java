package com.cy.soul.content.service.impl;

import com.cy.soul.content.service.EmoService;
import com.cy.soul.entity.response.ResInEmo;
import com.cy.soul.util.EmoUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 怒
 */
@Service("anger")
public class AngerServiceImpl implements EmoService {

    @Override
    public ResInEmo changeEmo(BigDecimal x, BigDecimal y, BigDecimal EmoVal) {
       return EmoUtil.moveToPoint(x, y, new BigDecimal("0"), new BigDecimal("1"), EmoVal);

    }

}
