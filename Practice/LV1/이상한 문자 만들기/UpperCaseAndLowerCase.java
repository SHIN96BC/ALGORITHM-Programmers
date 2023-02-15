
class UpperCaseAndLowerCase {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split("");
        int checkEven = 0;
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str.trim().length() == 0) {
                answer += str;
                // 공백을 만나면 단어 하나가 끝난 것이므로 다시 checkEven 를 0으로 초기화 시킵니다.
                checkEven = 0;
                continue;
            }
            
            if (checkEven % 2 == 0) {
                answer += str.toUpperCase();
            } else {
                answer += str.toLowerCase();
            }
            checkEven++;
        }
        
        return answer;
    }
}
