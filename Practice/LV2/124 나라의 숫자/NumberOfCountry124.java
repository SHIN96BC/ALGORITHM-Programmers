class NumberOfCountry124 {

/* # 실패 15점 문제 파악 중
    public String solution(int n) {
        String answer = "";
        
        answer = change124Number(n);
        
        return answer;
    }
    
    private String change124Number(int decimalNumber) {
        StringBuffer result = new StringBuffer();
        
        // 3의 배수인지 여부 0이면 3의배수
        int multipleOf3 = decimalNumber % 3;
        
        // 몫(3으로 나누어질 숫자)
        int quotient = decimalNumber;
        // 나머지(124 숫자를 결정하는 숫자)
        int remainder = 0;
        boolean isFirst = true;
        
        while (quotient > 0) {
            remainder = quotient % 3;
            
            if (multipleOf3 == 0) {
                // 3의 배수인 경우
                if (isFirst) {
                    // 1의자리 숫자를 결정하는 첫번째는 나머지가 0 == 4, 1 == 1, 2 == 2
                    switch (remainder) {
                        case 0:
                            result.append(4);
                            break;
                        case 1:
                            result.append(1);
                            break;
                        case 2:
                            result.append(2);
                            break;
                    }
                    // n이 1자리수인 경우 몫이 남아있어도 반복문이 끝나도록 합니다.
                    if (quotient < 10) {
                        quotient = 0;
                    }
                    isFirst = false;
                } else {
                    // 1의자리를 제외하고는 나머지가 0 == 2, 1 == 4, 2 == 1
                    switch (remainder) {
                        case 0:
                            result.insert(0, 2);
                            break;
                        case 1:
                            result.insert(0, 4);
                            break;
                        case 2:
                            result.insert(0, 1);
                            break;
                    }
                }
            } else {
                // 3의 배수가 아닌 경우
                // 나머지가 0 == 4, 1 == 1, 2 == 2
                switch (remainder) {
                    case 0:
                        result.append(4);
                        break;
                    case 1:
                        result.append(1);
                        break;
                    case 2:
                        result.append(2);
                        break;
                }
            }
            quotient = quotient / 3;
        }
        
        return result.toString();
    }
*/
    
    public String solution(int n) {
        String answer = "";
        
        return answer;
    }
}

/* 패턴 분석

    1 == 1
    2 == 2
        3 == 4     몫 = 1
    4 == 11
    5 == 12
        6 == 14     몫 = 2
    7 == 21
    8 == 22
        9 == 24     몫 = 3
    10 == 41
    11 == 42
        12 == 44     몫 = 4
    13 == 111
    14 == 112
        15 == 114     몫 = 5
    16 == 121
    17 == 122
        18 == 124     몫 = 6
    19 == 141
    20 == 142
        21 == 144     몫 = 7
    22 == 211
    23 == 212
        24 == 214     몫 = 8
    25 == 221
    26 == 222
        27 == 224     몫 = 9
    28 == 241
    29 == 242
        30 == 244     몫 = 10
    31 == 411
    32 == 412
        33 == 414     몫 = 11
    34 == 421
    35 == 422
        36 == 424     몫 = 12
    37 == 441
    38 == 442
        39 == 444     몫 = 13
    40 == 1111
    41 == 1112
        42 == 1114     몫 = 14
    43 == 1121
    44 == 1122
        45 == 1124     몫 = 15
    46 == 1141
    47 == 1142
        48 == 1144     몫 = 16
    49 == 1211
    50 == 1212
        51 == 1214     몫 = 17
    52 == 1221
    53 == 1222
        54 == 1224     몫 = 18
    55 == 1241
    56 == 1242
        57 == 1244     몫 = 19
    58 == 1411
    59 == 1412
        60 == 1414     몫 = 20
    61 == 1421
    62 == 1422
        63 == 1424     몫 = 21
    64 == 1441
    65 == 1442
    
    
    n = 66 -> 3의 배수
                66 / 3 = 몫 22, 나머지 0 ->
                22 / 3 = 몫 7, 나머지 1 -> 
                7 / 3 = 몫 2, 나머지 1 -> 
                2 / 3 = 몫 0, 나머지 2 ->
                결과. 66 == 1444
        
        
    n = 67 -> 3의 배수 아님
                67 / 3 = 몫 22, 나머지 1 ->
                22 / 3 = 몫 7, 나머지 1 ->
                7 / 3 = 몫 2, 나머지 1 ->
                2 / 3 = 몫 0, 나머지 2
                결과. 67 == 2111


    n = 102 -> 3의 배수
                102 / 3 = 몫 34, 나머지 0 첫번째로 나누었으므로 1의 자리는 4 ->
                34 / 3 = 몫 11, 나머지 1 나머지가 1이므로 10의 자리는 4 -> 
                11 / 3 = 몫 3, 나머지 2 나머지가 2이므로 100의 자리는 1 -> 
                3 / 3 = 몫 1, 나머지 0 나머지가 0이므로 1000의 자리는 2 -> 
                1 / 3 = 몫 0, 나머지 1 나머지가 1이므로 10000의 자리는 4 ->
                결과. 102 == 42144


    # 기본 패턴
        1. n을 3으로 나눈 나머지가 0이면 2, 1이면 4, 2이면 1 이다.
        2. n을 3으로 나눈 몫을 다시 3으로 나누며 진행한다.
        
    # 3의 배수일 때
        1. 3의 배수의 경우에는 1의자리만 0(나머지) == 4(124숫자), 1 == 1, 2 == 2 이다.
        2. 10의 자리부터는 0(나머지) == 2(124숫자), 1 == 4, 2 == 1
            
    # 3의 배수가 아닐 떄
        1. 0(나머지) == 4(124숫자), 1 == 1, 2 == 2
*/
