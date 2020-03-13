# Spring Boot와 Jsp 연결하기
## 1. pom.xml 추가하기
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

## 2. Spring boot 설정
```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```
src/main/resources경로에 있는 application.properties파일에 위 코드를 입력한다.

## 3. 폴더 추가
src/main에 webapp폴더 생성 -> webapp폴더 내부에 WEB-INF폴더 생성 -> WEB-INF폴더 내부에 jsp폴더 생성 -> jsp폴더 내부에 index.jsp파일 생성

최종적으로 <strong>src/main/webapp/WEB-INF/jsp/index.jsp</strong> 

## 4. Controller 생성
src/main/java경로에 Controller 패키지 생성하고 class 만들기
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
class파일에 위 코드를 입력하면 끝!

서버 구동은 <strong>프로젝트 폴더에 마우스 오른쪽 클릭 -> Run As -> Spring boot App클릭 -> http://localhost:8080 접속!</strong>

만약, 서버port번호 바꾸고 싶다면 application.properties파일에서 <strong>server.port=원하는 포트번호</strong>추가 하면 된다.