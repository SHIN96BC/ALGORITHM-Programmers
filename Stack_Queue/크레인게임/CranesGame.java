class CranesGame {
	public int solution(int[][] board, int[] moves) {
		int answer=0;
		Stack<Integer> s = new Stack();
		s.push(0);
		
		for(int move: moves) {
			for(int i=0; i<board.length;i++) {
				if(board[i][move-1] != 0) {
					if(s.peek()==board[i][move-1]){
						s.pop();
						answer+=2;
					}else {
						s.push(board[i][move-1]);
					}
					board[i][move-1] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
