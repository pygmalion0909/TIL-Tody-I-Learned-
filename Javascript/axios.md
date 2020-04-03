# axios
## 1. 개념
## 2. 설치
### (1) CDN
```html
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
```
### (2) npm설치 및 불러오기
```
npm install axios
```
```js
// vuejs에서 불러오기
import axios from 'axios'
```
```js
// nodejs에서 불러오기
const axios = require('axios');
```

## 3. 사용예제
### (1) get방식
1. 기본문법
```js
axios.get("요청url")
.then( (res) => {
  // res에 요청한 데이터가 담김
})
.catch( (err) => {
  // 요청에 대한 에러가 발생할 경우 err에서 알 수 있음
})

axios.get("https://reqres.in/api/users=2")
.then( (res) => {
  console.log(res) // 데이터가 콘솔에 찍힘
})
.catch( (err) => {
  console.log(err) // 에러 발생시 에러 출력
})

```

### (2) post방식
```js
axios.post('/user', {
    firstName: 'Fred',
    lastName: 'Flintstone'
  })
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
```

### (3) 옵션
1. url: '/user'
* axios로 요청 할 url

2. method: 'get'
* 요청할 방식

3. transformRequest
```js
transformRequest: [function (data, headers) {
  // Do whatever you want to transform the data
  return data;
}],
```

4. transformResponse
```js
 transformResponse: [function (data) {
    // Do whatever you want to transform the data

    return data;
  }],
```

5. headers
```js
headers: {'X-Requested-With': 'XMLHttpRequest'},
```
* 요청할때 header에 담아서 보냄

6. params
```js
params: {
  ID: 12345
},
```
* 요청할 때 URL의 파라미터 값을 함께 보냄
* params는 반드시 일반객체 또는 URLSearchRarams객체여야 함

7. data
```js
data: {
  firstName: 'Fred'
},
```
* `data` is the data to be sent as the request body
* Only applicable for request methods 'PUT', 'POST', and 'PATCH'

8. timeout
```js
timeout: 1000,
```
* 요청시간을 정해놓고 정해진 시간보다 길어질 경우 요청 실패로 됨

<strong>더 많은 옵션을 볼려면 aixos공식문서를 참조하기</strong>

## 3. async & await와 함께 사용
```js
const getDate = () => {
  return axios.get("https://reqres.in/api/users=2");
}

const testConsole = async() => {
  const getting = await getDate();
  console.log(getting); // 요청한 데이터 전부 출력
  console.log(getting.headers) // 데이터에 있는 headers의 값을 출력
  console.log("getDate에 응답이 오면 현재 콘솔이 출력");
}
testConsole();
```


## 4. axios method
1. axios.request(config)
2. axios.get(url[, config])
3. axios.delete(url[, config])
4. axios.head(url[, config])
5. axios.options(url[, config])
6. axios.post(url[, data[, config]])
7. axios.put(url[, data[, config]])
8. axios.patch(url[, data[, config]])