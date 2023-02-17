import java.util.regex.Pattern;
import java.util.regex.Matcher;

class RecommendNewId {
    public String solution(String new_id) {
        String answer = "";
        
        answer = check7(check6(check5(check4(check3(check2(check1(new_id)))))));
        
        return answer;
    }
    
    private String check1(String id) {
        // 1단계는 모든 대문자를 소문자로 바꿔줍니다.
        return id.toLowerCase();
    }
    
    private String check2(String id) {
        String newId = id;
        
        // 2단계는 정규식을 사용해서 소문자, 숫자, -, _, . 이외의 문자를 전부 제거해줍니다.
        String regex = "[^a-z0-9-_.]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(newId);
        
        if (matcher.find()) {
            newId = newId.replaceAll(regex, "");
        }
        
        return newId;
    }
    
    private String check3(String id) {
        String newId = id;
        
        // 3단계는 . 가 두번 이상 연속된 부분을 . 하나로 바꿔줍니다.
        
        // 성능 향상을 위해 indexOf를 사용해서 . 이 있는 곳만 찾아서 검사하므로써 반복 횟수를 줄여줍니다.
        int index = 0;
        while (newId.indexOf(".", index) > -1) {
            int dotIndex = newId.indexOf(".", index);
            // 만약 . 다음 글자가 . 인경우 잘라내줍니다.
            if (dotIndex < newId.length() - 1 && newId.charAt(dotIndex + 1) == 46) {
                newId = newId.substring(0, dotIndex + 1) + newId.substring(dotIndex+2);
            } else {
                if (dotIndex < newId.length() - 1) {
                    index = dotIndex + 1;
                } else {
                    break;
                }
            }
        }
        
        return newId;
    }
    
    private String check4(String id) {
        String newId = id;
        
        // 4단계는 . 가 id의 처음이나 끝에 존재한다면 제거합니다.
        
        // 아스키코드 . == 46
        if (newId.length() > 0 && newId.charAt(0) == 46) {
            if (newId.length() > 1) {
                newId = newId.substring(1);
            } else {
                // 문자열의 길이가 1보다 작거나 같다면 . 하나라는 의미이므로 문자열의 비워줍니다.
                newId = "";
            }
        }
        
        if (newId.length() > 0 && newId.charAt(newId.length() - 1) == 46) {
            if (newId.length() > 1) {
                newId = newId.substring(0, newId.length()-1);
            } else {
                // 문자열의 길이가 1보다 작거나 같다면 . 하나라는 의미이므로 문자열의 비워줍니다.
                newId = "";
            }
        }
        
        return newId;
    }
    
    private String check5(String id) {
        String newId = id;
        // 5단계는 id가 빈 문자열이라면 a를 대입합니다.
        
        if (id.length() < 1) {
            newId = "a";
        }
        
        return newId;
    }
    
    private String check6(String id) {
        String newId = id;
        
        // 6단계는 id의 길이가 16자 이상이면 맨 앞부터 15개의 문자를 제외한 나머지 문자열은 제거하고, 만약 마지막 문자가 . 이라면 제거합니다.
        
        if (newId.length() > 15) {
            newId = newId.substring(0, 15);
            if (newId.charAt(newId.length() - 1) == 46) {
                newId = newId.substring(0, newId.length() - 1);
            }
        }
        
        return newId;
    }
    
    private String check7(String id) {
        String newId = id;
        // 7단계는 id의 길이가 2자 이하라면 id의 길이가 3이 될 때까지 반복해서 마지막 문자를 붙입니다.
        
        if (newId.length() < 3) {
            while (newId.length() != 3) {
                newId += newId.substring(newId.length() - 1);
            }
        }
        
        return newId;
    }
}
