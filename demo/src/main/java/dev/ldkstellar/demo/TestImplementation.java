package dev.ldkstellar.demo;


import org.springframework.stereotype.Component;

@Component
public class TestImplementation implements TestInterface{// 인터페이스의 구현체면 Test interface 객체라고 볼수 있다.
    @Override

    public void sayHello() {
        System.out.println("hello I'm a bean");

    }
}
