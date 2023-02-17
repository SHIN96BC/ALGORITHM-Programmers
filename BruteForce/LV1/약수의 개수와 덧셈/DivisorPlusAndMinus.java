class DivisorPlusAndMinus {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            int divisorCount = 0;
            
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisorCount++;
                }
            }
            
            // 짝수일 때는 더하고, 홀수일 때는 뺀다.
            if (divisorCount % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}
