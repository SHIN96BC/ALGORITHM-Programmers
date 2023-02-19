import java.util.Map;
import java.util.HashMap;

class NumberAndString {
    public int solution(String s) {
        int answer = 0;
        
        StringToNumber stringToNumber = StringToNumber.getInstance();
        
        String checkStr = "";
        String answerStr = "";
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            // 숫자인지 확인
            // 아스키 코드 0 == 48 ~ 9 == 57
            if (str.charAt(0) > 47 && str.charAt(0) < 58) {
                answerStr += str;
            } else {
                checkStr += str;
                if (stringToNumber.findOfNumber(checkStr) != null) {
                    answerStr += stringToNumber.findOfNumber(checkStr);
                    checkStr = "";
                }
            }
        }
        
        answer = Integer.parseInt(answerStr);
        
        return answer;
    }
    
    private static class StringToNumber {
        private static final StringToNumber instance = new StringToNumber();
        private final Map<String, String> map;
        
        private StringToNumber() {
            this.map = new HashMap<>();
            
            map.put("zero", "0");
            map.put("one", "1");
            map.put("two", "2");
            map.put("three", "3");
            map.put("four", "4");
            map.put("five", "5");
            map.put("six", "6");
            map.put("seven", "7");
            map.put("eight", "8");
            map.put("nine", "9");
        }
        
        public static StringToNumber getInstance() {
            return instance;
        }
        
        public String findOfNumber(String str) {
            return map.get(str);
        }
        
    }
    
}
