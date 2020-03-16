# spring boot 에서 DB연동 방법
## 연동하기 위해 필요한 것 들
1. spring boot
2. DB(mysql)
3. MyBatis (MyBatis는 DB의 정보를 읽어오는데 도움을 준다.)

## 연동 순서
### 1. Spring boot -> MySql 연동

여기서는 Maven을 사용하여 설명한다.

<strong>pom.xml</strong>아래의 코드를 입력한다. 아래코드를 작성하면 srping boot에서 mysql을 의존한다 라는 느낌? 

nodejs에서 사용하고 싶은 모듈을 npm install해서 다운받아 사용하는 것 과 같은 개념이라고 생각하자.
```xml
<code>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
  </dependency>
</code>
```

다음으로 <strong>src/main/resources/application.properties<strong>에 아래의 코드 입력한다.
```properties
spring.datasource.hikari.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
spring.datasource.hikari.jdbc-url=jdbc:log4jdbc:mysql://localhost:3306/사용할 데이터베이스명 
spring.datasource.hikari.username=root
spring.datasource.hikari.password=mysql비밀번호
spring.datasource.hikari.connection-test-query=SELECT 1
mybatis.configuration.map-underscore-to-camel-case=true
```
1. spring.datasource.hikari.driver-class-name=

* mysql을 사용할 때 java와 mysql을 연동해줄 드라이버

2. spring.datasource.hikari.jdbc-url=

* mysql주소(default값 : 3306) + 내가 만든 database 이름

3. spring.datasource.hikari.username=

* mysql의 id (default값 : root)

4. spring.datasource.hikari.password=

* mysql의 비밀번호(개인이 지정한 비밀번호)

5. spring.datasource.hikari.connection-test-query=

* mysql이랑 연동 되었는지 확인할 쿼리

6. mybatis.configuration.map-underscore-to-camel-case=

* user_score로 작성된 컬럼명을 camelCase로 바꿀지 여부

위와 같이 2가지를 완료하면 Maven에서 mysql을 사용할 것 이라고 인식하고 알아서 라이브러리를 다운받아 spring boot에서 mysql을 사용할 준비를 끝마친다.


### 2. Spring boot -> MyBatis 연결

MyBatis를 사용하는 이유는?

mysql을 맺고 끝는것을 자동화하고 쿼리를 실행하고 쿼리 수행 결과를 미리 준비해둔 VO에 알아서 셋팅하기 위해

### (1) MyBatis 의존성 추가
<strong>pom.xml</strong>에 아래와 같이 코드 입력
```xml
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>mybatis-spring-boot-starter</artifactId>
  <version>2.0.0</version>
</dependency>
```

<strong>위 1번, 2번을 완료하면 기본적으로 spring boot에서 db를 사용할 준비단계는 끝이 난다. </strong>


### (2) MyBatis 환경설정








### 3. DAO 생성

mybatis사용하여 service에서 userDao있는 메소드 실행
userMapper.xml파일에는 DAO인터페이스에 있는 동일한 이름을 가진 메소드와 메소드 내부에 쿼리가 있어 메소드의 동작이 수행된다.

수행 단계별로 정리해보자.
1. Service는 UserDao에게 사용자의 요구사항을 전달
2. UserDao는 사용자의 요구사항이 정의 되어 있는지 userMapper.xml에게 요청
3. userMapper.xml는 요구사항을 확인하고 있는경우 해당 요구를 실행시켜 결과를 가져온다. 만약 없는 경우 에러를 반환. 여기서 userMapper.xml에 작성된 쿼리문이 db에서 수행하고 결과값을 반환
4. userDao는 Service에게 결과 반환

이 모든 단계는 MyBatis를 사용하여 동작 시킨다.


