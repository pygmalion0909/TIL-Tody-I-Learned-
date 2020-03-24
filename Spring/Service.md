# Service
## 1. Service 개념
사용자의 요청에 실질적으로 행동을 보여주는 역할.

1. 사용자가 Request를 보낸다.
2. Request URL에 맞는 Controller가 요청을 받는다.
3. Controller는 넘어온 요청을 처리하기 위해 Service에게 넘긴다.
4. Service는 알맞게 가공하여 Controller에게 데이터를 넘긴다.
5. Controller는 Service가 준 데이터를 사용자에게 응답 한다.

즉, 사용자의 요청에 실질적으로 결과물을 만드는 역할은 Service가 하고 Controller는 알맞은 경로로 길을 안내해주는 역할을 한다.

여기서 Service가 사용자의 요청에 대한 올바른 정보를 제공하기 위한 처리를 <strong>"비지니스 로직을 수행한다"</strong>고 말한다.

## 2. Service 사용법
1. Controller, Service 등 은 어노테이션을 사용하여 표시한다.
2. Service Interface 만들기
3. Service Interface 구현한 class 만들기




