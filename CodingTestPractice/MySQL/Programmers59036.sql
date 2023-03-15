-- 아픈 동물 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/59036)

SELECT ANIMAL_ID, NAME -- ANIMAL_ID와 NAME 조회
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
WHERE INTAKE_CONDITION = 'Sick' -- INTAKE_CONDITION이 Sick인 것들만