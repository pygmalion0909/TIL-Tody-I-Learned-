# @Data
## 1. 개념
* 롬복의 어노테이션
* getter, setter, toString등을 자동으로 만들어줌
* 잘 만들어졌는지 outline에서 확인가능

## 2. 사용
```java
@Data
public String lom{
  private String id;
  private String password;
}
```
* 위 같이 @Data 어노테이션만 만들어주면 자동적으로 getter, setter, toString이 만들어짐
