-- 가격이 제일 비싼 식품의 정보 출력하기

SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE -- PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE 조회
FROM FOOD_PRODUCT -- FOOD_PRODUCT 테이블에서
ORDER BY PRICE DESC -- PRICE 기준으로 내림차순 정렬
LIMIT 1 -- 1개만