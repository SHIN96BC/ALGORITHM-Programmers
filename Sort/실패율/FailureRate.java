import java.util.Arrays;

class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failureRate = new double[N];
        
        // 처음에 한번 오름차순으로 정렬해서 라운드별로 실패한사람 수를 찾습니다.
        Arrays.sort(stages);
        int index = 0;
        for(int i = 0; i < failureRate.length; i++) {
            for(int j = index; j < stages.length; j++) {
                if(stages[j] == i+1) {
                    failureRate[i] += 1;
                }else {
                    index = j;
                    break;
                }
            }
            // answer 배열에 index값을 저장합니다.
            answer[i] = i+1;
        }
        
        // 실패율을 계산합니다.
        double total = stages.length;
        for(int i = 0; i < failureRate.length; i++) {
            double tempTotal = total - failureRate[i];
            failureRate[i] = failureRate[i] / total;
            total = tempTotal;
        }
        
        // 스테이지 실패율이 높은 순서대로 정렬합니다.(스테이지 번호로 정렬합니다.)
        for(int i = 0; i < answer.length; i++) {
            for(int j = i+1; j < failureRate.length; j++) {
                if(failureRate[i] < failureRate[j]) {
                    // i 번째 실패율 보다 j 번째 실패율이 높으면 서로 바꿔줍니다.
                    double doubleTemp = failureRate[i];
                    failureRate[i] = failureRate[j];
                    failureRate[j] = doubleTemp;
                    
                    // index 값도 같이 바꿔줍니다.
                    int intTemp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = intTemp;
                }else if(failureRate[i] == failureRate[j]) {
                    if(answer[i] > answer[j]) {
                    // 실패율이 같을경우 index 값을 비교해서 i 번째가 더 크면 서로 바꿔줍니다.
                        int intTemp = answer[i];
                        answer[i] = answer[j];
                        answer[j] = intTemp;
                    }
                }
            }
        }
        return answer;
    }
}
