-- 이름이 있는 동물의 아이디(https://school.programmers.co.kr/learn/courses/30/lessons/59407)

SELECT ANIMAL_ID -- ANIMAL_ID 조회
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
WHERE NAME IS NOT NULL -- NAME이 NULL이 아닌것들만