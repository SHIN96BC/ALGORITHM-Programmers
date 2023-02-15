import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> topList = new ArrayList<>();
        
        // 매일 발표된 명예의 전당 중에서 최하위의 점수를 반환한다.
        // 1. 명예의 전당 배열 topList 에 있는 최하위 점수보다 오늘 발표된 점수가 높으면 최하위를 제외하고 새로운 점수를 넣고 오름차순 sort 해서 최하위 점수를 answer 에 담는다.
        
        for (int i = 0; i < score.length; i++) {
            if (topList.size() < k) {
                topList.add(score[i]);
                Collections.sort(topList);
            } else {
                if (topList.get(0) < score[i]) {
                    topList.remove(0);
                    topList.add(score[i]);
                    Collections.sort(topList);
                }
            }
            answer[i] = topList.get(0);
        }
        
        return answer;
    }
}
