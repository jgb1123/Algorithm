-- 강원도에 위치한 생산공장 목룍 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/131112)

SELECT FACTORY_ID, FACTORY_NAME, ADDRESS -- FACTORY_ID, FACTORY_NAME, ADDRESS 조회
FROM FOOD_FACTORY -- FOOD_FACTORY 테이블에서
WHERE ADDRESS LIKE '강원도%' -- 주소가 강원도로 시작하는것들만
ORDER BY FACTORY_ID -- FACTORY_ID를 기준으로 오름차순 정렬