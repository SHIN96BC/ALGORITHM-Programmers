public class PhoneBook{

	public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))) {
					// containsKey �� Map �� Ű ���� �ִ��� Ȯ���ϴ� �޼����̴�. 
					// ���ڷ� ���� Ű ���� ������ true �� ��ȯ�ϰ�, ������ false �� ��ȯ�Ѵ�.
					// cf) value ���� Ȯ���ϰ� ���� ��쿡�� containsValue �޼��带 ����Ѵ�.
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}