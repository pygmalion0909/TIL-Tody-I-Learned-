# DAO, DTO, Entity Class
## 1. DAO(Data Access Object)
* 실제로 db접근하는 객체
* Service와 DB의 연결고리
* SQL을 사용하여 DB에 접근한 후 적절한 CRUD API를 제공(JPA관련)
* @Repository 선언

## 2. DTO(Data Transfer Object)
* 계층간 데이터 교환을 위한 객체
* DB에서 데이터를 얻어 Service나 Controller등 으로부터 보낼 때 사용하는 객체
* 로직을 갖고 있지 않는 순수한 데이터 객체, getter/setter메서드만 갖는다.
* VO는 DTO와 동일한 개념이지만 VO는 read only속성을 갖는다.

## 3. Entity Class(도메인 class)
* 실제 