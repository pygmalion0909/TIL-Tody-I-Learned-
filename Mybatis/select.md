# select 태그
* 데이터 조회하는 태그
* 데이터 베이스에서 데이터를 가져옴
* select부분 코드가 맵핑 되어 db에 데이터를 가져오는 듯

## 1. select 속성
### (1) id
* mpper.java파일에서 맵핑하고 싶은 메소드 이름이랑 id이름이랑 같은 것 끼리 맵핑
* 만약, 메소드명과 id명이 다른 경우 Invalid bound statement (not found)에러 발생
* 즉, id속성은 mapper.java파일에 있는 특정 메소드와 select태그와 1:1 매칭 시켜주는 연결고리

### (2) parameterType
*  

### (3) resultType
* 데이터 반환값의 형식을 지정

### (4) resultMap

### (5) flushCache

### (6) useCache

### (7) timeout

### (8) fetchSize

### (9) statementType

### (10) resultSetType

### (11) databaseId

### (12) resultOrdered
