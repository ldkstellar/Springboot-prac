package dev.ldkstellar.demo;


import org.springframework.stereotype.Component;

@Component
//class springIoc 에서 관리하는 객체이다.
public class TestComponent {
    private TestInterface testInterface;
    public TestComponent(TestInterface testInterface) {
        this.testInterface = testInterface;
        this.testInterface.sayHello();
    }

    public  void sayHello(){
        this.testInterface.sayHello();
    }
}
