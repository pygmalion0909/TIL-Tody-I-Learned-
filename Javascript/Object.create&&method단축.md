# Object.create()
```js
let nationObj = {
  nation : 'CANADA',
  city : 'Quebec',
  number : '1-418',
  where(){
    return `${this.nation}-${this.city} : code number(${this.number})`;
  }
}
```
```js
console.log(nationObj.where()); // CANADA-Quebec : code number(1-418) 출력
``` 

nationObj 상속 받아서 새로운 객체를 만들려면 Object.create()를 사용한다.
```js
let addNationObj = Object.create(nationObj);
```
nationObj속성을 물려받은 addNationObj객체 탄생!

그런데 addNationObj 를 콘솔에 찍어보면?
```js
console.log(addNationObj); // {} 출력
```
콘솔창에 addNationObj에 있는 화살표를 눌려보면 __proto__: Object 나온다.
__proto__에 있는 화살표를 눌려보면
nation: "CANADA"
city: "Quebec"
number: "1-418"
where: ƒ where() 나온다.
addNationObj는 nationObj를 상속(복사)받아서 기본적으로 nationObj에 있는 프로퍼티를 가지고 있는 거 같다.
확인해보자. 콘솔에 addNationObj.nation을 찍으면 뭐가 나올까?
```js
console.log(addNationObj.nation); // CANADA 출력
```
단순히 console.log(addNationObj)을 하면 "{}" 나오지만 기본적으로 nationObj를 상속(내가 이해하기 쉽게는 복사) 받아서 addNationObj에서도 nation등
을 사용할 수 있는 거 같다.

그럼 addNationObj.city 와 number을 다른 값으로 바꿔버리면?
이렇게 말이다.
```js
addNationObj.city = 'Vancouver'
addNationObj.number = '1-604'
console.log(addNationObj.where()); // CANADA-Vancouver : code number(1-604) 출력
```
그럼 nationObj의 city와 number은 바꼈을까??
```js
console.log(nationObj.where()); // CANADA-Quebec : code number(1-418) 출력
```
바뀌지 않았다.

addNationObj는 nationObj의 객체를 상속(내가 이해하기 쉽게는 복사)을 받아 새로운 객체를 가진다. 자식(addNationObj)객체는 부모(nationObj) 프로퍼티를
사용 할 수 있고 또한 기존 프로퍼티 값을 바꿀 수 있다. 하지만 부모(nationObj)에 영향을 주지 않는다.

# method 단축

일반 method
```js 
let exObjShort = {
  a : 1,
  b : 2,
  sum : function(){
    return this.a + this.b
  }

console.log(exObjShort.sum()); // 3 출력
```

단축 method
```js
let exObjShort = {
  a : 1,
  b : 2,
  sum(){
    return this.a + this.b
  }

console.log(exObjShort.sum()); // 3 출력
```