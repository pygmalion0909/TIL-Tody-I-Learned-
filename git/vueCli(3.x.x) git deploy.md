# Vue Cli 3.x.x version git page (gh-pages 브랜치를 활용 방법)
## 1. vue cli 프로젝트
### (1) vue.config.js 파일 생성 및 설정
```js
module.exports = {
	publicPath: '/git레파지토리 이름/'
}
```

### (2) .gitignore 파일에 주석처리
* .gitignore파일에 "/dist" 주석처리

### (3) 빌드 하기
```
npm run build
```
* 위 명령어로 vue cli 프로젝트 빌드
* 빌드 후 dist파일 생성 되고 dist파일 내부에 빌드된 파일들이 생성

## 2. git
### (1) git에 레파지토리 생성
* git에 레파지토리 생성(일반적인 생성과 같음)

### (1) 브랜치 생성
```
git checkout --orphan gh-pages
```
* 위 명령어로 gh-pages 브랜치 생성
* --orphan은 부모 커밋이 없는 브랜치 생성을 위한 옵션

### (2) add 및 commit
```
git add dist && git commit -m "커밋메세지"
```
* dist파일만 add 하고 commmit하기

### (3) github와 연결
```
git remote add origin "github주소"
```
* 위 명령어로 github레파지토리와 연결

### (4) push하기
```
git subtree push --prefix dist origin gh-pages
```
* gh-pages브랜치에서 push 하기
* 프로젝트 안에 또다른 프로젝트로 push하기 위해 subtree옵션 사용

## 3. github setting
* github setting에 hosting 확인

## 4. 참고 문헌
* https://hyem-study.tistory.com/127