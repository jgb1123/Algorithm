-- 오프라인/온라인 판매 데이터 통합하기(https://school.programmers.co.kr/learn/courses/30/lessons/131537)

SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT -- SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 조회
FROM ONLINE_SALE-- ONLINE_SALE 테이블에서
WHERE SALES_DATE >= '2022-03-01' and SALES_DATE < '2022-04-01' -- 2022년 3월인 것들만

UNION ALL -- UNION ALL

SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT -- SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 조회, USER_ID는 NULL로
FROM OFFLINE_SALE -- OFFLINE_SALE 테이블에서
WHERE SALES_DATE >= '2022-03-01' and SALES_DATE < '2022-04-01' -- 2022년 3월인 것들만

ORDER BY SALES_DATE, PRODUCT_ID, USER_ID -- SALES_DATE 기준으로 오름차순 정렬, 같으면 PRODUCT_ID 기준으로 오름차순 정렬, 같으면 USER_ID 기준으로 오름차순 정렬