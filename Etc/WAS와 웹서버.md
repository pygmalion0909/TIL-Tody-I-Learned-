# WAS와 웹서버
## 1. 웹서버
* 클라이언트가 버섭에 페이지 요청을 하면 요청을 받아 정적 컨텐츠를 제공
* 클라이언트에서 요청이 올 때 가장 앞에서 요청에 대한 처리
* 정적 컨텐츠이면 웹서버에서 응답, 정적 컨텐츠가 아니면 WAS에게 요청을하고 WAS가 처리해준 컨텐츠를 웹서버거 클라이언트에게 응답함

## 2. WAS(Web Application Server)
* 동적 컨텐츠를 제공하기 위해 만들어진 서버
* JSP, Servlet구동 환경 제공
* 컨테이너, 웹컨테이너, 서블릿 컨테이너 라고도 불림
* 웹서버에서 요청이 오면 컨테이너가 받아서 처리
* 이런 WAS의 종류는 Tomcat, Jeus, JBoss등 이 있음
* Tomcat은 아파치의 웹서버기능도 포함하고 있음
* 정적, 동적 처리를 둘다 할 수 있지만 정적처리르 WAS가 하게 되면 부하가 많이 걸림