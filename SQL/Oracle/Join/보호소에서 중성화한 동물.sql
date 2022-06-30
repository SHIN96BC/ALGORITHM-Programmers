-- 이너 조인을 사용해서 먼저 outs 테이블의 sex_upon_outcome 와 ins 테이블의 sex_upon_intake 가 같지 않다면 
-- 보호소에 들어올때는 중성화가 되지 않았고, 보호소를 나갈때는 중성화가 되어서 나갔다는 말이됩니다.
-- 또한 outs 테이블에 있는 데이터만을 조회하기 위해 id 값이 같은 데이터만 출력하도록 합니다.
SELECT aout.animal_id, aout.animal_type, aout.name
FROM animal_ins ain, animal_outs aout
WHERE aout.sex_upon_outcome != ain.sex_upon_intake
AND aout.animal_id = ain.animal_id
ORDER BY aout.animal_id;
