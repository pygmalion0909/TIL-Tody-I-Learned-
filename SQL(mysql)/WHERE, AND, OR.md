# where
```xml
SELECT userId, userPw, userGender FORM user WHERE userId = "test"
```
* user 테이블에 userId가 test인 것 선택

# AND
```xml
SELECT userId, userPw, userGender FORM user WHERE userId = "test" AND userGender = "m";
```
* user 테이블에 userId가 test이고 userGender이 m 인 것 선택