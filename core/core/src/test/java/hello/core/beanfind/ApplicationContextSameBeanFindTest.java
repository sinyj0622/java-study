package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

//    @Test
//    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
//    void findBeanByTypeDuplicate(){
//        ac.getBean(DiscountPolicy.class);
//    }

    @Configuration
    static class SameBeanConfig {

//        @Bean
//        public MemberRepository memberRepository1(){
//            return new MemoryMemberRepository();
//        }
//
//        @Bean
//        public MemberRepository memberRepository2(){
//            return new MemoryMemberRepository();
//        }
    }
}
