package com.hackaton.Good_Night_3rd_Hackathon_Backend.beanfind.error;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.AppConfig;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service.WishService;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service.WishServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 조회(실패 코드)")
    void findByAll(){
        Object beans = ac.getBean(Object.class);
        System.out.println(beans);
        System.out.println(beans.getClass());
        //
    }
}
