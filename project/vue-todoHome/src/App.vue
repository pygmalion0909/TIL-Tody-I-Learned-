<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput></TodoInput>
    <TodoList></TodoList>
    <TodoFooter></TodoFooter>
  </div>
</template>

<script>
import TodoHeader from "./components/TodoHeader";
import TodoInput from "./components/TodoInput";
import TodoList from "./components/TodoList";
import TodoFooter from "./components/TodoFooter";

export default {
  components:{
    "TodoHeader": TodoHeader,
    "TodoInput": TodoInput,
    "TodoList": TodoList,
    "TodoFooter": TodoFooter,
  }
}
</script>

<style>
  body{
    text-align: center;
    background-color: #F6F6F6;
  }
  #app{
    background: lightgray;
    width: 420px;
    margin: 0 auto;
  }
  input{
    border-style: groove;
  }
  button{
    border-style: groove;
  }
  .shadow{
    box-shadow: 5x 10px 10px rgba(0, 0, 0, 0.03);
  }
</style>
