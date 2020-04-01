# Vuex의 store구조화, 모듈화
## 1. 사용
* vuex의 속성을 각각의 파일로 분리하여 관리
* 즉, getters, states, mutations, store파일로 분리하고 각각의 파일에서는 export를 함
* 최종적으로 store에 import를 하여 합침

```js
// store.js
import * as getters from './경로'

export const store = new Vuex.Store({
  getters: getters,
  mutations: mutations,
})
```
* *의미는 getters에서 export한 내용을 전부다 getters에 담겠다는 의미
* 이후 store객체에 넣어주면 됨

```js
// getters.js
export const gettersItem = (state) => {
  return state.Items;
}

// mutations.js
const mutations1 = (state) => {
  return state.Items;
}
const mutations2 = (state) => {
  return state.Items;
}
const mutations3 = (state) => {
  return state.Items;
}

export {mutations1, mutations2, mutations3};
```
* 각각의 파일에서는 함수로 작성
* 이후 export하고 store에서 import하면 됨
* getters파일에서는 메소드 하나를 바로 export했고 muations에서는 다수의 함수르 export{}를 사용하여 한꺼번에 export함
