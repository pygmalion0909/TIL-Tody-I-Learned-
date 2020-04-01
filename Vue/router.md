# 라우터
## 1. 개념
* 싱글페이지 애플리케이션을 구현하기 할 때 사용하는 라이브러리
* 공식 라이브러리
* 라우트에 컴포넌트를 매핑한 후, 어떤 주소에서 렌더링할 지 알려주는 것 뿐

## 2. 설치
### (1) CDN으로 설치
1. 구글에 vue라우터 검색
2. vue공식홈페이지 접속
3. 왼쪽 설치탭 접속
4. https://unpkg.com/vue-router/dist/vue-router.js를 복사해서 script태그의 src에 넣기
5. vue cdn먼저 scrip태그에 넣고 두번째로 위 router를 넣기(순서중요)
```html
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>
```

### (2) npm 으로 설치
```
npm install vue-router
```
* 위 명령어로 설치하고 나면 package.json에 dependenices에 vue-router에 추가 됨
```js
// src/main.js
import Vue from 'vue'
import App from './App.vue'
import router from './router' // 라우터 import하기 

Vue.config.productionTip = false

new Vue({
  router, // 여기에도 router을 작성해야 작동됨
  render: h => h(App),
}).$mount('#app')
```
* 위 코드는 router를 분리할 때 사용하는 import임
* npm으로 설치 했으면 위 코드 처럼 불러와서 사용 가능
* 위 같이 설정하고 router파일은 src내부에 만들어야 함, 다른 곳에 하면 에러 뜸
* 즉, src/router.js파일 만들고 router를 모으면 됨

## 3. 기본 구조
### (1) router와 vue인스턴스
```html
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>

  <script>
  // vue 라우터 인스턴스
    new VueRouter({
    })
  // vue 인스턴스 
    new Vue({
    })
  </script>
```

### (2) router와 vue랑 연결
```html
  <script>
    const router = new VueRouter({
    })

    new Vue({
      el: "#app",
      router: router,
    })
  </script>
```
1. const router = new VueRouter({})
* router를 사용하기 위해 router변수에 할당

2. router: router
* vue인스턴스에 router변수를 vue인스턴스의 속성인 router에 입력
* vue인스턴스의 router속성은 기본적으로 정해져있는 이름
* vue개발도구에 가면 router를 확인 가능

### (3) rotuer 기본예제
```html
  <div id="app">
    <router-view></router-view>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>

  <script>
    const LoginComponent = {
      template: "<h1>login Page</h1>"
    }
    const mainComponent = {
      template: "<h2>main Page</h2>"
    }

    const router = new VueRouter({
      routes: [
        {
          path: "/login",
          component: LoginComponent
        },
        {
          path: "/main",
          component: mainComponent,
        },
      ]
    })

    new Vue({
      el: "#app",
      router: router,
    })
  </script>
```
1. const router = new VueRouter({})
* 라우터 인스턴스 선언해서 router에 할당

2. router: router,
* vue인스턴스랑 router랑 연결

3. routes: [ {path: "/login", component: LoginComponent}, { path: "/main", component: mainComponent}]
* routes에 url경로 지정
* routes는 router의 속성
* path는 url, component는 해당 url로 들어올 경우 사용자에게 보여줄 component
* path에 작성한 경로로 사용자가 들어오면 해당 경로에 있는 component를 실행

4. router-view /router-view
* vue인스턴스와 router랑 연결 되야 사용 가능한 태그
* 경로에 따라 component를 다르게 보여줌

## 4. 폴더 분리해서 router하기
### (1) mian.js파일에 router설정
```js
// src/main.js
import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
```
1. import router from './router'
* npm으로 다운 받은 router를 import하기

2. new Vue({ router, })
* Vue인스턴스에서 router를 사용할 수 있게 import한 변수이름 입력
* 이거 작성 안하면 작동안함

