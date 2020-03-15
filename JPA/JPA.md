# JPA
## 1. ORM
1. object-relation mapping
2. 객체는 객체대로 설계, 데이터베이스는 데이터베스대로 설계 해서 ORM이 중간에서 알맞게 맵핑

## 2. JPA
1. java persistence API
2. 현재 자바의 ORM기술 표준
3. 인터페이스 모음
4. 시레로 동작하는 것 아님

## 3. 왜 JPA를 사용하나?
1. 객체지향과 관계형 데이터 베이스의 패러다임 불일치
1. 객체지향은 추상화, 캡슐화, 정보은닉 등등 복잡성을 제어하는 다양한 장치 그러나 관계형 데이터는 정규화해서 데이터를 보관하는 목표
1. 이런 패러다임의 불일치로 매핑에 문제가 발생한다.
1. 객체 중심으로 개발
2. 생산성(JPA를 사용하는 것은 마치 java collection)에 데이터를 넣고 빼는 것 처럼 사용
3. 간단한 명령 (저장: jap.persist(member), 조회: Member member = jpa.find(memberId), 수정 : member.setName("변경할 이름"), 삭제 : jpa.remove(member))
4. 유지보수

## 4. 동작과정
1. 개발자가 JAP를 사용 -> JPA내부에서 JDBC API를 사용 -> SQL을 호출 -> DB통신

## 5. 저장과정
1. 개발자 Member객체를 JPA에 넘김
2. JPA는 Member엔티티분석, INSERT SQL을 생성, JDBC API를 사용하여 SQL을 DB로 보냄

## 6. 조회과정
1. 개발자는 Member의 pk값을 JPA에 넘긴다
2. JPA는 아래와 같은 동작을 수행 한다.
3. 엔티티의 매핑 정보를 바탕으로 적절한 SELECT SQL을 생성
4. JDBC API를 사용하여 SQL을 DB로 보냄
5. DB로 부터 결과 반환
6. 결과를 객체에 모두 매핑

## 7. JAP 어노테이션
0. 어노테이션 개념
* 상황에 맞는 어노테이션을 넣으면 IOC컨테이너 안에 존재하는 Bean을 자동으로 주입

1. @Entity
* JPA를 사용하해서 테이블과 매핑할 클래스는 @Entity 어노테이션을 반드시 붙여야함
* @Entity가 붙은 클래스는 JPA가 관리
* JPA에서 사용할 엔티티 이름을 지정. 보통 기본값인 클래스 이름을 name으로 사용, 그러나 다른 패키지에 이름이 같은 엔티티 클래스가 있다면 이름을 지정해서 충돌 방지 필요 @Entity(name = "사용할 이름")

2. @Table
* 엔티티와 매핑할 테이블 지정
* 생략하면 매핑한 엔티티 이름을 테이블 이름으로 사용
* name속성: 매핑할 테이블 이름 ( @Table(name = "이름") )
* catalog속성 : catalog 기능이 있는 데이터베이스에서 catalog를 매핑
* schema속성 : schema기능이 있는 데이터베이스에서 schema를 매핑
* uniqueConstraints속성 : 

3. @Column
* 컬럼맵핑
* name 속성 : @Column(name = "name" )
* insertable 속성
* updatable 속성
* nullable 속성
* unique 속성
* columnDefinition 속성
* length 속성
* precision 속성

4. @Id
* pk 맵핑

5. @ManyToOne

6. @JoinColumn

7. @Enumerated

8. @GeneratedValue

9. @PersistenceContext
* persistence context는 엔티티를 영구 저장하는 환경으로, 논리적인 개념입니다.
* 엔티티 매니저( Entity Manager )로 엔티티를 저장( persist() ) , 조회( find() 또는 JPQL , QueryDSL )하면 엔티티 매니저는 그 엔티티를 영속성 컨테스트에 보관하고 관리합니다.

10. @Autowired
* 의존성 주입 DI(Dependency Injection) : 가령 a클래스(객체)와 b클래스(객체)가 있다고 하면 b클래스(객체)내부에서 a클래스를 불러와 사용할 경우 a와 b는 서로 의존관계라고 한다.
* 의존성 자동 주입
* spring에서 제공하는 어노테이션




## 8. 매니저 메소드
### 1. em.find();    // 엔티티 조회
### 2. em.persist(); // 엔티티 저장
### 3. em.remove();  // 엔티티 삭제
### 4. em.flush();   // 영속성 컨텍스트 내용을 데이터베이스에 반영
### 5. em.detach();  // 엔티티를 준영속 상태로 전환
### 6. em.merge();   // 준영속 상태의 엔티티를 영속상태로 변경
### 7. em.clear();   // 영속성 컨텍스트 초기화
### 8. em.close();   // 영속성 컨텍스트 종료



## 9. 엔티티 매니저, 엔티티 팩토리
* 앤티티 매니저는 저장, 수정, 조회 등 엔티티 관리
* 팩토리는 엔티티 매니저를 생성

<strong> 참고자료: </strong>
1. https://gmlwjd9405.github.io/2019/08/04/what-is-jpa.html
2. https://velog.io/@conatuseus/%EC%97%94%ED%8B%B0%ED%8B%B0-%EB%A7%A4%ED%95%91