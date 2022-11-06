class Hamburger {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int check = 0;
        for (int num: ingredient) {
            if (check == 3) {
                if (num == 1) {
                    answer++;
                    check = num;
                    continue;
                }
            }
            // check 변수에 + 1 을 한 값이 num 과 같으면 처음에는 1이 들어가고, 두번쨰는 2, 세번째는 3이 들어가게 되고 check 가 3이 되면 햄버거가 완성된 것이므로 answer + 1 해줍니다. 같지않은 경우에는 0으로 초기화 시켜줍니다.
            if (check + 1 == num) {
                check = num;
                
            } else {
                if (num == 1) {
                    check = num;
                } else {
                    check = 0;
                }
            }
        }
        
        return answer;
    }
}
// 문제 이해를 잘못했습니다.
// 1231 순서로 햄버거를 완성하면 그 1231 숫자 4개는 사라지고 사라진 상태에서 다시 1231 이 있는지 찾아야하는 문제였습니다.
