# project
## 1. vue 프로젝트 생성
1. 파일 생성
* vue-cli 4.3.1 version 사용
* node는 10.16.1 version 사용
* 아래와 같이 파일생성
```html
<!-- vue create "생성파일명" -->
vue create vue-project
```

2. preset설정
* manually select features 선택하여 플러그인을 수동으로 선택

3. 플러그인 선택
* babel
* linter/formatter
* unit testing

4. pick a linter / formatter confing 설정
* esLint + prettier 선택

5. lint features 설정
* lint on save 선택

6. pick a unit testing solution 설정
* jest로 선택

7. where do toy prefer placing config for .... ? 
* 플러그인을 package.json에 담을 것 인지 dedicated config에 담을 것 인지 여부
* in dedicated config files 선택

8. 마지막으로 no 선택

# rePlay(esLint랑 prettier, 절대경로 설정 다시보기!)
## 2. EsLint 설정
* 설정하지 않으면 에러가 발생할 경우 브라우저 화면에 에러 표시가 덮음, 이를 설정을 바꿔 에러가 생겨도 브라우져 화면에는 나타나게 하지 않게 설정
1. vue파일 최상위 경로에서(babel, jest등 환경설정이 있는 경로) vue.confing.js 파일 만들기
2. 아래와 같이 작성하면 설정 됨
* 즉, 화면에 에러 페이지 뜨는 것 을 막아줌
* 하지만 콘솔에는 에러가 표시됨
```js
module.exports = {
  devServer : {
    overlay: false
  }
}
```

## 3. prettier 설정
* 개발할때 문법 등 설정
* 따음표, 간격 등 설정 하는 것
* prettier을 설정할 때 중요한점은 프리티어를 EsLint 안에 설정을 해야함
* prettier와 EsLint의 중복되는 설정이 있어 겹치는 설정은 EsLint의 설정이 먹히게 하기 위해서임

### (1) EsLint파일에 설정한 prttier 설정 (전체 코드)
```js
module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: ["plugin:vue/essential", "eslint:recommended", "@vue/prettier"],
  parserOptions: {
    parser: "babel-eslint"
  },
  rules: {
    "no-console": process.env.NODE_ENV === "production" ? "warn" : "off",
    "no-debugger": process.env.NODE_ENV === "production" ? "warn" : "off",
    // prettier설정 하는 부분
    "prettier/prettier": ['error', {
      singleQuote: true,
      semi: true,
      useTabs: true,
      tabWidth: 2,
      trailingComma: 'all',
      printWidth: 80,
      bracketSpacing: true,
      arrowParens: 'avoid',
    }]
  },
  overrides: [
    {
      files: [
        "**/__tests__/*.{j,t}s?(x)",
        "**/tests/unit/**/*.spec.{j,t}s?(x)"
      ],
      env: {
        jest: true
      }
    }
  ]
};
```
* 위 코드는 vue프로젝트를 생성할 때 esLint를 설정하면 자동적으로 만들어지는 코드("prettier/prettier" 부분이 따로 설정한 코드)

### (2) prettier설정한 부분코드
```js
    // prettier설정 하는 부분
    "prettier/prettier": ['error', {
      singleQuote: true,
      semi: true,
      useTabs: true,
      tabWidth: 2,
      trailingComma: 'all',
      printWidth: 80,
      bracketSpacing: true,
      arrowParens: 'avoid',
    }]
```
* esLint의 rules에 prettier설정을 따로 함

## 4. 상대경로를 절대경로로 설정하기
1. 상대경로
```js
import Demo from '../../demp/test/demo'
```
* 위 같이 ../ 을 사용하여 현재 파일 기준으로 타고 올라가서 demo파일을 불러옴
* 이렇게 할 경우 많은 파일이 있을 경우 경로 지정에 어려움이 있음
* 따라서 특정 파일을 설정해 놓고 @을 사용하여 설정해놓은 특정파일 부터 경로를 작성하게 함

2. 절대경로 설정
```js

```
#

## 5. 라우터 설정
### (1) vue-router 설치
```js
// router설치 명령어
npm install vue-router
or
npm i vue-router
```
* 아래의 명령어을 사용하여 vue-router를 설치
* i는 install의 약자, 둘다 사용 가능

