# Component
## 1. 개념
* 기본 HTML 엘리먼트를 확장하여 재사용 가능한 코드를 캡슐화
* html을 모듈로 쪼개서 트리로 만드는 것
* 이렇게 쪼갠 모듈 하나하나를 component라고 함
* 크게 html, css, js으로 구분 함
* 컴포넌트는 화면을 구분 지어서 개발
* 재사용성이 컴포넌트의 핵심

## 2. component 등록
### (1) 전역 component 등록
```html
  <div id="app">
    <app-header></app-header>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

  <script>
    Vue.component("app-header", {
      template: "<h1>Header</h1>" 
    })

    new Vue({
      el: "#app",
    })

  </script>
```
1. component 등록
* Vue.component("컴포넌트 이름", {컴포넌트 내용})으로 등록

2. <app-header></app-header>
* 컴포넌트 이름이 html에서는 태그로 작성
* component의 template속성이 html태그에 적용

3. template: "h1 Header /h1"
* component이름이 있는 html태그에 적용

### (2) 지역 component 등록
```html
  <div id="app">
    <app-footer></app-footer>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  
  <script>

    new Vue({
      el: "#app",
      components: {
        "app-footer" : {
          template : "<h2>hello superpil!</h2>"
        } 
      },
    })
    
  </script>
```
1. new Vue({ components: "컴포넌트 이름" : {컴포넌트 내용} })
* 지역 컴포넌트란 Vue인스턴스 내부에서 component를 설정하는 것
* 지역에서는 components이며 s를 빼먹으면 안됨(전역은 component)

2. components: {"app-footer" : {template : " h2 hello superpil! /h2"} },
* 전역 컴포넌트와 같은 형식
* app-footer를 html파일에 가서 코드로 작성하면 template의 내용이 먹힘

## 3. instance 와 component의 관계
```html
  <div id="app">
    <app-header></app-header>
    <app-footer></app-footer>
  </div>

  <div id="app2">
    <!-- 전역 compoent로 만들었기 때문에 app, app2에서도 사용 가능 -->
    <app-header></app-header>
    <!-- #app의 지역 component로 만들었기 때문에 app에서만 compoent를 사용 가능하며 app2에서는 사용 불가 -->
    <app-footer></app-footer> 
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  
  <script>
    Vue.component("app-header", {
      template: "<h1>Header</h1>",
    })

    new Vue({
      el: "#app",
      components: {
        "app-footer" : {
          template : "<h2>hello superpil!</h2>"
        } 
      },
    })

    new Vue({
      el: "#app2",
    })
```
* 인스턴스 생성하면 vue개발자 도구에서 root가 생성 됨
* 만약 인스턴스를 2개 만들면 root가 2개 생성됨 
* 즉, 인스턴스를 사용하면 root가 생성 되며 전역으로 component를 만들면 서로 다른 root에서도 사용가능 하지만 지역으로 component를 만들면 서로 다른 root에서 사용 불가하고 component를 만든 root에서 사용가능
