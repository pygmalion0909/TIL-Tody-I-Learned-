### 현 내용은 "Java의 정석"(저자: 남궁성) 도서를 읽고 정리한 글 입니다.
# Java 객체지향 (Java의 정석 6장)
## 인스턴스 생성과 사용
```java
class Tv{
  Stirng color;
  boolean power;
  int channel;

  void power(){power = !power;}
  void channelIp(){++channel;}
  void channelDown(){--channerl;}
}

class TvTest{
  public static void main(String args[]){
    Tv t;
    t = new Tv();
    t.channerl = 7;
    t.channelDown();
    System.out.println("현재채널은" + t.channel + "입니다.");
  }
}
```
1. Tv t 

    개발자가 만든 Tv class로 t 변수 선언. Tv t = new Tv();로 줄임 가능
2. 
