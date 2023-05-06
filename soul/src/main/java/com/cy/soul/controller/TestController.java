package com.cy.soul.controller;

import com.cy.soul.config.EmoConfig;
import com.cy.soul.content.AffectiveStrategy;
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
        System.out.println(emoConfig.getFilepath());
        return null;
    }
}
