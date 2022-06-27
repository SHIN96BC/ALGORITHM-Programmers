class MaxNumber {
    public static final int FIRST_NUMBER_MAX = -1;
    public static final int LAST_NUMBER_MAX = 1;
    public static final int EXCEPTION = 0;
    
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> priQ = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위 큐를 이용해서 String 형태로 우선순위를 역순으로 정렬하려고 했으나, 1000 100 10 1을 비교하는 부분에서 한계가 있다는 것을 알았습니다. 그래서 1 10 100 1000 순으로 정렬하는 코드를 추가하려고 합니다. 
        
        for(int i=0; i<numbers.length; i++) {
           priQ.add(Integer.toString(numbers[i]));
        }

        // 배열이 모두 0 일때는 0을 하나만 반환합니다.
        if(priQ.peek().equals("0")) return "0";
        
        // 큐에서 하나씩 꺼내서 checkMaxNumberStr 메서드의 결과에 따라 다르게 처리해줍니다.
        String lastNumber = null;
        while(priQ.size() > 0) {
            String firstNumber = priQ.poll();
            
            // tempStr 이 null 일때 poll 을 한번 합니다.
            if(lastNumber == null) lastNumber = priQ.poll();
            
            // 앞자리가 같은 숫자들이(ex: 10 100 1000) 0을 포함하고 있는지 확인해서 우선순위를 바꿔줍니다.
            // 앞자리가 같은 숫자들을 전부 poll 해서 배열에 담습니다.
            if(firstNumber.charAt(0) == lastNumber.charAt(0)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(firstNumber);
                arrayList.add(lastNumber);
                while(priQ.peek().charAt(0) == firstNumber.charAt(0)) {
                    arrayList.add(priQ.poll());
                }
                
                for(int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i);
                }
                if(firstNumber.contains("0")) {
                    
                }
            }
            
            
            int result = checkMaxNumberStr(firstNumber, lastNumber);

            switch(result) {
                case FIRST_NUMBER_MAX:
                    answer += firstNumber;
                    break;
                case LAST_NUMBER_MAX:
                    answer += lastNumber;
                    lastNumber = firstNumber;
                    break;
                default:
            }
            System.out.println(answer);
        }
        answer += lastNumber;
        
        
         // 정렬을 했을 때 1000 100 10 1 이런식으로 정렬되기 때문에 우선순위 큐로 정렬하는 것에는 한계가 있는 것 같습니다. 일반배열로 변경합니다.
        // Arrays.sort(arr, Collections.reverseOrder());
        /* 일반 배열
        String[] strArray = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strArray[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strArray, Collections.reverseOrder());
        
        for(String str: strArray) {
            System.out.println(str);
        }
        */
        
        return answer;
    }
    
    // 두 문자열을 서로 앞뒤로 붙여서 비교했을 때 어느쪽이 더 큰지 확인하는 메서드 입니다.
    private int checkMaxNumberStr(String str1, String str2) {
        if(str1 == null && str2 == null) {
            return EXCEPTION;
        }else if(str1 == null) {
            return LAST_NUMBER_MAX;
        }else if(str2 == null) {
            return FIRST_NUMBER_MAX;
        }
        String tempStr = str1 + str2;
        // String 클래스의 compareTo()  메서드를 사용해서 사전순으로 비교합니다.
        // 파라미터의 스트링값이 더 크면 음수, 같으면 0, 작으면 양수
        if(tempStr.compareTo((str2+str1)) > 0) {
            return FIRST_NUMBER_MAX;
        }else {
            return LAST_NUMBER_MAX;
        }
    }
}
// 사전순 정렬에서 1000 이 100 보다 크다고 정의되어 있어서 그런지 1000 100 10 1 이런식으로 정렬이
// 되기 때문에 1을 먼저 넣어야하는데 1000 과 100 을 비교해서 큰쪽을 answer 에 붙여버리기 때문에
// 실패하게 되는것 같습니다.
