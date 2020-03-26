# computed와 watch
## 1. computed
* 특정 데이터를 바라보고 있다가 그 데이터가 변화가 일어나면 지정한 메소드가 실행되는 것 
* watch랑 비슷한 성격을 가짐
* computed는 data속성처럼 v-bind에 직접 넣을 수 있음

```html
  <h1 id="app">
    <p>{{num}}</p>
    <p>{{doubleNum}}</p>
  </h1>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

  <script>
    new Vue({
      el: "#app",
      data: {
        num: 10,
      },
      computed: {
        doubleNum(){
          return this.num * 2;
        },
      },
    })
  </script>
```

## 2. watch
* 어떤 데이터를 지정해서 그 데이터가 변화가 일어나면 탐지해서 지정한 로직을 실행하는 속성

```html
  <h1 id="app">
    <p>{{num}}</p>
    <button v-on:click="addNum">마! 클릭해봐라 올라간다!</button>
  </h1>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  
  <script>
    new Vue({
      el: "#app",
      data: {
        num:10,
      },
      watch: {
        num(){
          this.logText();
        }
      },
      methods: {
        addNum(){
          this.num = this.num + 2;
        },
        logText(){
          console.log("change!")
        }
      },
    })
  </script>
```
1. watch: { num(){ this.logText() } },
* vue인스턴스에 num의 변화가 생기면 vue인스턴스에 있는 logText메소드를 실행
* 데이터 변화에 따라 특정 로직을 실행 할 수 있게 함
* num의 데이터가 바뀔 때 마다 vue인스턴스에 있는 logText가 실행
* watch에서 정의하는 메소드 이름은 data에 만든 이름이랑 같아야 작동
* 즉, watch하고 싶은 데이터의 이름이랑 같아야함

```html
  <h1 id="app">
    <p>{{num}}</p>
    <button v-on:click="addNum">마! 클릭해봐라 올라간다!</button>
  </h1>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  
  <script>
    new Vue({
      el: "#app",
      data: {
        num:10,
      },
      watch: {
        num(newValue, oldValue){
          console.log("새로운값",newValue, "이전 값",oldValue)
          this.logText();
        }
      },
      methods: {
        addNum(){
          this.num = this.num + 2;
          console.log(this.num);
        },
        logText(){
          console.log("change!")
        }
      },
    })
  </script>
```
1. num(newValue, oldValue)
*  wath는 지정한 데이터의 변화를 감지하고 있기 때문에 메소드의 인자로 newValue, oldValue를 사용가능
* newValue는 변화가 이뤄진 새로운 값, oldValue는 변화가 이루어지기 직전의 값

## 3. computed, watch의 차이점
* computed 간단한 연산 쪽에 사용하면 좋을 것 같음\
* watch의 매번 실행되기 무거운 로직을 짤 때, 가령 데이터 요청같은

## 4. 