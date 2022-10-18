import java.util.Arrays;
import java.util.Comparator;

class StringSort {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        // 사전순으로 한번 정렬
        Arrays.sort(strings);
        
        // n 번째 글자순으로 정렬
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.charAt(n) - str2.charAt(n);
            }
        });
        
        return strings;
    }
}
