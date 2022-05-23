import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // for 문이 3개나 있다보니 시간초과가 발생한다. int배열을 그대로 2중포문으로 돌리고, 
        // findMaxNum 메서드에서 String 으로 변환해서 해보자!
        
        
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
            // x 가 마지막 숫자이면 y의 다음 숫자가 있는지 확인하고 그 숫자와 비교해서 y가 더 크면 true 를 반환한다. 
            if(x.length() == loop+1) {
                if(y.length() > loop+1) {
                    yNum = Integer.parseInt(y.substring(loop+1, loop+2));
                    if(xNum < yNum) {
                        return true;
                    }
                    return false;
                }else {
                    return false;
                }
            }else if(y.length() == loop+1) {
                // y 가 마지막 숫자이면 x의 다음 숫자가 있는지 확인하고 그 숫자와 비교해서 y가 더 크면 true 를 반환한다. 
                if(x.length() > loop+1) {
                    xNum = Integer.parseInt(x.substring(loop+1, loop+2));
                    if(xNum < yNum) {
                        return true;
                    }
                    return false;
                }else {
                    return false;
                }
            }

            // 해결: if문을 이용해서 문자열의 길이가 loop + 1 과 같으면 문자열 길이가
            // 초과 되므로 더 이상 재귀하지않고 return 하게 한다.(조건은 x가 loop + 1을 

            // 초과 했을 때, y가 loop + 1 을 초과 했을 때, 둘다 아닐 때)
            return findMaxNum(x,y,loop+1);
        }else if(xNum < yNum) {
            return true;
        }else {
            return false;
        }
    }
}
// 런타임 에러가 발생하고 있는데 아마도 저의 생각은 loop+1 때문에 길이가 초과된게 아닌가 싶습니다.길이에따라 제한이 필요할 것 같다
