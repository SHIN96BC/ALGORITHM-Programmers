public class PhoneNumberHide {
	public String solution(String phone_number) {
        String answer = "";
        String star = "";
        
        String num = phone_number.substring(phone_number.length()-4);
        for(int i=0; i<phone_number.length()-4; i++){
            star += "*";
        }
        answer = star + num;
        return answer;
    }
}
