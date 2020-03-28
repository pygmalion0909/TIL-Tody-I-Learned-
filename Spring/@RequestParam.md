# @RequestParam
## 1. 개념
* 사용자가 파라미터을 보낼 때 파라미터를 controller에서 받을 수 있게 하는 어노테이션
* 단, RequestParam으로 지정한 키 값이 존재하지 않는다면 BadRequest로 http 에러 발생
* 이를 방지하기 위해 존재하지 않는다면 DefaultValue를 지정 가능
* 쿼리스트링으로 보낼 경우 contorller에서 받을 때 사용하는 어노테이션
* 쿼리스트링이 key=value형태로 보내지니깐 contrllor에서 value값을 받을 때 사용

## 2. 예제
### (1) 기본예제
```
localhost:8080/board?key=value
```
* RequestParam어노테이션은 쿼리스트링으로 받음
* ?key = vlaue에서 value가 파라미터 값으로 전달

### (1)
```java
@RequestMapping("경로")
public String test(@RequestParam String value){
  //  value로 사용가능
}
```
* @RequestParam은 어노테이션 선언
* String은 파라미터의 값의 형태
* value는 파리미터 값을 담은 변수이름

### (2)
```java
@RequestMapping("경로")
public String test(@RequestParam("쿼리스트링의 key이름") String value1, @RequestParam("쿼리스트링의 key이름") String value2){
  // value1, value2로  사용가능
}
```
* 넘어오는 쿼리스트링 개수 만큼 만들어서 담으면 됨
* 하지만 만약 넘오는 값이 많을 경우 vo객체를 만들어 한번에 담는게 좋음
* vo객체로 만들어서 받아오는 파라미터와 vo객체에 있는 set메소드 이름이 일치해야 자동으로 값들이 vo객체에 주입됨
