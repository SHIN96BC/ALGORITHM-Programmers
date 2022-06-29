-- 코드를 입력하세요
SELECT ain.animal_id, ain.name 
FROM animal_ins ain, animal_outs aout
WHERE ain.datetime > aout.datetime 
AND ain.animal_id = aout.animal_id
ORDER BY ain.datetime;
