import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class MaxNumber {
    public static final int FIRST_NUMBER_MAX = -1;
    public static final int LAST_NUMBER_MAX = 1;
    public static final int EXCEPTION = 0;
    
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> priQ = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위 큐를 이용해서 String 형태로 우선순위를 역순으로 정렬하려고 했으나, 1000 100 10 1을 비교하는 부분에서 한계가 있다는 것을 알았습니다. 그래서 1 10 100 1000 순으로 정렬하는 코드를 추가하려고 합니다. 
        
        for(int i=0; i<numbers.length; i++) {
           priQ.add(Integer.toString(numbers[i]));
        }
        
        // 배열이 모두 0 일때는 0을 하나만 반환합니다.
        if(priQ.peek().equals("0")) return "0";
        
        // 큐에서 하나씩 꺼내서 checkMaxNumberStr 메서드의 결과에 따라 다르게 처리해줍니다.
        String lastNumber = null;
       while(priQ.size() > 0) {
            String firstNumber = priQ.poll();

            // tempStr 이 null 일때 poll 을 한번 합니다.
            if(lastNumber == null) lastNumber = priQ.poll();
            
            // 큐가 널일 때 처리
            if(lastNumber == null && priQ.peek() == null) {
            	lastNumber = firstNumber;
            	break;
            }
            
            // 앞자리가 같은 숫자들이(ex: 10 100 1000) 맨 앞자리 이외에 모든 숫자가 0인 숫자들만 확인해서 우선순위를 바꿔줍니다.
            if(firstNumber.charAt(0) == lastNumber.charAt(0)) {
                
                ArrayList<String> arrayList = new ArrayList<>();
                
                // firstNumber 와 lastNumber 를 먼저 체크합니다.
                int firstNumberZero = checkZeroNumber(firstNumber);
                int lastNumberZero = checkZeroNumber(lastNumber);
                
                // 만약 firstNumber 와 lastNumber 둘다 맨 앞자리 이외에 모든 숫자가 0이 아니라면 둘중에 큰 숫자를 먼저 answer 에 붙여줍니다.
                if(firstNumberZero != firstNumber.length()-1 && lastNumberZero != lastNumber.length()-1) {
                	if(Integer.parseInt(firstNumber+lastNumber) >= Integer.parseInt(lastNumber+firstNumber)) {
                		answer += firstNumber;
                		answer += lastNumber;
                	}else {
                		answer += lastNumber;
                		answer += firstNumber;
                	}
                }else if(firstNumberZero != firstNumber.length()-1){
                	answer += firstNumber;
                }else if(lastNumberZero != lastNumber.length()-1) {
                	answer += lastNumber;
                }
                
                // 만약 맨 앞 숫자 이외에 모든 숫자가 0 일 경우 배열에 추가합니다.
                if(firstNumberZero == firstNumber.length()-1) {
                	arrayList.add(firstNumber);
                }
                
                if(lastNumberZero == lastNumber.length()-1) {
                	arrayList.add(lastNumber);
                }
                
                
                
                while(priQ.peek() != null && priQ.peek().charAt(0) == firstNumber.charAt(0)) {
                	// 첫번째 숫자 이외에 나머지가 0인 숫자를 배열에 담아야 합니다.
                	// 아스키코드 0 ~ 9 == 48 ~ 57
                	String zeroCheckStr = priQ.poll();
                	int checkZeroNumber = checkZeroNumber(zeroCheckStr);
                	// 만약 체크한 0의 갯수가 해당 문자열의 길이 -1 과 같다면 배열에 넣어주고, 아니라면 answer 에 더해줍니다.
                	if(checkZeroNumber == zeroCheckStr.length()-1) {
                		arrayList.add(zeroCheckStr);
                	}else {
                		answer += zeroCheckStr;
                	}
                    
                }
                // 맨 앞자리 빼고 모두 0으로 이루어진 배열을 다시 정순으로 정렬합니다. 
                
                Collections.sort(arrayList);
                for(String str: arrayList) {
                    answer += str;
                } 
                lastNumber = null;
                continue;
            }
            
            int result = checkMaxNumberStr(firstNumber, lastNumber);

            switch(result) {
                case FIRST_NUMBER_MAX:
                    answer += firstNumber;
                    break;
                case LAST_NUMBER_MAX:
                    answer += lastNumber;
                    lastNumber = firstNumber;
                    break;
                default:
            }
        }
        if(lastNumber != null) answer += lastNumber;
        
        
         // 정렬을 했을 때 1000 100 10 1 이런식으로 정렬되기 때문에 우선순위 큐로 정렬하는 것에는 한계가 있는 것 같습니다. 일반배열로 변경합니다.
        // Arrays.sort(arr, Collections.reverseOrder());
        /* 일반 배열
        String[] strArray = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strArray[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strArray, Collections.reverseOrder());
        
        for(String str: strArray) {
            System.out.println(str);
        }
        */
        
        return answer;
    }
    
    // 0이 몇개인지 체크하는 메서드
    private int checkZeroNumber(String zeroCheckStr) {
    	int checkZeroNumber = 0;
    	for(int i = 0; i < zeroCheckStr.length(); i++) {
    		if(zeroCheckStr.charAt(i) == 48) {
    			checkZeroNumber++;
    		}
    	}
    	return checkZeroNumber;
    }
    
    // 두 문자열을 서로 앞뒤로 붙여서 비교했을 때 어느쪽이 더 큰지 확인하는 메서드 입니다.
    private int checkMaxNumberStr(String str1, String str2) {
        if(str1 == null && str2 == null) {
            return EXCEPTION;
        }else if(str1 == null) {
            return LAST_NUMBER_MAX;
        }else if(str2 == null) {
            return FIRST_NUMBER_MAX;
        }
        String tempStr = str1 + str2;
        // String 클래스의 compareTo()  메서드를 사용해서 사전순으로 비교합니다.
        // 파라미터의 스트링값이 더 크면 음수, 같으면 0, 작으면 양수
        if(tempStr.compareTo((str2+str1)) > 0) {
            return FIRST_NUMBER_MAX;
        }else {
            return LAST_NUMBER_MAX;
        }
    }
}
// 사전순 정렬에서 1000 이 100 보다 크다고 정의되어 있어서 그런지 1000 100 10 1 이런식으로 정렬이
// 되기 때문에 1을 먼저 넣어야하는데 1000 과 100 을 비교해서 큰쪽을 answer 에 붙여버리기 때문에
// 실패하게 되는것 같습니다.
