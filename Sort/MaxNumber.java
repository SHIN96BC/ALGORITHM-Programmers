import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // PriorityQueue<String> priQ = new PriorityQueue<>(Collections.reverseOrder());
        String[] numberStrArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
           numberStrArr[i] = Integer.toString(numbers[i]);
        }
        
        for(int i=0; i<numberStrArr.length; i++) {
            for(int j=i+1; j<numberStrArr.length; j++) {
                if(findMaxNum(numberStrArr[i], numberStrArr[j], 0)) {
                    String strTemp = numberStrArr[i];
                    numberStrArr[i] = numberStrArr[j];
                    numberStrArr[j] = strTemp;
                }
            }
        }
        
        // 정리된 배열을 스트링으로 만든다
        for(String str: numberStrArr) {
            answer += str;
        }

        return answer;
    }
    
    // 오른쪽이 더 클때 true 를 반환하는 메서드
    private boolean findMaxNum(String x, String y, int loop) {
        int xNum = Integer.parseInt(x);
        if(x.length() > 1) {
           xNum = Integer.parseInt(x.substring(loop, loop+1));
        }
        int yNum = Integer.parseInt(y);
        if(y.length() > 1) {
           yNum = Integer.parseInt(y.substring(loop, loop+1));
        }
        
        if(xNum == yNum) {
            // 길이가 더 긴 쪽이랑 loop 가 같아지면 어떻게 하나 똑같다는 의미이므로 false를 반환한다.
            if(x.length() >= y.length()) {
                if(x.length() == loop) return false;
            }else if(x.length() < y.length()) {
                if(y.length() == loop) return false;
            }
            return findMaxNum(x,y,loop+1);
        }else if(xNum < yNum) {
            return true;
        }else {
            return false;
        }
    }
}
// 런타임 에러가 발생하고 있는데 아마도 저의 생각은 loop+1 때문에 길이가 초과된게 아닌가 싶습니다.길이에따라 제한이 필요할 것 같습니다.
