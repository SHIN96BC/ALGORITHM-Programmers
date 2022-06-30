-- 이너 조인을 사용해서 ins 테이블의 datetime 보다 outs 테이블의 datetime 이 더 작은 데이터들을 조회합니다.
SELECT ain.animal_id, ain.name 
FROM animal_ins ain, animal_outs aout
WHERE ain.datetime > aout.datetime 
AND ain.animal_id = aout.animal_id
ORDER BY ain.datetime;
