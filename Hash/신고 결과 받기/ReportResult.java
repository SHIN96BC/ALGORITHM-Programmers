import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

class ReportResult {
    import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
       int[] answer = new int[id_list.length];
        
        // id 별로 신고를 몇번 받았는지를 저장하는 Map 입니다.
        Map<String, List<String>> reportedIdMap = new HashMap<>();
        
        // Map 에 value 는 신고자들을 문자열로 붙여서 처리합니다.
        
        // 유저들이 몇번 신고를 당했는지 계산합니다.(한사람이 여러번 신고했을 때는 1회로 처리합니다.)
        for(String reportStr: report) {
            String reportId = reportStr.substring(0, reportStr.indexOf(" "));
            String reportedId = reportStr.substring(reportStr.lastIndexOf(" ")+1, reportStr.length());
            // 맵에 신고당한 id 가 있다면 value 값을 꺼내어 1을 더해서 다시 저장하고, 없다면 새로 추가합니다.
            if(reportedIdMap.containsKey(reportedId)) {
                List<String> reportIdList = reportedIdMap.get(reportedId);
                // 신고자 리스트에 해당 신고자 id 가 없을 때만 공백과 함께 추가해줍니다.
                if(!reportIdList.contains(reportId)) {
                    reportIdList.add(reportId);
                    reportedIdMap.put(reportedId, reportIdList);
                }
            }else {
                List<String> reportIdList = new ArrayList<>();
                reportIdList.add(reportId);
                reportedIdMap.put(reportedId, reportIdList);
            }
        }
        
        
        // Map 에 key(신고당한 사람 리스트)값을 하나씩 꺼내서 그 key 값에 매핑되는 String value 값을 공백을 기준으로
        // split 해서 배열 갯수로 신고자가 몇명인지 알 수 있습니다.
        Set<String> keys = reportedIdMap.keySet();
        for(String key: keys) {
            List<String> valueStr = reportedIdMap.get(key);
            // 신고자가 k 랑 같거나 많으면 신고자를 찾아서 +1 해줍니다.
            if(valueStr.size() >= k) {
                // valueStr 에 contains 메서드를 사용해서 신고자 id 배열에 i 번째 사람이 
                // valueStr(정지당한 유저의 신고자 목록)에 있는지 체크합니다.
                
                for(int i = 0; i < id_list.length; i++) {
                    String userId = id_list[i];
                    if(valueStr.contains(userId)) {
                        answer[i] += 1;
                    }
                }
            }
            
        }
        
        return answer;
    }
}
// 다 푼줄알고 넘어갔는데 다시보니 아니어서 다시 풉니다.
// 3~21 테스트 실패 
// 원인은 제가 생각할 때 String 의 contains 이 해당 글자를 포함하는 이라는 기준이기 때문에 
// 만약 con 이라는 id 를 가지고 contains 를 하게되면 conten, cont 등등 의 con 을 포함하는 단어들이 모두 포함되어 버리기
// 때문에 실패하는 것 같습니다.
// 2022-07-18 일하느라 오랜만에 들어와서 String 으로 했던거를 List 로 바꾸어서 성공했습니다.
