# Controller
## 1. 개념
* 사용자의 요청을 어떻게 처리 할 지 결정하는 부분 이다. 
* Controller패키지를 따로 만들어 사용한다. 아래의 코드를 보자.

## 2. 기본 예시
```java
@Controller
public class ControllerSt{

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(ModelMap modelMap){
    return "/example/hello";
  }
  
}
```
1. @Controller(Annotation(어노테이션))
* Controller의 역할을 수행한다고 명시적으로 표시해준다. 
* 사용자의 요청이 서버에 도달했을 경우 Controller에 정의 된 기준으로 요청을 처리한다. * 이때 @Controller로 명시적으로 표시한 경우 해당 영역 기준으로 요청을 처리해준다.

2. @RequestMapping(Annotation(어노테이션))
* 사용자의 요청이 Controller에 들어오면 각각의 요청에 따라 응답을 각기 다르게 하기 위한 경로 지정이다. (nodejs에서 라우터 같은 개념?!) 
* 예를 들어 사용자가 <strong>http://naver.com</strong>으로 접속하면 @RequestMapping(value="/hello", method=RequestMethod.GET)으로 맵핑 되어 url이 http://naver.com/hello로 바뀌게 된다. 

3. return "/example/hello"
* 사용자의 요청에 대한 응답이다. 즉, return값으로 응답한다. 경로를 지정해 return으로 값을 두면 jsp파일로 응답 할 수 있다.

4. (ModelMap modelMap)
* 사용자의 요청에 return값으로 응답하는데 여기서는 return값으로 hello.jsp파일로 응답한다. 
* 응답할 때 hello.jsp페이지에 전달해야 할 내용이 있을 경우에 modelMap에 담아서 보내게 된다.

## 3. Controller Get, Post 방식
### 1. get방식
```java
@RequestMapping(value="/userInfo", method=RequestMethod.GET)
public String getUserInfo(@RequestParam("name") String userName, @RequestParam("age") String userAge, Model model) {
    model.addAttribute("userName", userName);
    model.addAttribute("userAge", userAge);
    return "user";
}
```
1. @RequestMapping(value="/userInfo", method=RequestMethod.GET)
* method=RequestMethod.GET는 사용의자 요청이 GET방식인 경우를 지정했다.

2. @RequestParam(Annotation(어노테이션))
* Request로 넘어온 Parameter를 처리하기 위한 어노테이션이다. 즉, 사용자가 GET방식으로 요청할 때 같이 전달되는 값이라고 생각하자. 
* 따라서 <strong>@RequestParam("name"), @RequestParam("age")</strong>을 해석하면 GET방식으로 요청할 때 함께 전달된 값들 중에서 name, age를 뜻 한다.
* <strong>String userName, String userAge</strong>은 GET방식으로 전달될 때 name전달된 값은 String형식으로 userName에 담고 age로 전달된 값은 String형식으로 userAge에 담겠다는 의미다.

### 2. post방식
```java
@RequestMapping(value="/userInfo", method=RequestMethod.POST)
public String postUserInfo(@RequestParam("userName") String userName, @RequestParam("userAge") String userAge, Model model) {
    model.addAttribute("userName", userName);
    model.addAttribute("userAge", userAge);
    return "user";
}
```
* GET방식과 차이점은 <strong>method=RequestMethod.POST</strong>로 설정이다. 참고로 method=RequestMethod는 default값이 GET방식이다.

## 4. Parmeter값이 많을 경우
### (1) Jsp에서 넘온 Parameter를 Controller에서 출력하기
```jsp
<!-- Jsp -->
	<form action="/testing" method="get">
		<input type="text" name="userId">
		<input type="text" name="userPass">
		<input type="submit">
	</form>
```
Jsp에서는 단순하게 2개의 input에서 값을 /testing 으로 넘긴다.

```java
// Controller
public class Home{
	
	@RequestMapping(value="/testing")
	public String index() {
		return "study";
	}

	@RequestMapping(value="/testing", method=RequestMethod.GET)
	public String testing(HttpServletRequest request) {
		System.out.println(request.getParameter("userId")); // input name="userId" 값이 출력
		System.out.println(request.getParameter("userPass")); // input name="userPass" 값이 출력
		return null; // 응답처리는 null값으로 Error를 띄우자.
	}
	
}
```
* 우선, Controller파일에서 input에서 넘어온 값을 확인해보자.
* <strong>HttpServletRequest</strong>객체를 사용하여 jsp파일에서 넘어오는 Parameter를 확인할 수 있다. <srtong>request.getParameter("input의 name")</strong>을 이용하여 원하는 값을 출력한다.

### (2) Parameter를 VO객체에 넣기
```jsp
<!-- Jsp -->
	<form action="/testing" method="get">
		<input type="text" name="userId">
		<input type="text" name="userPass">
		<input type="submit">
	</form>
```
```java
// Controller
@RequestMapping(value="/testing") // method=RequestMethod는 default값이 GET으로 생략함
public String Home(ValueObject user, Model model) {
  user.getUserId(); 
  user.setUserID();
  return "userInfo";
}
```
* input에서 넘오는 값이 Controller로 들어온다. 
* 이후, ValueObject의 객체로 넘어가고 ValueObject객체 내부있는 메소드에 의해 값을 가공한다. 
* 이후, user변수에 할당되고 Home객체 내부에서는 "user.메소드명()"으로 호출 할 수 있다. 
```java
// VO(Value Object)
public class ValueObject {
  private int userId;
  private String userName;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
```
* jsp->Controll->VO로 넘어온 값들이 어떻게 가공 되는 보자.
* VO객체에서 메소드를 생성할 때 input의 name명이랑 같아야 한다. 그렇지 않은경우 값을 못 받는다.
* 예를들어 <strong>input name="testName"</strong>으로 만들고 값을 넘기면 <strong>VO객체에서 메소드를 만들경우 getTestName, setTestName로 만들어야 input값이 받아진다.</strong> 그리고 setTestName메소드가 없는 경우에는 getTestName의 메소드는 input값을 받지 못 한다. 즉 이름이 같아야 자동적으로 메소드에 할당되고 set메소드가 없는 경우 이름이 같아도 자동으로 할당 되지 않는다.(정확하게 말하면 set메소드의 코드 때문인 듯)
이걸로 삽질.. 오지게 했다.

## 5. 또 다른 방법
### (1) @PathVariable 어노테이션 사용
