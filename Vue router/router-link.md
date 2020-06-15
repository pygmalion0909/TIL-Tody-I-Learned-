# router-link
## 1. 개념
* 목표 위치로 이동
* to, prop로 지정
* 기본적으로 href를 갖는 a태그로 렌더링
* a태그 개념이라서 router-link to="이동하고 싶은 url"로 지정할 경우 해당 url로 이동(즉, 페이지 이동)
```html
<!-- 리터럴 string -->
<router-link to="home">Home</router-link>
<!-- 이렇게 렌더링 됩니다. -->
<a href="home">Home</a>

<!-- `v-bind`를 이용한 표현식 -->
<router-link v-bind:to="'home'">Home</router-link>

<!-- `v-bind`를 생략하면 다른 prop를 바인딩 하는 것과 같습니다. -->
<router-link :to="'home'">Home</router-link>

<!-- 위와 같습니다. -->
<router-link :to="{ path: 'home' }">Home</router-link>

<!-- 이름을 가지는 라우트 -->
<router-link :to="{ name: 'user', params: { userId: 123 }}">User</router-link>

<!-- 쿼리가 있으면, `/register?plan=private` 이 됩니다. -->
<router-link :to="{ path: 'register', query: { plan: 'private' }}">Register</router-link>
```