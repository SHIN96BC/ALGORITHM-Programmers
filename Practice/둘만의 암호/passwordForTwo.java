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
