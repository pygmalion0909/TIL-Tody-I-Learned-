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

## 4. TodoList component 코드 작성
### (1) 리스트 추가
```html
<!-- TodoList -->
<template>
  <div>
    <ul>
      <li v-for="todoItem in todoItems" v-bind:key="todoItem">
        {{ todoItem }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data(){
    return{
      todoItems: [],
    }
  },
  created(){
    if(localStorage.length > 0){
      for(var i = 0; i < localStorage.length; i++){
        this.todoItems.push(localStorage.key(i));
      }
    }
  },
}
</script>

<style>
</style>
```
1. created(){ if(localStorage.length > 0){ for(var i = 0; i < localStorage.length; i++){ this.todoItems.push(localStorage.key(i)); } } }
* created()는 vue 라이프 사이클
* 인스턴스가 생성되자마자 호출되는  라이프사이클 훅
* localStorage의 길이가 0보다 크면(로컬에 내용이 있으면) 반복문 돌려서 뷰 인스턴스의 data에 있는 totoItems배열에 값을 집어 넣음
* locaStorage.key는 로컬스토리지의 key값을 뜻함

2. li v-for="todoItem in todoItems" v-bind:key="todoItem"
* todoItems배열 내부에서 todoItem숫자 만큼 반복
* 비주얼코드에서 v-for를 사용하면 v-bind:key를 설정해달라고 함, 아톰이나 다른 에디터에서는 v-bind 사용안해도 빨간줄 안 뜸

3. {{ todoItem }}
* v-for로 반복 된 값을 li태그에 데이터바인딩 함

### (2) 삭제버튼 추가 및 스타일 추가
```html
<!-- TodoList -->
<template>
  <div>
    <ul>
      <li v-for="(todoItem, index) in todoItems" v-bind:key="todoItem" class="shadow">
        {{ todoItem }}
        <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
          <i class="fas fa-trash-alt"></i>
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data(){
    return{
      todoItems: [],
    }
  },

  methods : {
    removeTodo(todoItem, index){
      localStorage.removeItem(todoItem);
      this.todoItems.splice(index, 1);
    },
  },

  created(){
    if(localStorage.length > 0){
      for(var i = 0; i < localStorage.length; i++){
        this.todoItems.push(localStorage.key(i));
      }
    }
  },
}

</script>

<style scoped>
  ul{
    list-style-type: none;
    padding-left: 0px;
    margin-top: 0;
    text-align: left;
  }
  li{
    display: flex;
    min-height: 50px;
    height: 50px;
    line-height: 50px;
    margin: 0.5rem 0;
    padding: 0 0.9rem;
    background: white;
    border-radius: 5px;
  }
  .checkBtn{
    line-height: 45px;
    color: #62acde;
    margin-right: 5px;
  }
  .checkBtnCompleted{
    color: #b3adad;
  }
  .removeBtn{
    margin-left: auto;
    color: #de4343;
    cursor: pointer;
  }
</style>
```
1. li v-for="(todoItem, index) in todoItems" v-bind:key="todoItem" class="shadow"
* v-for를 사용하면 ()묶고 두번째 자리는 해당 리스트의 index번호를 자동으로 부여함
* 첫번째 자리는 리스트 vlaue값

2. span class="removeBtn" v-on:click="removeTodo(todoItem, index)"
* 삭제 버튼을 클릭했을 때 몇번째 리스트인지 알려고 메소드 호출할 때 todoItem이랑 index를 넘김

3. this.todoItems.splice(index, 1)
* splice는 배열의 특정 인덱스를 지움
* 여기서 splice는 사용자가 클릭한 index번호가 removeTodo로 넘어오니깐 index번호를 지우는 역할을 함
* 이건 화면에 있는 value를 삭제

4. localStorage.removeItem(todoItem)
* 로컬스토리지에서 value삭제 

