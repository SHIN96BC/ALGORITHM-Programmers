import java.util.PriorityQueue;
import java.util.Collections;

class MaxNumber {
    public String solution(int[] numbers) {
        String answer = "";
//         PriorityQueue<String> priQ = new PriorityQueue<>(Collections.reverseOrder());
        
        if(numbers.length == 1) {
            return Integer.toString(numbers[0]);
        }
        
        // for 문이 3개나 있다보니 시간초과가 발생한다. int배열을 그대로 2중포문으로 돌리고, 
        // findMaxNum 메서드에서 String 으로 변환해서 해보자!
        
        
        // PriorityQueue<String> priQ = new PriorityQueue<>(Collections.reverseOrder());
        // String[] numberStrArr = new String[numbers.length];
        // for(int i=0; i<numbers.length; i++) {
        //    numberStrArr[i] = Integer.toString(numbers[i]);
        // }
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[j] < 1) continue;
                if(findMaxNum(numbers[i], numbers[j], 0)) {
                    int intTemp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = intTemp;
                }
            }
        }
        
        // 배열이 전부 0인 경우 0을 하나만 반환한다.
        if(numbers[0] == 0) return "0"; 
        
        // 정리된 배열을 스트링으로 만든다
        for(int number: numbers) {
            answer += number;
        }

        return answer;
    }
    
    // 오른쪽이 더 클때 true 를 반환하는 메서드
    private boolean findMaxNum(int x, int y, int loop) {
        String xStr = Integer.toString(x);
        String yStr = Integer.toString(y);
        
        int xNum = Integer.parseInt(xStr);
        if(xStr.length() > 1) {
           xNum = Integer.parseInt(xStr.substring(loop, loop+1));
        }
        int yNum = Integer.parseInt(yStr);
        if(yStr.length() > 1) {
           yNum = Integer.parseInt(yStr.substring(loop, loop+1));
        }
        
        if(xNum == yNum) {
            // x 가 마지막 숫자이면 y의 다음 숫자가 있는지 확인하고 그 숫자와 비교해서 y가 더 크면 true 를 반환한다. 
            if(xStr.length() == loop+1) {
                if(yStr.length() > loop+1) {
                    yNum = Integer.parseInt(yStr.substring(loop+1, loop+2));
                    if(xNum < yNum) {
                        return true;
                    }
                    return false;
                }else {
                    return false;
                }
            }else if(yStr.length() == loop+1) {
                // y 가 마지막 숫자이면 x의 다음 숫자가 있는지 확인하고 그 숫자와 비교해서 y가 더 크면 true 를 반환한다. 
                if(xStr.length() > loop+1) {
                    xNum = Integer.parseInt(xStr.substring(loop+1, loop+2));
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
// 60점 시간초과 5개, 실패 1개인데 시간초과는 알겠는데 실패의 원인은 잘 모르겠습니다.
