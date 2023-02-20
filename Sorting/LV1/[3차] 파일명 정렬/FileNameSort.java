import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileNameSort {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        // head == 글자만 존재함
        // number == 1~5글자 사이의 숫자만 존재함
        // tail == 둘다 존재하거나, 빈 문자열
        
        
        // 정렬기준: 1. head == 사전 순 정렬(대소문자 구분X)
        //         2. head 가 같으면 number 순으로 정렬(맨 앞에 0은 무시한다 ex: 12 == 012)
        //         3. haad, number 가 같으면 입력 순
        
        // head 부분을 group1, number 부분을 group2 로 나눠주는 정규식입니다.
        Pattern pattern = Pattern.compile("([a-zA-Z-.\\s]*)([0-9]{1,5})");
    
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String fileName1, String fileName2) {
                String head1 = "";
                int number1 = -1;
                String head2 = "";
                int number2 = -1;
                
                // Matcher 를 사용해서 group1, group2 의 값을 받아줍니다.
                Matcher matcher = pattern.matcher(fileName1);
                if (matcher.find()) {
                    head1 = matcher.group(1);
                    number1 = Integer.parseInt(matcher.group(2));
                }
                
                matcher = pattern.matcher(fileName2);
                if (matcher.find()) {
                    head2 = matcher.group(1);
                    number2 = Integer.parseInt(matcher.group(2));
                }
                
                // head 의 값을 먼저 비교하고 같으면(compareTo 는 같으면 0 을 반환합니다.) number 로 비교합니다.
                if (head1.toLowerCase().compareTo(head2.toLowerCase()) == 0) {
                    return number1 - number2;
                } else {
                    return head1.toLowerCase().compareTo(head2.toLowerCase());
                }
            }
        });
        
        
        return files;
    }
}
