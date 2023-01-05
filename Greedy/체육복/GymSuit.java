import java.util.Arrays;

class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        
// 1차 60점 실패 
// 원인 파악: lost 배열에서 나온 숫자를 순서대로 중복체크 하다보니 lost배열에서 아직 나오지 않은 숫자가 중복된 경우에 answer++이 실행되어서 문제가 생깁니다.
// 해결방안: 중복체크를 lost 배열이 아니라 reserve 배열에서 하는 것이 좋을 것 같습니다.
/*        
        int answer = 0;
        
        // Arrays의 contains을 사용하기 위해서 int배열을 Integer배열로 박싱 해줍니다.
        // (int배열인 상태에서 asList를 사용하면 List<int[]> 이런 형태로 들어가게되서 contains 사용이 불가하다.)
        Integer[] reserveWrapper = Arrays.stream(reserve).boxed().toArray(Integer[]::new);
        // reserve 배열에서 사용된 값을 다시 체크하지 않기 위한 변수
        int reserveIndex = 0;
        // 중복된 학생의 번호(도난당했는데 여분을 가진 학생)
        int overlabNum = -1;
        // 중복된 학생 숫자(도난당했는데 여분을 가진 학생)
        int overlabCount = 0;
        for (int lostNum: lost) {
            boolean isOverlab = Arrays.asList(reserveWrapper).contains(lostNum);
            // 중복 체크
            if (isOverlab) {
                overlabNum = lostNum;
                overlabCount++;
            } else {
                // 중복이 아닌경우
                for (int i = reserveIndex; i < reserve.length; i++) {
                    // 중복인 번호는 넘긴다.
                    if (reserve[i] == overlabNum) {
                        continue;
                    }
                    
                    int checkGap = lostNum - reserve[i];
                    if (checkGap == 1 || checkGap == -1) {
                        reserveIndex = i + 1;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        // 수업을 들을 수 있는 총 인원수 계산
        // 총 인원수 - (체육복을 도난 당한 학생수 + 체육복을 빌려줄 수 있는 학생수 - 중복개수) + 체육복을 빌리는데 성공한 학생수 + 체육복을 원래 가지고 있는 학생수
        answer = n - (lost.length + reserve.length - overlabCount) + (answer + reserve.length);
        
        return answer;
*/ 
        
// 2차 96점 실패
// 원인 파악: 테스트 케이스를 작성하던 중 n = 5, lost = [2, 3, 4], reserve = [1, 2, 5] 일 때 정답은 4인데 결과값으로 5가 나왔습니다. 
//         reserve를 먼저 하나씩 꺼내다보니 2번은 여벌을 가지고 있는데도 불구하고 1번에게 빌리게되는 현상 때문이라는 것을 알았습니다.
// 해결방안: 먼저 중복을 전부 제거한 후 진행해야할 것 같습니다.
/*
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // Arrays의 contains을 사용하기 위해서 int배열을 Integer배열로 박싱 해줍니다.
        // (int배열인 상태에서 asList를 사용하면 List<int[]> 이런 형태로 들어가게되서 contains 사용이 불가하다.)
        Integer[] lostWrapper = Arrays.stream(lost).boxed().toArray(Integer[]::new);
        // reserve 배열에서 사용된 값을 다시 체크하지 않기 위한 변수
        int reserveIndex = 0;
        // 중복된 학생 숫자(도난당했는데 여분을 가진 학생) 리스트
        List<Integer> overlabList = new ArrayList<>();
        for (int lostNum: lost) {
            for (int i = reserveIndex; i < reserve.length; i++) {
                boolean isOverlab = Arrays.asList(lostWrapper).contains(reserve[i]);
                // 중복인 번호 스킵
                if (isOverlab) {
                    // 중복 리스트에 없는 번호만 리스트에 추가
                    if (!overlabList.contains(reserve[i])) {
                        overlabList.add(reserve[i]);
                    }
                    continue;
                }

                int checkGap = lostNum - reserve[i];
                if (checkGap == 1 || checkGap == -1) {
                    if (!overlabList.contains(lostNum)) {
                        reserveIndex = i + 1;
                        answer++;
                    }
                    break;
                } 
            }
        }
        
        // 수업을 들을 수 있는 총 인원수 계산
        // 총 인원수 - (체육복을 도난 당한 학생수 + 체육복을 빌려줄 수 있는 학생수 - 중복개수) + 체육복을 빌리는데 성공한 학생수 + 체육복을 원래 가지고 있는 학생수
        answer = n - (lost.length + reserve.length - overlabList.size()) + (answer + reserve.length);
        
        return answer;
*/
        
// 3차
        int answer = 0;
        
        return answer;
        
    }
}
