class MinimalRectangle {
    public int solution(int[][] sizes) {
        int answer = 1;
        
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            // 지갑을 회전시켜도 되므로 가장 긴 길이를 가로라고 합니다.
            int width = sizes[i][0];
            int height = sizes[i][1];
            if (height > width) {
                int tempSize = height;
                height = width;
                width = tempSize;
            }
            
            // 가로와 세로의 최대값을 구합니다.
            if (width > maxWidth)
                maxWidth = width;
            
            if (height > maxHeight)
                maxHeight = height;
        }
        
        // 가로와 세로의 최대값을 곱하면 모든 지갑이 들어가는 최소 크기가 나옵니다.
        answer = maxWidth * maxHeight;
        
        return answer;
    }
}
