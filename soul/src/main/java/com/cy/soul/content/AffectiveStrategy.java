package com.cy.soul.content;

import com.cy.soul.content.service.EmoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 情感策略
 */
@Service
public class AffectiveStrategy {

    /**
     * 存储实例化service
     */
    @Autowired
    public Map<String, EmoService> emoMap ;


    public EmoService strategy(String tag) {
        return emoMap.get(tag);
    }


}
