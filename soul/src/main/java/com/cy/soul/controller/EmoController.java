package com.cy.soul.controller;

import com.cy.soul.config.EmoConfig;
import com.cy.soul.content.AffectiveStrategy;
import com.cy.soul.entity.Growth;
import com.cy.soul.entity.InEmo;
import com.cy.soul.entity.Talent;
import com.cy.soul.entity.response.ResInEmo;
import com.cy.soul.entity.response.ResInEmoAnswer;
import com.cy.soul.util.EmoUtil;
import com.cy.soul.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmoController {

    @Autowired
    private AffectiveStrategy strategy;


    @Autowired
    private EmoConfig emoConfig;

    //初始化模型建立
    @GetMapping("/start")
    public String start() {
        Talent talent = new Talent();
        ResInEmo res = EmoUtil.emoRandomPoint();
        BeanUtils.copyProperties(res, talent);
        //初始化情绪参数并且写入文件
        talent.setEmoUpCurvature(EmoUtil.random());
        talent.setTimeCurvature(EmoUtil.random());
        FileUtil.JSONWriteUtil(emoConfig.getStartfilepath(), talent);

        //初始化当前情绪
        Growth growth = new Growth();
        BeanUtils.copyProperties(res, growth);
        growth.setAngerActsNum(0);
        growth.setCheerfulActsNum(0);
        growth.setHappyActsNum(0);
        growth.setSorrowActsNum(0);
        FileUtil.JSONWriteUtil(emoConfig.getGrowthfilepath(), growth);

        return "ok";
    }

    @PostMapping("/input")
    public Growth input(@RequestBody InEmo inEmo) {
        //读取输入的情绪坐标
        //计算反馈情绪值
        ResInEmoAnswer answer = EmoUtil.calculateEmo(inEmo.getX(), inEmo.getY());

        //读取当前的模型值
        Growth growth = FileUtil.JSONReadUtil(emoConfig.getGrowthfilepath(), new Growth());

        //读取天赋值
        Talent talent = FileUtil.JSONReadUtil(emoConfig.getStartfilepath(), new Talent());

        //当前的情绪值
        ResInEmo res = strategy.strategy(answer.getEmoTag()).changeEmo(growth.getEmoX(), growth.getEmoY(), answer.getStep().multiply(talent.getEmoUpCurvature()));

        System.out.println("返回"+res);
        growth.setEmoX(res.getEmoX());
        growth.setEmoY(res.getEmoY());
        growth.setEmo(answer.getEmoTag());
        //写入文件
        FileUtil.JSONWriteUtil(emoConfig.getGrowthfilepath(), growth);
        //
        return growth;
    }

    @GetMapping("/nowEmo")
    public Growth nowEmo() {
        //读取当前的模型值
        return FileUtil.JSONReadUtil(emoConfig.getGrowthfilepath(), new Growth());

    }

}
