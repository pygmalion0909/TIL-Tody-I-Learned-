# Component
## 1. 개념
* 기본 HTML 엘리먼트를 확장하여 재사용 가능한 코드를 캡슐화

## 2. 예제
### (1) 전역등록
```html
<div id="example">
  <my-component></my-component>
</div>
```
```javascript
// Vue.component(tagName, options)
Vue.component('my-component', {
  template: <h1>frist Vue Page!</h1>
})

new Vue({
  el: '#example',
  // 옵션
})
```
1. new Vue
* new Vue가 component보다 먼저 선언되면 component가 실행 안됨

2. template
* template을 밖으로 빼서 사용하는 듯