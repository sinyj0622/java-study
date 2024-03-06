package hello.core.singleton;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void stateFulServiceSingleton(){
        //스프링 빈은 항상 무상태(stateless)로 설계하자
        //필드 대신에 자바에서 공유되지 않는 지역변수, 파라미터, ThreadLocal등을 사용해야 한다
        
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAp = stateFulService1.order("userA",10000);
        //ThreadA: B사용자 20000원 주문
        int userBp = stateFulService1.order("userB",20000);

        //ThreadA: 사용자A 주문 금액 조회
//        int price = stateFulService1.getPrice();
        System.out.println("price = " + userAp);

//        Assertions.assertThat(stateFulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }

}