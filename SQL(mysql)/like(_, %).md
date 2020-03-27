# like( _, %)
## 1. 개념 
* 조건식을 만들어 줄 때 문자열과 비교
* 조건을 확장할 때 사용
* " _ "는 글자 하나를 의미, 언더바 한개가 한글자를 의미하니깐 언더바를 5개 찍으면 5글자를 의미함
* " % "는 글자 수와 상관없이 모든 글자를 의미

## 2. 예제
### (1)
````
select emp_no, first_name
from employees
where first_name = "Tommaso";
````
* employees테이블에서 emp_no, first_name를 가져오는데 first_name이 Tommaso인 것 만 가져옴

### (2)
``````
select emp_no, first_name
from employees
where first_name like 'A%';
``````
* 첫글자가 대문자로 시작하는 값을 찾아옴
* employess테이블에서 emp_no, first_name를 가져오는데 first_name에 첫글자가 대문자 A인 데이터만 가져옴
* 대문자 A로 시작하는 데이터값을 찾아오게 하는 명령어가 A% 임
* A%는 A로 시작하는 문자열이 몇글자인지 상관 없이 전부 가져옴

### (3)
````
select emp_no, first_name
from employees
where  first_name like "%s";
````
* 데이터 값에 마지막에 s로 끝나는 데이터를 가져옴
* "%s"는 앞에 몇글자가 상관없이 끝나는 글자가 s로 끝나는 값을 전부 가져옴

### (4)
````
select emp_no, first_name
from employees
where  first_name like "_i%";
````
* 문자열 두번째 글자가 i인 값을 가져옴
* " _ "는 글자 하나를 의미함

### (5)
````
select emp_no, first_name
from employees
where  first_name like "%o%";
````
* 이름에 o가 포함된 데이터를 가져옴
* "&o%" 문자에 o가 있으면 가져옴

### (6)
```
select emp_no, first_name
from employees
where  first_name like "%o%" and not first_name like "%o";
```
* 문자열에 o가 포함되어 있지만 마지막에는 o가 포함되어 있지 않는 값을 가져옴
* not을 사용하면 first_name에 마지막 o가 아닌 문자열을 뜻함

### (7)
````
select emp_no, first_name
from employees
where  first_name like "______";
````
* 문자열 수가 5개 이상인 데이터를 가져옴
* 언더바가 5개니깐 5글자를 가진 데이터를 가져옴
