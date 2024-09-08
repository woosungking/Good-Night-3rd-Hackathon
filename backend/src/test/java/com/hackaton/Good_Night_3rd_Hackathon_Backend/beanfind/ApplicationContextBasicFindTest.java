package com.hackaton.Good_Night_3rd_Hackathon_Backend.beanfind;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.AppConfig;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.dao.WishDaoImpl;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service.WishService;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service.WishServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName(){
        WishService wishService = ac.getBean("wishService", WishService.class);
        System.out.println("wishService = "+wishService);
        System.out.println("wishService.getClass() = "+wishService.getClass());
//        Assertions.assertInstanceOf(WishServiceImpl.class, wishService);
//        Assertions.assertInstanceOf(WishService.class, wishService);
//        Assertions.assertInstanceOf(WishDaoImpl.class, wishService);
    }
}
