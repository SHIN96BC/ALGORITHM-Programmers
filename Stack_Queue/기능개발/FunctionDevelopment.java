import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> dayQ = new LinkedList<>();
        // 먼저 Queue 에 각 기능개발에 걸리는 날짜를 계산해서 추가한다.
        for(int i=0; i<progresses.length; i++) {
            int check = 100 - progresses[i];
            int day = (check % speeds[i] == 0) ? 
                check / speeds[i] : check / speeds[i] + 1; // 나누어서 나머지가 0이 아니면 하루가 더 걸린다는 뜻이다. 때문에 +1 해준다.
            dayQ.add(day);
        }
        int peek = dayQ.peek();  // 처음 숫자를 변수에 넣는다.(비교대상)
        int num = 0;
        List<Integer> resultList = new ArrayList<>();  // 배열의 사이즈를 알 수 없으므로 가변배열을 사용
        while(dayQ.size() != 0) {
          // 현재 비교 대상인 peek 변수와 현재 제일 왼쪽에 있는 숫자를 비교해서 같거나 작으면 이미 개발이 끝난 기능이므로
          // num 변수에 1을 더하고 비교한 숫자를 제거한다.
          // 같거나 작지 않다면 아직 개발중인 기능이므로 num을 가변배열에 추가하고, 다음 비교대상을 peek 변수에 넣고 num 을 초기화 시킨다.
            if(dayQ.peek() <= peek) {   
                num++;
                dayQ.poll();
            }else {
                resultList.add(num);
                peek = dayQ.peek();
                num = 0;
            }
        }
      // 만약 num이 0이 아니라면 마지막 숫자가 추가되지 않은 상태이므로 가변배열에 추가해준다.
        if(num != 0) {
            resultList.add(num);
        }
      // 이제 배열의 크기를 알았으므로 가변배열에 있는 데이터들을 int 배열에 옴겨담고 리턴한다.
        int[] answer = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}
