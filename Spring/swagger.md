# swagger
## 1. swagger 개념

## 2. swagger 적용
### (1) 라이브러리 추가
```gradle
dependencies {
  
  compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.5.0'
  compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.5.0'

}
```
* gradle로 사용함
* 위 라이브러리 추가 후 gradle프로젝트 리프레쉬 꼭 해줘야 적용됨

### (2) 설정하기
```java
// Config/SwaggerConfig.java
package kr.com.yourHelper.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
	//swagger ui에 표시될 정보 설정
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("youerHelper API")
                .description("youerHelper Project All API document")
                .build();
    }
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		//apiInfo는 .select()보다 위에 위치해야 적용됨
        		.apiInfo(this.apiInfo())
                .select()
                //현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
                .apis(RequestHandlerSelectors.any())
                //그중 /api/v1/** 인 URL들만 필터링
                .paths(PathSelectors.ant("/api/v1/**"))
                .build();
    }
    
}

```
1. @Configuration
1. @EnableSwagger2
1. @Bean
1. .apis(RequestHandlerSelectors.any())
1. .paths(PathSelectors.ant("/api/v1/**"))

### (3) Controller 적용
```java
@RestController
@RequestMapping("/api/v1")
public class GateA1 {
  
  @PostMapping("/member/create")
  @ApiOperation(value = "member", tags = "memberApi")
  public String testGate() {
    return "test";
  }

}
```
* @RestController와 @RequestMapping("/api/v1")를 적용하여 swagger와 매칭 시킴
* 정확하게 말하면 @RequestMapping("/api/v1")에 작성한 경로와 swagger에 설정에 .paths(PathSelectors.ant("/api/v1/**"))와 경로가 맞아야 함
* 이제 swagger는 자동적으로 GateA1에 작성된 api를 인식하여 화면에 나타냄

1. @ApiOperation(value = "member", tags = "memberApi")
* controller에 있는 api를 구분하여 나누게하는 역할
* tags에 작성한 내용이 swagger페이지에서 카테고리이름으로 나타남

### (4) 설정확인
```java
http://localhost:8080/swagger-ui.html
```
* 설정완료 후 위 url로 접속하면 나의 api swagger페이지가 나옴

