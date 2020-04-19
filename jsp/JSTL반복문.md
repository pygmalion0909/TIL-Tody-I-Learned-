# 반복문
## 1. 개념
* 서버에서 받은 데이터를 반복시켜 화면에 출력
* 가령 게시판에 글 목록을 반복문을 사용하여 출력 함

## 2. 예제
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tbody>
  <c:forEach var="item" items="${list}" varStatus="status">
    <tr>
    <!-- 반복상태의 속성에 +1을 해서 글 순번을 정함 -->
    <!-- varStatus의 속성은 아래에 설명 -->
      <td>${status.index + 1}</td>
      <td>${item.title}</td>
      <td>${item.createDate}</td>
      <td>${item.updateDate}</td>
      <td>${item.count}</td>
    </tr>
  </c:forEach>
</tbody>
```
1. <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
* 반복문을 사용하기 위해 jsp페이지 상단에 선언

2. <c:forEach var="item" items="${list}" varStatus="status">
* c:forEach태그 내부에 있는 내용을 반복 시킴
* c:forEach태의 속성값은 아래와 같음
* var : 사용할 변수명, c:forEach태그 내부에서 사용할 변수 명을 뜻 함(필수)
* items : collection 객체, 반복될 대상(필수)
* begin : 반복시작 index, 디폴트 값 0, 반복시킬 시작 index를 정함
* end : 반복 종료 index, 디폴트는 마지막 index
* step : 반복할 때마다 건너 뛸 indxe 갯수
* varStatus : 반복 상태를 알 수 있는 변수

3. varStatus의 속성은 다음과 같음
* index : items에 정의한 항목을 가리키는 index번호, 0부터 시작
* count : 현재 몇번째 반복인지 나타냄, 1부터 시작 
* first : 현재 반복이 첫번째인지 여부 (불리언으로 나타냄)
* last : 현재 반복이 마지막인지 여부 (불리언으로 나타냄)