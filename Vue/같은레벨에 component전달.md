# 같은 레벨에 component끼리 전달
## 1. 개념
* root아래에 동일선상에 있는 compoent들 끼리의 전달
* root 아래에 AppHeader 와 AppContent가 있다면 AppHeader과 AppContent끼리의 전달을 의미
* 같은 레벨끼리 전달할려면 상위component 한테 전달하고 상위component가 다른 하위component 한테 전달 해야함

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
          this.$emit('pass', 10); // root한테 event를 전달 할 때 pass와 함께 10을 함께 전달
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
