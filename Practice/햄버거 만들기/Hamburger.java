class Hamburger {
    public int solution(int[] ingredient) {
/* 실패 35.3점 
(문제 이해를 잘못했습니다. 1231 순서로 햄버거를 완성하면 그 1231 숫자 4개는 사라지고 사라진 상태에서 다시 1231 이 있는지 찾아야하는 문제였습니다.)
        int answer = 0;
        
        int check = 0;
        for (int num: ingredient) {
            if (check == 3) {
                if (num == 1) {
                    answer++;
                    check = num;
                    continue;
                }
            }
            // check 변수에 + 1 을 한 값이 num 과 같으면 처음에는 1이 들어가고, 두번쨰는 2, 세번째는 3이 들어가게 되고 check 가 3이 되면 햄버거가 완성된 것이므로 answer + 1 해줍니다. 같지않은 경우에는 0으로 초기화 시켜줍니다.
            if (check + 1 == num) {
                check = num;
                
            } else {
                if (num == 1) {
                    check = num;
                } else {
                    check = 0;
                }
            }
        }
        
        return answer;
*/

/* 실패 47.1 시간초과 
(시간초과를 해결하기 위해서는 반복문을 줄여야합니다. 즉, stack 에 배열 ingredient 안에 있는 숫자들을 넣으면서 체크해줘서 반복문을 한번만 사용할 수 있도록 구현하겠습니다.)
(stack 에 숫자를 하나씩 넣으면서 1231 이 되는 즉시 pop 하는 방식으로 구현하겠습니다.)
        int answer = 0;
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for (int i = ingredient.length - 1; i >= 0; i--) {
            stack1.push(ingredient[i]);
        }
        
        // stack 을 두개 준비해서 첫번째 stack 에서 두번째 stack 으로 숫자를 하나씩 빼면서 체크하고 1231 이 완성되면 1231 4가지 숫자를 삭제하고 첫번째 stack 에 두번째 stack 에 남아있는 숫자를 전부 push 하고 다시 체크하기를 반복합니다.
        int check = 0;
        while (stack1.size() > 0) {
            if (check == 3) {
                if (stack1.peek() == 1) {
                    answer++;
                    check = 0;
                    
                    // 1231 삭제
                    stack1.pop();
                    for (int i = 0; i < 3; i++) {
                        stack2.pop();
                    }
                    
                    // stack2 에 있는 숫자를 전부 stack 1 으로 이동
                    while (stack2.size() > 0) {
                        stack1.push(stack2.pop());
                    }
                } else {
                    stack2.push(stack1.pop());
                    check = 0;
                }
                continue;
            }
            
            if (stack1.peek() == check + 1 || stack1.peek() == 1) {
                check = stack1.pop();
                stack2.push(check);
            } else {
                stack2.push(stack1.pop());
                check = 0;
            }
        }
        
        return answer;

*/

        
    }
}

