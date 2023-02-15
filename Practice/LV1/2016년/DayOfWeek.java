import java.time.LocalDate;
import java.time.DayOfWeek;

class DayOfWeek {
    public String solution(int a, int b) {
        String answer = "";
        
        LocalDate localDate = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int week = dayOfWeek.getValue();
        
        switch (week) {
            case 1:
                answer = "MON";
                break;
            case 2:
                answer = "TUE";
                break;
            case 3:
                answer = "WED";
                break;
            case 4:
                answer = "THU";
                break;
            case 5:
                answer = "FRI";
                break;
            case 6:
                answer = "SAT";
                break;
            case 7:
                answer = "SUN";
        }
        
        return answer;
    }
}
