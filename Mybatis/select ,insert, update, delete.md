# select
## 1. 개념
* 데이터베이스에서 데이터를 가져옴
* 데이터 조회기능

## 2. 예제
### (1) 예제1
```xml
<select id="TargetInfoList" parameterType="int" resultType="com.example.domain.dto.TargetDto">
  select *
  from target
  where t_id = #{tId};
</select>
```
1. id="TargetInfoList"
* DAO에 메소드 이름
* 즉 java의 mapper와 현재 select구문과 서로 맵핑하기 위한 식별값

2. parameterType="int"
* 지금 구문에 들어오게 될 값의 형태가 int
* 여기서는 #{tId}가 int형태로 들어온다는 뜻

3. resultType="com.example.domain.dto.TargetDto"
* 구문이 정상적으로 작동하고 결과 값을 서버에 반환 할 때 형태
* 대부분 값을 DTO에 맵핑 시켜 보냄
* 여기서는 TargetDto에 값을 맵핑시켜 TargetDto형태로 내보냄
* 따라서 객체 형태로 나감

4. #{tId}
* 파라미터 표기법

## 3. select 구문의 설정
```xml
<select
  id="selectPerson"
  parameterType="int"
  resultType="hashmap"
  resultMap="personResultMap"
  flushCache="false"
  useCache="true"
  timeout="10"
  fetchSize="256"
  statementType="PREPARED"
  resultSetType="FORWARD_ONLY"
>
```
1. resultMap
2. flushCache
3. useCache
4. timeout
5. fetchSize
6. statementType
7. resultSetType
8. parameterType
* 파라미터가 객체로 안들어오고 하나로 들어올 때 타입을 지정 해주는 것?!
* 여러개도 가능
* 단, 많은 파라미터 일 때는 DTO에 담아서 보내기?

# insert
## 1. 개념
* 데이터베이스에 데이터를 입력 기능

## 2. 예제
```xml
<insert id="insertAuthor">
  insert into Author (id,username,password,email,bio)
  values (#{id},#{username},#{password},#{email},#{bio})
</insert>
```
# update
## 1. 개념
* 기존 데이터를 수정하는 기능

## 2. 예제
```xml
<update id="updateAuthor">
  update Author set
    username = #{username},
    password = #{password},
    email = #{email},
    bio = #{bio}
  where id = #{id}
</update
```
# delete
## 1. 개념
* 데이터 삭제 기능

## 2. 예제
```xml
<delete id="deleteAuthor">
  delete from Author where id = #{id}
</delete>
```