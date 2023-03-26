-- 상품 별 오프라인 매출 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/131533)

SELECT PRODUCT_CODE, SUM(P.PRICE * O.SALES_AMOUNT) AS SALES -- PRODUCT_CODE, SALES 조회
                                                            -- P의 PRICE와 O의 SALES_AMOUNT의 곱을 SALES로
FROM PRODUCT P -- PRODUCT 테이블에
JOIN (SELECT PRODUCT_ID, SALES_AMOUNT FROM OFFLINE_SALE) AS O -- OFFLINE_SALE 테이블을 JOIN
ON P.PRODUCT_ID = O.PRODUCT_ID -- PRODUCT_ID가 같은 조건들만
GROUP BY P.PRODUCT_ID -- P의 PRODUCT_ID가 같은것들 끼리 그룹으로
ORDER BY SALES DESC, P.PRODUCT_CODE -- SALES 기준으로 내림차순 정렬, 같으면 P의 PRODUCT_CODE 기준으로 오름차순 정렬