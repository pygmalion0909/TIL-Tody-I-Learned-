# Vuex
## 1. 개념
* vue.js 애플리케이션에 대한 상태 관리 패턴 + 라이브러리
* 컴포넌트가 많아 졌을 때 관리하기 하기 위해 패턴 라이브러리
* state, getters, mutations, actions, Helper
* state는 컴포넌트 간에 공유하는 데이터(data)
* View는 데이터를 표시하는 화면(template)
* Action 사용자의 입력에 따라 데이터를 변경(methods)

## 2. 설치하기 및 셋팅
### (1) 설치하기
```
npm install vuex --save
```
* 위 명령어로 설치
* 설치하고 package.json에 가보면 추가 되어 있음

### (2) store파일 만들기
```
src/store/store.js
```
* 위 경로에 store.js파일 만들기
* 일반적인 vuex 디렉토리 구조

### (3) vuex설정하기
```js
// src/store/store.js
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const store = new Vuex.Store({

})
```
1. import Vue from 'vue', import Vuex from 'vuex'
* sotre파일에 vue, vuex라이브러리 불러오기

2. Vue.use(Vuex)
* Vuex를 사용하겠다고 선언
* 이렇게 하면 프로젝트 전역에서 Vuex를 사용가능하게 만듬

3. export const store = new Vuex.Store({ })
* vuex인스턴스 만들기

```js
import Vue from 'vue'
import App from './App.vue'
import {store} from './store/store'

Vue.config.productionTip = false

new Vue({
  store,
  render: h => h(App),
}).$mount('#app')
```
1. import {store} from './store/store'
* store가 변수로 export됬기 때문에 {}를 사용

2. store
* Vue인스턴스에 store을 추가하면 vuex를 사용할 수 있게 됨
* 원래 store: store 인데 es6문법으로 사용하여 축약함

## 3. state 및 getters

## 4. mutations
* state의 값을 변경할 수 있는 유일한 방법 및 메소드
* commit()으로 동작시킴

```js
// store.js
state: {
  num: 10,
}

mutations:{
  aMethod(state){
    return state.num
  },
  bMethod(state, anotherNum){
    return state.num + anotherNum;
  },
  cMethod(state, payload){
    console.log(payload.str);
    console.log(payload.num);
  },

}

// App.vue
this.$store.commit("aMethod");
this.$store.commit("bMethod", 30);
this.$store.commit("bMethod", {str: 'testStr', num: 20});
```
1. aMethod(state)
* 항상 첫번째 인자는 stats의 인자들이 들어옴

2. this.$store.commit("aMethod")
* 이렇게 작동시킴
* state의 값이 바뀜

3. this.$store.commit("bMethod", 30)
* 두번재 인자에 값을 넘길 수 있음

4. cMethod(state, payload)
* payload는 객체로 인자가 넘어온다는 뜻
* 객체로 넘어올 때 통상적으로 payload이름을 사용함

## 5. actions
* 비동기처리는 모두 actions에서 선언

```js
// store.js
state: {
  num: 10
},
mutations: {
  aMathod(state){
    state.num * 2
  },
  actions: {
    delayDoubleNum(context){
      context.commit('aMathod');
    },
  }
}
// App.vue
this.$store.dispatch('delayDoubleNum');
```
1. context
* actions에서 mutations에게 접근하기 위해

2. this.$store.dispatch('delayDoubleNum')
* App.vue에서 dispatch로 delayDoubleNum를 호출하면 actions의 메소드가 실행됨

3. context.commit('aMathod')
* context.commit()에서 mutations를 호출함

4. aMathod(state){}
* 결과적으로 mutations의 메소드가 호출됨
* 즉, actions는 mutations를 호출하기 위한 도구
* actions 메소드에서 비동기식 코드를 작성하면 비동적으로 mutations의 메소드가 호출 됨