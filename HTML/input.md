# input
## 1. 개념
* 사용자 입력부분과 전송 기능을 제공

## 2. 속성
### (1) hidden 속성
* 화면에는 나타나지 않지만 데이터는 보냄

````html
<form action="">
  <input type="text" name="userId">
  <input type="hidden" name="userPass" vlaue="super">
  <input type="submit" vlaue="제출!">
</form>
````
* input의 type을 hidden을 하면 화면상에 나타나지 않음
* hidden했지만 value를 super로 정하고 name을 upserpass로 정했기 때문에 실질적으로 전송이 되면 userPass=super로 전송됨
* 대체적으로 서버에 데이터를 전송할 때 사용
