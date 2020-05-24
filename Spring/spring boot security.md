# 
## 1. 라이브러리 추가
```gradle
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
```
* 프로젝트 생성 후 라이브러리 추가할 경우 gradle 리플레쉬 해야 적용됨
* spring boot 시큐리티는 라이브러리 추가만 해도 로그인/로그아웃이 작동 됨
* 시큐리티 설정 파일을 만들어서 개인적으로 필요한 부분 설정하면 됨
* 설정은 WebSecurityConfigurerAdapter라는 클래스를 상속받은 클래스에서 메서드를 오버라이딩하여 설정 가능 함

## 2. 설정하기
```java
// 환경설정 어노테이션
@Configuration
// spring boot Security를 사용하겠다는 어노테이션
@EnableWebSecurity

@AllArgsConstructor
// class에 webSecurityConfigurerAdpter을 확장함
// 확장해서 오버라이딩해 설정함
public class SecurityConfig extends WebSecurityConfigurerAdapter {

}
```