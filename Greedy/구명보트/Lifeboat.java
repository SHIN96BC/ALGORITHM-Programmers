import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Collections;

class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // Greedy 알고리즘이란 현재 상황에서 최선의 선택을 하는 알고리즘 입니다.
        // 만약에 가장 큰 수를 얻어야하는 문제가 있을 때 
        // A 루트: 시작 -> 7 -> 30, 
        // B 루트: 시작 -> 13 -> 3 이렇게 두가지 루트가 있을 때
        // Greedy 알고리즘은 현재 상황에서 더 큰 수인 13 을 선택해서 
        // 더 큰 숫자인 30 을 얻을 수 있는 A 루트가 아니라 B 루트를 선택하는 알고리즘입니다.
        // 그래서 Greedy 를 사용하는 문제는 굉장히 단순한 문제여야합니다.
        // 완전 탐색처럼 모든 경우의 수를 체크하지 않습니다.
        
/* 실패1 시간초과 && 실패
        List<Integer> list = new ArrayList<>();
        for (int num: people) {
            list.add(num);
        }
        
        int i = 0;
        // list 크기가 1개 이하라면 멈추고 answer + 1 해주고 반환합니다. 
        while (list.size() > 1) {
            int num = list.get(i);
            // 리스트를 순회하면서 i 번째 값과 i+1 번째 값을 더했을 때
            // limit 보다 작거나 같은 숫자가 있다면 두개의 숫자를 리스트에서 삭제합니다.
            // 없다면 i 번째 수만 삭제합니다.
            int index = IntStream
                            .range(i+1, list.size())
                            .filter(n -> list.get(n) + num <= limit)
                            .findFirst()
                            .orElse(-1);
            // 필터에 해당하는 값이 없다면 보트에 같이 태울 수 있는 사람이 없는 것 이므로 i 번째만 삭제합니다.
            if (index == -1) {
                answer++;
                list.remove(i);
                i = 0;
            } else {
                // 
                answer++;
                // i 번째를 먼저 제거하면 인덱스 값이 하나씩 앞으로 당겨져서 index 값이 맞지 않게 되므로 index 번째를 먼저 제거합니다. 
                list.remove(index);
                list.remove(i);
                i = 0;
            }
        }
        
        if (list.size() == 1) {
            answer++;
        }
        return answer;
*/
   
/* 실패2 보트가 2인승인데 2인승이 아닌줄알고 구현해서 실패
        // 모든 경우를 탐색할 필요가 없으므로 크기가 작은 순서대로 정렬해서 반복문을 한번만 사용합니다.
        Arrays.sort(people);

        int kg = 0; // 보트에 탑승한 두명의 몸무게 합
        for (int i = 0; i < people.length; i++) {
            int num = people[i];
            // kg 에 새로운 사람의 몸무게를 더했을 때 무게가 초과되면 answer + 1 하고 새로운 사람의 몸무게를 다시 kg 에 넣습니다.
            if ((kg + num) > limit) {
                answer++;
                // 다음 사람 몸무게인 num 이 limit 보다 크다면 answer + 1 해주고 kg 를 0으로 초기화 시켜줍니다.
                if (num > limit) {
                    answer++;
                    kg = 0;
                } else {
                    kg = num;
                }
            } else {
                kg += num;
            }
            // 만약에 리스트의 마지막이라면 answer + 1 해줍니다.
            if (i == people.length - 1) {
                answer++;
            }
        }
        
        return answer;
*/
        
        // 내림차순으로 정렬해서 맨앞(제일큰수)와 맨뒤(제일작은수)를 더해서 limit 을 넘는지 확인합니다.
        // 내림차순 정렬을 위해 int 배열을 Integer 배열로 바꿔줍니다.
        Integer[] peopleBoxed = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(peopleBoxed, Collections.reverseOrder());
        
        // 맨 앞 사람과 맨 뒤 사람이 같이 보트를 탔을 때 loop 를 -1 해줘서 이미 보트를 탄 맨 뒤 사람들을 또 체크하는 일이 없도록 하기위한 변수입니다.
        int loop = peopleBoxed.length - 1; // 맨 뒤 사람 체크용 변수
        for (int i = 0; i < peopleBoxed.length; i++) {
            
            if (peopleBoxed[i] + peopleBoxed[loop] <= limit) {
                loop--;
            }
            answer++;
            
            if (i == loop) {
                break;
            }
        }
        
        return answer;
    }
}
