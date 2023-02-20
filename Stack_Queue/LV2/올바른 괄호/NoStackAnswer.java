class NoStackAnswer {
    boolean solution(String s) {
        boolean answer = true;
        
        // 처음이 닫힌 괄호면 올바른 괄호가 아니므로 false 를 반환합니다.
        if (s.charAt(0) == 41) {
            return false;
        }
        
        // 마지막이 열린 괄호면 올바른 괄호가 아니므로 false 를 반환합니다.
        if (s.charAt(s.length()-1) == 40) {
            return false;
        }

        
        // 아스키코드 ( === 40, ) === 41
        // 왼쪽 괄호가 나오면 +, 오른쪽 괄호가 나오면 - 를 해서 왼쪽보다 오른쪽 괄호가 많으면 false 를 리턴합니다.
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 40) {
                left++;
            } else if (s.charAt(i) == 41) {
                left--;
            }
            
            if (left < 0) {
                return false;
            }
        }

        // 끝났을 때 left 가 0이 아니면 왼쪽괄호가 더 많은 것이므로 false 를 반환합니다.
        if (left != 0) {
            return false;
        }
        
        return answer;
    }
}
