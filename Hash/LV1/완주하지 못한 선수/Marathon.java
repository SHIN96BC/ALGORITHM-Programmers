class Marathon {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		// getOrDefault 는 찾는 키가 존재한다면 찾는 키의 값을 반환하고, 없다면 기본값을 반환하는 메서드 이다.
		// 사용방법: getOrDefault(Object, V defaultValue)
		//        첫번째 인자는 key 값, 두번째 인자는 지정된 키로 매핑된 값이 없는 경우 반환되는 기본값이다.
		// HashMap 은 동일한 ket 값을 추가할 경우 값이 덮어쓰기가 되므로, 기존 key 값의 value 값을 계속 사용하고 싶을 경우 사용한다.
		for (String player : completion) hm.put(player, hm.get(player) - 1);

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0){
				answer = key;
				break;
			}
		}
		return answer;
	}
}
