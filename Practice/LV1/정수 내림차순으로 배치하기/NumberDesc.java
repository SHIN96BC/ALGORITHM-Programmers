import java.util.*;

class NumberDesc{
	public long solution(long n) {
        long answer = 0;
        String nStr = nStr = Long.toString(n);
        Integer[] temp = new Integer[nStr.length()];
        
        for(int i=0; i<nStr.length(); i++){
            String str = nStr.substring(i,i+1);
            temp[i] = Integer.parseInt(str);
        }
        
        Arrays.sort(temp, Comparator.reverseOrder());
        
        nStr = "";
        for(int j=0; j<temp.length; j++){
            nStr += Integer.toString(temp[j]);
        }
        answer = Long.parseLong(nStr);
        System.out.println(answer);
        return answer;
    }
}
