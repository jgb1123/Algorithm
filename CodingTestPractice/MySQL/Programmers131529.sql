-- 카테고리 별 상품 개수 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/131529)

SELECT LEFT(PRODUCT_CODE, 2) AS CATEGORY, COUNT(PRODUCT_ID) AS PRODUCTS -- CATEGORY, PRODUCTS 조회
                                                                        -- PRODUCT_CODE의 앞 2글자는 CATEGORY로, 개수를 PRODUCTS로
FROM PRODUCT -- PRODUCT 테이블에서
GROUP BY CATEGORY -- CATEGORY가 같은것들끼리 그룹으로
ORDER BY CATEGORY -- CATEGORY를 기준으로 오름차순 정렬