# Vue Cli(Command Line Interface)
## 1. 개념
* 개발자가 쉽게 Vue 프로젝트를 개발 할 수 있게 해주는 유용한 도구
* Command창에서 타이핑으로 명령어를 입력하여 원하는 바를 실행하는 도구
* Vue-cli는 내부적으로 webpack을 활용
* cli을 사용하기 위해서는 nodejs가 설치 필요

## 2. 설치
```
npm install @vue/cli
```
## 2. 버전확인
```
vue --version
```
* 버전 정보 나오면 설치 완료

## 3. 프로젝트 생성
```
vue create 프로젝트이름
```
* 프로젝트 구성에 필요한 요소들을 선택하는 안내 나옴(babel, eslint)
* default로 하면 babel, eslint가 설치 됨
* Manually select features를 선택하면 vuex, vue-router등 몇가지 더 선택 가능

## 4. 브라우저에서 프로젝트 확인 및 생성
```
vue ui
```
* 현재 만든 프로젝트를 브라우저에서 확인 가능

## 5. 프로젝트 실행
```
npm run serve
```
* 로컬 서버가 실행

## 6. cli plugin 설치
```
vue add plugin이름
```
* src > plugins폴더에서 확인 가능
* add하면 main.js에서 import "./plugins/axios"로 되어 있음

## 7. 프로젝트 구조
1. src
* 개발자가 작성하는 소스 코드를 배치하는 디렉토리

2. public
* 배포 버전을 빌드할 때 필요한 파일

3. node_modules
* app개발과 배포에 필요한 npm 패키지들이 저장된 디렉토리
