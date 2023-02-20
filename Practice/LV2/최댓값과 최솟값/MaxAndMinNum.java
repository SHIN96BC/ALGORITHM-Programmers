class MaxAndMinNum {
    public String solution(String s) {
        String answer = "";
        
        String[] strArray = s.split(" ");
        
        int max = Integer.parseInt(strArray[0]);
        int min = Integer.parseInt(strArray[0]);
        
        for (int i = 1; i < strArray.length; i++) {
            int num = Integer.parseInt(strArray[i]);
            
            if (max < num)
                max = num;
            
            if (min > num)
                min = num;
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}
