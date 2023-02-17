class SumPositiveNegativeNumber {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        // 먼저 absolutes 배열의 길이만큼 반복문을 돌린다.
        for(int i = 0; i < absolutes.length; i++) {
            // 그리고 signs 배열의 i 번째를 확인해서 참이면 그냥 더하고, 
            // 거짓이면 -1 을 곱해서 더한다.
            if(signs[i]) {
                answer += absolutes[i];
            }else {
                answer += absolutes[i] * -1;
            }
        }
        return answer;
    }
}
