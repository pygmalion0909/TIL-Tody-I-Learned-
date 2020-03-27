# 트랜젝션 관리
## 1. 개념
* 데이터 베이스에서 데이터 처리의 한 단위를 트랜젝션이라 함
* 데이터 베이스에 있는 데이터들을 저장, 수정, 삭제, 추가 등을 하면 바로 데이터베이스테 적용 되는게 아니라 메모리상에 먼저 적용됨
* 혹시나 명령어 실수로 데이터에 손상이 갈까봐 안전장치를 만듬
* 커밋이라는 작업를 실행하기 전에까지는 메모리에서 작동하고 커밋이 되면 데이터베이스에 적용
* 개발자가 데이터에 대한 작업을 하기위해 입력하는 명령문들의 시작부터 커밋까지를 하나의 트랜젝션이라고 함

## 2. rollback, commit
```
create table test1(data1 int(10), data2 varchar(100), data3 float(10));

insert into test1 values(10, 'hello', 20); 
insert into test1 values(10, 'hello', 20); 
insert into test1 values(10, 'hello', 20); 

commit;

select * from test1;

update test1 set data1=1, data2="change", data3=1;

delete from test1 where data1 = 1;

rollback;
```
* 데이터의 저장, 삭제, 수정 등의 작업을 하고 난 후 원래의 형태로 되돌리는 작업
* 커밋이라는 작업을 하고난 후에는 rollback작업을 해도 되돌릴 수 없음
* workbench등의 프로그램에서는 자동으로 커밋 작업이 발생하여 rollback를 해도 원래 상태로 돌아오지 못함
* 따라서 workbench에서 오토커밋 설정을 해제 해줘야함
* commit하면 rollback해도 소용없음
* rollback을 하면 commit하기 전 단계로 돌아감
* 즉, insert into test1 values(10, 'hello', 20)을 테이블에 3번 넣었을 때로 돌아감

## 4. save point
```
create table test1(data1 int(10), data2 varchar(100), data3 float(10));

insert into test1 values(10, 'hello', 20); 
insert into test1 values(10, 'hello', 20); 
insert into test1 values(10, 'hello', 20); 

commit;

select * from test1;

update test1 set data1=1, data2="change", data3=1;
savepoint thispoint1;

delete from test1 where data1 = 1;

rollback to thispoint1;
select * from test1;
```
* save point를 지정하면 rollback시 지정된 위치로 복원 가능
* save point 명령어로 지점을 지정하고 rollback 명령어로 복원
* savepoint에 이름을 지정해주고
* rollback할 때 savepoint이름을 적어주면 해당 savepoint지점으로 되돌림

## 5. truncate
* 지정된 테이블의 모든 로우를 삭제
* truncate는 바로 데이터베이스에 반영되어 rollback가 되지 않음
* 반면 delete는 rollback가 가능
* 쓰지말자... 위험한 것 같음