### (2) routes 폴더 만들기
* src폴더 아래에 routes폴더 만들기

### (3) routes 폴더 내부 index.js 만들기
* routes폴더 아래에 index.js파일 만들기
* index.js 파일에서 라우터를 사용

### (4) routes폴더 내부에 있는 index.js파일에 작성
```js
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export default new VueRouter();
```
1. import Vue from 'vue';
* index.js파일에 vue를 불러옴

2. import VueRouter from 'vue-router';
* 다운 받은 router를 불러옴

3. Vue.use(VueRouter);
* 라우터를 사용하겠다고 선언?!

4. export default new VueRouter();
* 라우터를 밖으로 내보내는 역할

### (5) main.js에서 export한 router를 넣음
```js
// main.js
import Vue from 'vue';
import App from './App.vue';
import router from './routes/index';

Vue.config.productionTip = false;

new Vue({
  render: h => h(App),
  router,
}).$mount('#app');
```
1. import router from './routes/index';
* 위에서 만든 router index.js를 불러옴

2. router,
* vue인스턴스에 router등록

## 6. 라우터 경로 만들기
### (1) 라우터 경로 설정
* 원하는 라우터를 만듬
* 아래는 로그인, 회원가입 로우터를 만든 코드
* 지금 상태에서는 component부분에 빨간줄이 생김
* 이유는 아직 만들지 않은 component기 때문
* 아래 만든 라우터를 설명하자면 /login 경로로 접속할 경우 LoginPage컴포넌트가 화면에 나타남
* 즉, 경로와 컴포넌트를 연결하여 해당 경로에 접속할 경우 지정한 컴포넌트를 화면에 뿌려줌

```js
// routes/index.js
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: '/login',
      component: LoginPage,
    },
    {
      path: '/signup',
      component: SignupPage,
    },
  ],
});
```

### (2) 라우터에 맞는 컴포넌트 만들기
* 위에서 라우터를 만들고 만든 라우터에 접속할 경우 화면에 보여질 컴포넌트를 설정 함
* 이제 해당 컴포넌트를 만들 차례
* src/views 폴더를 만들고 views폴더 내부에 각각의 컴포넌트를 생성
* 만든 컴포넌트에 코드를 작성하면 됨

```js
// src/views/LoginPage,
// src/views/SignupPage
```

### (3) 컴포넌트를 라우터에 연결하기
```js
// routes/index.js
import Vue from 'vue';
import VueRouter from 'vue-router';
import LoginPage from '@/views/LoginPage.vue';
import SignupPage from '@/views/SignupPage.vue';

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: '/login',
      component: LoginPage,
    },
    {
      path: '/signup',
      component: SignupPage,
    },
  ],
});
```
1. import LoginPage from '@/views/LoginPage.vue';
* 컴포넌트를 불러와서 라우터와 컴포넌트를 연결
* SignupPage도 동일

## 7. 라우터 사용(router-link,router-view 사용)
```js
// 다시 공부하기 
```

## 8. 코드 스플리팅(라우터)
* 원래는 사용자가 홈페이지를 여는 순간 서버로 부터 모든 페이지의 정보를 받아옴
* 이렇게 할 경우 단점이 페이지 수가 많을 경우 처음 서버로 부터 받아오는 데이터가 많아져 시간이 많이 걸림
* 따라서 한번에 서버로 부터 모든 페이지 정보를 받아오는게 아니라 사용자가 접속한 url에 맞는 페이지 정보만 서버로 부터 받아옴
* 이후 다른 url로 접속할 경우 해당 url에 맞는 데이터를 또 서버로 부터 받아옴
```js
// routes/index.js
import Vue from 'vue';
import VueRouter from 'vue-router';
// import LoginPage from '@/views/LoginPage.vue';
// import SignupPage from '@/views/SignupPage.vue';

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: '/login',
      component: () => import('@/views/LoginPage.vue'),
    },
    {
      path: '/signup',
      component: () => import('@/views/SignupPage.vue'),
    },
  ],
});
```
1. component: () => import('@/views/LoginPage.vue'),
* 위 코드와 같이 바꿔주면 스플리팅 적용됨
* 기존에 import LoginPage from '@/views/LoginPage.vue';으로 컴포넌트 불러온 것은 필요없음

