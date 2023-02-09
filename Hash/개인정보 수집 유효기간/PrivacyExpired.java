import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class PrivacyExpired {
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception {
        List<Integer> expiredIndexList = new ArrayList<>();
        
        Map<String, Integer> termsMap = getTermsMap(terms);
        
        for (int i = 0; i < privacies.length; i++) {
            String dateStr = privacies[i].substring(0, privacies[i].indexOf(" "));
            String type = privacies[i].substring(privacies[i].lastIndexOf(" ") + 1, privacies[i].length());
            int term = termsMap.get(type);
            
            // 파기해야하는 개인정보의 index값을 리스트에 담습니다. (문제에서 배열의 첫번째 값을 1로 나타내고 있으므로 +1)
            boolean expired = isExpired(dateStr, today, term, "M");
            if (expired) {
                expiredIndexList.add(i + 1);
            }
        }
        
        int[] answer = changeListOfArray(expiredIndexList);
        
        return answer;
    }
    
    private Map<String, Integer> getTermsMap(String[] terms) {
        Map<String,Integer> termsMap = new HashMap<>();
        
        for (String t: terms) {
            String type = t.substring(0, t.indexOf(" "));
            int period = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1, t.length()));
            termsMap.put(type, period);
        }
        
        return termsMap;
    }
    
    private boolean isExpired(String dateStr, String todayStr, int terms, String termsType) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar calendar = Calendar.getInstance();
        
        // 개인정보를 수집한 날짜
        Date checkDate = dateFormat.parse(dateStr);
        calendar.setTime(checkDate);
        
        // 년, 월, 일 중에 어떤걸로 계산할지 선택
        switch (termsType) {
            case "Y":
                calendar.add(Calendar.YEAR, terms);
                break;
            case "M":
                calendar.add(Calendar.MONTH, terms);
                break;
            case "D":
                calendar.add(Calendar.DATE, terms);
                break;
        }
        
        // 유효기간이 만료되는 날짜
        Date expiredDate = calendar.getTime();
        
        Date todayDate = dateFormat.parse(todayStr);
        
        // 오늘날짜가 만료날짜보다 크거나 같다면 팍기합니다.
        if (todayDate.after(expiredDate) || todayDate.equals(expiredDate)) {
            return true;
        }
        
        return false;
    }
    
    private int[] changeListOfArray(List<Integer> list) {
        int[] array = new int[list.size()];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        
        return array;
    }
}

// 성공은 했지만 생각보다 시간이 오래걸려서 시간을 단축시킬 수 있는 방법으로 개선해야할 것 같습니다.