### (2) router파일 생성
```js
// src/router.js
import Vue from 'vue'
import VueRouter from 'vue-router'
import page1 from './components/page1'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {path:'/page1', name: "page1", component: page1},
  ]
})

export default router
```
* 일단, 내가 만든 router.js는 평범한 js파일이라고 생각하고 시작
* 평범한 js파일을 router파일로 만든다고 생각하기

1. import Vue from 'vue'
* Vue를 사용하기 위해 vue 불러오기

2. import VueRouter from 'vue-router'
* npm으로 다운 받은 router도 사용하기 위해 불러오기

3. import page1 from './components/page1'
* 경로마다 지정할 component를 불러오기

4. Vue.use(VueRouter)
* Vue가 router객체를 사용하겠다고 설정
* node에서 미들웨어 같은 느낌

5. const router = new VueRouter({ })
* 본격적으로 router를 사용하기 위해 router인스턴스 만들고 router에 할당

6. mode: 'history'
* router의 속성

7.  routes: [ ]
* 본격적으로 path마다 component설정
* 이제 path경로로 사용자가 들어오면 component가 출력됨
* 단, App.vue에 설정해야함

8. export default router
이제 작성한 router를 내보내기를 해서 App에서 사용할 수 있게 함

9. name: "page1"
* 해당 라우터의 이름
* router-link태그에 경로 정할 때 path뿐만 아니라 :to="{name: 'page1'}"처럼 name으로 사용가능

### (3) App.vue에 설정
```js
<template>
  <div id="app">
    <h1>테스트 페이지 입니다.</h1>
    <router-link to="/page1">소개</router-link>
    <router-link to="/page2">서비스</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
}
</script>

<style>
</style>
```
1. router-view 태그
* 사용자가 설정해놓은 path로 들어올 경우 router-view태그에서 component가 뿌려짐

2. router-link to="/page1"
* link태그에 to로 경로지정해서 사용자가 쉽게 path경로로 접근하게 함

## 5. 중첩 router
* 특정 router의 하위 경로가 변경됨에 따라 컴포넌트를 변경하게 하는 기능
* page1/subpage1, page1/subpage2가 있다고 한다면
* router의 children속성을 사용하여 컴포넌트를 지정할 수 있음
```js
// router.js
import Vue from 'vue'
import VueRouter from 'vue-router'
import page1 from './components/page1'
import subpage1 from './components/subpage1'
import subpage2 from './components/subpage2'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path:'/page1',
      component: page1,
      children: [ 
        {path:'subpage1', component: subpage1},
        {path:'subpage2', component: subpage2},]
    },
  ]
})

export default router
```
1. children: []
* 사용자 page1으로 들어왔을 때 하위 경로 subpage1, subpage2의 경로에 대한 컴포넌트를 지정하는 속성

2. {path:'subpage1', component: subpage1}
* path랑 component는 기본적으로 작성 방식으로 적으면 됨
* 지금 path에 subpage1이라고만 작성 되어 있지만 사실상 앞에 page1이 생략이 되어 있음
* 즉, 사용자는 page1/subpage1으로 들어와야 해당 컴포넌트가 렌더링 됨

```js
<template>
  <div>
    <h1>page1</h1>
    <router-view></router-view>
  </div>
</template>

<script>
export default {

}
</script>

<style>
</style>
```
1. router-view
* subpage1, subpage2가 렌더링 될 포지션
* 원하는 위치에 태그를 작성하면 그 위치에 렌더링 됨
* 이 태그 없으면 suppage화면에 렌더링 안됨

## 6. this.$router 의미
* 모든 컴포넌트에서 router를 자주사용함
* this.$router는 정확히 router와 동일함
* this.$router를 사용하는 이유는 라우터를 조작해야하는 모든 컴포넌트에서 라우트 객체를 가져올 필요가 없기 때문에 사용

