class StringPAndYNum {
    boolean solution(String s) {
        boolean answer = true;

        String[] sArr = s.split("");
        
        int pNum = 0;
        int yNum = 0;
        
        for (String str: sArr) {
            if ("p".equals(str.toLowerCase())) {
                pNum++;
            }
            if ("y".equals(str.toLowerCase())) {
                yNum++;
            }
        }
        
        if(pNum != yNum) {
            answer = false;
        }

        return answer;
    }
}
