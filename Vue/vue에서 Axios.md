# Axios
## 1. 개념 및 라이브러리 사용 시 확인 사항
* 서버와 비동기적 처리를 하기 위해 사용 하는 오픈소스
* https://github.com/axios/axios Axios github 주소
* 오픈 소스를 사용할 때는 Star개수가 많은지 확인 필요
* 그리고 commits, contributors가 많은지 확인 필요
* 라이브러리가 언제 수정되었는지를 확인, 수정이 최근에 이루어졌으면 지금 당장 라이브러리에 문제가 생겨도 누군가 고칠 수 있다고 판단

## 2. Vue에서 Axios사용 예제(CDN으로 설치)
```html
  <div id="app">
    <button v-on:click="getData">get user</button>
    <div>
      {{ users }}
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

  <script>
    new Vue({
      el: '#app',
      data: {
        users: []
      },
      methods: {
        getData: function() { 
          axios.get('https://jsonplaceholder.typicode.com/users/')
            .then((response)=> {
              this.users = response.data;
              console.log(response.data);
              console.log(this);
              })
            .catch(function(error) {
              console.log(error);
            });
        }
      }
    })
  </script>
```
1. v-on:click="getData"
* button을 클릭 했을 때 getData메소드가 실행 됨
* getData메소드는 Vue인스턴스에 정의 되어 있음

2. methods: { getData: function(){ ... }}
* 위 버튼을 클릭하면 Vue인스턴스에 있는 methods속성에 정의 되어 있는 getData메소드가 실행

3. axios.get('https://jsonplaceholder.typicode.com/users/')
* get방식으로 해당 RestApi로 요청함

4. .then((response)=> { this.users = response.data; console.log(this); })
* api한테서 받아온 데이터는 비동기로 받아옴
* 받아온 데이터는 then으로 넘어오고 response에 담김
* this.users는 Vue인스턴스에 내부에 있는 data속성에 users를 뜻함
* 지금은 es6문법인 에로우 펑션을 사용 했기 때문에 this가 Vue인스턴스를 바라보고 있어 Vue인스턴스의 users를 바라봄
* 하지만 일반적인 선언식, 표현식 함수를 사용할 경우 this는 전역객체를 바라봄
* axios내부의 this와 외부의 this가 가리키는 것은 다름
* axios외부에서 this는 Vue를 가리키지만 axios 내부에서 this는 전역객체를 바라봄
* 즉, 메소드로써 this는 자기가 소속된 객체를 바라보지만 함수 및 콜백함수에서 this는 어디에 소속 되어 있든 전역객체를 바라 봄

5. .catch(function(error) { console.log(error); });
* 만약 Restapi 요청에 실패할 경우 catch문에 들어와서 에러를 콘솔에 찍힘

## 3. VueCLI에서 Axios사용(npm으로 설치)
### (1) npm으로 Axios설치
```
npm i axios
```
* 터미널에서 위 명령어 사용하여 다운

### (2) 예제
```js
import axios from 'axios';
```
* script태그 내부에서 import해서 axios를 불러와서 사용