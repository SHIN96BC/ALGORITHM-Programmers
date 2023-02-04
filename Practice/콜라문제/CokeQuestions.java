class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int remainder = 0;
        int emptyCoke = n;
        
        while (emptyCoke >= a) {
            // 새로 받은 콜라  = (총 빈 병 / 필요 빈 병 수 * 지급 병 수)
            int newCoke = emptyCoke / a * b;
            remainder = emptyCoke % a;
            
            answer += newCoke;
            
            // 새로 받은 콜라 + 나머지 빈병
            emptyCoke = newCoke + remainder;
        }
        
        return answer;
    }
}
