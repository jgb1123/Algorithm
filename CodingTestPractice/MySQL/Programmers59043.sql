-- 있었는데요 없었습니다(https://school.programmers.co.kr/learn/courses/30/lessons/59043)

SELECT AI.ANIMAL_ID, AI.NAME -- AI.ANIMAL_ID, AI.NAME 조회
FROM ANIMAL_INS AS AI -- ANIMAL_INS 테이블에
JOIN ANIMAL_OUTS AS AO -- ANIMAL_OUTS 테이블 조인
ON AI.ANIMAL_ID = AO.ANIMAL_ID -- ANIMAL_ID가 같은 조건들만
WHERE AO.DATETIME <= AI.DATETIME -- AO.DATETIME이 AI.DATETIME 이하인 것들만
ORDER BY AI.DATETIME -- AI.DATETIME기준으로 오름차순 정렬