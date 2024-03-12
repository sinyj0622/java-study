package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Bean만 사용해도 스프링 비으로 등록되지만, 싱글톤을 보장하지 않는다.
//의존관계 주입이 필요해서 메서드를 직접 호출할 때 싱글톤을 보장하지 않는다.
//스프링 설정정보는 항상 @Configuration을 사용하자!
public class AppConfig {
    //역할과 구현 클래스가 한눈에 들어온다.
    //애플리케이션 설정정보
    @Bean
    public MemberService memberService(){
        System.out.println("call memberService");
        return new MemberServiceImpl(memberRepository());
    }
    
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call memberRepository");
        return new MemoryMemberRepository();
    }
    
    @Bean
    public OrderService orderService(){
//        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
        return null;
    }
    
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
