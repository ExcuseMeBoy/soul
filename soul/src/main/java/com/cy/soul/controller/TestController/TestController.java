package com.cy.soul.controller.TestController;

import com.cy.soul.content.service.EmoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class TestController {
    @Autowired
   private EmoService strategy;

    @GetMapping("/t")
    public void test(){
        BigDecimal bigDecimal = strategy.changeEmo(new BigDecimal("0.01"), new BigDecimal("0.01"), new BigDecimal("0.01"));
        System.out.println(bigDecimal);
    }
}
