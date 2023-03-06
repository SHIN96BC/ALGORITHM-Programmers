class NumberOfCountry124 {

/* #1 실패 15점 문제 파악 중
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

/* #2 실패 20
    public String solution(int n) {
        String answer = "";
        
        answer = change124Number(n);
        
        return answer;
    }
    
    private String change124Number(int n) {
        StringBuffer result = new StringBuffer();
        
        // 몫(3으로 나누어질 숫자)
        int quotient = n;
        // 나머지(124 숫자를 결정하는 숫자)
        int remainder = 0;
        
        // n이 3의 배수면 패턴 0번, 아니면 1번 스타트
        int patternNum = 0;
        
        while (quotient > 0) {
            System.out.println("patternNum = " + patternNum);
            remainder = quotient % 3;
            
            System.out.println("quotient = " + quotient);
            System.out.println("remainder = " + remainder);
            
            // 나누는 숫자가 3이면 패턴을 0으로 바꿔서 계산하고 멈춥니다.
            if (quotient == 3) {
                result.insert(0, pattern(remainder, 0));
                break;
            }
            
            result.insert(0, pattern(remainder, patternNum));
            System.out.println("result = " + result.toString());
            
            if (quotient % 3 == 0 && patternNum == 0) {
                patternNum = 1;
            }
            
            quotient = quotient / 3;
            
            System.out.println();
        }
        
        return result.toString();
    }
    
    private int pattern(int remainder, int patternNum) {
        if (patternNum == 0) {
            // 패턴0 나머지가 0 == 4, 1 == 1, 2 == 2
            switch (remainder) {
                case 0:
                    return 4;
                case 1:
                    return 1;
                case 2:
                    return 2;
            }
        } else if(patternNum == 1) {
            // 패턴1 나머지가 0 == 2, 1 == 4, 2 == 1
            switch (remainder) {
                case 0:
                    return 2;
                case 1:
                    return 4;
                case 2:
                    return 1;
            }
        }
        return -1;
    }
    
    // 실패 케이스 n = 9, 27, 30, 60, 90
*/
    
    
/* #3 실패 25
        public String solution(int n) {
        String answer = "";
        
        answer = change124Number(n);
        
        return answer;
    }
    
    private String change124Number(int n) {
        StringBuffer result = new StringBuffer();
        
        // 몫(3으로 나누어질 숫자)
        int quotient = n;
        // 나머지(124 숫자를 결정하는 숫자)
        int remainder = 0;
        
        // n이 3의 배수면 패턴 0번, 아니면 1번 스타트
        int patternNum = 0;
        
        while (quotient > 0) {
            remainder = quotient % 3;
            
            // 나누는 숫자가 3이면 패턴을 0으로 바꿔서 계산하고 멈춥니다.
            if (quotient == 3) {
                result.insert(0, pattern(remainder, patternNum));
                break;
            }
            
            result.insert(0, pattern(remainder, patternNum));
            
            if (quotient % 3 == 0 && patternNum == 0) {
                patternNum = 1;
            }
            
            quotient = quotient / 3;
        }
        
        return result.toString();
    }
    
    private int pattern(int remainder, int patternNum) {
        if (patternNum == 0) {
            // 패턴0 나머지가 0 == 4, 1 == 1, 2 == 2
            switch (remainder) {
                case 0:
                    return 4;
                case 1:
                    return 1;
                case 2:
                    return 2;
            }
        } else if(patternNum == 1) {
            // 패턴1 나머지가 0 == 2, 1 == 4, 2 == 1
            switch (remainder) {
                case 0:
                    return 2;
                case 1:
                    return 4;
                case 2:
                    return 1;
            }
        }
        return -1;
    }
    // 실패 케이스 n == 60(두번째 자리가 다름), 101(끝 자리가 다름), 102(끝 자리가 다름), 108(끝 자리가 하나 김), 120(끝 자리가 하나 김)
*/
    
    
    
// #4 성공
    public String solution(int n) {
        String answer = "";
        
        answer = change124Number(n);
        
        return answer;
    }
    
    private String change124Number(int n) {
        StringBuffer result = new StringBuffer();
        
        // 몫(3으로 나누어질 숫자)
        int quotient = n;
        // 나머지(124 숫자를 결정하는 숫자)
        int remainder = 0;
        
        while (quotient > 0) {
            remainder = quotient % 3;
            
            int resultNum = pattern(remainder);
            result.insert(0, resultNum);

            quotient = quotient / 3;
            if (remainder == 0) {
                quotient = quotient - 1;
            }
        }
        
        return result.toString();
    }
    
    private int pattern(int remainder) {
        // 패턴0 나머지가 1 == 1, 2 == 2, 0 == 4
        switch (remainder) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 0:
                return 4;
        }
        return -1;
    }
    
}

