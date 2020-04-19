# 동적 SQL
## 1. 개념
* 조건에 맞는 SQL을 동적으로 생성

## 2. if
### (1) 개념
* 단일 조건문

### (2) 예제
```xml
<select id="TargetInfoList" resultType="com.example.domain.dto.TargetDto">
  select *
  from target
  where t_name = "제니"
  <if test="t_depart != null">
    and t_id = "40"
  </if>
</select>
```
* target테이블에서 t_name컬럼의 값이 "제니"인 컬럼전부를 가져옴
* 이때 t_depart컬럼이 null이 아니면(값이 있으면) t_id컬럼의 값이 40인 조건을 추가해서 데이터를 불러 옴
* 즉, if문의 test가 참일 경우  where t_name = "제니" and t_id = "40" 조건이 되어 조건에 맞는 데이터를 가져옴

## 3. where
### (1) 개념
* where은 if태그에 의해 데이터가 리턴되면 단순히 where만 추가
* 또한, and, or로 시작하면 and와 or을 지워 버림
* 즉, where태그 내부에 있는 if태그 하나만 적용 조건에 적용됨?!

### (2) 예제
```xml
<select id="">
  select *
  from table
  <where>
    <if>
    </if>
    <if>
    </if>
    <if>
    </if>
  </where>
</select>
```

## 4. choose(when, otherwise)


## 5. set
### (5) trim
### (8) foreach
### (9) script
### (10) bind
### (11) script
### (12) Multi-db vendor support
