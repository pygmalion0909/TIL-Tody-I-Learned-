# 동적 SQL
## 1. 개념
* 조건에 맞는 SQL을 동적으로 생성

## 2. 종류
### (1) if
* 단일 조건문
* 
```xml
<if test="조건">
조건에 맞으면 실행될 쿼리문
</if>
```













### (2) choose
* 다중 조건문

### (3) when
* 다중 조건문

### (4) otherwise
* 다중 조건문

### (5) trim
### (6) where
* 여기 에서 조건문

### (7) set
### (8) foreach
### (9) script
### (10) bind
### (11) script
### (12) Multi-db vendor support
### (13) ${}, #{}
1. #{}
```xml
<select id="test" resultType="testDto">
  SELECT userId, userPw FROM user WHERE userId = ${userId}
</select>
```
* 파라미터가 String형태로 들어와 자동적으로 key = value형태로 만듬
* userId = value로 바뀜 

2. ${}
```xml
```
