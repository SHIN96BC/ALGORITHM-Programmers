class TheThreeMusketeers {
    public int solution(int[] number) {
        int answer = 0;
        
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    int result = number[i] + number[j] + number[k];
                    
                    if (result == 0) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}

// 현재 이 문제에서는 배열의 길이가 13까지여서 3중 포문을 사용해도 문제가 없었지만,
// 만약 길이가 더 길었다면 위의 풀이로는 해결이 불가능합니다. 그래서 더 좋은 방법이 없는지 고민이 필요할 것 같습니다.
