class SmallString {
    public int solution(String t, String p) {
        int answer = 0;
        
        // (1) t를 p의 길이만큼 잘라서 작거나 같은 수가 몇개인지 구합니다.
        // (2) int형보다 큰 수가 나오므로 long을 사용합니다.
        long pNum = getNum(p);
        for (int i = 0; i < t.length(); i++) {
            int lastIndex = i + p.length();
            
            if (lastIndex > t.length())
                break;
            
            long cutNum = getNum(t.substring(i, lastIndex));
            
            if (cutNum <= pNum) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private long getNum(String s) {
        return Long.parseLong(s);
    }
}
