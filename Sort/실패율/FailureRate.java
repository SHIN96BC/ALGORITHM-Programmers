import java.util.Arrays;

class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 처음에 한번 오름차순으로 정렬해서 라운드별로 실패한사람 수를 찾습니다.
        Arrays.sort(stages);
        int index = 0;
        for(int i = 0; i < answer.length; i++) {
            for(int j = index; j < stages.length; j++) {
                if(stages[j] == i+1) {
                    answer[i] += 1;
                }else {
                    index = j;
                    break;
                }
            }
        }
        // 실패율을 계산합니다.
        int total = answer.length;
        for(int i = 0; i < answer[0].length; i++) {
            int tempTotal = total - answer[i];
            answer[i] = answer[i] / total;
            total = tempTotal;
        }
        
        // 스테이지 실패율이 높은 순서대로 정렬합니다.(스테이지 번호로 정렬합니다.)
        
        
        return answer;
    }
}
