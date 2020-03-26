# 싱글component
## 1. 개념
* html, js, css코드를 한개의 파일에 정리한 것 이 싱글파일 component 임
* default, vue, scf중 하나 입력하고 탭 눌리면 싱글파일 컴포넌트 구조를 자동 완성
* 컴포넌트 파일을 만들 때 두개의 단어로 조합하고 첫글자와 단어시작에는 대문자로 만들기
* html태그와 충돌을 방지 하기 위함

```html
<template>
  <!-- html코드-->
</template>

<script>
export default {
// js 코드
}
</script>

<style>
/* css코드 */
</style>
```

## 2. 기본 틀
### (1) 싱글컴포넌트 사용 전 코드
```js
const appHeader = {
  template: "<div>header</div>",
  methods: {
    upNum(){
      // 코드
    }
  },
}
```
### (2) 싱글컴포넌트 사용 후 코드
```html
<template>
  <div>header</div>
</template>

<script>
export default {
 methods: {
    upNum(){
      // 코드
    }
  },
}
</script>

<style>
/* css */
</style>
```

## 3. 예제
### (1) App.vue
```html
<template>
  <div>
    {{str}}
  </div>
</template>

<script>
export default {
  data(){
    return {
      str: "hi!!",
    }
  }
}
</script>

<style>

</style>
```
1. App.vue
* root다음으로 최상위 폴더
* 여기서 

2. template태그
* template에는 항상 root태그가 한개 있어야 함
* 하나의 태그 내부에 여러개 태그를 만들수 있음
* 두개의 root태그가 있으면 안됨, 에러발생

3. data(){ return { str: "hi!!", } }
* 기존에 사용하던 new Vue({ data:{ str:"hi!!", } })랑 같은 코드
* 재사용할 때 중복방지를 위해 메소드로 만들어 객체를 리턴함

### (2) component 연동
```html
<!-- 파일 : App.vue -->
<template>
  <div>
    <app-header></app-header>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";

export default {
  data(){
    return {
      str: "hi!!",
    }
  },
  components:{
    'app-header': AppHeader
  }
}
</script>

<style>

</style>
```
1. import AppHeader from "./components/AppHeader.vue"
* import는 불러오는 명령어
* AppHeader은 불러온 파일을 담을 변수명
* ./components/AppHeader.vue는 불러올 파일의 경로지정

2. components:{ 'app-header': AppHeader }
* 불러온 AppHeader파일을 컴포넌트 속성에 'app-header'로 설정

3. app-header /app-header
* html에 컴포넌트 입력

```html
<!-- 파일 : components/AppHeader.vue -->
<template>
  <header>
    <h1></h1>
  </header>
</template>

<script>
export default {

}
</script>

<style>

</style>
```
* App.vue로 보내질 파일
* App파일은 AppHeader파일보다 상위에 위치
* 즉, App파일이 AppHeader파일에게 데이터를 보낼려면 props를 사용해야 하고, AppHeader파일에서 App파일로 데이터를 보낼려면 Event을 사용해야 함

### (3) 분리된 component끼리 props사용
```html
<!-- 파일 : App.vue -->
<template>
  <div>
    <app-header v-bind:propsData="str"></app-header>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";

export default {
  data(){
    return {
      str: "Header",
    }
  },
  components:{
    'app-header': AppHeader
  }
}
</script>

<style>

</style>
```
1. v-bind:propsData="str"
* App파일에서 data속성에 있는 str값을 propsData이름으로 bind해서 AppHeader파일로 보냄
* 즉, App파일에서는 propsData이름으로 보내고 AppHeader파일에서는 propsData로 받음
* 한마디로 서로 소통하기 위한 매개변수 랄까?

```html
<!-- 파일 : components/AppHeader.vue -->
<template>
  <header>
    <h1>{{propsData}}</h1>
  </header>
</template>

<script>
export default {
  props: ['propsData']
}
</script>

<style>

</style>
```
1. props: ['propsData']
* props속성에 App파일에서 보낸 propsData를 설정해줌
* 현재 propsData에는 App파일에 data속성에 있는 str값이 들어있음

2. {{propsData}}
* 데이터 바인딩으로 propsData를 화면에 입력

### (4) 분리된 component끼리 event emit사용
```html
<!-- App.vue -->
<template>
  <div>
    <app-header v-bind:propsData="str" v-on:renew="renewStr"></app-header>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";

export default {
  data(){
    return {
      str: "Header",
    }
  },
  components:{
    'app-header': AppHeader
  },
  methods:{
    renewStr(){
      this.str = "Content"
    }
  }
}
</script>

<style>

</style>
```
1. v-on:renew="renewStr"
* 하위에서 renew으로 신호를 보내면 renewStr메소드를 작동함

2. methods:{ renewStr(){ this.str = "Content" } }
* renewStr메소드는 현재 인스턴스의 str값을 Content로 바꿈

```html
<!-- 파일 : components/AppHeader.vue -->
<template>
  <header>
    <h1>{{propsData}}</h1>
    <button v-on:click="sendEvent">send</button>
  </header>
</template>

<script>
export default {
  props: ['propsData'],
  methods:{
    sendEvent(){
      this.$emit('renew');
    },
  }
}
</script>

<style>

</style>
```
1. v-on:click="sendEvent"
* button을 클릭하면 click이벤트를 발생시킴
* 이때 sendEvent메소드를 실행함

2. sendEvent(){ this.$emit('renew'); },
* sendEvent메소드는 상위 component로 renew라는 신호를 보냄
* 상위 컴포넌트는 rene신호를 받으면 상위 컴포넌트에서 설정한 것이 작동함
* 즉, 하위에서 신호를 보내면 상위에서 동작함
* 하위에서 신호를 보내지 않으면 상위에서는 아무런 동작 하지 않음

### (5) etc
```html
<template>
  <form action="" v-on:submit.prevent="getIdPw">
    <div>
      <label for="userName">id : </label>
      <input type="text" id="userName" v-model="username"> 
    </div>
    <div>
      <label for="userPw">password : </label>
      <input type="password" id="userPw" v-model="userpw"> 
    </div>
    <button type="submit"> login </button>
  </form>
</template>

<script>
// axios 가져오기
import axios from 'axios';

export default {
  // 컴포넌트 별로 개발할 때는 data가 서로 공유되지 않게 메소드로 만들어 객체를 리턴해야 함
  data(){
    return{
      username: "",
      userpw: "",
    }
  },
  methods: {
    getIdPw(){
      const url = 'https://jsonplaceholder.typicode.com/users';
      const data ={
        username : this.username,
        userpw : this.userpw,
      }
      // 데이터를 post방식으로 서버에 전송
      // 첫번재 인자는 url이고 두번째 인자는 보낼 데이터를 입력
      axios.post(url, data)
      .then(
        (res) => {
          console.log(res);
        }
      )
      .catch(
        (err) => {
          console.log(err);
        }
      );
    }
  }
}
</script>

<style>
</style>
```


