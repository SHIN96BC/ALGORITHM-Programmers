public class ColatzGuess{
	public int solution(int num) {
        int answer = 0;
        int hol = 0;
        
        for(int i=0; i<500; i++){
            if(num == 1){
                return answer;
            }
            hol = num%2;
            if(hol == 0){
                num = num/2;
                answer++;
            }else if(hol == 1){
                num = (num*3)+1;
                answer++;
            }
        }
        return -1; 
    }
}
