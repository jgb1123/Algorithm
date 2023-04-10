-- 5월 식품들의 총매출 조회하기(https://school.programmers.co.kr/learn/courses/30/lessons/131117)

SELECT O.PRODUCT_ID, P.PRODUCT_NAME, SUM(O.AMOUNT * P.PRICE) AS TOTAL_SALES -- O.PRODUCT_ID, P.PRODUCT_NAME, TOTAL_SALES(SUM(O.AMOUNT * P.PRICE)) 조회
FROM FOOD_ORDER AS O -- FOOD_ORDER 테이블에
JOIN FOOD_PRODUCT AS P -- FOOD_PRODUCT 테이블 JOIN
ON O.PRODUCT_ID = P.PRODUCT_ID -- PRODUCT_ID가 같은 조건만
WHERE O.PRODUCE_DATE >= '2022-05-01' AND O.PRODUCE_DATE < '2022-06-01' -- O.PRODUCE_DATE가 5월인 것들만
GROUP BY O.PRODUCT_ID -- O.PRODUCT_ID가 같은것들끼리 그룹으로
ORDER BY TOTAL_SALES DESC, O.PRODUCT_ID -- TOTAL_SALES 기준으로 내림차순 정렬, O.PRODUCT_ID 기준으로 오름차순 정렬