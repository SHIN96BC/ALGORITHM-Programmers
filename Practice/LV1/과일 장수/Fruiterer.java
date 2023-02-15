class Fruiterer {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // (1) 배열을 내림차순으로 정렬합니다.
        Integer[] wrapperScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(wrapperScore, Collections.reverseOrder());
        
        // (2) 최대 이익을 계산합니다.
        int boxCount = 0;
        int minNum = 0;
        for (int i = 0; i < wrapperScore.length; i++) {
            int s = wrapperScore[i];
            
            // 가장 점수가 낮은 사과의 점수를 찾습니다.
            if (boxCount <= 0) {
                minNum = s;
            } else {
                if (s < minNum) {
                    minNum = s;
                }
            }
            
            
            // 상자에 사과를 담습니다.
            boxCount++;
            
            // 한 상자에 사과가 m개 만큼 채워지면 해당 상자의 이익금을 계산합니다.
            if (boxCount == m) {
                answer += minNum * m;
                
                // 초기화
                boxCount = 0;
                minNum = 0;
            }
        }
        
        // 남은 사과의 갯수가 m보다 크거나 같은지 확인해서 크거나 같다면 해당 상자의 이익금도 포함합니다.
        if (boxCount == m) {
            answer += minNum * m;
        }
        
        return answer;
    }
}
