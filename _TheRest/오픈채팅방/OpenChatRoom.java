import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class OpenChatRoom {
    public String[] solution(String[] record) {
        // 아이디를 key값으로 닉네임을 담을 Map
        Map<String,String> nickMap = new HashMap<>();
        
        // 유저가 들어오고 나가는 행동이 몇번인지 체크하는 변수
        int arrNum = 0;
        
        // 유저의 마지막 닉네임 체크
        for(String msg: record) {
            // 유저의 입장과 닉네임 변경에 따라 닉네임을 새로 추가하거나, 변경한다.
            String checkStr = msg.substring(0, msg.indexOf(" "));
            if(checkStr.equals("Enter") || checkStr.equals("Change")) {
                String nick = msg.substring(msg.lastIndexOf(" ")+1, msg.length());
                String id = msg.substring(msg.indexOf(" ")+1, msg.lastIndexOf(" "));
                nickMap.put(id, nick);
            }
            // 입장 퇴장 갯수 
            if(checkStr.equals("Enter") || checkStr.equals("Leave")) {
                arrNum++;
            }
        }
        
        // 메세지 세팅
        String[] answer = new String[arrNum];
        int answerIndex = 0;
        for(String msg: record) {
            // 유저의 행동 체크
            String checkStr = msg.substring(0, msg.indexOf(" "));
            String nick = "";
            if(checkStr.equals("Enter")) { 
                // Map 에서 id로 닉네임 찾기
                nick = nickMap.get(msg.substring(msg.indexOf(" ")+1, msg.lastIndexOf(" ")));
                answer[answerIndex] = nick + "님이 들어왔습니다.";
                answerIndex++;
            }else if(checkStr.equals("Leave")) {
                nick = nickMap.get(msg.substring(msg.lastIndexOf(" ")+1, msg.length()));
                answer[answerIndex] = nick + "님이 나갔습니다.";
                answerIndex++;
            }
        }
        
        return answer;
    }
}
