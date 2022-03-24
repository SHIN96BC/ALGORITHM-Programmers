class Marathon {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		// getOrDefault �� ã�� Ű�� �����Ѵٸ� ã�� Ű�� ���� ��ȯ�ϰ�, ���ٸ� �⺻���� ��ȯ�ϴ� �޼��� �̴�.
		// �����: getOrDefault(Object, V defaultValue)
		//        ù��° ���ڴ� key ��, �ι�° ���ڴ� ������ Ű�� ���ε� ���� ���� ��� ��ȯ�Ǵ� �⺻���̴�.
		// HashMap �� ������ ket ���� �߰��� ��� ���� ����Ⱑ �ǹǷ�, ���� key ���� value ���� ��� ����ϰ� ���� ��� ����Ѵ�.
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
