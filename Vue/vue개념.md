# vuejs 개념
## 1. 구조
* Dom -> DOM Listeners -> Model(Js)
* Model(Js) -> Data Bindings -> Dom

## 2. 구조 예제
```html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>@@@@@@@@@@@</title>
</head>
<body>

  <div id="app"></div>
  
  <script>
    const div = document.querySelector("#app");
    console.log(div);
    div.innerHTML = "hello vue";

    // 만약 hello vue를 hello world로 바뀐다면
    div.innerHTML = "hello world";
  </script>
  
</body>
</html>
```
* 위는 vue를 사용하지 않고 일반적인 웹 개발 코드 방식
* 위와 같이 스크립트에 코드를 작성한다면 서버에서 받아온 데이터를 하나하나 작성해야함
* 데이터가 바뀔 때 마다 수정 해야함

```html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>way!</title>
</head>
<body>
  
  <div id="app"></div>
  
  <script>
    const div = document.querySelector("#app");
    const viewModel ={};

    Object.defineProperty(viewModel, 'str', {
      // 속성에 접근 했을 때 동작을 정의
      get(){
        console.log("접근");
      },
      // 속성에 값을 할당했을 때 동작의 정의
      set(newValue){
        console.log("할당", newValue);
        div.innerHTML = newValue;
      },
    });
  </script>

</body>
</html>
```
* Object.defineProperty("대상객체", "객체속성", {정의내용}); 객체의 동작을 재정의 하는 api
* set(newValue)으로 str속성을 바꿔 할당 함 
* str의 속성이 바뀌면서 div.innerHTML = newValue코드로 인해 화면에 바뀐 데이터가 뿌려짐
* 위와 같이 바로바로 데이터가 바뀌는 것이 vue의 핵심
* 이런 코드가 위에서 설명한 data Bindings 임

```html
<div id="app"></div>

<script>

  const div = document.querySelector("#app");
  const viewModel ={};
  
  (function(){

    function init(){
      Object.defineProperty(viewModel, 'str', {
        get(){
          console.log("접근");
        },
        set(newValue){
          console.log("할당", newValue);
          render(newValue);
        },
      });
    }
    
    function render(value){
      div.innerHTML = value;
    };

    init();

  })();

</script>
```
* 코드 리팩토링 함 