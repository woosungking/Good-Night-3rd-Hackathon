package com.hackaton.Good_Night_3rd_Hackathon_Backend.beanfind;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.AppConfig;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service.WishService;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service.WishServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ApplicationContextFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 조회(실패 코드)")
    void findByAll(){
        Object beans = ac.getBean(Object.class);
        System.out.println(beans);
        System.out.println(beans.getClass());
    }

    @Test
    @DisplayName("모든 빈 조회")
    void findByAll2(){
        Map<String, Object> beans = ac.getBeansOfType(Object.class);
        System.out.println("!!!!!!!!!"+beans);
        System.out.println(beans.getClass());

        Object temp = beans.get("wishService");
        System.out.println("!@#!@#!@#!@#"+temp);
    }
}
