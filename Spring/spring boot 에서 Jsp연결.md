# Spring Boot와 Jsp 연결하기
## 1. 디펜던시 추가하기
### 1. pom.xml에 추가하기 (메이븐)
```xml
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>jstl</artifactId>
</dependency>
 
<dependency>
  <groupId>org.apache.tomcat.embed</groupId>
  <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```
spring-boot-starter-web 에 포함된 tomcat 은 JSP 엔진을 포함하고 있지 않아 위 코드(jasper, jstl)를 추가 해야 jsp파일을 구동할 수 있다.

### 2. build.gradle에 추가하기(gradle)
```
dependencies{
  implementation 'javax.servlet:jstl'
  implementation 'org.apache.tmocat.embed:tomcat-embed-jasper'
}
```
* 기존에 있는 dependencies에 위 와 같이 추가하기
* 이후, gradle 리플레쉬 해야함! (프로젝트에 우클릭 해서 보면 리플레쉬 있음)

## 2. Spring boot 설정
```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```
* src/main/resources경로에 있는 application.properties파일에 위 코드를 입력한다.

## 3. 폴더 추가
* src/main에 webapp폴더 생성 -> webapp폴더 내부에 WEB-INF폴더 생성 -> WEB-INF폴더 내부에 jsp폴더 생성 -> jsp폴더 내부에 index.jsp파일 생성
* 최종적으로 <strong>src/main/webapp/WEB-INF/jsp/index.jsp</strong>
* 그럼 아래와 같이 생성
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
``` 

## 4. Controller 생성
* src/main/java경로에 Controller 패키지 생성하고 class 만들기
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home{
	
	@RequestMapping(value="/")
	public String showJsp() {
		return "index";
	}

}
```
* class파일에 위 코드를 입력하면 끝!
* 서버 구동은 <strong>프로젝트 폴더에 마우스 오른쪽 클릭 -> Run As -> Spring boot App클릭 -> http://localhost:8080 접속!</strong>
* 만약, 서버port번호 바꾸고 싶다면 application.properties파일에서 <strong>server.port=원하는 포트번호</strong>추가 하면 된다.
* @RequestMapping(value="/")는 사용자가 root로 들어 왔을 때 index.jsp를 출력시킴
* 즉, return에 jsp파일명을 적으면 jsp파일을 출력 시킴
* 만약, @RequestMapping(value="/test")로 지정했다면 localhost:8080/test 의미하고
* return "test1"을 지정했다면 test1.jsp파일을 출력 시킨다는 뜻, 즉, 사용자가 localhost:8080/test로 들어오면 test1.jsp파일을 보여준다는 의미