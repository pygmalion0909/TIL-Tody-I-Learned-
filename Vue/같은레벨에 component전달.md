# 같은 레벨에 component끼리 전달
## 1. 개념
* root아래에 동일선상에 있는 compoent들 끼리의 전달
* root 아래에 AppHeader 와 AppContent가 있다면 AppHeader과 AppContent끼리의 전달을 의미
* 같은 레벨끼리 전달할려면 보낼려는 형제component가 상위component 한테 전달하고 상위component가 받을려는 하위component 한테 전달 해야함

## 2. 예제
```html
  <div id="app">
    <app-header v-bind:propsdata= "num"></app-header>
    <app-content v-on:pass= "deliverNum"></app-content>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

  <script>
    const appHeader = {
      template: "<div>header</div>",
      props: ['propsdata']
    }

    const appContent = {
      template: "<button v-on:click='passNum'> pass </button>",
      methods: {
        passNum(){
          this.$emit('pass', 10);
        },
      }
    }

    new Vue({
      el: "#app",
      components: {
        "app-header" : appHeader,
        "app-content" : appContent,
      },
      data: {
        num: 0
      },
      methods: {
        deliverNum(value){
          this.num = value;
        },
      }
    })
  </script>
```
1. button v-on:click='passNum' pass /button
* pass버튼을 클릭하면 passNum이라는 메소드가 작동

2. methods: { passNum(){ this.$emit('pass', 10); } }
* passNum메소드는 상위 component에게 pass와 10을 전달하는 작동을 함

3. app-content v-on:pass= "deliverNum"
* v-on으로 pass를 전달 받으면 상위 conponent에 있는 deliverNum메소드를 실행
* 이때 deliverNum에는 10도 같이 전달 받음

4. methods: { deliverNum(value){ this.num = value; } }
* 하위conponent에서 전달 받은 10이 value로 들어감
* this.num은 상위conponent의 num을 뜻하고 value는 하위 conponent에서 받은 값임
* 그래서 상위conponent에 있는 num의 값을 10으로 바꿈
* 결국 상위 conponent에는 하위에 받은 10의 값을 자기 자신한테 저장 함

5. props: ['propsdata']
* appHeader는 상위 conponent의 값을 받기 위해 props속성을 시전
* 이때 상위 conponent에서 받은 값을 propsdata에 담음

6. app-header v-bind:propsdata= "num"
* 상위component에 받은 값을 v-bind를 이용해서 적용
* 상위component에 있는 data속성이 propsdata에 담겨 있음
* prosdata에 있는 num값을 적용