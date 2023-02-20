import java.util.Stack;
import java.util.LinkedList;

class PairedRemove {
    public int solution(String s) {
        // 같은 문자인지 검사할때 사용할 Stack
        Stack<String> stack = new Stack();
        // 문자열을 하나씩 담을 배열
        String[] strArr = new String[s.length()];
        
        // 문자열을 하나씩 잘라서 배열에 담는다.
        for(int i=0; i<s.length(); i++) {
            strArr[i] = s.substring(i, i+1);
        }
        
        // 배열에서 하나씩 문자열을 꺼내서 stack의 크기가 0이면 추가해주고, 0이 아니면 stack의 가장 위에 있는 값과 배열에서 꺼낸 문자열(그다음 문자열이다.)을 비교하여 같으면 stack에 있는 값을 지워준다.
        for(String str: strArr) {
            if(stack.size() != 0) {
                if(stack.peek().equals(str)) {
                    stack.pop();
                }else {
                    stack.push(str);
                }
            }else {
                stack.push(str);
            }
        }
        // 스텍에 크기가 0이면 전부 제거할 수 있다는 의미이므로 1을 반환하고, 0이 아니라면 제거하지 못했으므로 0을 반환한다.
        if(stack.size() == 0) {
            return 1;
        }else {
            return 0;
        }
    }
}
