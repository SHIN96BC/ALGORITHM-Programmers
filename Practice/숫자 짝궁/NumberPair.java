class NumberPair {
    public String solution(String X, String Y) {
        
// 시간초과 실패(73.7)
/*        
        String answer = "";
        
        List<Integer> pairNumArr = new ArrayList<>();
        
        String yTemp = Y;

        for (int i = 0; i < X.length(); i++) {
            int xNum = Integer.parseInt(X.substring(i, i + 1));
            
            for (int j = 0; j < yTemp.length(); j++) {
                int yNum = Integer.parseInt(yTemp.substring(j, j + 1));
                
                if (xNum == yNum) {
                    pairNumArr.add(yNum);
                    // 중복방지를 위해 짝궁이 된 문자열 제거
                    yTemp = yTemp.substring(0, j) + yTemp.substring(j + 1, yTemp.length());
                    break;
                }
            }
        }
        
        // 가장 큰 수를 찾아야 하므로 내림차순 정렬
        Collections.sort(pairNumArr, Collections.reverseOrder());
        
        if (pairNumArr.size() < 1)  {
            answer = "-1";
        } else {
            int sum = 0;
            
            for (int num: pairNumArr) {
                sum += num;
                answer += num;
            }
            
            // 배열에 0만 존재할 때는 0을 하나로 표기
            if (sum == 0)
                answer = "0";
        }

        return answer;
*/
        
//
    }
}
