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
        int loopCount = 1;
        int i = 1;
        while (loopCount <= moveIndex) {
            int checkAlphabetNum = c + i;

            String alphabet = Character.toString(checkOutOfRange(checkAlphabetNum));
            
            if (skip.contains(alphabet)) {
                i++;
                skipCount++;
            } else {
                // skip일 때는 반복카운트을 올리지 않습니다.
                i++;
                loopCount++;
            }
        }

        char movedAlphabet = (char)(c + moveIndex + skipCount);

        return checkOutOfRange(movedAlphabet);
    }
    
    private char checkOutOfRange(int alphabetNum) {
         // 아스키코드 a ~ z == 97 ~ 122
        
        if (alphabetNum > 122) {
            return (char)('a' + alphabetNum - 123);
        } else {
            return (char)alphabetNum;
        }
    }
}

/* 문제발생1 (21.1점)
    문제 원인: 스킵되는 문자 빼고 15번 돌아야하는데 그냥 15번만 돌고 멈추는게 원인이었습니다.
    작성한 테스트케이스: s = "dwertyufbn", skip = "zklpm", index = 15, result = "wqxhjsnyue"
    잘못된 result: "woxhjrkyue"
    문제가 발생한 문자: s에서 "wyu"
*/

/* 문제발생2 (78.9점)
    실패테스트케이스: 3, 17, 18, 19번
    문제원인: 알파벳의 범위를 넘어가는게 원인이었습니다.
    작성한 테스트케이스: s = "wxyz", skip = "abcdefghij", index = 20, result = "klmn"
    잘못된 result = "{|}~"
    원인분석: 알파벳은 총26개인데 skip에는 최대 10개의 알파벳이 들어갈 수 있습니다. 그때 skip이 아닌 알파벳은 16개인데 index를 20을 주게되면 
            두바퀴를 돌아야하는데 첫번째는 a로 잘 돌아가지만 두바퀴째에 알파벳의 범위를 초과해버립니다.
*/
