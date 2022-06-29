import java.util.Arrays;

class StringCompression {
    public int solution(String s) {
        int answer = 0;
        // 1개부터 n/2개 까지 잘랐을 때의 문자열의 길이를 담을 배열입니다.
        // 어차피 문자열 길이의 절반까지만 자를 수 있으므로 배열의 길이는 문자열 길이의 절반으로 합니다.
        int[] strLengthNumberArray = new int[s.length()/2];
        
        int compressionNumber = 1;
        String checkCutStr = null;
        String resultStr = "";
        for(int i = 0; i < s.length()/2; i++) {
            checkCutStr = s.substring(0, i+1);
            // 초기식의 j 를 i+1 부터 시작하게 하고
            // 증감식을 j 에 i+1(i가 0부터 시작하기 때문)만큼을 증가시키게 해서 문자열을 비교합니다.
            for(int j = (i+1); j < s.length(); j=j+(i+1)) {
            	// 만약 j+(i+1) 가 s 의 length 보다 작거나 같을 때는 문자열을 비교하고, length 보다 크면 나머지 문자열을 그냥 붙입니다.
            	if(j+(i+1) <= s.length()) {
		            // 만약 j 부터 j+(i+1) 까지 문자열을 잘랐을 때 checkCutStr 과 같으면 compressionNumber 를 1 증가 시킵니다.
		            if(checkCutStr.equals(s.substring(j, j+(i+1)))) {
		            	compressionNumber++;
		            }else {
		            	// 만약 compressionNumber 가 1이 아니라면 같은 문자가 있었다는 것이므로 resultStr 에 추가해줍니다.
		            	if(compressionNumber > 1) {
		            		resultStr += compressionNumber + checkCutStr;
		            	}else {
		            		resultStr += checkCutStr;
		            	}
		            	// 같지 않으면 checkCutStr 를 다음 문자로 바꿔줍니다.
		            	checkCutStr = s.substring(j, j+(i+1));
		            	compressionNumber = 1;
		            }
            	}
            	// 마지막으로 남은 문자열을 더해줍니다.
        		if(j+(i+1) >= s.length()) {
        			if(compressionNumber > 1) {
        				resultStr += compressionNumber + checkCutStr;
        			}else {
        				// compressionNumber 가 1보다 작거나 같을 경우 나머지 문자들을 모두 붙여줍니다.
        				if(j+(i+1) == s.length()) {
        					resultStr += checkCutStr;
        				}else {
        					// 만약 j+(i+1) 가 s 의 길이와 같지 않다면 뒤에 문자가 남아있다는 의미가 되므로 마지막 문자까지 추가해줍니다.
                    		resultStr += checkCutStr + s.substring(j, s.length());
        				}
        				
                	}
            	}
            }
            // for 문이 한번 끝나면 resultStr 의 길이를 strLengthArray 배열에 추가합니다.
            strLengthNumberArray[i] = resultStr.length();
            resultStr = "";
            compressionNumber = 1;
        }
        
        // 이제 마지막으로 최소값을 찾기위해 정렬해줍니다.
        Arrays.sort(strLengthNumberArray);
        answer = strLengthNumberArray[0];
        
        return answer;
    }
}
