class TernaryBase3Reverse {
    public int solution(int n) {
        int answer = 0;
        
        // 3진법 변환
        String ternaryN = Integer.toString(n, 3);
        
        StringBuffer sb = new StringBuffer();
        
        // 앞뒤 반전
        for (int i = 0; i < ternaryN.length(); i++) {
            sb.insert(0, ternaryN.substring(i, i+1));
        }
        
        // 10진법 변환
        answer = Integer.parseInt(sb.toString(), 3);
        
        return answer;
    }
}
