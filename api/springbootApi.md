# spring boot로 restful api 만들기
## 1. 프로젝트 생성
### (1) 라이브러리
1. maven
2. spring web
4. dev tools
5. lombok
3. jpa
6. h2

## 2. Api 종류
### (1) /users (get)
* 모든 사용자 조회

### (2) /users (post)
* 사용자 등록

### (3) /users/{id} (get)
* 특정 user 상세 조회

### (4) /users/{id} (delete)
* 특정 user 삭제

### (5) /users/{id}/posts (get)
* 특정 사용자가 작성한 포스트 조회

### (6) /users/{id}/posts (post)
* 특정 users 포스트 작성

### (7) /users/{id}/posts/{post_id}
* 특정 users가 작성한 포스트 상세페이지 조회

## 3. controller 연습
```java
// controller
@RestController
public class HelloWorld(){

  @GetMapping("hello")
  public HelloWorldBean hellowroldbean(){
    return new HelloWorldBean("helloWorld!")
  }

}

// HelloWorldBean
public calss HelloWroldBean(){
  private String massage;

  public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

  public HelloWorldBean(String ms) {
		this.message = ms;
	}

}
// 사용자가 hello로 접근하면 {"massage" : "hellowrold!"}로 출력 됨 
```
* RestController을 사용하여 body에 담지 않고 데이터 보내기

1. public HelloWorldBean(String ms) {}
* 해당 컨스트럭트 때문에 controller에서 helloWrold문자열을 받아서 HelloWorldBean 클래스에서 있는 massage변수에 담는다
* 이후 controller에서 HellowWorldBean을 return하면 사용자가 hello로 접근하면 {"massage" : "hellowrold!"}로 출력 됨
* massage의 getter,setter가 없으면 해당 변수에 값이 들어가지 않음

## 4. Path Variable
* 가변적인 url을 만들 수 있음
* 해당 url부분은 사용자가 임의적으로 값을 지정하여 전달하면 서버에서 받음

```java
@GetMapping("hello/{name}")
	public HelloWorldBean variable(@PathVariable(value="name") String nam) {
		System.out.println(nam);
	}
```
1. @GetMapping("hello/{name}")
* 사용자가{name}부분은 임의적으로 지정하여 보낼 수 있음

2. @PathVariable(value="name") String nam
* 페치 어노테이션을 사용하여 사용자가 임의적으로 보낸 값을 받음
* value는 {name}을 뜻하기 때문에 받을 url이름과 같아야 함
* 만약, url과 담을 변수가 같다면 value속성은 사용하지 않고 바로 String name으로 해서 사용 가능
* 여기서는 url name의 값을 nam으로 받을려고 value 속성을 사용

## 5. 의존성 주입 연습
* 글로 정리하기가 어려움
* 코드를 보고 느낌으로 알자

```js

```