## 5. 리스트에 완료했을 때 체크박스
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
      if(this.newTodoItem !== ""){
        const obj = {completed: false, item: this.newTodoItem};
        localStorage.setItem(this.newTodoItem, JSON.stringify(obj));
        this.clearInput();
      }
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
1. const obj = {completed: false, item: this.newTodoItem}
* 할일 완료 표시를 하기 위해 속성이 필요함
* completed로 완료여부 판단하여 화면에 완료표시를 할꺼임
* 그러기 위해서 로컬스토리지에 저장할 때 객체로 저장해야 함
* completed가 false이면 아직 완료안됬고 true이면 완료됨

2. if(this.newTodoItem !== ""){
* input에 값이 있을 경우 로컬스토리지에 담김, 하지만 아래코드로는 스페이스바 여러번 눌리고 엔터하면 값이 들어감, 추후 개선할 점

3. localStorage.setItem(this.newTodoItem, JSON.stringify(obj))
* 로컬에 객체 담을려면 문자열로 바꿔서 넣어야함, 나중에 다시 꺼낼 때 객체형태로 바꿔서 깨내면 됨, 이렇게 하기 위해 json을 사용

```html
<!-- TodoList -->
<template>
  <div>
    <ul>
      <li v-for="(todoItem, index) in todoItems" v-bind:key="todoItem.item" class="shadow">
        <!-- v-bind는 html태그에  속성을 넣을 수 있음 -->
        <!-- 또한 옵션을 걸어서 옵션에 맞으면 속성을 넣고 옵션에 안맞으면 옵션을 안주고 할 수 있음 -->
        <!-- v-bind:원하는속성="{속성값 : 옵션}" -->
        <i class="checkBtn fas fa-check" v-bind:class="{checkBtnCompleted: todoItem.completed}" v-on:click="toggleComplete(todoItem, index)"></i>
        <!-- todoItem이 지금 객체니깐 . 을 사용하여 todoItem의 item만 화면에 렌더링 함-->
        <!-- v-bind는 html태그에다가 동적으로 속성을 추가가 함-->
        <!-- 즉, span태그에 class를 textCompleted를 주는데 todoItem.completed가 true면 주고 false면 class를 주지 않음 -->
        <span v-bind:class="{textCompleted: todoItem.completed}">  {{ todoItem.item }} </span>
        <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
          <i class="fas fa-trash-alt"></i>
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data(){
    return{
      todoItems: [],
    }
  },

  methods : {
    removeTodo(todoItem, index){
      localStorage.removeItem(todoItem);
      this.todoItems.splice(index, 1);
    },
    toggleComplete(todoItem){
      // todoItem.completed가 false이면 true로 바꾸고 true이면 fals로 바꾸는 토글 코드임
      todoItem.completed = !todoItem.completed;

      // 로컬스토리지에 업데이트 메소드가 없어서 체크한 목록을 지우고 completed를 true로 바꾸고 추가하는 방법으로 해야함
      localStorage.removeItem(todoItem.item);
      localStorage.setItem(todoItem.item, JSON.stringify(todoItem));
    },
  },

  created(){
    if(localStorage.length > 0){
      for(var i = 0; i < localStorage.length; i++){
        // 이렇게하면 로컬스토리지의 value값을 얻을 수 있음
        // localStorage.getItem(localStorage.key(i));
        // JSON.parse를 해서 데이터를 문자열에서 객체로 변환함
        // todoItems배열에 객체를 담음
        this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
      }
    }
  },
}
</script>

<style scoped>
  ul{
    list-style-type: none;
    padding-left: 0px;
    margin-top: 0;
    text-align: left;
  }
  li{
    display: flex;
    min-height: 50px;
    height: 50px;
    line-height: 50px;
    margin: 0.5rem 0;
    padding: 0 0.9rem;
    background: white;
    border-radius: 5px;
  }
  .checkBtn{
    line-height: 45px;
    color: #62acde;
    margin-right: 5px;
    margin-top: 5px;
    cursor: pointer;
  }
  .checkBtnCompleted{
    color: #b3adad;
  }
  .removeBtn{
    margin-left: auto;
    color: #de4343;
    cursor: pointer;
  }
  .textCompleted{
    text-decoration: line-through;
    color: lightgray;
  }
</style>
```
1. li v-for="(todoItem, index) in todoItems"
* todoItem, index는 li의 하위태그에서 매개변수로 사용가능

## 6. footerComponent
```html
<template>
  <div class="clearAllContainer">
    <span class="clearAllBtn" v-on:click="clearTodo">Clear All</span>
  </div>
</template>

<script>
export default {
  methods: {
    clearTodo(){
      localStorage.clear();
    }
  }
}
</script>

<style scoped>
  .clearAllContainer{
    width: 8.5rem;
    height: 50px;
    line-height: 50px;
    background: white;
    border-radius: 5px;
    margin: 0 auto;
    cursor: pointer;
  }
  .clearAllBtn{
    color: crimson;
    display: block;
  }
</style>
```
1. span class="clearAllBtn" v-on:click="clearTodo"
* span태그를 클릭했을 경우 clearTodo메소드가 실행

2. methods: { clearTodo(){ localStorage.clear(); } }
* clear()는 로컬스토리지를 모두 지우는 메소드

## 7. 리팩토링
### (1) App에 몰아주기(list의 created를 App로 보내기)
* Header, Input, List, Footer 컴포넌트에서 일을 처리하는게 아니라 모든 정보는 App에게 넘겨주고 App에서 동작을 하게 만듬
* 컴포넌트마다 데이터를 다룬다면 복잡하고 갱신된 데이터를 계속 옮겨줘야하니깐 한 곳에 모아서 데이터를 조작함

```html
<!-- App.vue -->
<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput></TodoInput>
    <TodoList v-bind:propsdata="todoItems"></TodoList>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoInput from './components/TodoInput.vue'
import TodoList from './components/TodoList.vue'
import TodoFooter from './components/TodoFooter.vue'

export default {
  data(){
    return{
      todoItems: [],
    }
  },
  created: function() {
    if (localStorage.length > 0) {
      for (var i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) !== 'loglevel:webpack-dev-server') {
          this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
        }
      }
    }
  },
  components: {
    TodoHeader: TodoHeader,
    TodoInput: TodoInput,
    TodoList: TodoList,
    TodoFooter: TodoFooter
  }  
}
</script>

<style>
body {
  text-align: center;
  background-color: #F6F6F8;
}
input {
  border-style: groove;
  width: 200px;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
}
</style>
```
* 우선, List컴포넌트에서 인스턴스가 만들어지는 순간 로컬스토리지의 데이터를 가져와 화면에 뿌려지는 역할을 했지만 이제는 App컴포넌트에서 함
* 그래서 created훅을 App에 넣음

1. TodoList v-bind:propsdata="todoItems"
* TodoList한테 propsdata이름으로 todoItmes데이터를 내려 보냄

```html
<!-- TodoList -->
<template>
  <section>
    <ul>
      <li v-for="(todoItem, index) in propsdata" class="shadow" v-bind:key="todoItem.item">
        <i class="checkBtn fas fa-check" v-bind:class="{checkBtnCompleted: todoItem.completed}" v-on:click="toggleComplete(todoItem, index)"></i>
        <span v-bind:class="{textCompleted: todoItem.completed}">{{ todoItem.item }}</span>
        <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
          <i class="removeBtn fas fa-trash-alt"></i>
        </span>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  props: ['propsdata'],
  methods: {
    removeTodo: function(todoItem, index) {
      this.todoItems.splice(index, 1);
      localStorage.removeItem(todoItem);
    },
    toggleComplete: function(todoItem) {
      todoItem.completed = !todoItem.completed;
      localStorage.removeItem(todoItem.item);
      localStorage.setItem(todoItem.item, JSON.stringify(todoItem));
    }
  },
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}
li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}
.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}
.checkBtnCompleted {
  color: #b3adad;
}
.textCompleted {
  text-decoration: line-through;
  color: #b3adad;
}
.removeBtn {
  margin-left: auto;
  color: #de4343;
}
</style>
```
1. props: ['propsdata']
* App.vue가 내려보낸 데이터를 이런식으로 받음, propsdata에 데이터가 들어가 있음

2. li v-for="(todoItem, index) in propsdata" v-bind:key="todoItem.item" class="shadow"
*  App.vue한테 받은 데이터를  for문 돌려서 리스트로 출력

### (2) TodoInput의 기능을 App로 이전
```html
<!-- TodoInput -->
<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
    <span class="addContainer" v-on:click="addTodo">
      <i class="addBtn fas fa-plus" aria-hidden="true"></i>
    </span>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      newTodoItem: ''
    }
  },
  methods: {
    addTodo: function() {
      if (this.newTodoItem !== '') {
        this.$emit("addTodoItem", this.newTodoItem);
        this.clearInput();
      }
    },
    clearInput: function() {
      this.newTodoItem = '';
    }
  }
}
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>
```
* input에서 로컬스토리지에 저장하는 기능을 App에게 이전 함

1. this.$emit("addTodoItem", this.newTodoItem)
* ddTodo메소드가 실행되면 addTodoItem이라는 이벤트가 발생됨, 이때 this.newTodoItem값을 같이 보내서 발생
* addTodoItem이벤트는 App.vue에서 정의되어 있음
* 즉, input컴포넌트가 이벤트를 App한테 전달함

```html
<!-- App -->
<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodoItem="addOneItem"></TodoInput>
    <TodoList v-bind:propsdata="todoItems"></TodoList>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoInput from './components/TodoInput.vue'
import TodoList from './components/TodoList.vue'
import TodoFooter from './components/TodoFooter.vue'

export default {
  data(){
    return{
      todoItems: [],
    }
  },
  methods:{
    addOneItem(todoItem){
      var obj = {completed: false, item: todoItem};
      localStorage.setItem(todoItem, JSON.stringify(obj))
      this.todoItems.push(obj);
    }
  },
  created: function() {
    if (localStorage.length > 0) {
      for (var i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) !== 'loglevel:webpack-dev-server') {
          this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
        }
      }
    }
  },
  components: {
    TodoHeader: TodoHeader,
    TodoInput: TodoInput,
    TodoList: TodoList,
    TodoFooter: TodoFooter
  }  
}
</script>

<style>
body {
  text-align: center;
  background-color: #F6F6F8;
}
input {
  border-style: groove;
  width: 200px;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
}
</style>
```
1. TodoInput v-on:addTodoItem="addOneItem"
* v-on:하위에서 올라오는 이벤트이름="현재파일에 있는 메소드이름" 

2. addOneItem(todoItem)
* 하위에서 보낸 매개변수를 todoItem으로 받음

### (3) 삭제기능
```html
<!-- App -->
<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodoItem="addOneItem"></TodoInput>
    <TodoList v-bind:propsdata="todoItems" v-on:removeItem="removeOneItem"></TodoList>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoInput from './components/TodoInput.vue'
import TodoList from './components/TodoList.vue'
import TodoFooter from './components/TodoFooter.vue'

export default {
  data(){
    return{
      todoItems: [],
    }
  },
  methods:{
    addOneItem(todoItem){
      var obj = {completed: false, item: todoItem};
      localStorage.setItem(todoItem, JSON.stringify(obj))
      this.todoItems.push(obj);
    },
    removeOneItem(todoItem, index){
      localStorage.removeItem(todoItem.item);
      this.todoItems.splice(index, 1);
    }
  },
  created: function() {
    if (localStorage.length > 0) {
      for (var i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) !== 'loglevel:webpack-dev-server') {
          this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
        }
      }
    }
  },
  components: {
    TodoHeader: TodoHeader,
    TodoInput: TodoInput,
    TodoList: TodoList,
    TodoFooter: TodoFooter
  }  
}
</script>

<style>
body {
  text-align: center;
  background-color: #F6F6F8;
}
input {
  border-style: groove;
  width: 30%;
  height: 100%;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
}
</style>

```

```html
<!-- TodoList -->
<template>
  <section>
    <ul>
      <li v-for="(todoItem, index) in propsdata" class="shadow" v-bind:key="todoItem.item">
        <i class="checkBtn fas fa-check" v-bind:class="{checkBtnCompleted: todoItem.completed}" v-on:click="toggleComplete(todoItem, index)"></i>
        <span v-bind:class="{textCompleted: todoItem.completed}">{{ todoItem.item }}</span>
        <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
          <i class="removeBtn fas fa-trash-alt"></i>
        </span>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  props: ['propsdata'],
  methods: {
    removeTodo: function(todoItem, index) {
      this.$emit("removeItem", todoItem, index);
    },
    toggleComplete: function(todoItem) {
      todoItem.completed = !todoItem.completed;
      localStorage.removeItem(todoItem.item);
      localStorage.setItem(todoItem.item, JSON.stringify(todoItem));
    }
  },
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}
li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}
.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}
.checkBtnCompleted {
  color: #b3adad;
}
.textCompleted {
  text-decoration: line-through;
  color: #b3adad;
}
.removeBtn {
  margin-left: auto;
  color: #de4343;
}
</style>
```

### (4) 토글(완료) 기능
```html
<!-- App -->
<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodoItem="addOneItem"></TodoInput>
    <TodoList v-bind:propsdata="todoItems" v-on:removeItem="removeOneItem" v-on:toggleItem="toggleOneItem"></TodoList>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoInput from './components/TodoInput.vue'
import TodoList from './components/TodoList.vue'
import TodoFooter from './components/TodoFooter.vue'

export default {
  data(){
    return{
      todoItems: [],
    }
  },
  methods:{
    addOneItem(todoItem){
      var obj = {completed: false, item: todoItem};
      localStorage.setItem(todoItem, JSON.stringify(obj))
      this.todoItems.push(obj);
    },
    removeOneItem(todoItem, index){
      localStorage.removeItem(todoItem.item);
      this.todoItems.splice(index, 1);
    },
    toggleOneItem(todoItem, index){
      this.todoItems[index].completed = !this.todoItems[index].completed;
      localStorage.removeItem(todoItem.item);
      localStorage.setItem(todoItem.item, JSON.stringify(todoItem));
    }
  },
  created: function() {
    if (localStorage.length > 0) {
      for (var i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) !== 'loglevel:webpack-dev-server') {
          this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
        }
      }
    }
  },
  components: {
    TodoHeader: TodoHeader,
    TodoInput: TodoInput,
    TodoList: TodoList,
    TodoFooter: TodoFooter
  }  
}
</script>

<style>
body {
  text-align: center;
  background-color: #F6F6F8;
}
input {
  border-style: groove;
  width: 30%;
  height: 80%;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
}
</style>
```
1. v-on:toggleItem="toggleOneItem"
* 하위에서 toglleItem이름으로 이벤트 전달하면 App에서는 toggleOneItem메소드를 실행

2. toggleOneItem(todoItem, index)
* 하위에서 이벤트를 전달할 때 받은 매개변수를 지정

3. this.todoItems[index].completed = !this.todoItems[index].completed
* App에 todoItems에 값을 가지고 코드를 짬

```html
<!-- TodoList -->
<template>
  <section>
    <ul>
      <li v-for="(todoItem, index) in propsdata" class="shadow" v-bind:key="todoItem.item">
        <i class="checkBtn fas fa-check" v-bind:class="{checkBtnCompleted: todoItem.completed}" v-on:click="toggleComplete(todoItem, index)"></i>
        <span v-bind:class="{textCompleted: todoItem.completed}">{{ todoItem.item }}</span>
        <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
          <i class="removeBtn fas fa-trash-alt"></i>
        </span>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  props: ['propsdata'],
  methods: {
    removeTodo: function(todoItem, index) {
      this.$emit("removeItem", todoItem, index);
    },
    toggleComplete: function(todoItem, index) {
      this.$emit("toggleItem", todoItem, index);
    }
  },
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}
li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}
.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}
.checkBtnCompleted {
  color: #b3adad;
}
.textCompleted {
  text-decoration: line-through;
  color: #b3adad;
}
.removeBtn {
  margin-left: auto;
  color: #de4343;
}
</style>
```
1. toggleComplete: function(todoItem, index) { this.$emit("toggleItem", todoItem, index);}
* i태그를 클릭 했을 때 toggleComplete메소드가 실행되면서 App한테 이벤트를 전달함
* this.$emit이 이벤트 전달하는 것
* 이벤트 전달 할 대 togglerItem이름으로 전달하며 todoItem, index값도 같이 전달함
* 그래서 App에서 값을 사용 가능

### (5) 토글(완료) 기능
```html
<!-- App -->
<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodoItem="addOneItem"></TodoInput>
    <TodoList v-bind:propsdata="todoItems" v-on:removeItem="removeOneItem" v-on:toggleItem="toggleOneItem"></TodoList>
    <TodoFooter  v-on:clearAll="clearAllItems"></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoInput from './components/TodoInput.vue'
import TodoList from './components/TodoList.vue'
import TodoFooter from './components/TodoFooter.vue'

export default {
  data(){
    return{
      todoItems: [],
    }
  },
  methods:{
    addOneItem(todoItem){
      var obj = {completed: false, item: todoItem};
      localStorage.setItem(todoItem, JSON.stringify(obj))
      this.todoItems.push(obj);
    },
    removeOneItem(todoItem, index){
      localStorage.removeItem(todoItem.item);
      this.todoItems.splice(index, 1);
    },
    toggleOneItem(todoItem, index){
      this.todoItems[index].completed = !this.todoItems[index].completed;
      localStorage.removeItem(todoItem.item);
      localStorage.setItem(todoItem.item, JSON.stringify(todoItem));
    },
    clearAllItems(){
      localStorage.clear();
      this.todoItems = [];
    }
  },
  created: function() {
    if (localStorage.length > 0) {
      for (var i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) !== 'loglevel:webpack-dev-server') {
          this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
        }
      }
    }
  },
  components: {
    TodoHeader: TodoHeader,
    TodoInput: TodoInput,
    TodoList: TodoList,
    TodoFooter: TodoFooter
  }  
}
</script>

<style>
body {
  text-align: center;
  background-color: #F6F6F8;
}
input {
  border-style: groove;
  width: 30%;
  height: 80%;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
}
</style>
```
1. TodoFooter v-on:clearAll="clearAllItems"
* TodoFooter컴포넌트에서 clearAll이름으로 이벤트를 전달함
* 이벤트가 전달되면 App에 있는 clearAllItems메소드를 실행

2. clearAllItems(){ localStorage.clear(); this.todoItems = []; }
* 로컬스토리지 초기화 시코 todoItems에 있는 데이터도 비워버림
* 로컬스토리지와 화면상에 뿌려지는 데이터랑 같게 하기 위해

```html
<!-- TodoFooter -->
<template>
  <div class="clearAllContainer">
    <span class="clearAllBtn" v-on:click="clearTodo">Clear All</span>
  </div>
</template>

<script>
export default {
  methods: {
    clearTodo: function() {
      this.$emit("clearAll");
    }
  }
}
</script>

<style scoped>
.clearAllContainer {
  width: 8.5rem;
  height: 50px;
  line-height: 50px;
  background-color: white;
  border-radius: 5px;
  margin: 0 auto;
}
.clearAllBtn {
  color: #e20303;
  display: block;
  cursor: pointer;
}
</style>
```
1. clearTodo: function() { this.$emit("clearAll"); }
* clearTodo메소드가 실행됨녀 App에게 clearAll이라는 이름으로 이벤트 전달

## 8. 사용자 경험 개선
### (1) 모달 컴포넌트 등록
* components/common/Modal.vue 만들기
* 하나의 Modal을 여러 컴포넌트에서 사용하기 위해 common폴더에 따로 배치함
```html
<!-- components/common/Modal.vue -->
<template>
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <slot name="header">
              default header
            </slot>
          </div>

          <div class="modal-body">
            <slot name="body">
              default body
            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              default footer
              <button class="modal-default-button" @click="$emit('close')">
                OK
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
export default {

}
</script>

<style>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 300px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  font-family: Helvetica, Arial, sans-serif;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
}

.modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>
```
* 해당 코드는 vue공식페이지에서 제공하는 코드

```html
<!-- TodoInput -->
<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
    <span class="addContainer" v-on:click="addTodo">
      <i class="addBtn fas fa-plus" aria-hidden="true"></i>
    </span>
    <!-- modal의 html 코드 등록 -->
    <Modal v-if="showModal" @close="showModal = false">
        <!--
      you can use custom content here to overwrite
      default content
    -->
      <h3 slot="header">custom header</h3>
    </Modal>
  </div>
</template>

<script>
import Modal from "./common/Modal.vue";

export default {
  data: function() {
    return {
      newTodoItem: '',
      showModal: false,
    }
  },
  methods: {
    addTodo: function() {
      if (this.newTodoItem !== '') {
        this.$emit("addTodoItem", this.newTodoItem);
        this.clearInput();
      }else{

      }
    },
    clearInput: function() {
      this.newTodoItem = '';
    }
  },
  components: {
    Modal: Modal
  }
}
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>
```
1. components: { Modal: Modal }
* App.vue 밑에는 4개의 Footer, List, input, Lsit컴포넌트가 있음, 근데 components코드로 인해서 input하위에 하나의 컴포넌트가 생김
* 즉, TodoInput컴포넌트 아래에 Modal이라는 컴포넌트가 생김, Modal입장에서는 상위가 TodoInput이고 TodoInput에 입장에서 상위는 App임

2. import Modal from "./common/Modal.vue";
* 임포트 해서 modal컴포넌트 들고옴

### (2) Modal컴포넌트 내용을 TodoInput컴포넌트에서 가공
```html
<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
    <span class="addContainer" v-on:click="addTodo">
      <i class="addBtn fas fa-plus" aria-hidden="true"></i>
    </span>
    <Modal v-if="showModal" @close="showModal = false">
      <h3 slot="header">마!</h3>
      <h4 slot="body">내용 입력 해라이!</h4>
    </Modal>
  </div>
</template>

<script>
import Modal from "./common/Modal.vue";

export default {
  data: function() {
    return {
      newTodoItem: '',
      showModal: false,
    }
  },
  methods: {
    addTodo: function() {
      if (this.newTodoItem !== '') {
        this.$emit("addTodoItem", this.newTodoItem);
        this.clearInput();
      }else{
        this.showModal = !this.showModal;
      }
    },
    clearInput: function() {
      this.newTodoItem = '';
    }
  },
  components: {
    Modal: Modal
  }
}
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>
```
1. Modal v-if="showModal" 
* 만약, showModal이 true면 Modal이 나타나고 false이면 화면에서 사라짐

2. h3 slot="header"(slot기능)
* slot기능 특정 일부분을 재사용 하게 할 수 있는 기능을 가지고 있음
* modal컴포넌트에 가보면 slot태그가 있음
* slot태그부분은 todoInput컴포넌트에서 다시 정의 할 수 있음
* 즉, 기본적으로 Modal에 정의된 부분을 TodoInput컴포넌트에서 재정의 함 

3. showModal: false
* 기본값으로 false하기, 그래야 화면에 안보임

4. this.showModal = !this.showModal
* 사용자가 아무것도 입력안하면 모달창 띄움
* 즉, true로 바꿈

## 9. 트랜지션
* 애니매이션 효과 주는 것
```html
<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
    <span class="addContainer" v-on:click="addTodo">
      <i class="addBtn fas fa-plus" aria-hidden="true"></i>
    </span>
    <Modal v-if="showModal" @close="showModal = false">
      <h3 slot="header">
        마!
        <i class="closeModalBtn fas fa-plus addBtn" @click="showModal=false"></i>
      </h3>
      <h4 slot="body"> 내용 입력 해라이! </h4>
    </Modal>
  </div>
</template>

<script>
import Modal from "./common/Modal.vue";

export default {
  data: function() {
    return {
      newTodoItem: '',
      showModal: false,
    }
  },
  methods: {
    addTodo: function() {
      if (this.newTodoItem !== '') {
        this.$emit("addTodoItem", this.newTodoItem);
        this.clearInput();
      }else{
        this.showModal = !this.showModal;
      }
    },
    clearInput: function() {
      this.newTodoItem = '';
    }
  },
  components: {
    Modal: Modal
  }
}
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
.closeModalBtn{
  color:#6478FB;
}
</style>
```

## 10.
## 11.
## 12.
