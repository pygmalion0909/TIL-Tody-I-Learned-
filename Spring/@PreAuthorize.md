# PreAuthorize
## 1. 개념
* 권한 체크
* 클래스나 메소드에 사용하여 권한이 있으면 클래스나 메소드를 실행하고 없으면 에러 던짐

## 2. 예제
```java
@RequestMapping("/index")
@PreAuthorize("hasAuthority('test1') or hasAuthority('test2')")
public String security(String value){
  // ....
}
```
### (1) @PreAuthorize("hasAuthority('test1') or hasAuthority('test2')") 
*
* and도 가능

### (2)

## 3. 설정
