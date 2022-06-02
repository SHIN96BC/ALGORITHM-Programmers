import java.util.*;

public class SumDigit {
    public int solution(int n) {
        int answer = 0;
        
        String nStr = Integer.toString(n);
        
        for(int i = 0; i < nStr.length(); i++) {
            answer += Character.getNumericValue(nStr.charAt(i));
        }

        return answer;
    }
}
