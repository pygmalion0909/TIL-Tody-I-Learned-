# TodoList
## 1. Component 생성하기
### (1) 폴더구성
```
src/components
```
* src폴더 밑에 components폴더 만들기
* 여기에 component를 모아 놓음
* 앞으로 화면 구성을 compoent단위로 할꺼니깐 여기서 component를 구성하면 됨

### (2) component 만들기
* 아래 4개 component들을 만들기
* TodoHeader
* TodoInput
* TodoList
* TodoFooter
```html
<template>
  <div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>
```
* 만들고 각각의 component들을 태그 구성을 위와 같이 하기
* scf 또는 defalt 하고 탭 눌리면 자동으로 태그를 만들어 줌

### (3) App.vue와 연결하기
```html
<!-- App.vue파일 -->
<template>
  <div id="app">
  </div>
</template>

<script>
import TodoHeader from "./components/TodoHeader";
import TodoInput from "./components/TodoInput";
import TodoList from "./components/TodoList";
import TodoFooter from "./components/TodoFooter";

export default {
}
</script>

<style>
</style>
```
* 왜 연결하냐면 App.vue가 root파일이니깐
* App파일 아래에 내가 만든 component를 등록해서 자식 요소로 만듬
* 기존에 디폴드로 되어있는 App.vue파일의 내용은 다 지우고 component의 틀만 남겨두기
* 이제 내가 만든 component랑 연결하기

1. import TodoHeader from "./components/TodoHeader";
* ./ 는 상대경로를 뜻함, 즉 App파일 기준에서 경로를 생각함
* App.vue파일에 내가 만든 component를 가져옴
* 이렇게 import하면 내가 만든 4개의 component들은 App.vue에 담기고 App.vue랑 연결되어 소통이 가능함

### (4) App.vue에 component등록하기
```html
<!-- App.vue파일 -->
<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput></TodoInput>
    <TodoList></TodoList>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from "./components/TodoHeader";
import TodoInput from "./components/TodoInput";
import TodoList from "./components/TodoList";
import TodoFooter from "./components/TodoFooter";

export default {
  components:{
    "TodoHeader": TodoHeader,
    "TodoInput": TodoInput,
    "TodoList": TodoList,
    "TodoFooter": TodoFooter,
  }
}
</script>

<style>
</style>
```
1. components : { 만든 component 등록 }
* App에 내가 만든 component를 등록
* "템플릿에 등록할 이름" : import해서 가져온 이름
* 이렇게 등록하고 App template에 태그를 입력해야 html태그로 봤을 때 App태그 아래에 자식 요소로 잡힘  
* 이렇게 등록하고 서버 돌려서 vue개발자 도구 가면 App밑에 4개의 component가 보임

## 2. TodoHeader component 코드 작성
### (1) css스타일 꾸미기
```html
<!-- TodoHeader component -->
<template>
  <header>
    <h1>Todo it!</h1>
  </header>
</template>

<script>
export default {

}
</script>

<style scoped>
h1{
  color: crimson;
  font-weight: 900;
  margin: 2.5rem 0 1.5rem;
}
</style>
```
1. style scoped
* 원래는 싱글component를 하면 상위의 스타일요소를 상속받음
* 즉, 현재 TodoHeader파일의 부모인 App파일의 css를 상속 받음
* 하지만 scoped를 하게되면 App파일의 css를 상속 받지 않고 현재 TodoHeader파일 내부에서만 단독적으로 적용함

```html
<!-- App -->
<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput></TodoInput>
    <TodoList></TodoList>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from "./components/TodoHeader";
import TodoInput from "./components/TodoInput";
import TodoList from "./components/TodoList";
import TodoFooter from "./components/TodoFooter";

export default {
  components:{
    "TodoHeader": TodoHeader,
    "TodoInput": TodoInput,
    "TodoList": TodoList,
    "TodoFooter": TodoFooter,
  }
}
</script>

<style>
  body{
    text-align: center;
    background-color: #F6F6F6;
  }
  #app{
    background: lightgray;
    width: 420px;
    margin: 0 auto;
  }
  input{
    border-style: groove;
  }
  button{
    border-style: groove;
  }
  .shadow{
    box-shadow: 5x 10px 10px rgba(0, 0, 0, 0.03);
  }
</style>

```
* 전체적으로 꾸미기 할 때는 App파일에서 꾸미면 됨

