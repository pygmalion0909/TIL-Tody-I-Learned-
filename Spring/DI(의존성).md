# 의존성 주입(DI = Dependency Injection)
## 1. 개념
* 다른 객체를 사용하는 것을 다른 객체를 의존 한다 라는 의미
* 객체를 내가 생성해서 사용할 수 있고 다른 객체를 불러와서 사용 가능
* 만약, a가 b,c의 객체를 사용하고 싶으면 a가 b,c를 직접 만들어서 사용가능함
* 이때 a는 b,c를 의존한다 라고 함
* 또한, a가 b,c를 다른 곳에서 불러와서 사용가능 
* 여기서 컨테이너라는 의미가 나옴, 컨터네이는 다양한 객체를 모아 두고 누가 객체 빌려달라고 하면 빌려주는 역할, 즉, 컨테이너가 객체를 담당하고 있어 a가 b,c객체의 라이플사이클을 담당할 필요가 없어 객체를 사용함에 있어 관리하기 쉬움
* 이렇게 컨테이너에서 불러서 사용하면 a는 관리할게 적어 b,c객체와 약한 결합을 가짐
* 만약, a가 b,c객체를 직접 만들면 b,c를 관리를 해줘야 하기 때문에 강한 결합이라고 함

## 2. 예제
```java
public class Test{
    public static void main(String[] args){
    }
    // 강한결합(클래스를 직접 생성)
    public static void test1(){
        Rock r = new Rock();
    }
    // 약한 결합(생성된 클래스를 주입 받음)
    public Static void test2(Rock r){
        Rock r1 = r;
    }
}

class Rock{
    String name;
    String nickName;
}
```

## 3. 약한결합을 해야하는 이유
* 다른 클래스의 변화에 안전하게 대체할 수 있음
