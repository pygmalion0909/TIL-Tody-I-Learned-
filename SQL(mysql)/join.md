# join
## 1. 개념
* 데이터 베이스에서 가장 중요한 부분은 데이터를 가져오는데 걸리는 시간의 최소화
* 사용자가 응답하면 3초 안에 데이터를 나타 나야함
* 데이터가 클수록 데이터를 가져올 때 시간이 오래 걸림
* 그래서 데이터는 중복을 줄여야함
* 중복을 최소화 하기 위해서 테이블을 분리시켜 저장하고 가져올 때는 join을 사용하여 합쳐서 가져옴
* 여러 테이블을 join할 때는 테이블의 이름을 " , "로 구분하여 작성하고 각 테이블의 컬럼명을 기술하여 주면 원하는 데이터를 가져옴
* SELECT 컬럼명1, 컬럼명2, 컬럼명3 from 테이블1, 테이블2
* join을 할 때 테이블과 테이블 끼리 공통된 분모가 있는지 확인하고 조건을 걸어서 가져와야함
* 서로의 테이블의 컬럼수가 다르면 중복된 테이블를 가져오기 때문
* 만약 중복되는 분모가 없는 경우 또 다른 테이블을 이용해 분모들 찾아서 조건문을 작성

## 2. 예제
### (1) "다 대 다"를 생각하지 않고 join
```
select dept_emp.emp_no, dept_emp.dept_no, departments.dept_name 
from departments, dept_emp;
```
* 현재 분리되어 있는 두개의 데이블에서 원하는 컬럼 값을 가져옴
* departemets, dept_emp테이블에서 원하는 컬럼 값을 가져옴
* emp_no는 deft_emp에서 dept_no는 dept_emp에서 dept_name은 departments에서 가져옴
* " . "으로 컬럼이 어느 테이블에 있는지 표시 함

### (2)
```
select a2.emp_no, a2.dept_no, a1.dept_name
from departments a1, dept_emp a2;
```
* 별칭을 이용하여 테이블 명시하기
* departmemnts에는 a1, dept_emp에는 a2라는 별칭을 이용하여 컬럼을 가져올 수 있음

### (3)
````
select a2.emp_no, a2.dept_no, a1.dept_name
from departments a1, dept_emp a2
order by a2.emp_no;
````
* order by을 사용하여 사원번호 기준으로 오름차순
* asc는 생략 가능

### (4) "다 대 다"를 고려해서 join
* 먼저 의미가 같은 공통분모가 있는지 확인

```
select a2.emp_no, a2.dept_no, a1.dept_no, a1.dept_name
from departments a1, dept_emp a2
where a1.dept_no = a2.dept_no
order by a2.emp_no;
```
* dept_no에서 1개의 로우를 꺼내면 departments에 있는 컬럼(부서가 9개 있어 로우가 있음)이 전부 꺼내 옴
* 이를 막기 위해 조건문을 사용하여 조건에 맞는 데이터 가져옴

```
select a1.emp_no, a1.first_name, a2.dept_no
from employees a1, dept_emp a2
where a1.emp_no = a2.emp_no
```
