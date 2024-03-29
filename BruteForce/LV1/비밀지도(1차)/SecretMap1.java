class SecretMap1 {
    public String[] solution(int n, int[] arr1, int[] arr2) {

// #방법1 실패 75점 테스트 2번 6번 런타임 에러 발생
//         String[] answer = new String[n];
        
//         String result = "";
//         for (int i = 0; i < n; i++) {
//             String arr1Binary = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr1[i])));
//             String arr2Binary = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr2[i])));
            
//             for (int j = 0; j < n; j++) {
//                 if (arr1Binary.charAt(j) == 48 && arr2Binary.charAt(j) == 48) {
//                     result += " ";
//                 } else {
//                     result += "#";
//                 }
//             }
            
//             answer[i] = result;
//             result = "";
//         }
        
//         return answer;
        
// #방법2 성공 100점 런타임 에러 원인은 int의 범위초과 문제였습니다. Long으로 바꾸어서 해결했습니다.
        String[] answer = new String[n];
        
        String result = "";
        for (int i = 0; i < n; i++) {
            String arr1Binary = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String arr2Binary = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i])));
            
            for (int j = 0; j < n; j++) {
                if (arr1Binary.charAt(j) == 48 && arr2Binary.charAt(j) == 48) {
                    result += " ";
                } else {
                    result += "#";
                }
            }
            
            answer[i] = result;
            result = "";
        }
        
        return answer;
    }
}
