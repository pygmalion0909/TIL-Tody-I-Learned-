# button 속성 및 사용 예제

**button을 사용할 때 반드시 설정해야 하는 속성이 있다.**

button type="" 속성이다. button의 type속성으로는 **button, submit, reset**가 있고 button, submit을 많이 사용한다.
```html
    <button type="button">버튼</button>
    <button type="submit">Form 제출 버튼</button>
    <button type="reset">reset 버튼</button>
```
button type은 일반적으로 많이 사용한다.

submit type은 사용자가 button을 클릭하면 form에 제출하는 type이다.

reset type은 사용자가 작성한 내용을 초기화 시키는 type이다. 
```html
    <form action="/" method="get">
      <label for="nickname">닉네임</label>
      <input type="text" id="nickname">
      
      <button type="submit">제출</button>
      <button type="reset">다시작성</button>
    </form>
```
사용자가 위 input type="text"칸에 닉네임을 입력하고 button type="submit"을 클릭하면 form에 제출되어 닉네임이 서버로 전송된다.

하지만 사용자가 button type="reset"을 클릭하면 input칸에 작성한 내용이 reset된다.

위 두가지 속성처럼 특별하게 사용 용도가 있지 않으면 type은 "button"으로 하면 된다. 대부분 button속성을 많이 사용한다.