-- 먼저 중성화 여부에 따라 O 또는 X 를 출력할 컬럼이 필요하므로 CASE 문을 사용합니다.
-- 조건을 걸어서 sex_upon_intake 가 Neutered 또는 Spayed 로 시작할 경우 O 를 출력하고, 
-- 그 이외에는 X 를 출력하도록 합니다. 추가로 END as 절을 이용해서 O, X 를 출력할 컬럼의 이름을 지정해줍니다.
SELECT animal_id, name,
    CASE 
        WHEN sex_upon_intake LIKE 'Neutered%' THEN 'O'
        WHEN sex_upon_intake LIKE 'Spayed%' THEN 'O'
        ELSE 'X'
    END AS 중성화
FROM animal_ins
ORDER BY animal_id;
