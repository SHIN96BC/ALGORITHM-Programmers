class NearestIdenticalLetter {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        String checkedStr = "";
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            
            // 해당 글자와 같은 글자가 앞에 있었는지 체크합니다.
            int checkIndex = checkedStr.lastIndexOf(str);
            if (checkIndex > -1) {
                answer[i] = i - checkIndex;
            } else {
                answer[i] = checkIndex;
            }
            
            // strArr에 추가해줍니다.
            checkedStr += str;
        }
        
        return answer;
    }
}
