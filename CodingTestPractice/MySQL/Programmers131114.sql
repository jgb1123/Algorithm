-- 경기도에 위치한 식품창고 목록 출력하기

SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IF(FREEZER_YN IS NULL, 'N', FREEZER_YN) AS FREEZER_YN -- WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESSE, FREEZER_YN 조회
                                                                                                    -- FREEZER_YN 값이 NULL이면 N으로 출력, 컬럼명은 FREEZER_YN으로
FROM FOOD_WAREHOUSE -- FOOD_WAREHOUSE 테이블에서
WHERE ADDRESS LIKE '경기도%' -- ADDRESS가 경기도로 시작하는 것들만
ORDER BY WAREHOUSE_ID -- WAREHOUSE_ID기준으로 오름차순 정렬