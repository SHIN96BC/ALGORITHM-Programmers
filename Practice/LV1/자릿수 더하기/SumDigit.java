import java.util.*;

public class SumDigit {
    public int solution(int n) {
        int answer = 0;
        
        String nStr = Integer.toString(n);
        
        for(int i = 0; i < nStr.length(); i++) {
            // charAt 메서드를 사용해서 문자열을 하나씩 잘라냅니다.
            // Character 의 getNumericValue 메서드를 사용해서 char 타입을 int 타입으로 바꿔줍니다.
            answer += Character.getNumericValue(nStr.charAt(i));
        }

        return answer;
    }
}
