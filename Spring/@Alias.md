# @Alias
## 1. 개념
* mybatis에서 지원하는 어노테이션
* 경로를 단축시켜 작성 가능
* 어노테이션 사용하기 위해서는 sessionFactory설정 부분에 다음 코드 추가 필요

## 2. 예제
### (1) 설정 추가
* sesstionFactory설정 부분에 다음 코드를 추가
```java
sessionFactory.setTypeAliasesPackage("@Alias를 적용할 경로")
```

### (2) 사용
