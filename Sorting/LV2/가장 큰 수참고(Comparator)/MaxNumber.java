import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public String solution(int[] numbers) {
    	String answer = "";

    	// 문자열 리턴을 해줄 스트링 배열 생성
    	String[] strArray = new String[numbers.length];
    	
    	// int 배열 String 배열로 변환
    	for(int i = 0; i < numbers.length; i++) {
    		strArray[i] = Integer.toString(numbers[i]);
    	}
    	
    	// 내림차순 정렬
    	Arrays.sort(strArray, new Comparator<String>() {
    		@Override
    		public int compare(String a, String b) {
    			return (b+a).compareTo(a+b);
    			// 오름차순 정렬 (a+b).compareTo(a+b);
    		}
    	});
    	
    	// 0값이 중복일 경우
    	if(strArray[0].equals("0")) return "0";
    	
    	for(String str: strArray) answer += str;

    	return answer;
    }
}
