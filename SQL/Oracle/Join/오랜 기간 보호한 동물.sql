-- 먼저 서브쿼리 없이 rownum <= 3 을 하면 ORDER BY 가 되지 않기 때문에 
-- 아우터 조인을 사용해서 ins 테이블에서 outs 테이블에 존재하지 않는 id 값을 찾아서 datetime 을 기준으로 ORDER BY 절을 실행하고
-- 그 쿼리문을 서브쿼리로 사용해서 rownum <= 3 을 해서 datetime 을 기준으로 위에서부터 3개만 조회할 수 있었습니다.
SELECT *
FROM (SELECT ain.name, ain.datetime 
    FROM animal_ins ain, animal_outs aout
    WHERE ain.animal_id = aout.animal_id(+)
    AND aout.animal_id IS NULL
    ORDER BY ain.datetime)
WHERE rownum <= 3;
