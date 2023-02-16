public class RemoveSmallerNumbers{
	public int[] solution(int[] arr) {
        int[] temp = new int[arr.length];
        int min = 0;
        int k =  0;
        
        if(arr.length == 1) {
            temp[0]=-1;
            return temp;
        }
        min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        for(int j=0; j< arr.length; j++){
            if(min == arr[j]) continue;
            temp[k] = arr[j];
            k++;
        }
        int[] answer = new int[k];
        for(int c=0; c<temp.length; c++){
            if(temp[c] == 0) break;
            answer[c] = temp[c];
        }
        return answer;
    }
}
