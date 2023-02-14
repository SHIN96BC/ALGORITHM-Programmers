class Solution {
    public String solution(String s, String skip, int index) {
        StringBuffer answer = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            answer.append(getNextAlphabet(s.charAt(i), index, skip)); 
        }
        
        return answer.toString();
    }
    
    private char getNextAlphabet(char c, int moveIndex, String skip) {

        int skipCount = 0;
        for (int i = 1; i <= moveIndex; i++) {
            char checkAlphabet = (char)(c + i); 
            String alphabet = Character.toString(checkOutOfRange(checkAlphabet)); 

            if (skip.contains(alphabet)) {
                skipCount++; 
            }
        }

        char movedAlphabet = (char)(c + moveIndex + skipCount);

        return checkOutOfRange(movedAlphabet);
    }
    
    private char checkOutOfRange(char alphabet) {
         // 아스키코드 a ~ z == 97 ~ 122
        if (alphabet > 122) {
            return (char)('a' + alphabet - 123);
        } else {
            return alphabet;
        }
    }
}

/*
    문제 원인: 스킵되는 문자 빼고 15번 돌아야하는데 그냥 15번만 돌고 멈추는게 원인이었습니다.
    직접 작성한 테스트케이스: s = "dwertyufbn", skip = "zklpm", index = 15, result = "wqxhjsnyue"
    잘못된 result: "woxhjrkyue"
    문제가 발생한 문자: s에서 "wyu"
*
*/


