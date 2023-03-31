-- 오랜 기간 보호한 동물(2)(https://school.programmers.co.kr/learn/courses/30/lessons/59411)

SELECT AO.ANIMAL_ID, AO.NAME -- AO.ANIMAL_ID, AO.NAME 조회
FROM ANIMAL_OUTS AS AO -- ANIMAL_OUTS 테이블에
JOIN ANIMAL_INS AS AI -- ANIMAL_INS 테이블 JOIN
ON AO.ANIMAL_ID = AI.ANIMAL_ID -- ANIMAL_ID가 같은 조건만
ORDER BY AO.DATETIME - AI.DATETIME DESC -- AO.DATETIME - AI.DATETIME을 기준으로 내림차순 정렬 (보호기간이 가장 긴 순으로)
LIMIT 2 -- 2개만 출력