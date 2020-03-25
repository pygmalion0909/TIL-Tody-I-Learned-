# event emit
## 1. 개념
* component는 각각 자기 데이터는 자기가 관리
* 상위 component랑 하위 component랑 교류 하기 위해서는 props, event로 교환 함
* 상위에서 하위로는 데이터를 내려줌(props)
* 하위에서 상위로는 데이터를 올려줌(event)
* component 는 항상 자기의 상위, 하위로만 전달
* props를 통해 상위에서 자기 하위로만 전달
* Event로 하위가 자기 상위한테로 전달

## 2. 예제
### (1) 기본 사용
```html
  <div id="app">
    <app-header></app-header>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script>
    const appHeader = {
      template: "<button v-on:click='passEvent'>click me</button>",
      methods: {
        passEvent(){
          this.$emit('pass');
        },
      },
    }
    
    new Vue({
      el: "#app",
      components: {
        "app-header": appHeader,
      }
    })
  </script>
```
1. button v-on:click='passEvent' click me /button
* v-on으로 click이벤트를 설정함
* 이벤트는 passEvent임
* passEvent는 아래 methods에 정의 되어 있음

2. methods: { passEvent(){ this.$emit('pass'); } }
* $emit로 pass라는 이벤트를 상위에 전달
* vue개발자 도구에 가면 events탭에 가서 확인 가능
* 버튼을 클릭 할때마다 상위에 전달

### (2) 응용
```html
  <div id="app">
    <app-header v-on:pass="logText"></app-header>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script>
    
    const appHeader = {
      template: "<button v-on:click='passEvent'>click me</button>",
      methods: {
        passEvent(){
          this.$emit('pass');
        },
      },
    }
    
    new Vue({
      el: "#app",
      components: {
        "app-header": appHeader,
      },
      methods:{
        logText(){
          console.log("hi!");
        }
      },
    })
  </script>
```
1. button v-on:click='passEvent' click me /button
* v-on으로 click이벤트를 설정함
* 이벤트는 passEvent임
* passEvent는 아래 methods에 정의 되어 있음

2. methods: { passEvent(){ this.$emit('pass'); } }
* $emit로 pass라는 이벤트를 상위에 전달
* vue개발자 도구에 가면 events탭에 가서 확인 가능
* 버튼을 클릭 할때마다 상위에 전달

3. v-on:pass="logText"
* v-on:하위 컴포넌트에서 발생한 이벤트 이름="상위 컴포넌트의 메서드 이름"
* root에서 정의한 logText의 메소드를 실행
* 즉 하위에서 이벤트를 발생시켜 root로 전달 되면 root에 있는 logText가 실행 됨

4.  methods:{ logText(){ console.log("hi!") } }
* 이벤트가 하위 컴포넌트에서 올라오면 root에서 실행될 메소드 정의 부분

``` html
  <div id="app">
    <app-content v-on:upnum="numbering"></app-content>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script>

    const appContent = {
      template: "<button v-on:click='addNum'>come on! </button>",
      methods:{
        addNum(){
          this.$emit("upnum");
        },
      },
    }
    
    new Vue({
      el: "#app",
      components: {
        "app-content": appContent,
      },
      methods:{
        numbering(){
          this.num = this.num + 1;
          console.log(this.num);
        }
      },
      data: {
        num: 10
      }
    })

  </script>
```
1. button v-on:click='addNum' come on! /button
* 버튼을 클릭 했을 때 v-on으로 click이벤트를 발생 시키면 addNum의 메소드가 실행

2.  methods:{ addNum(){ this.$emit("upnum") } }
* addNum의 정의 부분
* root로 이벤트 전달
* 이때 전달하는 이벤트의 이름은 upnum
* root는 upnum이 전달 됬을 때 동작 함

3. app-content v-on:upnum="numbering"
* root가 upnum을 전달 받으면 numbering메소드를 실행
* numbering는 root의 메소드
* 즉, 하위에서 신호를 전달하면 root는 자기가 가지고 있는 메소드를 실행
* 이때 메소드는 원하는거 선택가능
* 여기서는 numbering메소드를 실행

4. methods:{ numbering(){ this.num = this.num + 1; console.log(this.num); } }
* numbering메소드의 정의부분
* this.num은 root인스턴스의 num을 가리킴
* 메소드가 실행 될 때 마다 인스턴스의 num을 1씩 증가

