class Babbling2 {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str: babbling) {
            // 체크할 단어가 들어있는 map을 받습니다.
            Map<String, Boolean> checkWord = getCheckWord();
            String checkStr = "";
            for (int i = 0; i < str.length(); i++) {
                // checkStr에 한글자씩 더해가며 체크합니다.
                checkStr += str.substring(i, i+1);
                // 글자를 하나씩 체크하다가 체크할 단어 목록에 있는 단어가 있고, 바로 직전에 발음하지 않은 단어라면 checkWord를 초기화하고 방금 발음한 단어만 true로 바꿔주고 checkStr을 초기화 합니다.
                if (checkWord.get(checkStr) != null && !checkWord.get(checkStr)) {
                    checkWord = getCheckWord();
                    checkWord.put(checkStr, true);
                    checkStr = "";
                }
            }
            
            // 최종적으로 checkStr이 빈값이면 모두 조카가 발음할 수 있는 발음입니다.
            if (checkStr == "") {
                answer++;
            }
        }
        
        return answer;
    }
    
    private Map<String, Boolean> getCheckWord() {
        Map<String, Boolean> map = new HashMap<>();
        
        map.put("aya", false);
        map.put("ye", false);
        map.put("woo", false);
        map.put("ma", false);
        
        return map;
    }
}

// 급하게 만든 방법이라서 좀 더 개선이 필요할 것 같습니다.
// 좀 더 효율적으로 체크할 방법을 생각중입니다.


