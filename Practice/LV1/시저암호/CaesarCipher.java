class CaesarCipher {
    public String solution(String s, int n) {
        StringBuffer answer = new StringBuffer();
        
        for (int i = 0; i < s.length(); i ++) {
            answer.append(getNextAlphabet(s.charAt(i), n));
        }
        
        return answer.toString();
    }
    
    private char getNextAlphabet(char c, int moveIndex) {
        // 아스키 코드 a ~ z == 97 ~ 122
        // 아스키 코드 A ~ Z == 65 ~ 90
        if (c > 64 && c < 91) {
            // 마지막 글자 일 때는 처음 글자로 돌아가서 이동
            if (c + moveIndex > 90) {
                return (char)('A' + (c + moveIndex - 91));
            } else {
                return (char)(c + moveIndex);
            }
        } else if (c > 96 && c < 123) {
            // 마지막 글자 일 때는 처음 글자로 돌아가서 이동
            if (c + moveIndex > 122) {
                return (char)('a' + (c + moveIndex - 123));
            } else {
                return (char)(c + moveIndex);
            }
        } else {
            // 아스키 코드 공백 == 32
            return ' ';
        }
    }
}