/* 초기의 패턴 분석(실패 #1 ~ #3까지에 사용한 패턴)

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
                
    n = 68 -> 3의 배수 아님
                68 / 3 = 몫 22 나머지 2 ->
                22 / 3 = 몫 7, 나머지 1 ->
                7 / 3 = 몫 2, 나머지 1 ->
                2 / 3 = 몫 0, 나머지 2
                결과. 68 == 2112
                
    69 == 2114
    70 == 2121
    71 == 2122
    72 == 2124
    73 == 2141
    74 == 2142
    75 == 2144
    76 == 2211
    77 == 2212
    78 == 2214
    79 == 2221
    80 == 2222
    81 == 2224
    82 == 2241
    83 == 2242
    84 == 2244
    85 == 2411
    86 == 2412
    87 == 2414
    88 == 2421
    89 == 2422
    90 == 2424
    91 == 2441
    92 == 2442
    93 == 2444
    94 == 4111
    95 == 4112
    96 == 4114
    97 == 4121
    98 == 4122
    99 == 4124
    100 == 4141

    n = 101 -> 3의 배수 아님
                101 / 3 = 몫 33, 나머지 2 ->
                33 / 3 = 몫 11, 나머지 0 ->
                11 / 3 = 몫 3, 나머지 2 ->
                3 / 3 = 몫 1, 나머지 0 ->
                결과. 101 == 4142

    n = 102 -> 3의 배수
                102 / 3 = 몫 34, 나머지 0 ->
                34 / 3 = 몫 11, 나머지 1 -> 
                11 / 3 = 몫 3, 나머지 2 -> 
                3 / 3 = 몫 1, 나머지 0 -> 
                결과. 102 == 4144
                
     n = 103 -> 


    # 기본 패턴
        1. n을 3으로 나눈 나머지로 124 숫자를 만듭니다.
        2. n을 3으로 나눈 몫을 다시 3으로 나누며 진행합니다.
        3. 나누는숫자가 3이면 몫이 0이 아니어도 중지합니다.
        4. 첫번째 나눌때는 0번 패턴으로 진행합니다.
        5. 나누는 숫자가 3의 배수일 때 패턴이 1로 바뀝니다.
        
    # 패턴0
        1. 0(나머지) == 4(124숫자), 1 == 1, 2 == 2
            
    # 패턴1
        1. 0(나머지) == 2(124숫자), 1 == 4, 2 == 1
        
    # 해당 패턴의 문제점
        1. 마지막으로 나누어지는 숫자가 3일 때 몫이 1이 남게 되므로 한번 더 반복되는 문제(result 값이 한자리 길어짐)
        2. 3의 배수를 나누어서 나온 나머지 값이 패턴0과 패턴1에 맞는 부분과 맞지않는 부분이 생기는 문제
           (3의 배수라도 숫자마다 다른 패턴이 적용됨) 
           (3의 배수가 등장하는 횟수에 따라 바뀌는 것도 아니고, 3의 배수가 등장할 때마다 바뀌는 구조도 아니었음)
           (9, 27, 30, 60, 90에 패턴을 맞추면 101, 102가 맞지 않았음)
        
*/


/* 수정한 패턴 분석(성공 #4)
    
    # 패턴을 수정한 이유
        1. 처음에는 몫(나누어지는 수)가 3의 배수일 때 패턴이 바뀌는 구조인줄 알고 나머지가 0일 때마다 패턴을 바꾸어가며
           진행했지만, 아무리 시도를 해봐도 나머지로 패턴을 나누는 방식으로는 모든 케이스를 충족시킬 수 없음을 인지했습니다.
        2. 또한 result 패턴이 1,2,4 3가지밖에 없으므로, 몫(나누어지는 수)이 3의 배수일 때(즉, 나머지가 0일 때) 반드시 
           그 다음 result 숫자의 자릿수가 올라가게 됩니다. 
           그래서 3의 배수가 나올때마다 몫이나 나머지의 값을 보정해줘야만 합니다. 
           하지만 나머지에 따라서 result 값을 보정해주는 방법이 실패했기 때문에 몫(나누어지는 수)을 보정해주는 방법을 시도했습니다.
    
    # 수정한 패턴
        1. 몫(나누어지는 수)가 3의 배수일 때(나머지가 0일 떄) 자릿수가 하나 올라가므로, 다음으로 나누어지는 수(몫)에서 -1 해줍니다.
        2. 이렇게 자릿수가 하나 올라갈 때 몫을 -1 보정해주면 기존 패턴의 첫번째 패턴 하나만 가지고 모든 경우의 수를 충족시킬 수 있습니다.

*/
