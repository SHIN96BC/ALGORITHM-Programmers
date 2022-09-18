class StringBasic {
    public boolean solution(String s) {
        
        try {
            int num = Integer.parseInt(s);
            
            if (s.length() == 4 || s.length() == 6) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }

    }
}
