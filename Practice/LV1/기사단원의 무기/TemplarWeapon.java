class TemplarWeapon {
    public int solution(int number, int limit, int power) {
        
        int[] weaponArr = new int[number];
        
        for (int i = 0; i < number; i++) {
            weaponArr[i] = getDivisorCount(i + 1, limit, power);
        }
        
        return getAllArrayPlus(weaponArr);
    }
    
    private int getDivisorCount(int number, int limit, int power) {
        int count = 0;
        
        // 약수를 구하는 과정에서 시간초과가 발생해서 효율적으로 약수를 구하는 방법을 사용했습니다.
        for (int i = 1; i * i < number + 1; i++) {
            if (i * i == number)
                count++;
            else if (number % i == 0)
                count += 2;
        }
        
        // 공격력 제한 수치를 넘었을 때는 power로 변경
        if (count > limit) {
            count = power;
        }
        
        return count;
    }
    
    private int getAllArrayPlus(int[] numbers) {
        int total = 0;
        
        for (int number: numbers)
            total += number;
        
        return total;
    }
}
