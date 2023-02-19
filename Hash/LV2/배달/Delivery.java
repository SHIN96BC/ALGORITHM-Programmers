class Delivery {
    public int solution(int N, int[][] road, int K) {
        // N == 마을의 개수, 
        // read == [마을번호1, 마을번호2, 두마을을 연결하는 도로를 지나는데 걸리는 시간], 
        // K == 음식배달이 가능한 시간
        // 문제: 1번 마을에 있는 음식점이 K 이하의 시간에 배달가능 지역이 몇개인지 리턴
        
        // 1번 마을도 배달이 가능하므로 배달 가능지역으로 구분한다.
        // 1번 마을과 연결된 마을이 어느 마을인지 알아야한다.
        // 1번 마을과 직접 연결된건 아니지만 1번마을과 연결된 다른 마을이 있는지 알아야한다.
        
        // Map 을 사용할지 배열을 그대로 가지고 풀지 생각중이다.
        int answer = 0;
        
        int[] intArr = new int[N];
        
        for(int i = 0; i < road.length; i++) {
            
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
