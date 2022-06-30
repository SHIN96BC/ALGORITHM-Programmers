-- 먼저 보호소를 나간 날짜에서 보호소를 들어온 날짜를 빼서 나온 결과값으로 ORDER BY DESC 해서 정렬합니다.
-- 이제 이 쿼리문을 서브쿼리로 사용해서 rownum 을 위에서부터 2개만 조회합니다.
SELECT animal_id, name
FROM(SELECT aout.animal_id, aout.name, 
        aout.datetime - ain.datetime as max_date
    FROM animal_ins ain, animal_outs aout
    WHERE aout.animal_id = ain.animal_id
    ORDER BY max_date DESC)
WHERE rownum <= 2;
