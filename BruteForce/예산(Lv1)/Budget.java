class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(d);
        
        int dSum = 0;
        for (int dNum: d) {
            // 하나씩 더해서 예산을 초과하면 break
            if (dSum + dNum <= budget) {
                dSum += dNum;
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
