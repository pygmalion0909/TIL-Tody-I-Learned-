# Function.prototype.call()
call 메소드의 구문은 다음과 같다.
```javascript
fun.call(thisArg[, arg1[, arg2[, ...]]])
```
1. thisArg

    function의 this값을 임의적으로 바꿀 수 있다. function을 호출 할 경우 일반적으로 this는 전역객체를 바라본다.
    하지만 call메소드를 사용하면 첫번째 매개변수에 입력한 값이 this값이 된다.

	```javascript
	//일반적으로 함수를 호출 했을 때 this값

	const thisTest = function(){
		console.log(this); // 전역객체(window)
	}

	thisTest();
	```
	```javascript
	//call메소드를 사용 했을 때 this값
	let obj1 = {
		nickname : 'superpil',
	}
	
	const thisTest = function(){
		console.log(this); // {nickname: "superpil"}
	}

	thisTest.call(obj1);
	```
2. arg1, arg2
	
	함수에 전달되는 매개변수 값 이다. 아래에 예제를 보면 call메소드의 첫번째 인자는 this값이고 두번째는 thisTest함수에 전달되는 인자값 이다.
	```javascript
	let obj1 = {
		nickname : 'superpil',
	}
	
	const thisTest = function(state){
		console.log(this.nickname + ' ' + state); // superpil good
	}
	
	thisTest.call(obj1, 'good');
	```