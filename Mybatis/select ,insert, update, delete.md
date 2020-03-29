# select 태그
## 1. 개념
* 

## 2. 속성
### (1) parameterType
* 사용자가 요청할때 넘겨주는 값(파라미터)의 타입을 지정하는 속성

# insert 태그
## 1. 개념
* 데이터를 변경하는 구문
```xml
<insert></insert>
```

## 2. 속성
### (1) id
* mapper클래스의 메서도와 1:1 매칭

### (2) parameterType
* 

### (3) flushCache
* 이 값을 true 로 셋팅하면 구문이 호출될때마다 캐시가 지원(flush), 디폴트는 false

### (4) statementType
* 

### (5) keyProperty
* 

### (6) keyColumn
* 

### (7) useGeneratedKeys
* 

### (8) timeout
* 예외가 던져지기 전에 데이터베이스의 요청 결과를 기다리는 최대시간을 설정, 디폴트는 셋팅하지 않는 것이고 드라이버에 따라 다소 지원되지 않음

# update
## 1. 개념
* 데이터를 변경하는 구문

## 2. 속성
### (1) id
### (2) parameterType
### (3) flushCache
### (4) statementType
### (5) timeout
* insert속성와 동일

# delete
## 1. 개념
* 데이터를 변경하는 구문

## 2. 속성
### (1) id
### (2) parameterType
### (3) flushCache
### (4) statementType
### (5) timeout
* insert속성와 동일
