# @Autowired
자동적으로 외부 패키지의 파일의 메소드를 불러와서 사용할수 있다
```java
// Controller
@Controller
public class MainController {
	
	@Autowired
	MainService getSpring;
	
	@RequestMapping(value="/")
	public String testing() {
		System.out.println(getSpring.showReturn()); // 터미널에 hello Spring 출력	
		return "test";
	}
	
}

// Service
@Service
public class MainService {
	
	public String showReturn() {
		return "hello Spring";
	}

}
```