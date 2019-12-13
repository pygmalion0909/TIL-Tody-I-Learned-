# table Tag

html로 데이터를 담을 때 사용하는 tag 이다. 표를 만든다고 생각하면 된다. table태그의 하위 태그에는 tr, th, td가 있다. 

table tag를 사용할 때 가로줄 기준으로 생각 해야된다. table안에 하나의 가로줄을 만들려면 tr(table row)태그를 사용한다.

가로줄(tr)안에 하나의 셀을 만드는데 셀이 제목의 성격을 가지고 있으면 th태그를 사용한다. 만약 내용(데이터)에 관한 성격을 가졌으면 td태그를 사용한다.

아래에 예제를 보자.

```html
<table>
  <tr>
    <th>순번</th>
    <th>이름</th>
    <th>포지션</th>
  </tr>
  <tr>
    <td>01</td>
    <td>superpil</td>
    <td>frontend</td>
  </tr>
</table>
```
table을 만들기 위해서는 먼저 table 태그를 사용해서 table영역을 잡는다. 그리고 아래에 tr, th, td 를 작성해야한다.

다음으로 가로줄을 만든다. 위 예제에는 tr태그가 두개 있으니 2줄의 가로줄이 생긴다.

첫번째 가로줄(tr)에는 th태그로 제목을 만들어준다. 순번, 이름, 포지션 순으로 가로로 배치 된다.

다음 두번째 가로줄(tr)에는 td 위 th(제목)에 대한 내용이 담긴다. 첫번째 td(01)은 th(순번)아래에 위치한다. 두번째 td(superpil)은 th(이름)아래에 위치한다.

첫번째 tr태그 내부에 th태그를 어떻게 짜는지에 따라 아래에 td들이 동일하게 영향을 받는다.

# thead, tbody, tfoot

thead, tbody, tfoot는 table의 태그들을 그룹화 시키는 태그이며 반드시 작성해야 하는 태그는 아니다. 하지만 3개의 태그를 사용하면 브라우저가 쫌 더 정확하게 table의 내부의 역할 구분 지어 알 수 있다. 또한 코드를 쫌 더 가독성 좋게 만들기도 한다. 아래에 예제를 보자.

```html
<table>
  <thead>
    <tr>
      <th>순번</th>
      <th>TeamName</th>
      <th>인원</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>01</td>
      <td>super</td>
      <td>3명</td>
    </tr>
    <tr>
      <td>02</td>
      <td>ultra</td>
      <td>3명</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td>-</td>
      <td>-</td>
      <td>총 6명</td>
    </tr>
  </tfoot>
</table>
```
thead태그는 table내용 중에서 제목에 해당되는 부분을 묶어서 표시한다. tbody태그는 thead에 대한 실질적인 내용들을 묶어서 그룹핑한다.

tfoot는 table의 마지막 결론에 해당되는 부분을 묶어서 그룹핑한다. 웹사이트에도 header, nav, footer와 같이 영역을 나누듯 table도 thead, tbody, tfoot를 같은 의미로 그룹화 시키면 된다.