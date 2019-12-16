# 1. textarea Tag
textarea tag는 사용자가 많은 텍스트를 작성할수 있게 해주는 공간을 제공해 준다.

input type="text"같은 경우에는 여러 줄로 작성된 텍스트는 받을 수 없다. 

기본 사용은 아래와 같다.
```html
    <textarea>텍스트 공간</textarea>
```
# 2. textarea 속성
```html
    <textarea rows="10" cols="10">텍스트 공간</textarea>
```
rows속성과 cols속성이 있다.

rows와 cols은 각각 가로, 세로 텍스트를 작성할 수 있는 줄수를 말한다.

또한 두가지 속성 모두 CSS로 조정 가능해서 필수 속성은 아니다.

textarea 태그에도 placeholder속성과 disabled속성이 사용가능하다.