## 9. 라우터의 리다이렉트 기능
* 사용자가 path에 지정한 경로로 접속 할 경우 redirect에 지정한 경로로 바로 가게 만듬
```js
// routes/index.js
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      component: () => import('@/views/LoginPage.vue'),
    },
    {
      path: '/signup',
      component: () => import('@/views/SignupPage.vue'),
    },
  ],
});
``` 
1. path: '/', redirect: '/login',
* 사용자가 / 경로로 접속할 경우 /login 페이지로 바로 이동하게 만듬

## 10. 콜백 라우터
* 사용자가 없는 url로 접속할 경우 응답하는 기능
```js
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      component: () => import('@/views/LoginPage.vue'),
    },
    {
      path: '/signup',
      component: () => import('@/views/SignupPage.vue'),
    },
    {
      path: '*',
      component: () => import('@/views/NotFoundPage.vue'),
    },
  ],
});
```
1. path: '*',
* 설정한 경로 이 외 경로를 뜻함
* 설정한 경로 말고 다른 경로로 사용자가 접속할 경우 지정한 컴포넌트로 응답함

## 11. history mode (라우터)
* url에 #이 없어짐
* history mode를 하지 않으면 기존에 url에 #이 자동적으로 입력됨
* #이 있는 이유는 찾아보자..... 이해를 못하겠다....
* 사용할때 주의할점이 있으니 찾아보자... 배포할때 주의할점이라고 함
```js
// routes/index.js
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      component: () => import('@/views/LoginPage.vue'),
    },
    {
      path: '/signup',
      component: () => import('@/views/SignupPage.vue'),
    },
    {
      path: '*',
      component: () => import('@/views/NotFoundPage.vue'),
    },
  ],
});
```
1. mode: 'history',
* 이렇게 설정하면 url에 #이 없어짐

## 12. 회원가입 구성 짜기
```js
```

## 13. axios 설정
### (1) axios 다운
```js
npm i axios
```
### (2) axios 설정
* 여러 파일에서 axios를 사용하기 위해 axios로 요청하는 파일을 따로 분리 시켜 api에 요청하는 코드를 모아 놓아 개발
* src/api/index.js 경로로 만들어서 api요청 코드를 한곳에 모으기
* 이후 api가 필요한 파일에서 해당 index.js를 불러와서 사용
```js
// src/api/index.js
import axios from 'axios';

function registerUser() {
  const url = 'http://localhost:3000/signup';
  return axios.post(url);
}

export { registerUser };
```
1. import axios from 'axios';
* 해당 파일에 axios를 불러옴

2. function registerUser(){}
* 회원가입으로 요청할 api만듬

3. export { registerUser };
* 내보내기 해서 사용하고 싶은 파일에서 import해서 사용하면 됨

```js
// src/common/SigupForm.vue
import { registerUser } from '@/api/index';

export default {
  date() {
    return {
      username: '',
      password: '',
      nickname: '',
    };
  },
  methods: {
    submitForm() {
      registerUser();
    },
  },
};
```
1. import { registerUser } from '@/api/index';
* 위 코드와 같이 import해서 불러옴

2. submitForm() { registerUser(); }
* 불러온 registerUser을 호출하면 api/index.js에 설정해놓은 axios가 실행되어 서버에 요청 됨

