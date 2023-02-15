public class NNumber{
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long xr = 0;
        
        for(int i=0; i<n; i++){
            xr += x;
            answer[i] = xr;
        }
        return answer;
    }
}
