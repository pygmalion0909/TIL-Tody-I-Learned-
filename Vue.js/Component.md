# Component
## 1. 개념
* 기본 HTML 엘리먼트를 확장하여 재사용 가능한 코드를 캡슐화

## 2. 예제
### (1) 전역등록
```html
 <div id="test1">
    <testing></testing> <!-- hello! world!!!! 출력-->
    <testing></testing> <!-- hello! world!!!! 출력-->
    <testing></testing> <!-- hello! world!!!! 출력-->
    <testing></testing> <!-- hello! world!!!! 출력-->
  </div>
```
```javascript
// Vue.component(tagName, options)
Vue.component('testing', {
  template: "<h1>hello! world!!!!</h1>"
})

new Vue({
  el: '#test1'
})
```
1. new Vue
* el속성이랑 html의 id랑 연결, 즉 이름이 같아야함 
* new Vue가 component보다 먼저 선언되면 component가 실행 안됨

2. template
* template을 밖으로 빼서 사용하는 듯
* component에 들어갈 html태그