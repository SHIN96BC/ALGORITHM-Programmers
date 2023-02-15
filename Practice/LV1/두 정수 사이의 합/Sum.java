class Sum {
	public long solution(int a, int b) {
        long answer = 0;
        if(a==b) return a;
        if(a>b){
            int c = 0;
            c = b;
            b = a;
            a = c;
        }
        for(int i=a; i<=b; i++){
            answer += i;
        }
        return answer;
    }
}
