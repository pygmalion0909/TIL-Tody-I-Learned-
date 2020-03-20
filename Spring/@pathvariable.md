# pathvariable
## 1. 개념
* 사용자가 get방식으로 보낼 경우 URL에 쿼리문에 파라미터가 전달
* 대체적으로 http://123.1.0.0?test=1&test1=2 로 전달
* 위 전달에는 key=value형식으로 전달
* @pathvariable을 사용하면 http://123.1.0.0/test/1로 전달
* URL의 일부를 변수로 전달
* 즉, 서버에서는 / 뒤에 내용을 값으로 쓸 수 있음 

## 2. 예제
```
get방식으로 보내기
http://test.com/detail/userId
```
```java
@RequestMapping(value="/detail/{userId}", method = RequestMethod.GET)
public String home(@PathVariable("userId") String userId){
  // userId에 get방식으로 넘어온 데이터가 담겨 코드에서 사용
}
```
### (1) http://test.com/detail/userId
* 위 url로 서버에 요청
* 만약 get요청에 userId를 10으로 수정하고 보내면 서버에서 userId자리에 10으로 받음

### (2) (@PathVariable("userId") String userId)
* url에서 userId자리에 있는 값만 받음
* 받은 값을 String userId로 받음
* userId는 매개변수이기 때문에 개발자가 자유롭게 바꿔도 됨
* 이제 메소드 내부에서 userId로 사용