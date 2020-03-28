# ModelAndView
## 1. 개념
* 객체임
* 
```java
public ModelAndView viewing(){
  ModelAndView mv = new ModelAndView();
}
```
* 반환값은 ModelAndView객체

## 2. 메소드
### (1) setViewName()
```java
mv.setViewName("뷰의 경로")
```
* 뷰 이름을 지정

### (2) addObject()
```java
mv.addObject("변수 이름", "데이터 값")
```
* 뷰로 보낼 데이터 값