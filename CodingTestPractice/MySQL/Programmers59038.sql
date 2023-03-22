-- 최솟값 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/59038)

SELECT MIN(DATETIME) AS 시간 -- DATETIME의 최솟값 조회, 컬럼명은 시간으로
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서