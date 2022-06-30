-- 먼저 대소문자 구분없이 el 이 들어간 이름을 찾아야 하므로 조회하는 name 값을 LOWER case 를 사용해서 
-- 소문자로 바꿔서 LIKE 절의 %el%, 즉 앞뒤로 el 이 들어간 name 값들을 찾습니다.
-- (LIKE 절의 % 는 문자의 앞에적으면(ex: %el) 해당 문자로 끝나는 문자를 찾고, 뒤에 적으면(ex: el%) 해당 문자로 시작하는 문자를 찾고 
--  양쪽에 적으면 문자 전체에서 el 이 있는 문자를 조회할 수 있습니다.)
-- 그리고 그중에서 type 이 Dog 인 값들만 조회해서 name 순으로 정렬합니다.

SELECT animal_id, name
FROM animal_ins
WHERE LOWER(name) LIKE '%el%'
AND animal_type = 'Dog'
ORDER BY name;
