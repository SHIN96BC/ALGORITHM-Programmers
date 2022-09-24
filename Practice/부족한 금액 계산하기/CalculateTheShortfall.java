class CalculateTheShortfall {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            // N 번째 이용하면 N 배만큼 증가하므로 i 를 곱해줍니다.
            totalPrice += price * i;
        }
        
        // 만약에 금액이 부족하지 않다면 0을 return 합니다.
        if (money >= totalPrice) {
            return 0;
        }
        
        // 금액이 부족하다면 부족한 금액을 계산해서 return 합니다.
        answer = totalPrice - money;
        
        return answer;
    }
}
