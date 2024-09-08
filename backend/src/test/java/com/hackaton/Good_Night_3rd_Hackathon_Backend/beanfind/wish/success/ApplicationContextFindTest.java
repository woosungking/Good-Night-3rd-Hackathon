package com.hackaton.Good_Night_3rd_Hackathon_Backend.beanfind.wish.success;

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
    @DisplayName("빈 이름으로 조회")
    void findByName(){
        WishService wishService = ac.getBean("wishService", WishService.class);
        System.out.println("wishService = "+wishService);
        System.out.println("wishService.getClass() = "+wishService.getClass());
//        Assertions.assertInstanceOf(WishServiceImpl.class, wishService);
//        Assertions.assertInstanceOf(WishService.class, wishService);
//        Assertions.assertInstanceOf(WishDaoImpl.class, wishService);
    }

    @Test
    @DisplayName("타입으로 빈 조회")
    void findByType() {
        WishService wishService = ac.getBean(WishService.class);
        WishServiceImpl wishServiceImpl = ac.getBean(WishServiceImpl.class);

        // 타입으로 Bean을 조회했을 때 동일 인스턴스인지 확인
        Assertions.assertSame(wishServiceImpl, wishService, "The beans should be the same instance.");

        // WishService 의 구현체가 1개밖에 없어서 테스트 통과를 하지만, 구현체가 2개 이상일때 인터페이스의 타입으로 조회를 하면
        // 원하는 결과를 얻지 못 할 수 있다. 주의주의 ~!
    }


}
