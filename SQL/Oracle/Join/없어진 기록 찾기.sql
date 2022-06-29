-- 아우터 조인을 사용해서 animal_outs 테이블을 기준으로 셀렉문을 작성합니다.
-- animal_ins 테이블과 animal_outs 테이블에서 같은 id 를 가진 값들 중에 animal_ins 에 id 값이 null 인 값들을 출력합니다.
SELECT aout.animal_id, aout.name 
From animal_ins ain RIGHT OUTER JOIN animal_outs aout 
ON aout.animal_id = ain.animal_id 
WHERE ain.animal_id IS NULL
ORDER BY aout.animal_id;

-- RIGHT OUTER JOIN 말고 (+) 로도 아우터 조인을 할 수 있습니다.
SELECT aout.animal_id, aout.name 
From animal_ins ain, animal_outs aout 
WHERE aout.animal_id = ain.animal_id(+)
AND ain.animal_id IS NULL
ORDER BY aout.animal_id;
