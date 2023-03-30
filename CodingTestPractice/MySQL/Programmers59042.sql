-- 없어진 기록 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/59042)

SELECT AO.ANIMAL_ID, AO.NAME -- AO.ANIMAL_ID, AO.NAME 조회
FROM ANIMAL_OUTS AS AO -- ANIMAL_OUT 테이블에
LEFT JOIN ANIMAL_INS AS AI -- ANIMAL_INS 테이블 LEFT JOIN
ON AO.ANIMAL_ID = AI.ANIMAL_ID -- ANIMAL_ID가 같은 조건들만
WHERE AI.ANIMAL_ID IS NULL -- AI.ANIMAL_ID가 NULL인 것들만