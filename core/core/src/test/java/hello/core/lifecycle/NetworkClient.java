package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    //스프링 빈은 간단하게 다음과 같은 라이프사이클을 가진다.
    //객체생성>의존관계 주입!
    private String url;

    public  NetworkClient(){
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }
    
    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: = " + url);
    }
    
    public void call(String message){
        System.out.println("call: = " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
        disconnect();
    }
    //스프링 빈의 이벤트 라이프사이클
    //스프링 컨테이너 생성>스프링 빈 생성>의존관계주입>초기화 콜백>사용>소멸전 콜백>스프링 종료
    //초기화 콜백: 빈이 생성되고 빈의 의존관계 주입이 완료된 후 호출
    //소멸전 콜백: 빈이 소멸되기 직전에 호출
}
