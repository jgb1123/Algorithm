-- 과일로 만든 아이스크림 고르기(https://school.programmers.co.kr/learn/courses/30/lessons/133025)

SELECT FH.FLAVOR -- FLAVOR 조회
FROM FIRST_HALF AS FH -- FIRTS_HALF 테이블에서
JOIN ICECREAM_INFO AS II -- ICECREAM_INFO 테이블 JOIN
ON FH.FLAVOR = II.FLAVOR -- FH의 FLAVOR와 II의 FLAVOR가 일치하는 조건만
WHERE FH.TOTAL_ORDER > 3000 AND II.INGREDIENT_TYPE = 'fruit_based' -- FH의 TOTAL_ORDER가 3000초과이면서, II의 INGREDIENT_TYPE이 fruit-based인 것들만
ORDER BY TOTAL_ORDER DESC -- TOTAL_ORDER 기준으로 내림차순 정렬