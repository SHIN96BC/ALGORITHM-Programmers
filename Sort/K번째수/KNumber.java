import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // commands 의 들어있는 첫번째 숫자부터 두번째 숫자까지 잘라서 세번째 숫자 위치에 있는
        // 숫자를 배열에 담습니다.
        
    List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < commands.length; i++) {
            int startNum = commands[i][0];
            int lastNum = commands[i][1];
            // 먼저 lastNum 가 startNum 보다 큰지 확인하고, 만약 작다면 두 숫자를 바꿉니다.
            if(lastNum < startNum) {
                int tempNum = lastNum;
                lastNum = startNum;
                startNum = tempNum;
            }
            // 그다음에 해당 값들을 빼내서 배열로 만들고 정렬해줍니다.
            // 시작하는 숫자는 배열의 인덱스가 0부터 시작하므로 -1 해줍니다.
            for(int j = startNum-1; j < lastNum; j++) {
                arrayList.add(array[j]);
            }
            
            // 배열을 정렬해줍니다. (밑에 Collections 는 가변배열을 위한 클래스 입니다.)
            // (기본배열은 Arrays 클래스를 사용합니다.)
            Collections.sort(arrayList);
            
            // commands 의 세번째 인덱스 값으로 List에서 해당하는 값을 꺼내서 반환할 배열에 넣어줍니다.
            answer[i] = arrayList.get(commands[i][2] - 1);
            
            // List 는 사용 후 비워줍니다.
            arrayList.clear();
        }
        
        return answer;
    }
}
