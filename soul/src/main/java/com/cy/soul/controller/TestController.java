package com.cy.soul.controller;

import com.cy.soul.config.EmoConfig;
import com.cy.soul.content.AffectiveStrategy;
import com.cy.soul.entity.Talent;
import com.cy.soul.entity.response.ResInEmo;
import com.cy.soul.util.EmoUtil;
import com.cy.soul.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TestController {
    @Autowired
    private AffectiveStrategy strategy;

    @GetMapping("/t")
    public void test() {
        BigDecimal bigDecimal = strategy.strategy("happy").changeEmo(new BigDecimal("0.01"), new BigDecimal("0.01"), new BigDecimal("0.01"));
        System.out.println(bigDecimal);
    }

    @Autowired
    private EmoConfig emoConfig;

    //初始化模型建立
    @GetMapping("/start")
    public String start() {
        Talent talent = new Talent();
        ResInEmo res = EmoUtil.emoRandomPoint();
        BeanUtils.copyProperties(res, talent);

        System.out.println(emoConfig.getFilepath());
        return null;
    }
}
