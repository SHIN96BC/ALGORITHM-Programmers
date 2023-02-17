import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DartGame1 {
    public int solution(String dartResult) {
        int answer = 0;
        
        
        List<String> scoreList = scoreSplit(dartResult);
        
        answer = getTotalScore(scoreList);
        
        return answer;
    }
    
    private List<String> scoreSplit(String score) {
        List<String> resultList = new ArrayList<>();
        
        int firstLength = 0;
        for (int i = 0; i < score.length(); i++) {
            if (i > 0) {
                // 아스키코드 0 == 48, 9 == 57
                if (score.charAt(i) > 47 && score.charAt(i) < 58) {
                    // 숫자가 10인 경우 잘라내면 안되므로 continue
                    if (firstLength + 1 == i)
                        continue;
                    resultList.add(score.substring(firstLength, i));
                    firstLength = i;
                }
            }
        }
        
        // // 마지막으로 남은 점수를 리스트에 넣고 반환
        resultList.add(score.substring(firstLength, score.length()));
        
        return resultList;
    }
    
    private int getTotalScore(List<String> scoreList) {
        Stack<Integer> scoreStack = new Stack<>();
        
        // 아스키코드 S == 83, D == 68, T == 84, * == 42, # == 35
        for (String score: scoreList) {
            String scoreStr = "";
            int oneGameSocre = 0;
            for (int i = 0; i < score.length(); i++) {
                char c = score.charAt(i);
                if (c > 47 && c < 58) {
                    scoreStr += score.substring(i, i+1);
                } else if (c == 83 || c == 68 || c == 84) {
                    int scoreNum = Integer.parseInt(scoreStr);
                    
                    if (c == 83) {
                        oneGameSocre = scoreNum;
                    } else if (c == 68) {
                        oneGameSocre = scoreNum * scoreNum;
                    } else if (c == 84) {
                        oneGameSocre = scoreNum * scoreNum * scoreNum;
                    }
                } else if (c == 42 || c == 35) {
                    if (c == 42) {
                        if (scoreStack.size() > 0) {
                            int beforeScore = scoreStack.pop();
                            scoreStack.push(beforeScore * 2);
                        }
                        oneGameSocre *= 2;
                    } else if (c == 35) {
                        oneGameSocre *= -1;
                    }
                }
            }
            scoreStack.push(oneGameSocre);
        }

        int totalScore = 0;
        int k = 1;
        while (scoreStack.size() > 0) {
            k++;
            totalScore += scoreStack.pop();
        }
        
        return totalScore;
    }
}
