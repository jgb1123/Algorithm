-- 여러 기준으로 정렬하기(https://school.programmers.co.kr/learn/courses/30/lessons/59404)

SELECT ANIMAL_ID, NAME, DATETIME -- ANIMAL_ID, NAME, DATETIME 조회
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
ORDER BY NAME, DATETIME DESC -- NAME 순으로 정렬, NAME이 같으면 DATETIME 역순으로 정렬