-- 자동차 대여 기록에서 장기/단기 대여 구분하기(https://school.programmers.co.kr/learn/courses/30/lessons/151138)

SELECT HISTORY_ID, CAR_ID, -- HISOTRY_ID, CAR_ID 조회
       DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE, -- START_DATE는 %Y-%m-%d 형식으로 조회, 컬럼명은 START_DATE로
       DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE, -- END_DATE는 %Y-%m-%d 형식으로 조회, 컬럼명은 END_DATE로
       IF(DATEDIFF(END_DATE, START_DATE) < 29, '단기 대여', '장기 대여') AS RENT_TYPE -- END_DATE와 STARTDATE의 차이가 29일 미만이면 단기대여, 29일 이상이면 장기대여, 컬럼명은 RENT_TYPE으로
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY -- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
WHERE START_DATE LIKE '2022-09%' -- START_DATE가 2022-09로 시작하는 것들만
ORDER BY HISTORY_ID DESC -- HISTORY_ID를 기준으로 내림차순 정렬