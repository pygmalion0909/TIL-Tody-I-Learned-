# spring boot 에서 DB연동 방법
## 1. 연동하기 위해 필요한 것 들
1. spring boot
2. DB(mysql)
3. MyBatis (MyBatis는 DB의 정보를 읽어오는데 도움을 준다.)

## 2. Spring boot -> MySql 연동
### (1) dependency 추가
* 프로젝트 생성 때 mysql dependency 추가 하기
* 만약 프로젝트 생성 후 추가 할려면 아래 코드를 budild.gradle폴더에 dependency쪽에 추가, 이후 프로젝트에 우클릭 해서 리플레쉬 하면 추가 됨
```
compile 'mysql:mysql-connector-java'
```

### (1) 설정
1. application.properties파일에 정의하기
```properties
<!-- src/main/resources/application.properties -->
spring.datasource.hikari.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.hikari.jdbc-url=jdbc:mysql://localhost:3306/사용할 db이름?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
spring.datasource.hikari.username=root
spring.datasource.hikari.password=icandoit
spring.datasource.hikari.connection-test-query=SELECT 1
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

### (2) 히카리CP 란
* 커넥션 풀이 톰캣에서 히카리CP로 변경
* 커넥션 풀이란 애플리케이션과 데이터베이스를 연결할 때 이를 효과적으로 관리 하기 위해 사용 되는 라이브러리
* 커넥션 풀에 대한 추가 내용 : 데이터베이스와 연결된 커넥션을 미리 만들어서 풀(pool) 속에 저장해 두고 있다가 필요할 때 커넥션을 풀에서 쓰고 다시 풀에 반환하는 기법, 애플리케이션에서는 데이터베이스의 환경 설정과 연결, 관리 등을 따로 xml파일이나 속성 파일을 사용해서 관리, 다수의 사용자가 데이터베이스에 접근해야 하는 상황일 경우 요청때 마다 db에 연결하는 것은 비효율
* 커넥션 풀에 대한 추가 내용 : 커넥션 풀에 db와 연결해 놓은 객체를 두고 필요할 때마다 커넥션 풀에서 빌려오고 연결이 끝나면 다시 풀에 돌려줌

### (3) DatabaseConfiguration 클래스 만들기
```java
// src/main/java/board/configuration/DatabaseConfiguration.java
package com.example.demo.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
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

## 2. Spring boot -> Mybatis 연동
### (1) Mybatis 개념
* SQL매퍼 프레임워크
* SQL을 XML파일로 작성하기 때문에 SQL의 변환이 자유롭고 가독성 좋음
* 마이바티스를 사용하지 않고 직접 JDBC를 이용할 경우 개발자가 반복적으로 작성해야 할 코드가 많고 서비스 로직 코드와 쿼리를 분리하기가 어려움
* 마이바티스는 개발자가 지정한 SQL, 저장프ㅗ시저 그리고 몇 가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크, 마이바티스는 JDBC로 처리하는 상당부분의 코드와 파라미터 설정 및 결과 맵핑을 대신해줌, 마이바티스는 데이터베이스 레코드에 원시타입과 MAP 인터페이스 그리고 자바 POJO를 설정해서 매핑하기 위해 XML과 애노테이션을 사용(마이바티스 홈페이지 글)

### (2) dependency 추가
* spring boot를 사용하면 프로젝트를 만들 때 mybatis를 검색하여 dependency를 쉽게 추가 할 수 있음
* 프로젝트 생성 후 build.gradle폴더(gradle) 또는 pom.xml(메이븐)에서 확인 할 수 있음
* dependency 부분에 "org.mybatis.spring.boot" 가 있으면 됨
* 프로젝트 생성 할 때 dependency 추가 하는 부분에서 jdbc도 추가 해야 되는 듯


### (3) Mybatis 설정
* Mysql과 연결하기 위해 만든 DatabaseConfiguration.java클래스에 추가하기
```java
public class DatabaseConfiguration {
	@Autowired
	public ApplicationContext applicationContext;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
```
1. SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
* 스프링-마이바티스에서는 SqlSeesionFactory를 생성하기 위해서 SqlSessionFactoryBean을 사용
* 만약 스프링이 아닌 마이바티스 단독으로 사용할 경우에는 SqlSessionFactoryBuilder 사용

2. sqlSessionFactoryBean.setDataSource(dataSource);
* 앞에서 만든 데이터 소스를 설정

3. (applicationContext.getResources("classpath:/mapper/**/*.xml"));
* 마이바티스 매퍼 파일의 위치를 설정
* 매퍼는 애플리케이션에서 사용할 SQL을 담고 있는 xml파일을 의미
* 매퍼를 등록할 때에는 매퍼 파일을 하나씩 따로 등록할 수도 있지만 하나의 애플리케이션에는 일반적으로 많은 수의 매퍼 파일이 존재
* 따라서 패턴을 기반으로 한번에 등록
* classpath는 resources폴더를 의미
* /mapper/**/는 mapper폴더 밑의 모든 폴더를 의미, 프로젝트의 크기가 구조에 따라 여러개의 매퍼 파일이 있을 수 있고 매퍼 폴더 밑에 다시 여러개의 폴더를 가진 구조가 있을 수 있어 mapper폴더 밑에 많은 폴더가 생성 되더라도 모두 지정될 수 있도록 **(모든 폴더 의미)을 사용
* /*.xml는 이름이 sql-로 시작하고 확장자가 xml인 모든 파일 의미
* 만약, /*.xml이 없다면 mapper폴더 안에 전체를 뜻 함
* mapper파일 만들어줘야 설정했을 때 오류 안뜸

### (2) Mybatis 연결 확인
```java
// src/test/java/BoardApplicationTests.java 
// JUnit을 사용하여 코드를 test하는 공간
package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardApplicationTests {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSqlSession() throws Exception{
		System.out.println(sqlSession.toString());
	}
}
```
* 테스트 성공하면 org.mybatis.spring.SqlSessionTemplate@103082dd 가 출력됨

## 3. mysql과 mybatis의 config의 전체적 코드
```java
package com.example.domain.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class ConfigApp {
//	mybatis 연동
	@Autowired
	public ApplicationContext applicationContext;
//	mysql 연동
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		return dataSource;
	}
//	mybatis 연동
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
//	mybatis 맵핑 설정
	@Bean
	@ConfigurationProperties(prefix="mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig(){
		return new org.apache.ibatis.session.Configuration();
	}
	
}
```