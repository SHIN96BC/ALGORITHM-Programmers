class CourierBox {
   public int solution(int[] order) {
/* 실패 50점
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int orderIndex = 0;
        // 1부터 order 배열의 길이만큼 반복합니다.
        for (int i = 1; i <= order.length; i++) {
            // 먼저 order 배열의 orderIndex 번째와 i 가 같은지 체크합니다.
            if(order[orderIndex] == i) {
                // 같다면 트럭에 실은 개수를 +1 해주고, 그 다음 상자의 번호를 확인하기 위해서 orderIndex 를 +1 해줍니다.
                answer++;
                orderIndex++;
            } else {
                // 만약에 다르다면 stack 에 맨 위에 있는 값과 비교해서 같다면 트럭에 실은 개수를 +1 해줍니다.
                if (stack.size() > 0) {
                    if (order[orderIndex] == stack.peek()) {
                        stack.pop();
                        answer++;
                        orderIndex++;
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        
        
        while (stack.size() > 0) {
            if (stack.peek() == order[orderIndex]) {
                stack.pop();
                answer++;
                orderIndex++;
            } else {
                break;
            }
        }
        
        return answer;
\*/

// 성공
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int orderIndex = 0;
        int i = 1;
        // 1부터 order 배열의 길이만큼 반복합니다.
        while (i <= order.length) {
            // 먼저 order 배열의 orderIndex 번째와 i 가 같은지 체크합니다.
            if(order[orderIndex] == i) {
                // 같다면 트럭에 실은 개수를 +1 해주고, 그 다음 상자의 번호를 확인하기 위해서 orderIndex 를 +1 해줍니다.
                answer++;
                orderIndex++;
                i++;
            } else {
                // 만약에 다르다면 stack 에 맨 위에 있는 값과 비교해서 같다면 트럭에 실은 개수를 +1 해줍니다.
                if (stack.size() > 0) {
                    if (order[orderIndex] == stack.peek()) {
                        stack.pop();
                        answer++;
                        orderIndex++;
                    } else {
                        stack.push(i);
                        i++;
                    }
                } else {
                    stack.push(i);
                    i++;
                }
            }
        }
        
        // stack 에 남은 것들중에 트럭에 실을 수 있는게 있는지 확인합니다.
        while (stack.size() > 0) {
            if (stack.peek() == order[orderIndex]) {
                stack.pop();
                answer++;
                orderIndex++;
            } else {
                break;
            }
        }
        
        return answer;
    }
    }
}
