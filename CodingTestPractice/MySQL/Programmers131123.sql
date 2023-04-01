-- 즐겨찾기가 가장 많은 식당 정보 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/131123)

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES -- FOOD_TYPE, REST_ID, REST_NAME, FAVORITES 조회
FROM REST_INFO -- REST_INFO 테이블에서
WHERE (FOOD_TYPE, FAVORITES) IN ( -- FOOD_TYPE과 FAVORITES이 다음에 해당하는 것들만
    SELECT FOOD_TYPE, MAX(FAVORITES) -- FOOD_TYPE, MAX(FAVORITES) 조회
    FROM REST_INFO -- REST_INFO 테이블에서
    GROUP BY FOOD_TYPE -- FOOD_TYPE이 같은것들끼리 그룹으로
)
ORDER BY FOOD_TYPE DESC -- FOOD_TYPE기준으로 내림차순 정렬