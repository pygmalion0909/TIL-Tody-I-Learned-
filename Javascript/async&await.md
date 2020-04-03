# async & await
## 1. 개념
* 비동기 처리를 동기 처리로 하기 위한 것
* 비동기 처리 메소드는 꼭 프로미스 객체를 반환해야 await가 의도대로 작동함
* 프로미스 객체를 반환하는게 Axios등 있음
* 단순하게 생각하면 async & await는 비동기적으로 실행되어 넘어오는 데이터를 받아 동기적으로 실행하기 위해 사용
* 비동기적으로 요청하고 받아내는 역할은 axios나 ajax 같은 친구들이 함
* 비동기적으로 요청해서 언제 돌아올지 모르는 데이터를 가공해서 순차적으로 처리하고 싶은 경우 사용
* async는 단순 선언, 즉 await를 사용하겠다는 선언
* await는 해당 데이터가 응답이 올 때 까지 기다렸다가 응답오면 다음 로직이 처리되게함, 데이터가 넘어 올때 까지 파싱을 일시정시 함
* await는 async함수 내부에서만 사용 가능

## 2. axios로 비동기적 처리
* 아래 코드는 예시, url정보와 데이터가 예시라서 작동 안됨
```js
axios.get("https://reqres.in/api/users=2", {
  params:{
    Id: 1234,
    pss: fe,
  }
})
.then( (res) => {
  console.log(res);
})
.catch( (err) => {
  console.log(err);
})

console.log("first");
```
* axios의 get방식
1. axios.get("요청url주소", {"요청할 때 담아서 보낼 정보"})
* 요청 방식중에 get방식으로 요청
* 첫번째 인자는 url주소, 두번째 인자는 요청할 때 필요한 정보를 넘기는 객체
* 요청시 담아서 보낼 정보는 해당 url에서 원하는 정보를 담아서 보내야함
* api를 제공해주는 사이트에서 어떤 정보를 원하는지 알려 줌

2. .then( (res) => {})
* 요청결과를 받는 곳
* then으로 받아서 res에 담김
* 함수 내부에서 res를 콘솔에 찍어보면 받아온 데이터가 담겨 있다는 것을 확인 할 수 있음

3. catch( (err) => {})
* 요청 후 에러 발생할 경우 catch에서 받음

4. console.log("first")
* 비동기적으로 받아지는지 확인 하기위한 test용
* axios가 비동기적으로 받아지니깐 console.log()가 처음에 출력 됨

```js
axios.post('https://reqres.in/api/users=2', {
    id: 'df',
    pass: 'qw'
  })
  .then(function (res) {
    console.log(res);
  })
  .catch(function (err) {
    console.log(err;
  });
```
* axios의 post방식
