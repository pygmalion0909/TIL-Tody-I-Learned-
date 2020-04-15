# ArrayList 와 Map
## 1. ArrayList
1. 데이터값을 넣으면 자동적으로 index가 설정된다.
2. index가 데이터 넣는 순으로 정해진다.
### (1) ArrayList 속성
```java
// ArrayList생성
ArrayList<데이터 타입> 변수명 = new ArrayList<데이터 타입>();

// 데이터 추가
변수명.add(데이터 타입에 맞는 값1);
변수명.add(데이터 타입에 맞는 값2);

// 인덱스에 맞게 추가
변수명.add(0, 데이터 타입에 맞는 값3); // 인덱스0번 째 앞에 값이 추가 됨

// 데이터 수정
변수명.set(0, 수정할 데이터 값); // 인덱스 0번째 데이터를 수정 한다.

// 데이터 제거
변수명.remove(인덱스번호); // 인덱스 번호에 있는 데이터를 제거 한다.

// 전체 제거
변수명.clear(); // 데이터를 전체 제거

// 데이터 추출
변수명.get(인덱스번호).toString(); // 인덱스번호에 있는 값을 추출한다.

// 데이터 유무
변수명.isEmpty(); // 데이터가 하나도 없으면 false, 하나라도 있으면 true

// 지정 데이터 유무
변수명.contains(확인하고 싶은 데이터 값); // 지정한 데이터가 있는지 여부 true, false

// 길이
변수명.size(); // 길이를 알 수 있다.
```
### (2) ArrayList 예제


## 2. Map 예제
1. kye = value 로 입력한다.
2. key는 중복이면 안된다.
3. value는 중복이 가능하다.
```java
// Integer = Key값
// String = value(데이터 타입 맞게)
HashMap<Integer, String> 변수명 = new HashMap<Integer, String>();

// 데이터 추가
 변수명.put(key값, value값); // 하나의 key값과 value값이 한 셋트로 추가 된다.

// 데이터 수정
변수명.put(수정하고 싶은 key값, 수정할 value값)

// 데이터 추출
변수명.get(key값); // key값에 있는 value값을 출력한다.

// 특정 데이터 제거
변수명.remove(key값);

// 특정 데이터 포함 유무
변수명.containsKey(key값); // 해당 key값에 value값이 있는지 true, false로 출력

// 데이터 전체 제거
변수명.clear(); 

// 데이터 유무
변수명.isEmpty(); // 데이터가 하나 이상 있는지 여부 ture, false
```