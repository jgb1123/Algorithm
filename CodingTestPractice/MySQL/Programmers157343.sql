-- 특정 옵션이 포함된 자동차 리스트 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/157343)

SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS -- CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS 조회
FROM CAR_RENTAL_COMPANY_CAR -- CAR_RENTAL_COMPANY_CAR 테이블에서
WHERE OPTIONS LIKE '%네비게이션%' -- 네비게이션이 포함된 것들만
ORDER BY CAR_ID DESC -- CAR_ID 기준으로 내림차순 정렬렬