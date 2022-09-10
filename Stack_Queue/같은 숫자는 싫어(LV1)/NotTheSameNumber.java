import java.util.Stack;

public class NotTheSameNumber {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        for (int num: arr) {
            // stack 이 비어있으면 숫자를 추가하고 continue 시킵니다.
            if (stack.empty()) {
                stack.push(num);
                continue;
            }
            
            // stack 에 들어있는 마지막 숫자와 비교해서 만약 값이 다르다면 추가합니다.
            if (stack.peek() != num) {
                stack.push(num);
            }
        }
        
        // 스택에 있는 숫자들을 배열에 담아줍니다.
        int[] answer = new int[stack.size()];
        int index = stack.size() - 1;
        while (stack.size() > 0) {
            answer[index] = stack.pop();
            index--;
        }

        return answer;
    }
}
