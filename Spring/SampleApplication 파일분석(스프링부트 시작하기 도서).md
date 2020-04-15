# SampleApplication 파일 분석(스프링부트 시작하기 도서)
## 1. 코드
```java
package com.example.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
```
### (1) @SpringBootApplication
* 스프링 부트 애플리케이션의 핵심 어노테이션
* 이 어노테이션은 세 개의 어노테이션으로 구성
1. @EnableAutoConfiguration
* EnableAutoConfiguration은 다양한 설정이 자동 완료
2. @ComponentScan
* 기존 스프링은 빈 클래스를 사용하기 위해 xml에 일일이 빈을 선언 해야함
* 스프링부트는 ComponentScan으로 컴포넌트 검색 기능을 활성화 해서 자동으로 여러 가지 컴포넌트 클래스를 검색하고 검색된 컴포넌트 및 빈 클래스를 스프링 애플리케이션 컨텍스트에 등록하는 역할을 함
3. @Configuration
* Configuration이 붙은 자바 클래스는 자바 기반 설정 파일을 뜻 함.
* 자바 기반의 설정이 필요한 경우 @cConfiguration을 사용

### (2) SpringApplication.run(DemoApplication.class, args)
* 스프링 부트 프로젝트의 장점은 톰캣이나 제티와 같은 웹 애플리케이션 서버에 배포하지 않고도 실행할 수 있는 JAR파일로 웹 애플리케이션을 개발 할 수 있음
* SpringApplication.run()메서드가 스프링 부트 애플리케이션을 실행 할 수 있게 함
* XML설정 파일도 사용하지 않고 가능, 스프링 부트로 생성된 애플리케이션은 순수 자바만을 이용해서 개발을 할 수 있게 함.