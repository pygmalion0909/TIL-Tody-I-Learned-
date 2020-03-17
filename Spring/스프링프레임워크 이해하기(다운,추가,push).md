# 스프링프레임워크 이해하기
## 1.

## 2.


## 3. 데이터 베이스 연결하기(Spring boot에서 DB연동파일에 옮기기)
### (1) application.properties파일에 정의하기
```properties
<!-- src/main/resources/application.properties -->
spring.datasource.hikari.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.hikari.jdbc-url=jdbc:mysql://localhost:3306/사용할DB이름?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
spring.datasource.hikari.username=DB아이디
spring.datasource.hikari.password=DB비밀번호
spring.datasource.hikari.connection-test-query=SELECT
```
1. jdbc:mysql://localhost:3306/사용할DB이름?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
* 연결할 데이터베이스의 주소를 정함
* 주소에 유니코드 설정과 UTF-8문자열 인코딩, 그리고 서버의 타임존 설정 추가

2. spring.datasource.hikari.username=DB아이디
* 데이터베이스의 아이디 설정

3. spring.datasource.hikari.password=DB비밀번호
* 데이터베이스의 비밀번호 설정

4. spring.datasource.hikari.connection-test-query=SELECT
* 데이터베이스와 정상적으로 연결되는지 확인하기 위한 테스트 쿼리

### (2) 히카리CP란
* 커넥션 풀이 톰캣에서 히카리CP로 변경
* 커넥션 풀이란 애플리케이션과 데이터베이스를 연결할 때 이를 효과적으로 관리 하기 위해 사용 되는 라이브러리

### (3) DatabaseConfiguration 클래스 만들기
```java
// src/main/java/board/configuration/DatabaseConfiguration.java
package com.insight.borad.configuration;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration{

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig(){
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() throws Exception{
    DataSource dataSource = new HikariDataSource(hikariConfig());
    System.out.println(dataSource.toString());
    return dataSource;
  }

}
```
1. @PropertySource("classpath:/application.properties")
* application.properties을 사용할 수 있도록 설정 파일의 위치를 지정
* 여기서는 application.properties을 지정했지만 @PropertySource를 사용하여 다른 설정 파일도 사용 가능

2. @Bean
   @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
    return new HikariConfig();
   }
* application.properties에 설정했던 데이터베이스 관련 정보를 사용하도록 지정
* @ConfigurationProperties에 prefix가 spring.datasource.hikari로 설정되어 있어 spring.datasource.hikari로 시작하는 설정을 이용해 히카리CP의 설정 파일을 만듬

3. public DataSource datasource() throws Exception{
    DataSource dataSource = new HikariDataSource(hikariConfig());
    System.out.println(dataSource.toString());
    return dataSource;
   }
* 앞에서 만든 히카리CP의 설정 파일을 이용해서 데이터베이스와 연결하는 데이터 소스 생성
* 여기서 데이터 소스가 정상적으로 생성되었는지 확인하기 위해 데이터 소스를 출력

4. 실행결과 로그 확인
```java

```
