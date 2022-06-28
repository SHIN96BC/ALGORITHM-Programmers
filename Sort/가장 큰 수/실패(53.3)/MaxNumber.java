import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class MaxNumber {
    public static final int FIRST_NUMBER_MAX = -1;
    public static final int LAST_NUMBER_MAX = 1;
    public static final int EXCEPTION = 0;
    
    int[] iArray1 = {6, 10, 2};
    int[] iArray2 = {3, 30, 34, 5, 9};
    int[] iArray3 = {111, 110, 88, 76, 87, 100, 125, 425, 854};
    int[] iArray4 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2};
    int[] iArray5 = {0, 0, 0, 0, 0, 0, 0};
    int[] iArray6 = {12, 100, 110, 1000, 101};
    int[] iArray7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1000, 0, 100, 300, 30, 3000};
    int[] iArray8 = {12, 121, 13, 134, 15, 155, 10, 100, 1000, 21, 212, 0};
    int[] iArray9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
    		33, 34, 35, 36, 37, 38, 39, 40, 100, 121, 134, 133, 132, 131, 130, 122, 785, 456, 576, 456, 10, 20, 30, 40, 50, 1, 2, 3, 4, 5, 6, 1000};
    
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> priQ = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위 큐를 이용해서 String 형태로 우선순위를 역순으로 정렬하려고 했으나, 1000 100 10 1을 비교하는 부분에서 한계가 있다는 것을 알았습니다. 
        // 그래서 1 10 100 1000 순으로 정렬하는 코드를 추가하려고 합니다. 
        
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
            
            // 앞자리가 같은 숫자들이(ex: 10 100 1000) 맨 앞자리 이외에 모든 숫자가 0인 숫자들만 확인해서 우선순위를 바꿔줍니다.(1 10 100 1000 정렬에 대응)
            if(firstNumber.charAt(0) == lastNumber.charAt(0)) {
                
            	// 맨 앞 숫자 이외에 모든 숫자가 0인 숫자를 담기 위한 배열
                ArrayList<String> zeroList = new ArrayList<>();
                
                // 맨 앞에 숫자 이외에 숫자가 맨 앞에 숫자보다 작은 숫자들을 담을 배열
                ArrayList<String> lastNumberList = new ArrayList<>();
                
                // firstNumber 와 lastNumber 를 먼저 체크합니다.
                int firstNumberZero = checkZeroNumber(firstNumber);
                int lastNumberZero = checkZeroNumber(lastNumber);
                
                // 만약 firstNumber 와 lastNumber 둘다 맨 앞자리 이외에 모든 숫자가 0이 아니라면 둘중에 큰 숫자를 먼저 answer 에 붙여줍니다.
                if(firstNumberZero != firstNumber.length()-1 && lastNumberZero != lastNumber.length()-1) {
                	if(Integer.parseInt(firstNumber+lastNumber) >= Integer.parseInt(lastNumber+firstNumber)) {
                		// firstNumber 처리
                		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), firstNumber)) {
                			lastNumberList.add(firstNumber);
                		}else {
                			answer += firstNumber;
                		}
                		// lastNumber 처리
                		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), lastNumber)) {
                			lastNumberList.add(lastNumber);
                		}else {
                			answer += lastNumber;
                		}
                	}else {
                		// lastNumber 처리
                		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), lastNumber)) {
                			lastNumberList.add(lastNumber);
                		}else {
                			answer += lastNumber;
                		}
                		// firstNumber 처리
                		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), firstNumber)) {
                			lastNumberList.add(firstNumber);
                		}else {
                			answer += firstNumber;
                		}
                	}
                }else if(firstNumberZero != firstNumber.length()-1){
                	// firstNumber 처리
            		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), firstNumber)) {
            			lastNumberList.add(firstNumber);
            		}else {
            			answer += firstNumber;
            		}
                }else if(lastNumberZero != lastNumber.length()-1) {
                	// lastNumber 처리
            		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), lastNumber)) {
            			lastNumberList.add(lastNumber);
            		}else {
            			answer += lastNumber;
            		}
                }
                
                // 만약 맨 앞 숫자 이외에 모든 숫자가 0 일 경우 배열에 추가합니다.
                if(firstNumberZero == firstNumber.length()-1) {
                	zeroList.add(firstNumber);
                }
                
                if(lastNumberZero == lastNumber.length()-1) {
                	zeroList.add(lastNumber);
                }
                System.out.println("answer1 = " + answer);
                
                // 우선순위 체크를 위한 변수입니다.
                String zeroCheckLastNumber = null;
                while(priQ.peek() != null && priQ.peek().charAt(0) == firstNumber.charAt(0)) {
                	// 첫번째 숫자 이외에 나머지가 0인 숫자를 배열에 담아야 합니다.
                	// 아스키코드 0 ~ 9 == 48 ~ 57
                	String zeroCheckFirstNumber = priQ.poll();

                	int checkZeroNumber = checkZeroNumber(zeroCheckFirstNumber);
                	// 만약 체크한 0의 갯수가 해당 문자열의 길이 -1 과 같다면 배열에 넣어주고, 아니라면 answer 에 더해줍니다.(한자리수 일때는 제외합니다.)
                	if(checkZeroNumber == zeroCheckFirstNumber.length()-1 && zeroCheckFirstNumber.length() != 1) {
                		zeroList.add(zeroCheckFirstNumber);
                	}else {
                		// 우선순위 체크를 위해서 zeroCheckLastNumber 가 null 일 경우 방금 poll 한 값을 zeroCheckLastNumber 에 대입해주고, 
                		// null 이 아니라면 비교해서 큰쪽을 answer 에 더해줍니다.
                		if(zeroCheckLastNumber != null) {
                			int result = checkMaxNumberStr(zeroCheckFirstNumber, zeroCheckLastNumber);

                            switch(result) {
                                case FIRST_NUMBER_MAX:
                                	// zeroCheckFirstNumber 처리
                            		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), zeroCheckFirstNumber)) {
                            			lastNumberList.add(zeroCheckFirstNumber);
                            		}else {
                            			answer += zeroCheckFirstNumber;
                            		}
                            		// zeroCheckLastNumber 와 zeroCheckFirstNumber 의 두번째 자리수가 같지 않을 때 lastNumberList 에 있는 문자열들을
                            		// 합쳐줍니다.(자리수가 바뀔 때 마다 배열을 비워줍니다.(둘 중 하나가 3자리수 일 때)
                            		if(lastNumberList.size() != 0 && zeroCheckFirstNumber.length() == 3 || zeroCheckLastNumber.length() == 3) {
                            			// 만약 둘 중 하나라도 1자리수 일 경우
                            			if(zeroCheckFirstNumber.length() > 1 && zeroCheckLastNumber.length() > 1) {
                            				if(zeroCheckFirstNumber.charAt(1) != zeroCheckLastNumber.charAt(1)) {
                                				for(String str: lastNumberList) answer += str;
    	                            			lastNumberList.clear();
                                			}
                            			}else {
                            				for(String str: lastNumberList) answer += str;
	                            			lastNumberList.clear();
                            			}
                            		}
                                    break;
                                case LAST_NUMBER_MAX:
                                	// zeroCheckFirstNumber 처리
                            		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), zeroCheckLastNumber)) {
                            			lastNumberList.add(zeroCheckLastNumber);
                            		}else {
                            			answer += zeroCheckLastNumber;
                            		}
                            		// zeroCheckLastNumber 와 zeroCheckFirstNumber 의 두번째 자리수가 같지 않을 때 lastNumberList 에 있는 문자열들을
                            		// 합쳐줍니다.(자리수가 바뀔 때 마다 배열을 비워줍니다.(둘 중 하나가 3자리수 일 때)
                            		if(lastNumberList.size() != 0 && zeroCheckFirstNumber.length() == 3 || zeroCheckLastNumber.length() == 3) {
                            			// 만약 둘 중 하나라도 1자리수 일 경우
                            			if(zeroCheckFirstNumber.length() > 1 && zeroCheckLastNumber.length() > 1) {
                            				if(zeroCheckFirstNumber.charAt(1) != zeroCheckLastNumber.charAt(1)) {
                                				for(String str: lastNumberList) answer += str;
    	                            			lastNumberList.clear();
                                			}
                            			}else {
                            				for(String str: lastNumberList) answer += str;
	                            			lastNumberList.clear();
                            			}
                            		}
                                    zeroCheckLastNumber = zeroCheckFirstNumber;
                                    break;
                            }
                		}else {
                			zeroCheckLastNumber = zeroCheckFirstNumber;
                		}

                	}
                	
                	System.out.println("answer2 = " + answer);
                	System.out.println("zeroCheckLastNumber = " + zeroCheckLastNumber);
                }
                // 만약 zeroCheckLastNumber 가 남아있다면 answer 에 더해줍니다.
                if(zeroCheckLastNumber != null) {
                	// zeroCheckLastNumber 처리
            		if(checkFirstNumberMoreMinNumber(firstNumber.substring(0,1), zeroCheckLastNumber)) {
            			lastNumberList.add(zeroCheckLastNumber);
            		}else {
            			answer += zeroCheckLastNumber;
            		}
                }
                
		// 2022-06-27 개선중
		// 일단 while 문에서 맨 앞자리가 같은 숫자들을 배열에 담고, 그 배열을 정렬하는데 그 기준은 두번째 세번째 자리수가 맨 앞자리 숫자보다 낮으면 
		// 또 다른 배열에 일단 담아서 한자리 숫자가 앞으로 올 수 있도록 합니다.
		
                for(String number: lastNumberList) answer += number;
		    
                System.out.println("answer3 = " + answer);
                
                // 맨 앞자리 빼고 모두 0으로 이루어진 배열을 다시 정순으로 정렬합니다. 
                Collections.sort(zeroList);
                for(String str: zeroList) {
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
    
    // 맨 앞에 숫자 이외에 숫자중에 맨 앞에 숫자보다 낮은 숫자가 있는지 체크하는 메서드
    private boolean checkFirstNumberMoreMinNumber(String firstStr, String checkStr) {

    	for(int i = 1; i < checkStr.length(); i++) {
    		// 작은 숫자가 있으면 return true
    		if(firstStr.charAt(0) >= checkStr.charAt(i)) {
    			return true;
    		}
    	}
    	return false;
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
        // 사전순이 아니라 int 로 계산합니다.
    	if(Integer.parseInt(str1+str2) >= Integer.parseInt(str2+str1)) {
    		return FIRST_NUMBER_MAX;
    	}else {
    		return LAST_NUMBER_MAX;
    	}
        
        /*
        String tempStr = str1 + str2;
        // String 클래스의 compareTo()  메서드를 사용해서 사전순으로 비교합니다.
        // 파라미터의 스트링값이 더 크면 음수, 같으면 0, 작으면 양수
        if(tempStr.compareTo((str2+str1)) > 0) {
            return FIRST_NUMBER_MAX;
        }else {
            return LAST_NUMBER_MAX;
        }
        */
    }
	
	
	public static void main(String[] args) {
		TestB testB = new TestB();
		String result = testB.solution(testB.iArray9);
		System.out.println("result: " + result);
	}
}
// -문제점 체크- 2022-06-27
// iArray9 번 테스트 케이스를 실험하면서 문제점을 알 수 있었습니다.
// 이 문제는 PriorityQueue 로 숫자를 문자열 기준으로 사전순으로 내림차순 정렬을 해서 그대로 진행했기 때문에 발생한 문제였습니다.
// 먼저 20번대까지는 22가 2보다 먼저 answer 에 더해져도 상관없어서 괜찮았는데, 30번대로 실험을 하다보니 32 보다 3 이 먼저 더해져야 하는데 32 와 31 이 비교되어 버려서 
// 3보다 32 가 먼저 더해져서 계속 실패했던 것 입니다. 이게 40 번대 50번대가 되면 더욱 문제가 커질 것 입니다.
// 10번대, 20번대, 30번대 이런식으로 한번 배열에 담고 거기서 한번 정렬하는 방식을 추가하거나, 방식을 전부 바꾸어서 해보겠습니다.

// -문제점 해결 시도-2022-06-28
// 1~6번 테스트가 실패했는데 원인을 모르겠습니다.
