-- 가장 비싼 상품 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/131697)

SELECT MAX(PRICE) AS MAX_PRICE -- PRICE컬럼의 가장 큰 값을 조회, 컬럼명은 MAX_PRICE로
FROM PRODUCT -- PRODUCT 테이블에서