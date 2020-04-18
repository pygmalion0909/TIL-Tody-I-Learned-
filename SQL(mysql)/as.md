# as
## 1. 개념
* select문에서 as를 이용해 속성값을 별칭으로 지정 가능

## 2. 예제
```xml
SELECT kim AS super FROM person
```
* person테이블에 kim컬럼을 AS를 사용하여 super별칭을 지정 함
* 즉, super는 kim컬럼을 뜻 함
* 데이터가 출력될때 kim컬럼은 super로 바껴서 출력됨
* 만약 별칭을 영어가 아닌 한국어로 할려며 "" 를 붙여서 사용 ("슈퍼") 
