# model
## 1. 개념

## 2. 사용
```java
@Controller
public class MyContorl(){

  @RequestMapping("/testing")
  public ModelAndView test1(){
    ModelAndView mv = new ModelAndView();
  
      List<String> list = new ArrayList<>();

      list.add("hello1");
      list.add("hello2");

      mv.addObject("lists", list);
      mv.addObject("objtest", "테스트중!");
      
      mv.setViewName("view/myView");

      return mv;
  }

}
```
1. mv.setViewName("view/myView")
* jsp경로 지정
* src/main/webapp/WEB-INF/views/view/myView.jsp 파일을 지정함
* 즉, 사용자가 testing으로 들어올경우 myView.jsp파일을 보여줌

```jsp

```