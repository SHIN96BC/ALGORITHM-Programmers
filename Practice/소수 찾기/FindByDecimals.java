class FindByDecimals {
    public int solution(int n) {
        int answer = 0;
        // 에라토스테네스의 체 구현
        // 소수가 아닌 0과1은 제외하고 2부터 자기자신을 제외한 배수들을 모두 지워나가기를 반복합니다.
        // 예를들어 120까지의 소수의 개수를 구하고 싶다면 11을 두번 곱했을 때 120보다 커지므로 
        // 11보다 작은 수의 배수만 지워주면 소수의 개수를 구할 수 있습니다.
        
        boolean[] isNotDecimals = new boolean[n + 1];
        
        // 0과 1은 소수가 아니므로 제외
        isNotDecimals[0] = true;
        isNotDecimals[1] = true;
        
        // 1은 소수가 아니므로 2부터 시작
        for (int i = 2; i * i < n + 1; i++) {
            // 소수 혹은 아직 지워지지 않은 숫자
            if (!isNotDecimals[i]) {
                // i의 배수 j들을 지웁니다.
                // i * i 미만의 숫자들은 이미 지워졌으므로 제외
                for (int j = i * i; j < n + 1; j+=i) {
                    isNotDecimals[j] = true;
                }
            }
        }
        
        // 소수 개수 체크
        for (int i = 2; i < isNotDecimals.length; i++) {
            if (!isNotDecimals[i])
                answer++;
        }
        
        return answer;
    }
}