## 3. TodoInput component 코드 작성
### (1)
```html
<!-- TodoInput.vue -->
<template>
  <div>
    <input type="text" v-model="newTodoItem">
    <button v-on:click="addTodo">Add</button>
  </div>
</template>

<script>
export default {
  data(){
    return {
      newTodoItem: ""
    }
  },
  methods:{
    addTodo(){
      localStorage.setItem(this.newTodoItem, this.newTodoItem);
      this.clearInput();
    },
    clearInput(){
      this.newTodoItem = "";
    },
}
</script>

<style>
</style>
```
1. input type="text" v-model="newTodoItem"
* v-model은 input의 값을 동적으로 즉각적으로 vue인스턴스 내부에 연동함
* 화면이랑 vue인스턴스랑 실시간 연동 됨
* 여기서 vue인스턴스는 TodoInput의 vue인스턴스를 말함 
* 정확하게 말하면 TodoInput의 data에 있는 newTodoItem과 v-model이름이랑 같으면 연동 됨
* 화면에 input박스에 사용자가 입력하면 즉각적으로 vue인스턴스의 data내부에 있는 newTodoItem에 값이 입력됨
2. button v-on:click="addTodo"
* v-on은 이벤트를 걸어줌
* button을 클릭할 때 마다 addTodo메소드가 실행 됨
* 메소드는 vue인스턴스의 methods에서 정의함

3. localStorage.setItem(this.newTodoItem, this.newTodoItem);
* 브라우저에 저장소들이 있음, 그 중 로컬스토리지를 사용
* 로컬스토리지에 저장할려면 setItem메소드를 사용하면 됨
* 값을 넣을 때는 key:value형태로 넣으면 됨
* 지금은 input의value: input의value 형태로 넣음

4. this.clearInput()
* 사용자가 input박스에 값을 집어 넣고 add버튼을 눌리면 input의 값이 초기화 시키는 작업
* 여기서 중요한것은 method도 같은 인스턴스 내부에 있으면 this로 호출 가능

### (2) css꾸미기, 코드 수정
```html
<!-- TodoInput -->
<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
    <span class="addContainer" v-on:click="addTodo">
      <i class="far fa-plus-square addBtn"></i>
    </span>
  </div>
</template>

<script>
export default {
  data(){
    return {
      newTodoItem: "",
    }
  },
  methods:{
    addTodo(){
      localStorage.setItem(this.newTodoItem, this.newTodoItem);
      this.clearInput();
    },
    clearInput(){
      this.newTodoItem = "";
    },
  },
}
</script>

<style scoped>
  input:focus{
    outline: none;
  }
  .inputBox{
    background: white;
    height: 50px;
    line-height: 50px;
    border-radius: 5px;
  }
  .inputBox input{
    border-style: none;
    font-size: 0.9rem;
    width: 80%;
    box-sizing: border-box;
  }
  .addContainer{
    float: right;
    background: linear-gradient(to right, #6478FB, #8763FB);
    display: block;
    width: 3rem;
    border-radius: 0 5px 5px 0;
    cursor: pointer;
  }
  .addBtn{
    color: white;
    vertical-align: middle;
  }
</style>
```
1. span class="addContainer" v-on:click="addTodo"
* 스타일 야매로 입힐려고 button태그를 span태그로 대체함
* 이제 span태그 클릭하면 button버튼 클릭한 것 처럼 작동함

2. i class="far fa-plus-square addBtn"
* 폰트어썸 사용함
* 폰트 어썸 CDN은 public/index.html에 넣으면 적용됨
* 즉, public/index.html파일이 최상위 폴더라서 모든 component는 index.html으로 모인다고 생각하면 편함

3. v-on:keyup.enter="addTodo"
* input에서 keyup을 하고 enter을 하면 addTodo메소드가 실행 됨
* keyup은 input태그에 키가 눌렸다 올라왔을 때 를 뜻함


## 4.
## 5.
## 6.
## 7.
## 8.
## 9.
## 10.
## 11.
## 12.
