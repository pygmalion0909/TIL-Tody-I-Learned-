# prototype chapter_1

우선 prototype에 관련된 용어 부터 알자.

1. constructor
2. prototype
3. instance
4. \_\_proto\_\_

간단하다. 위 4가지의 역할만 알면 된다.

1. constructor

먼저 constructor의 생김새를 보자.
```js
var Person = function(name){
  this.nickName = name
}
```
Person이 constructor 또는 생성자 함수라고 한다.
생성자 함수의 첫글자는 대문자로 표시해야한다.(관습이라고 어디선가 봤다.)

그래서 constructor는 뭐냐?! 표현식 함수 생김새를 하고 있지만 constructor는 객체를 만드는 것 이다. 뭔 개똥같은 소리냐? 라고 할 수 있다. 이쯤해서 넘어가자. 머리 아프다..

2. instance
```js
var superPil = new Person('superPil');
```
위 "var superPil"이 instance가 된다.
var superPil에 생성자 함수 Person이 할당 되었다.
즉, constructior(생성자함수)에서 정의된 내용을 바탕으로 새로운 instance(var superPil)가 생성 된다.

콘솔에 superPil을 한번 찍어 보자.
```js
var Person = function(name){
  this.nickName = name
}

let superPil = new Person('superPil');

console.log(superPil); // Person {nickName: "superPil"} 출력
```
콘솔을 찍어보니 {}내부에 nickName: "superPil"가 있다.
{}를 보니 superPil은 객체고 nickName: "superPil"는 객체의 프로퍼티 이다. 그렇다. 생성자함수(Person)는 객체를 만드는 역할을 한다. 객체를 superPil에 할당하니 당연 superPil도 객체가 될 것 이다. 

3. prototype

이제 복잡해진다. 마음 단단히 먹자. 정신 단디 차려야 한다. 
시작해보자! 우선 아래는 Person의 prototype의 코드 다.
```js
Person.prototype.whoAreU = function(){
  return this.nickName;
}
```
코드는 봤고 중요한건 대체 prototype이 뭐냐 이다.?! 생성자함수(constructor)인 Person을 생성하면 내가 따로 만들지 않아도 Person의 prototype이 자동생성된다. **이때 prototype은 객체 로 생성 된다!** 확인 해보기 위해 콘솔에 아래 코드를 찍어보자.
```js
console.log(Person.prototype); // {constructor: ƒ} 출력
```  
"{constructor: ƒ}"가 출력된다. {} 내부에 있는 constructor: f는 무시하자. 알고싶어도 참아라. 복잡다.
여튼 {}로 출력 되는거 보니 Person.prototype은 객체다.
분명 난 Person만 생성했는데 Person.prototype라는 객체도 같이 생성 되었다.

그럼 3번 제일 위에 작성한 코드를 입력하고 콘솔에 찍어보자. 이렇게 말이다.
```js
var Person = function(name){
  this.nickName = name
}

Person.prototype.whoAreU = function(){
  return this.nickName;
}

console.log(Person.prototype); // {whoAreU: ƒ, constructor: ƒ} 출력
```
"{WhoAreYou: ƒ, constructor: ƒ}" 출력 된다. 즉, "Person.prototype.whoAreU = f(){ ... }" 코드는 Person.prototype객체에 프로퍼티로 추가 시켰다.

이쯤에서 정리를 해보자! 난 제일 처음에 "var Person = function(){...}"이라는 생성자함수를 만들었다. 이때 자동적으로 "Person.prototype"라는 객체가 생성된다. 이 객체에 내가 원하는 프로퍼티를 만들어 넣을 수 있다. 이렇게 말이다. 
```js
Person.prototype.whoAreU = function(){
  return this.nickName;
}
```
그럼 "Person.prototype"에 whoAreU라는 프로퍼티가 추가된다.

일단 prototype은 여기까지만 알자. 다음으로 넘어가자.

3. \_\_proto\_\_

이제 더더더더!욱 복잡해진다. 그래서 뭐? 어쩌라고? 어따 사용하는데? 라는 생각 까지 할 수 있다. 멘탈을 잡자.
자! __proto__가 뭐냐?! 위에서 생성자 함수 Person을 만들면 자동적으로 Person.prototype 객체가 생성 된다고 했다. **__proto__는 instance를 만들면 자동적으로 생기는 객체이다.** 아래 코드를 보자.
```js
var Person = function(name){
  this.nickName = name
}

let superPil = new Person('superPil');

console.log(superPil.__proto__); // {constructor: ƒ} 출력
```
"Person.prototype"와 같이 \_\_proto\_\_도 객체가 생성되고 내부에 constructor프로퍼티가 있다. 

그래. 자동으로 생성되는건 알겠어!! 그래서 \_\_proto\_\_가 뭐하길래 자동으로 생성되는데?!

**\_\_proto\_\_는 생성자함수의 prototype객체를 참조한다.** 그러니깐 superPil인스턴스를 생성하면 \_\_proto\_\_가 자동생성되고 \_\_proto\_\_는 Person.prototype을 참조한다. 그렇기때문에 아래와 같은 결과가 나타난다.
```js
console.log(Person.prototype === superPil.__proto__); // true 출력
``` 
superPil의\_\_proto\_\_는 Person의prototype을 참조하니깐 위와 같이 true가 출력된다.

그래서 뭐?!

음..그래서?! superPil인스턴스는 \_\_proto\_\_로 인해서 Person.prototype의 객체 내부에 있는 프로퍼티를 사용할 수 있다. 아래 코드를 보자.

```js
var Person = function(name){
  this.nickName = name
}

Person.prototype.whoAreU = function(){
  return this.nickName;
}

let superPil = new Person('superPil');

console.log(superPil.__proto__.whoAreU());
```
superPil의__proto__은 Person의 prototype을 참조하니깐 prototype에 있는 프로퍼티를 사용가능하다고 했다. 그럼 위 코드에서 "superPil.\_\_proto\_\_.whoAreU()"은 어떤 결과가 나올까?? **undefined**가 출력된다.
왜? 참조하니깐 사용 가능한거 아냐?!
이건 this 때문이다. 간략하게 말하면 "superPil.\_\_proto\_\_.whoAreU()"로 했을 때 whoAreU에 있는 this는 superPil.\_\_proto\_\_객체 내부에 nickName을 찾는다. superPil.\_\_proto\_\_객체에 nickName프로퍼티가 있는가?? 없다. 그래서 undefined가 출력된다. 그럼 어떻게 해야하나?! 아래처럼 하면 된다.

```js
var Person = function(name){
  this.nickName = name
}

Person.prototype.whoAreU = function(){
  return this.nickName;
}

let superPil = new Person('superPil');

console.log(superPil.whoAreU()); // superPil 출력
```
간단하게 \_\_proto\_\_를 지워주면 된다. 그럼 whoAreU에 this는 superPil인스턴스를 바라본다. superPil인스턴스에 nickName프로퍼티가 있는가? 당연 있다. superPil인스턴스는 Person생성자함수 바탕으로 생성했으니까! 즉 \_\_proto\_\_를 생략해도 Person의 prototype의 프로퍼티에 접근 가능하다!

