import java.util.HashMap;
import java.util.Map;

class MBTITest {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> testSheet = getNewTestSheet();
        
        for (int i = 0; i < choices.length; i++) {
            char choiceSurvey = ' ';
            int choice = choices[i];
            
            if (choice < 4) {
                choiceSurvey = survey[i].charAt(0);
            } else if (choice > 4) {
                choiceSurvey = survey[i].charAt(1);
            }
            
            if (choiceSurvey != ' ') {
                int score = getScore(choice);
                testSheet.put(choiceSurvey, testSheet.get(choiceSurvey) + score);
            }
        }
        
        
        return getResult(testSheet);
    }
    
    private Map<Character, Integer> getNewTestSheet() {
        Map<Character, Integer> testSheet = new HashMap<>();
        testSheet.put('R', 0); testSheet.put('T', 0);
        testSheet.put('C', 0); testSheet.put('F', 0);
        testSheet.put('J', 0); testSheet.put('M', 0);
        testSheet.put('A', 0); testSheet.put('N', 0);
        
        return testSheet;
    }
    
    private int getScore(int choice) {
        switch (choice) {
            case 1:
            case 7:
                return 3;
            case 2:
            case 6:
                return 2;
            case 3:
            case 5:
                return 1;
            default:
                return 0;
        }
    }
    
    private String getResult(Map<Character, Integer> testSheet) {
        String result = "";
        
        if (testSheet.get('R') >= testSheet.get('T')) {
            result += "R";
        } else {
            result += "T";
        }
        
        if (testSheet.get('C') >= testSheet.get('F')) {
            result += "C";
        } else {
            result += "F";
        }
        
        if (testSheet.get('J') >= testSheet.get('M')) {
            result += "J";
        } else {
            result += "M";
        }
        
        if (testSheet.get('A') >= testSheet.get('N')) {
            result += "A";
        } else {
            result += "N";
        }
        
        return result;
    }
}

// 성공은 했지만 좀 더 좋은 방법이 없을까 고민중입니다.
