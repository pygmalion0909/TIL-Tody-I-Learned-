# 논리연산자(and, or, not)
## 1. 개념
* and 양쪽 조건을 만족
* or 양쪽 조건 중 하나만 만족해도 선택
* not 조건의 결과를 반대하는 부정

## 2. and
```
SELECT userPw, userId, userNick FROM user WHERE count > 3;
```
* user테이블에서 userPw, userId, userNick에 있는 값을 가져오는데 count가 3 이상일 경우인 값만 가져 옴
* SELECT에 나열한 순서대로 가져옴
* 즉 테이블에 컬럼 나열이랑 SELECT에 나열한 순서랑 달라도 상관 없음

## 3. or
```
SELECT userPw, userId, userNick FROM user WHERE count = 3 OR count = 1;
```
* count가 3, 1 값을 가진 컬럼에 userPw, userId, userNick 값을 가져옴
* 만약, 둘중에 한군데가 값이 없으면 있는 데이터만 가져옴

## 4. not
```
SELECT userPw, userId, userNick FROM user WHERE NOT count = 1;
```
* count가 1값이 아닌 userPw, userId, userNick 컬럼 값을 가져옴

```
select userPw, userId, userNick from user where not count = 1 AND not count = 2;
```
* count가 1값이 아니고 count가 2값이 아닌 userPw, userId, userNick 컬럼 값을 가져옴 