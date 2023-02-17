import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class PickTwoAndSum {
    public int[] solution(int[] numbers) {
        List<Integer> sumList = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j <numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                // 중복 체크
                if (sumList.indexOf(sum) < 0) {
                    sumList.add(sum);
                }
            }
        }
        
        int[] answer = new int[sumList.size()];
        for (int i = 0; i < sumList.size(); i++) {
            answer[i] = sumList.get(i);
        }
        
        // 오름차순 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}
