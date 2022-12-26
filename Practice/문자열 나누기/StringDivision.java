class StringDivision {
    public int solution(String s) {
        int answer = 0;
        
        int xNum = 0;
        int notXNum = 0;
        String x = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            if (x.equals(s.substring(i, i+1))) {
                xNum++;
            } else {
                notXNum++;
            }
            
            // x의 횟수와 x가 아닌 글자의 횟수가 같을 때 answer를 +1 해주고 횟수들을 초기화 시키고, x의 글자를 그 다음 글자로 세팅합니다.
            if (xNum == notXNum) {
                answer++;
                xNum = 0;
                notXNum = 0;
                if (i+2 <= s.length()) {
                    x = s.substring(i+1, i+2);
                }
            }
        }
        
        // x의 횟수와 x가 아닌 글자의 횟수가 다른데 더 이상 읽을 수 있는 글자가 없는 경우 마지막 문자도 분리하고 종료하기 때문에 answer를 +1 해줍니다.
        if (xNum != notXNum) {
         answer++;   
        }
        
        return answer;
    }
}