### (3) 비동기처리
* 지금 회원가입은 비동기적 처리가 필요
* 따라서 asnyc/awiat를 사용하여 비동기적 처리로 함
```html
<template>
  <form @submit.prevent="submitForm">
    <div>
      <label for="username">id: </label>
      <input id="username" type="text" v-model="username" />
    </div>
    <div>
      <label for="password">pw: </label>
      <input id="password" type="text" v-model="password" />
    </div>
    <div>
      <label for="nickname">nick:</label>
      <input id="nickname" type="text" v-model="nickname" />
    </div>
    <button type="submit">login</button>
    <p>{{ logMessage }}</p>
  </form>
</template>

<script>
import { registerUser } from '@/api/index';

export default {
  data() {
    return {
      username: '',
      password: '',
      nickname: '',
      logMessage: '',
    };
  },
  methods: {
    async submitForm() {
      const userDate = {
        username: this.username,
        password: this.password,
        nickname: this.nickname,
      };
      const { data } = await registerUser(userDate);
      this.logMessage = `${data.username}님 가입 축하드립니다!`;
      this.initForm();
    },
    initForm() {
      this.username = '';
      this.password = '';
      this.nickname = '';
    },
  },
};
</script>
```

### (4) 반복되는 url 줄이기
* api에 요청할 때 반복되는 url을 따로 빼어 공통으로 사용하게 만듬
```js
// src/api/index.js
// 변경전
import axios from 'axios';

function registerUser() {
  const url = 'http://localhost:3000/signup';
  return axios.post(url);
}

function loginTest() {
  const url = 'http://localhost:3000/signup';
  return axios.post(url);
}

export { registerUser };
```
1. const url = 'http://localhost:3000/signup';
* http://localhost:3000번이 중복되는 것을 볼 수 있음
* 중복되는 부분을 빼서 뒤에 다른 부분만 집어넣어 보기 좋게 만듬

```js
// src/api/index.js
// 변경후
import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:3000/',
});

function registerUser(userDate) {
  return instance.post('signup', userDate);
}

export { registerUser };
```
1. const instance = axios.create({ baseURL: 'http://localhost:3000/', });
* instance변수를 선언하고 거기에 axios.create속성을 할당
* axios.createdpsms baseURL이라는 속성을 사용가능함(axios자체 속성)
* baseURL에 value로 중복되는 url을 작성

2. instance.post('signup', userDate)
* 이제 instansce변수를 사용하여 원하는 통신방식을 설정하고 파라미터 값을 넘기면 됨
* 첫번째 자리에는 중복되지 않는 url, 두번째 자리는 api요청에 필요한 파라미터






# 순서
1. vue-cli 프로젝트 생성
2. EsLint, prettier 설정
3. 절대경로 설정
4. vue-router설치 및 설정,사용
5. 회원가입 코드 구성
6. axios 설정
7. 
8. 


# 정리
## 1. axios
1. npm에서 axios 설치
1. 서버로 api요청할 필요한 코드는 따로 파일을 만들어 모아놓음
2. 이 파일은 src/api/index.js로 만듬, 여기에 api요청 코드 작성
3. 먼저 axios 불러오기(import axios from 'axios';)
4. 공통된 url을 axios의 create속성을 사용하여 뽑아내기
( const instance = axios.create({
  baseURL: 'http://localhost:3000/',
}); )
5. 함수를 만들어 각각의 api요청 로직 만들기
( function registerUser(userDate) {
  return instance.post('signup', userDate);
} )
6. 만든 api요청 로직을 원하는 파일에서 사용하기 위해 export하기
( export { registerUser }; )
7. 지금까지 정리한 방식 말고 .env파일을 만들어 공통 url을 따로 저장 후 index.js파일에 불러와 사용하는 방법도 있음, .env파일 만들어 url을 따로 빼는 이유는 .env파일은 3가지 파일을 지원함, 개발할때 url경로, 배포했을 때 url경로, 개발과 배포 url이없을 경우 지정될 url경로를 각각 분리하여 대응 할 수 있게 함(다시 공부)

## 2. vue-router (6번부터 다시 정리)
1. 사용자가 url로 접속한 경우 원하는 components를 보여주기 위해 router설정
2. npm에서 vue-roter설치
3. 라우터코드만 따로 만들기 위해 폴더와 파일 만들기(src/routes/index.js)
4. index.js파일에 vue랑 설치한 vue-router불러오기 (import Vue from 'vue';
import VueRouter from 'vue-router'; )
5. 아래 코드는 vueRouter를 사용하겠다고 선언, 꼭 필요한 선언임, 정확한 의미는 모름, ( Vue.use(VueRouter) )
6. ( export default new VueRouter({}) )