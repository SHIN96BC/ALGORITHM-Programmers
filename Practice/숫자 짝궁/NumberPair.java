class NumberPair {
    public String solution(String X, String Y) {
        
// 시간초과 실패(73.7)
// 원인분석: String을 그대로 합치고, 반복문이 많아서 시간초과가 발생
// 해결방안: StringBuffer를 사용해서 성능을 향상시키고, 반복문의 갯수를 최소화한다.
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
        
// 시간초과 실패(73.7)
// 원인분석: 리스트에 담아서 내림차순으로 정렬하는 부분에서 과부화 발생(실험결과 반복문 1번으로도 시간초과)
//         애초에 배열의 길이가 너무 커서 X를 그대로 반복문으로 돌리면 과부화 발생 
// 해결방안: 숫자는 0 ~ 9까지 있다는 것에 초점을 맞춰서 최대한 반복횟수를 줄인다.
/*        
        StringBuffer answer = new StringBuffer();
        
        List<Integer> pairNumArr = new ArrayList<>();
        
        String yTemp = Y;

        for (int i = 0; i < X.length(); i++) {
            String xNum = X.substring(i, i + 1);
            
            int index = yTemp.indexOf(xNum);
            
            if (index > -1) {
                pairNumArr.add(Integer.parseInt(xNum));
                yTemp = yTemp.substring(0, index) + yTemp.substring(index + 1, yTemp.length());
            }
        }
        
        // 가장 큰 수를 찾아야 하므로 내림차순 정렬
        Collections.sort(pairNumArr, Collections.reverseOrder());
        
        if (pairNumArr.size() < 1)  {
           return "-1";
        } else {
            int sum = 0;
            
            for (int num: pairNumArr) {
                sum += num;
                answer.append(num);
            }
            
            // 배열에 0만 존재할 때는 0을 하나로 표기
            if (sum == 0)
                return "0";
        }

        return answer.toString();
*/
        
//
    }
}
