# export
> javascript 모듈에서 함수, 객체, 원시 값을 내보낼 떄 사용한다. 내보낸 값은 다른 프로그램에서 import문으로 가져가 쓸 수 있다. export문은 HTML 내장 스크릅트에서 사용할 수 없다. -mozilla-

쉽게 말해 A.js파일에서 만든 함수, 객체 등등을 B.js파일에서도 사용할 수 있게 내보내는 기능인 것 같다.


# 구문
```js
export { name1, name2, …, nameN };
export { variable1 as name1, variable2 as name2, …, nameN };
export let name1, name2, …, nameN; // var, const에서 동일
export let name1 = …, name2 = …, …, nameN; // var, const에서 동일
export function FunctionName(){...}
export class ClassName {...}

export default expression;
export default function (…) { … } // class, function* 에서 동일
export default function name1(…) { … } // class, function* 에서 동일
export { name1 as default, … };

export * from …;
export { name1, name2, …, nameN } from …;
export { import1 as name1, import2 as name2, …, nameN } from …;
export { default } from …;
```
mozilla에 나오는 export 사용 방법이다. 

# 사용방법
>내보내기에는 두 종류, **named**과 **default** 내보내기가 있다. 모듈 하나에서 **named** 내보내기는 여러 개 존재할 수 있지만, **default** 내보내기는 하나만 가능합니다. 각 종류는 위의 구문 중 하나와 대응합니다. -mozilla-

우선, export를 사용하기 전 에 HTML파일에서 script태그 작성방법을 보자.
```html
<script src="app.js" type="module"></script>
```
반드시 type="module"를 작성해야 한다. 작성하지 않으면 **신텍스 에러가 뜬다.**

---

**named 방법**

**app.js 내보내기**
```js

let inAdd = (x, y) => {
    return x + y
} 

export function outSubtraction(x, y){
    return x - y;
}

let outMultiplication = (x, y) => {
    return x * y;
}

export { outMultiplication }
```
"inAdd"는 export로 내보내지 않았다. "outSubtraction"와 "outMultiplication"는 내보내기를 했다. "outSubtraction"는 함수가 선언되자 마자 내보내기를 했고 "outMultiplication"은 선언 후 "export{}"에 따로 해서 내보내기를 했다. 이제 test.js에서 받아보자.

**test.js 받기**
```js
import {  outSubtraction, outMultiplication } from  '/app.js'

console.log(outSubtraction(2, 2)); // 0 출력

console.log(outMultiplication(1, 2)); // 2 출력

console.log(inAdd(3, 3)) // InAdd is not defined    error

```
app.js에 선언한 함수를 test.js에서 사용 할려면 먼저 test.js에서 불러와야하는데 이때 사용하는 문법이 **import**와 **from** 이다.
import를 작성하고 "{}" 내부에 app.js에서 내보낸 함수 들을 작성하면 된다. 그리고 from 뒤에는 **불러오는 파일의 경로를 작성**하면 된다.
"outSubtraction"와 "outMultiplication"는 app.js에서 export를 했기 때문에 test.js에서 사용 할 수 있다. 하지만 "inAdd"은 app.js에서 export를 하지 않아 not defined error가 발생한다.

---

**default 방법**

default은 하나의 모듈에서 하나의 객체만 내보낸다. 이름이 필요없기 때문에 별도로 변수 할당 없이 바로 객체를 내보내기를 할 수 있다. 내보낼 때 어떤 이름도 지정하기 않기 때문에 불러올 때도 아무 이름이나 사용할 수 있다.

**app.js 내보내기**
```js
let InAdd = (x, y) => {
  return x + y
} 

export function OutSubtraction(x, y){
  return x - y;
}

let OutMultiplication = (x, y) => {
  return x * y;
}

export default{
  OutSubtraction(x, y) {
    return x - y;
  },
  
  OutMultiplication: function(x, y){
    return x * y;
  },
}
```
"export default{}"에 내보내고 싶은 함수들을 넣어서 한번에 내보낸다. 즉, 하나의 객체를 만들어 한번에 내보낸다.

**test.js 받기**
```js
import itsUpToYou from './app.js';

console.log(itsUpToYou.outSubtraction(2, 2)); // 0 출력

console.log(itsUpToYou.outMultiplication(1, 2)); // 2 출력

console.log(itsUpToYou.inAdd(3, 3)) // InAdd is not defined error
```
default방법으로 받을 때 import와 from구문은 같다. 다만 import 뒤에 식별자?는 임의적으로 정할 수 있다.
이후 from 뒤에 받아올려는 파일의 경로를 작성하면된다.
불러온 함수들을 사용할 때 는 객체를 사용할 때 처럼 **import뒤에 작성한 식별자.app.js에서 불러온 함수명** 으로 사용하면된다. 즉, import뒤에 작성한 식별자는 객체의 식별자라고 생각하면 되고 app.js에서 불러온 함수들은 객체 내부에 있는 메서드라고 생각 하면 될 것 같다. 

