# where
## 1. 개념
* 조건문

## 2. 예제
```xml
SELECT userId, userPw, userGender FORM user WHERE userId = "test"
```
* user테이블에서 userId, userPw, userGender을 가져오는데 user 테이블에 userId가 test인 것 선택

# AND
## 1. 개념
* where문에서 둘다 만족 할 경우

## 2. 예제
```xml
SELECT userId, userPw, userGender FORM user WHERE userId = "test" AND userGender = "m";
```
* user테이블에서 userId, userPw, userGender을 가져오는데 userID는 test이고 userGender은 m인 것만 가져옴

# or
## 1. 개념
* where문에서 둘중에 하나 만족할 경우

## 2. 예제
```xml
SELECT userId, userPw, userGender FORM user WHERE userId = "test" OR userGender = "m";
```
* 