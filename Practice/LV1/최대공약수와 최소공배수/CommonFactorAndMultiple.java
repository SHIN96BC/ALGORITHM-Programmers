public class CommonFactorAndMultiple {
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int temp = 0;
        int maxTemp = 0;
        int max = 0;
        int minTemp = 0;
        int min = 0;
        
        if(n<m){
            min = n;
            max = m;
            minTemp = n;
            maxTemp = m;
        }else{
            min = m;
            max = n;
            minTemp = m;
            maxTemp = n;
        }
        
        while(maxTemp !=0){
            temp = minTemp%maxTemp;
            minTemp = maxTemp;
            maxTemp = temp;
        }
        answer[0] = minTemp;
        answer[1] = min*max/answer[0];

        return answer;
    }
}
