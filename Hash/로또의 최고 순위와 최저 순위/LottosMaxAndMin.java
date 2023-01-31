class LottosMaxAndMin {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Map<Integer, Integer> checkWinNums = new HashMap<>();
        
        // 당첨번호 체크용 map
        for (int i = 0; i < win_nums.length; i++) {
            checkWinNums.put(win_nums[i], i+1);
        }
        
        // 로또번호 체크
        int hideCount = 0;
        int matchCount = 0;
        for (int num: lottos) {
            if (num == 0) {
                hideCount++;
            } else {
                if (checkWinNums.get(num) != null) {
                    matchCount++;
                }
            }
        }
        
        System.out.println("matchCount = " + matchCount + ", hideCount = " + hideCount);
        
        // 최고, 최저 순위
        int maxRanking = getRanking(matchCount);
        int minRanking = getRanking(matchCount);
        // 가려진 번호 존재시 체크
        if (hideCount > 0) {
            maxRanking = getRanking(matchCount + hideCount);
        }
        
        answer[0] = maxRanking;
        answer[1] = minRanking;
        
        return answer;
    }
    
    private int getRanking(int matchCount) {
        switch (matchCount) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
