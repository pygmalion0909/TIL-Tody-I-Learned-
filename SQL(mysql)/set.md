# set
## 1. 개념
* 두 select문을 통해 얻어온 결과를 집합 연사을 통해 하나의 결과로 만드는 것
* 합집합, 교집합, 차집합 등 집합 연산을 할 수 있음
* 집합 연산을 하기 위해서 두 select문을 통해 가져오는 컬럼이 같아야 함
1. UNION은 중복되는 데이터를 하나만 가져옴
2. UNION ALL은 중복되는 데이터도 모두 가져옴
3. 차집합은 서브쿼리를 이용해서 구함

## 2. 예제
### (1)
```
select emp_no from titles where title="Senior Staff"
union
select emp_no from titles where title="Staff";
```
* 두개의 select문에서 공통되는 값만 하나만 들고옴
* 예를 들어 두개의 select문에서 1001이 각각 1개씩 있다면 1001을 하나만 들고옴

```
select emp_no from titles where title="Senior Staff"
union all
select emp_no from titles where title="Staff";
```
* 두개의 select문에 있는 중복되는 값을 둘다 들고옴
* 예를 들어 두개의 select문에서 1001이 각각 1개씩 있다면 1001을 두개 들고옴

### (2)
```
```