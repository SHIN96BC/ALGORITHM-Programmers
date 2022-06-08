import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new Int[id_list.length];
        
        // id 별로 신고를 몇번 받았는지를 저장하는 Map 입니다.
        Map<String, Integer> reportNumber = new HashMap<>();
        
        // 유저들이 몇번 신고를 당했는지 계산합니다.(한사람이 여러번 신고했을 때는 1회로 처리합니다.)
        for(String reportStr: report) {
            String reportedId = reportStr.substring(reportStr.lastIndexOf(" ")+1, reportStr.length());
            // 맵에 신고당한 id 가 있다면 value 값을 꺼내어 1을 더해서 다시 저장하고, 없다면 새로 추가합니다.
            if(reportNumber.containsKey(reportedId)) {
                reportNumber.put(reportedId, reportNumber.get(reportedId));
            }else {
                reportNumber.put(reportedId, 1);
            }
        }
        /* 이렇게 getOrDefault() 를 이용해서 구현할 수도 있습니다.
        for(String reportStr: report) {
            String reportedId = reportStr.substring(reportStr.lastIndexOf(" ")+1, reportStr.length());
            
            // getOrDefault 메서드는 찾는 키가 존재한다면 찾는 키의 값을 반환하고, 없다면 기본값을 반환하는 메서드 입니다.
            reportNumber.put(reportedId, reportNumber.getOrDefault(reportedId, 1)+1);
        }
        */
        
        // 신고 횟수가 초과되어 정지된 id 를 찾아서 배열에 저장합니다.
        List<String> stopId = new ArrayList<>();
        Set<String> keys = reportNumber.keySet();
        for(String key: keys) {
            if(reportNumber.get(key) >= k) {
                stopId.add(key);
            }
        }
        
        // 정지당한 id 를 신고한 유저에게 결과 메일을 보내야하는 개수를 구합니다.
        for(int i = 0; i < id_list.length; i++) {
            
        }
        
        return answer;
    }
}
