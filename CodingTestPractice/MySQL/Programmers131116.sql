-- 식품분류별 가장 비싼 식품의 정보 조회하기(https://school.programmers.co.kr/learn/courses/30/lessons/131116)

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME -- CATEGORY, PRICE, PRODUCT_NAME 조회
FROM FOOD_PRODUCT -- FOOD_PRODUCT 테이블에서
WHERE (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE) -- CATEGORY와 PRICE가 서브쿼리의 결과에 해당하는 것들만, CATEGORY, MAX(PRICE) 조회
                            FROM FOOD_PRODUCT -- FOOD_PRODUCT 테이블에서
                            WHERE CATEGORY IN ('과자', '국', '김치', '식용유') -- CATEGORY가 과자, 국, 김치, 식용유인 것들만
                            GROUP BY CATEGORY -- CATEGORY가 같은것들끼리 그룹으로
)
ORDER BY PRICE DESC -- PRICE 기준으로 내림차순 정렬