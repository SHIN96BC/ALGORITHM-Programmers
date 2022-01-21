public class HarshadNumber {
	public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        String xStr = Integer.toString(x);
        int[] xa = new int[xStr.length()];
        for(int i=0; i<xStr.length(); i++ ){
            String temp = xStr.substring(i,i+1);
            xa[i] = Integer.parseInt(temp);
        }
        for(int j=0; j< xa.length; j++){
            sum += xa[j];
        }
        if(x%sum != 0) answer = false;
        
        return answer;
    }
}
