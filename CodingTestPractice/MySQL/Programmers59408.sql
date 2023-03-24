-- 중복 제거하기(https://school.programmers.co.kr/learn/courses/30/lessons/59408)

SELECT COUNT(DISTINCT NAME) AS count -- 중복 및 NULL을 제외하고 NAME의 수를 조회, 컬럼명은 count로
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서