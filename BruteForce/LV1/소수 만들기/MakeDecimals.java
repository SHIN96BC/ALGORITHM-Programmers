class MakeDecimals {
    public int solution(int[] nums) {
        int answer = 0;

        // 1000이하의 숫자중에 3개를 더했을 때 가장 큰 숫자를 입력
        boolean[] isNotDecimals = getIsNotDecimals(2997);
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int checkDecimals = nums[i] + nums[j] + nums[k];
                    if (!isNotDecimals[checkDecimals]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    private boolean[] getIsNotDecimals(int num) {
        boolean[] isNotDecimals = new boolean[num + 1];
        
        // 소수가 아닌 0과 1 제외
        isNotDecimals[0] = true;
        isNotDecimals[1] = true;
        
        for (int i = 2; i * i < num + 1; i++) {
            // 소수가 이거나 아직 체크하지 않은 숫자 체크
            if (!isNotDecimals[i]) {
                // i의 배수 j들을 지웁니다.
                // i * i 미만의 숫자들은 이미 지워졌으므로 제외
                for (int j = i * i; j < num + 1; j+=i) {
                    isNotDecimals[j] = true;
                }
            }
        }
        
        return isNotDecimals;
    }
}

// 더 좋은 방법이 없는지 고민이 필요
