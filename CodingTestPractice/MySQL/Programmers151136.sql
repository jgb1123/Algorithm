-- 평균 일일 대여 요금 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/151136)

SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE -- DAILY_FEE의 평균값을 소숫점 첫째자리에서 반올림한 값 조회, 컬럼명은 AVERAGE_FEE로
FROM CAR_RENTAL_COMPANY_CAR -- CAR_RENTAL_COMPANY_CAR 테이블에서
WHERE CAR_TYPE = 'SUV' -- CAR_TYPE이 SUV인 것들만