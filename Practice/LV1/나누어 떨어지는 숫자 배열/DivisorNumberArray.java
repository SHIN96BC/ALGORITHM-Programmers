import java.util.PriorityQueue;
import java.util.Queue;

class DivisorNumberArray {
    public int[] solution(int[] arr, int divisor) {
        // 우선순위 큐를 사용해서 나누어 떨어지는 숫자를 큐에 넣자마자 낮은 숫자순으로 정렬되도록 해줍니다.
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num: arr) {
            if (num % divisor == 0) {
                pq.add(num);
            }
        }
        
        // 아무것도 없는 경우에는 -1 을 리턴합니다.
        if (pq.size() < 1) {
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = new int[pq.size()];
            int index = 0;
            while (pq.size() > 0) {
                answer[index] = pq.poll();
                index++;
            }
            return answer;
        }
    }
}
