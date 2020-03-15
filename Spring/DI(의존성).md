# 의존성 주입(DI = Dependency Injection) 
```java
public class A {
    B b = new B();
    
    public void methodA() {
    	b.methodB();
    }
}
```
* A 객체에서 B의 객체를 불러옴
* methodA에서 b의 메서드를 사용
* B의 메소드가 달라지면 A의 내용도 달라짐
* A가 B에게 의존한다고 표현

