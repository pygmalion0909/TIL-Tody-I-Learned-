# IOC/DI
## 1. DI(Dependency Injection) 개념
* 각각의 부품을 구매하여 원하는 성능으로 만들 수 있음
* 반면에 완제품을 살 경우 원하는 성능으로 만들 수 없지만 각각의 부품을 사서 조립하는 수고스러움은 줄어듬
* 각각의 부품을 구매하면 DI가 알아서 조립해 사용할 수 있게 만듬
* 따라서 원하는 성능으로 부품을 구매하면 DI가 알아서 조립하므로 수고스러움을 덜어냄

## 1. IOC 개념
* 단순한 컨테이너라고 생각

## 1. 제어역전
* 일반적으로 프로그램은 개발자가 작성한 코드의 순서로 실행
* 제어역전으로 개발자가 일부 셋팅을 하면 프레임웍이 분석하여 알아서 처리

## 1. bean 객체
* POJO(plain old java Object) class 사용
* POJO는 자바 모델이나 기능 등에 따르지 않고 홀로 독립적인 기능을 가진 객체
* 가령 DAO, VO class 등이 있음
* 자바에서 이러한 객체들을 Bean이라고 부름

## 1. IOC컨테이너 종류
* BeanFactory
* ApplicationContext

## 1. BeanFactory 기능
* 객체 생성
* 객체 반환 
* 상속 관계 셋팅

## 1. ApplicationContext 기능
* BeanFactiory기능 모두 사용
* 국제화 기능 제공
* etc


## 참고문헌
* https://www.youtube.com/watch?v=KQZnjddkWu0
* https://www.youtube.com/watch?v=o47cl1Xh3t4
* https://www.youtube.com/watch?v=KCs2hXM-2E0
