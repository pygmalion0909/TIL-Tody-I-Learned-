컬럼이름/데이터타입/null여부/제약조건

-------------------------
데이터 타입
--
# enum
## 1. 개념
* 컬럼 정의 할 때 enum컬럼에 들어갈 값을 정의
* empty String, null 값을 허용
* 정의 하지 않은 값을 받을 경우 빈문자열로 저장
## 2. 사용법
```
ENUM('m', 'w')
```

--
# datetime
## 1. 개념
* YYYY-MM-DD HH:MM:SS 형식으로 저장

## 2. 사용
```
컬럼명/ DATETIME/ not null
```

--
# date
## 1. 개념
* YYYY-MM-DD 형식으로 저장
```
컬럼명/ DATE/ not null
```



-------------------
제약조건
--
# auto_increment
## 1. 개념
* 테이블에서 고유값을 생성할 때 사용
* 0부터 값이 시작
* auto_increment값이 중간에 삭제되어도 마지막을 기준으로 계속 증가
* auto_increment키는 반드시 primary key로 지정, 하지 않을 경우 문법 에러 발생
## 2. 시작값 설정
```
ALTER TABLE ${테이블명} AUTO_INCREMENT = #{바꾸고 싶은 값}
ALTER TABLE testTable AUTO_INCREMENT = 100
```
* auto_increment시작 값이 100부터 시작
## 3. 사용




--
# default
## 1. 개념
* 디폴트로 값을 지정
* 값을 넣지 않을 경우 디폴트로 정한 값이 자동 저장
## 2. 사용
```
default 1000
```
* 해당 컬럼에 값을 지정하지 않으면 자동적으로 1000이 저장

--
# foreign key
## 1. 개념
* "외래키"라고 불림
* 다른 컬럼을 참조함
* 다른 컬럼의 값 중에서만 선택 가능
* 중복 가능
* 데이터의 참조 무결성을 확인하기 위해 사용(허용된 값만 데이터베이스에 저장)
* 참조하고있는 값(foreign key)을 삭제해야 참조대상의 값(primary key)을 삭제 가능
## 2. 사용
```
FOREIGN KEY (외래키 하고싶은 컬럼명) REFERENCES 기본키테이블명 (기본키컬럼명)
```

--
# unique
## 1. 개념
* 컬럼의 값을 유니크하게 설정

## 2. 사용
### (1) 일반적 사용
```
컬럼명 데이터타입 not null unique
```
### (2) 함수로 사용
```
컬럼명1 데이터타입,
컬럼명2 데이터타입,
unique(컬럼명1, 컬럼명2)
```


-------
# join
## 1. 개념
## 2. 종류
1. INNER 조인
2. LEFT OUTER, RIGHT OUTER, OUTER 조인
## 3. 예제
### (1) 테이블(2개)
1. department table (부모)
```
CREATE TABLE department(
d_id int NOT NULL unique,
d_depart varchar(100) NOT NULL,
d_room_number varchar(100) not null unique,
PRIMARY KEY (d_depart)
);
```
|field|type|null|key|
|------|----|----|----|
|d_depart|varchar(100)|NO|PRI|
|d_id|int(11)|NO|UNI|
|d_room_number|varchar(100)|NO|UNI|

2. target table(자식)
```
CREATE TABLE target(
t_id int not null auto_increment,
t_name varchar(100) not null,
t_depart varchar(100) not null,
t_sex enum('m', 'w') not null,
t_birthday date,
primary key(t_id),
FOREIGN KEY (t_depart) REFERENCES department (d_depart)
);
```
|field|type|null|key|extra|
|------|----|----|----|----|
|t_id|int(11)|NO|PRI|auto_increment
|t_name|varchar(100)|NO|
|t_depart|varchar(100)|NO|MUL|
|t_sex|	enum('m','w')|NO|
|t_birthday|date|YES|

* 자식테이블의 t_depart는 부모의 d_depart를 참조함

### (2) 단순 join
```
select t_id, t_name, t_depart, t_sex, t_birthday
from target join department;
```
1. select t_id, t_name, t_depart, t_sex, t_birthday from target
* target 테이블에서 t_id, t_name, t_depart, t_sex, t_birthday를 가져옴

2. from target join department;
* target테이블에서 가져오는 오는데 department값도 같이 들고옴
* 들고올 때 trget의 row 한줄에 department에 있는 row가 전부 들어옴
* 만약, department에 6개의 row가 있으면 target의 1개의 row를 들고 오면 department에 있는 6개의 row가 가져와짐
* form에 정해진 테이블 기준으로 생각!!!!

### (3) 단순 join on
```
select d_id, d_depart, d_room_number
from department join target
on department.d_depart = target.t_depart;
```
1. on department.d_depart = target.t_depart
* on 작성한 조건에 맞는 데이터를 가져옴












----
# bind:key
## 1. 

