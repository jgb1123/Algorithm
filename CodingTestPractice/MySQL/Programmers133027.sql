-- 주문량이 많은 아이스크림들 조회하기(https://school.programmers.co.kr/learn/courses/30/lessons/133027)

SELECT FH.FLAVOR -- FH.FLAVOR 조회
FROM FIRST_HALF AS FH -- FIRST_HALF 테이블에
JOIN(SELECT FLAVOR, TOTAL_ORDER -- JULY 테이블에서 FLAVOR, TOTAL_ORDER만 조회한 테이블 JOIN
     FROM JULY
) AS J
ON FH.FLAVOR = J.FLAVOR -- FLAVOR가 같은 조건만
GROUP BY FLAVOR -- FLAVOR가 같은것들끼리 그룹으로
ORDER BY SUM(FH.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC -- FH.TOTAL_ORDER의 총 합 + J.TOTAL_ORDRE의 총 합 기준으로 내림차순 정렬
LIMIT 3 -- 3개만 출력