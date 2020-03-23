# Integer
## 1. 개념
* Integer는 class 임
* Unboxing 하지 않으면 산술 연산이 불가
* null값은 처리 가능
* int는 null값이 허용 안됨
* 그래서 Integer를 sql에 많이 사용
* 숫자가 들어가는 객체
* 그런데 객체라서 참조형

```java
	Integer integet1 = new Integer(1);
  Integer integet2 = new Integer(2);
  System.out.println(integet1 == integet2); // false

// 반면에

  int int1 = 1;
  int int2 = 1;
  System.out.println(int1 == int2); // true
```
* Integer는 객체라서 참조형이니깐 데이터 주소값이 달라 false이겠지?!
* int는 기본데이터 타입이라 데이터 주소값이 같아 true이겠지?!

## 2. Integer 메서드
