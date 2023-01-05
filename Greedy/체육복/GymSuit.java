import java.util.Arrays;

class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        
// 1차 60점 실패 
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
        
// 2차 
        int answer = 0;
        
        return answer;
        
    }
}
