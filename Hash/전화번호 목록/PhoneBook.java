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
					// containsKey 는 Map 에 키 값이 있는지 확인하는 메서드이다. 
					// 인자로 보낸 키 값이 있으면 true 를 반환하고, 없으면 false 를 반환한다.
					// cf) value 값을 확인하고 싶은 경우에는 containsValue 메서드를 사용한다.
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}