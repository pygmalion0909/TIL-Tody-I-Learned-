# Generrics(제너릭스)
## 1. 개념
* 컬렉션 클래스에서 다룰 객체를 미리 명시해줌으로써 형변환을 하지 않고 사용하는 것
* Generrics를 사용하면 ㅏ입의 안정성을 제공, 타입체크와 형변환을 생략 가능
* <String>는 String객체만, <Integer>는 Interger클래스만 이렇게 정함

## 2. 예제
```java
ArrayList<String> stringEx = new ArrayList<Stirng>();
stringEx.add("안녕하세요");
stringEx.add(1); // 에러
```
