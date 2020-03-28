# th문법
## 1. th:href
* url표현 속성
```html
```

## 2. th:text
* 태그 안에 들어가는 텍스트 값
* 해당 태그에 th:text에서 정한 값이 들어감
```html
<span th:text="${user.firstName}"></span>
```
```html
<!-- 문자 더하기 -->
<span th:text="|Hello ${user.name}|"></span>
<span th:text="'Hello' + ${user.name}"></span>
<span th:text="Hello + |${user.name} ${user.nickName}|"></span>
```
* " || "를 사용하면 문자열과 ${}를 다른 것 연결 문자 없이 사용 가능
* " || "를 사용하지 않는다면 " + "를 사용하여 문자열 더하기
* " + "와 " || "을 둘다 같이 사용해도 됨

## 3. th:each
* 반복문
```html
<span th:each="list : ${list}">
	<p th:text="${list.title}"></p>
</span>
```
* 서버에서 넘어온 list를 th:each를 사용하여 list에 있는 길이만큼 반복
* th:text를 사용하여 p태그에 list에 있는 title값을 집어넣음

## 4. th:attr
* 속성추가
```html
```

## 5. th:if
```html
```

## 6. th:unless
* 조건문에서 else 구문이랑 같음
```html
```
## 7. th:value

## 8. th:action

## 9. th:with
