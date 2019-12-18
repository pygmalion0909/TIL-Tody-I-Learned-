# 문자열 내 p와 y의 개수
1. 설명

    대문자와 소문자가 섞여있는 문자열 s가 진다. s에   'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면  False를 return 하는 함수를 완성 하라. 'p', 'y'  모두 하나도 없는 경우는 항상 True를 리턴합니다. 단,  개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

    예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면   false를 return합니다.

2. 제한사항

    문자열 s의 길이 : 50 이하의 자연수
    문자열 s는 알파벳으로만 이루어져 있습니다.

3. 해결 / 풀이

    01. 해결
    
        ```js
        // 테스트로 출력해 보기 위한 코드
        let ex1 = 'pPoooyY'; // 'p' 와 'y' 갯수가 같아서 true
        let ex2 = 'Pyy'; // 'p' 와 'y' 갯수가 달라서 false
        let ex3 = 'ooo'; // 아무것도 없어서 true
        
        function solution(s){
        let answer;
        let newArr = s.split('');
        let pCount = 0;
        let YCount = 0;
        
        newArr.forEach((value) => {
          if(value === 'P' || value === 'p'){
            pCount++
          }else if(value === 'y' || value === 'Y'){
            YCount++
          }
        })
        
        if( pCount === YCount || (YCount === 0 && pCount === 0)){
          answer = true;
        }else{
          answer = false;
        }
          return answer;
        }
        
        console.log(solution(ex1)); // true
        console.log(solution(ex2)); // false
        console.log(solution(ex3)); // true
        ```

    02. 해결
        ```js
        // 테스트로 출력해 보기 위한 코드
        let ex1 = 'pPoooyY'; // 'p' 와 'y' 갯수가 같아서 true
        let ex2 = 'Pyy'; // 'p' 와 'y' 갯수가 달라서 false
        let ex3 = 'ooo'; // 아무것도 없어서 true
        
        function solution(s){
          let answer;
          let newArr = s.toUpperCase().split("");
          let count = 0;
        
          newArr.forEach((value) => {
            if(value === 'P'){
              count++
            }else if(value === 'Y'){
              count--
            }
          })
        
          return count === 0 ? answer = true : answer = false
        
        }
        
        console.log(solution(ex1)); // true
        console.log(solution(ex2)); // false
        console.log(solution(ex3)); // true

        ```
        **newArr = s.toUpperCase().split("")** 
        
        s문자열을 대문자로 바꾸고 배열로 만든다.

        **newArr.forEach((value) => {
          if(value === 'P'){
            count++
          }else if(value === 'Y'){
            count--
          }
        })**

        forEach메서드를 사용하여 배열을 반복한다. 
        반복하면서 "P"가 있으면 count++하고 "Y"가 있으면 count--한다. "P"와 "Y"의 갯수가 같거나 하나도 없으면 count는 0 이 되고 둘 중에 많거나 적으면 count는 0보다 적거나 많다.