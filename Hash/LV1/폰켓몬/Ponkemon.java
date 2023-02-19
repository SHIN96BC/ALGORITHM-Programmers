class Ponkemon {
	public int solution(int[] nums) {
        int answer = 0;
        Vector<Integer> v = new Vector<>();

        for(int p: nums) {
        	if(v.size() == nums.length/2) return v.size();
        	for(int i=0; i<v.size(); i++) {
        		if(p == v.get(i)) {
        			v.remove(i);
        			break;
        		}
        	}
        	v.add(p);
        }
        return v.size();
    }
}
