# 메소드(method)
## 1. 메소드 내부 변수
### (1) 변수 예제
```java
class Test{
  static int b = 3; // 클래스 변수
  int a = 2; // 인스턴스 변수
  void testMethod(){
    int c = 1; // 지역 변수
  }
}
```
* 클래스 변수는 크래스가 메모리에 올라갈 때 생성
* 인스턴스 변수는 인스턴스가 생성되었을 때 생성
* 지역변수는 변수 선언문이 수행되었을 때 생성

### (2) 변수별 사용 용도
* 인스턴스 변수는 독립적인 저장공간을 가지므로 서로 다른 값을 가짐, 인스턴스마다 고유한 상태를 유지해야하는 속성의 경우, 인스턴스 변수 사용
* 클래스 변수는 인스턴스변수에 static을 붙이기만 하면 됨, 모든 인스턴스가 공통된 저장공간을 공유함, 한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우 사용
* 지역 변수는 메서드 내에서만 사용 가능, 메서드가 종료되면 소멸, {}내부에서만 사용가능

## 2. 메소드 구현
```java
반환타입 메서드이름(타입 변수명, 타입 변수명){
  메서드 호출시 수행될 코드
}
```



## 2. 메소드 반환타입
### (1) 기본적 반환타입
* 
### (2) 참조형 반환타입
* 메소드 반환타입이 참조형이 될 수 있음
```java
// ObjCreat
public class ObjCreat {
	public int x;
	public int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "ObjCreat [x=" + x + ", y=" + y + "]";
	}
	
}
```
1. ObjCreat
* 객체에 데이터를 담기위한 틀

2. public int x; public int y;
* ObjCreat객체에 x, y 변수 선언

3. getter, setter 메소드
* getter, setter 메소드는 다른 곳에서 사용해서 x, y에 값을 넣기

```java
// ObjUse
public class ObjUse {
	
	public ObjCreat thisMethod() {
		ObjCreat val = new ObjCreat();
		val.setX(100);
		val.setY(200);
		System.out.println(val.toString()); // ObjCreat[x=100, y=200] 출력
		return val;
	}
}
```
1. ObjUse
* 틀을 가지고 와서 가공

2. public ObjCreat thisMethod()
* 이 메소드는 ObjCreat객체를 반환 하는 메소드라고 선언
* 메소드 내부에서 어떤 코드가 있든 이 메소드는 ObjCreat객체를 반환함

3. ObjCreat val = new ObjCreat()
* ObjCreat를 가져와서 val에 할당

4. val.setX(100); val.setY(200);
* ObjCreat객체에 있는 x, y에 데이터 담기

5. return val
* val을 return
* 당연 여기서 val은 ObjCreat객체 

```java
// main
public class StApplication {

	public static void main(String[] args) {
		ObjUse finall = new ObjUse();
		finall.thisMethod();
	}
	
}
```
1. main
* ObjUse에서 가공된 메소드를 불러서 사용하는 공간

2. ObjUse finall = new ObjUse();
* ObjUse를 불러 finall에 할당

3. finall.thisMethod()
* ObjCreat에 선언한 thisMethod메소드 사용
* ObjCreat [x=100, y=200] 출력
* 즉, ObjCreat의 객체가 ObjUse에 가공된 값을 main에서 사용