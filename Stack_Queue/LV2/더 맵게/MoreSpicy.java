import java.util.*;

class MoreSpicy {
    public int solution(int[] scoville, int K) {
		 int answer = 0;
		 PriorityQueue<Integer> q = new PriorityQueue<>();
		 for(int key: scoville) {
			 q.add(key);
		 }
		 while(q.peek()<K && q.size()>1) {
			 int a = q.poll();
			 int b = q.poll();
			 int sum = a+(b*2);
			 q.add(sum);
			 answer++;
		 }
		 if(q.peek()<K) {
			 return -1;
		 }
		 return answer;
	}
}
