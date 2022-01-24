class EvenAndOdd {
	public String solution(int num) {
        int r = 0;
        r = num%2;
        if(r == 0) return "Even";
        else return "Odd";
    }
}
