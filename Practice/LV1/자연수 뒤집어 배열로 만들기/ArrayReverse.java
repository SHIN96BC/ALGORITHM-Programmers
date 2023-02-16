class ArrayReverse{
	public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer1 = new int[str.length()];
        Integer[] answer2 = new Integer[str.length()];
        int con = str.length()-1;
        for(int i=0; i<str.length(); i++){
            answer2[con] = Integer.parseInt(str.substring(i,i+1));
            con--;
        }
        for(int j=0; j<answer2.length; j++){
            answer1[j] = answer2[j];
        }
        return answer1;
    }
}