## 7. 동적 router
* url에 파라미터 값을 router에 들오고기
* 가령 page1/123 으로 url이 왔을 때 123을 router에 가져오는 것
```js
import Vue from 'vue'
import VueRouter from 'vue-router'
import page1 from './components/page1'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {path:'/page1/:id', component: page1},
  ]
})
export default router

```
1. path:'/page1/:id', component: page1
* 사용자가 /page1/123으로 들어오면 123의 값을 가져올 수 있음
* 문법은 " :변수명 "으로 하면 됨

```js
<template>
  <div>
    <h1>{{this.$route.params.id}}</h1>
  </div>
</template>

<script>
export default {

}
</script>

<style>
</style>
```
1. {{this.$route.params.passing}}
* router라이브러리를 다운받았기 때문에 this.$route로 접근 가능 함
* 위 코드는 예시를 들기위해 컴포넌트에 id값을 출력 시켰음
* 쿼리문자열은 this.$route.query로 확인 가능

## 8. router-link
### (1) 기본사용
```html
  <div id="app">
    <div>
      <router-link to="/login">login</router-link>
      <router-link to="/main">main</router-link>
    </div>
    <router-view></router-view>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>

  <script>
    const LoginComponent = {
      template: "<h1>login Page</h1>"
    }

    const mainComponent = {
      template: "<h2>main Page</h2>"
    }

    const router = new VueRouter({
      routes: [
        {
          path: "/login",
          component: LoginComponent
        },
        {
          path: "/main",
          component: mainComponent,
        },
      ]
    })

    new Vue({
      el: "#app",
      router: router,
    })
  </script>
```
1. router-link to="/login" login /router-link
* router-link는 화면에 a태그로 변환되어 나옴
* to를 사용해서 해당 router-link에 url경로 지정

### (2) router-link 스타일
* router-link에 스타일 적용하는 클래스
* 경로에 따라 메뉴가 단계별로 구성될 경우 사용하는 듯
1. .router-link-active는 경로 앞부분만 일치하면 추가되는 클래스
2. .router-link-exact-active는 모든 경로가 일치해야 추가되는 클래스
```js
```

## 9. 데이터 가져오기 (Data Fetching)
* 서버로부터 데이터를 가져오는 기능
* 화면별로 라우팅이 일어나는 시점에 데이터를 불러오게 하기
* 기본적으로 created()훅에서 가져옴
* created()는 vue의 라이프사이클훅 중에서 한개 임

## 10. router.push()
* 현재 페이지 갱신?!
* :key속성이랑 같이 사용!?

* router.push(location, onComplete, onAbort)
* 인스턴스 내부에서 라우터 인스턴스에 $router로 액세스 할 수 있음
* 즉, this$router.push 사용 가능
* push에 지정한 경로로 이동



## 11. router name
* router에 별칭을 정하는 것

```js
// router.js
import Vue from 'vue'
import VueRouter from 'vue-router'
import intro from './components/intro'
import page1 from './components/page1'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {path:'/', component: intro},
    {path:'/page1', name: 'page1', component: page1},
  ]

})
export default router
```
1. path:'/page1', name: 'page1', component: page1
* /page1경로에 별칭으로 page1를 만들어 줌

```js
<template>
  <div class="intro">
    <h1>This HomePage is Test!</h1>
    <router-link :to="{name:'page1'}">링크</router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
</style>
```
1. router-link :to="{name:'page1'}"
* name으로 page1라우터를 연결 함













<hr>



### (1) router.push방식
```js
// 리터럴
router.push('home')

// object
router.push({ path: 'home' })
```
## 7. Api
### (1) router-link
* 사용자 네비게이션을 간능하게 하는 컴포넌트
* 목표 위치는 to prop로 지정
* 기본적으로 href를 갖는 a태그로 렌더링 됨
* 라우트가 활성화되어 있으면 링크가 자동으로 active CSS클래스를 가져옴

1. to
* 필수로 작성
* 문자열로 작성
*  


2. replace
3. append
4. tag
5. active-class
6. exact
7. event
8. exact-active-class

### (2) router-view


## 8. router 속성
* mode 속성 기본값은 해쉬뱅 모드

