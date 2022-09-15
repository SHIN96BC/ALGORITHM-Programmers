import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;

class StringDescSort {
    public String solution(String s) {
        String answer = "";
        
        String[] answerArr = s.split("");
        
        // desc 로 정렬합니다.
        Arrays.sort(answerArr, Collections.reverseOrder());
        
        // 배열을 문자열로 합쳐줍니다.
        answer = Arrays.stream(answerArr).collect(Collectors.joining());
        
        return answer;
    }
}
