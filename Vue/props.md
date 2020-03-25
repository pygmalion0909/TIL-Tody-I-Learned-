# props
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
  <app-header v-bind:propsdata="message"></app-header>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<script>
  const appHeader = {
    template: "<h1>{{propsdata}}</h1>",
    props:['propsdata']
  }

  new Vue({
    el: "#app",
    components: {
      "app-header" : appHeader,
    },
    data: {
      message: "hi"
    }
  })

</script>
```
1. data: { message: "hi" }
* root에 있는 값(new Vue의 인스터스가 root), 이 데이터를 component(app-header component)로 전달 하기 위해 사용하는 것이 props

2. props:['propsdata']
* root의 하위 component에게 데이터를 전달하기 위해 props속성을 선언
* root의 데이터는 propsdata변수에 담아서 사용 하겠음
* 이때 root의 모든 데이터가 propsdata에 할당
* props이름을 카멜기호를 사용하니 안먹힘?!

3. v-bind:propsdata="message"
* v-bind:props속성이름 = "상위컴포넌트의 데이터 이름" 구성
* root의 data에 있는 message값을 bind함

4. template: "h1 {{propsdata}} /h1"
* {{}}를 사용하여 템플릿에 적용

### (2) 응용
```html
  <div id="app">
    <app-header v-bind:propsdata="message"></app-header>
    <app-content v-bind:propsdata="num"></app-content>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

  <script>
    const appHeader = {
      template: "<h1>{{propsdata}}</h1>",
      props:['propsdata']
    }

    const appConente = {
      template: "<h3>{{propsdata}}</h3>",
      props:['propsdata']
    }

    new Vue({
      el: "#app",
      components: {
        "app-header" : appHeader,
        "app-content" : appConente,
      },
      data: {
        message: "hi",
        num: 100,
      },
    })

  </script>
```
1. data: { message: "hi", num: 100,}
* 이번에는 데이터가 2개
* 똑같이 하위 component에 넘겨줄 데이터 정의

2. props:['propsdata']
* props로 내려주겠다고 선언
* root의 데이터를 'propsdata'에 담아

3. app-header v-bind:propsdata="num"
* v-bind:props속성이름 = "상위컴포넌트의 데이터 중 사용할 이름" 구성
* root의 데이터중 사용할 데이터의 이름을 작성

4. template: "h3 {{propsdata}} /h3"
* {{}}를 사용하여 root의 데이터를 템플릿에 적용