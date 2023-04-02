-- 대여 기록이 존재하는 자동차 리스트 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/157341)

SELECT CAR_ID -- CAR_ID 조회
FROM CAR_RENTAL_COMPANY_CAR -- CAR_RENTAL_COMPANY_CAR 테이블에서
WHERE CAR_TYPE = '세단' AND CAR_ID IN( -- CAR_TYPE이 세단이고, 서브쿼리 결과에 해당하는 CAR_ID일 경우만
    SELECT CAR_ID -- CAR_ID 조회
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY -- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
    WHERE MONTH(START_DATE) = 10 -- START_DATE의 MONTH가 10인 경우
)
GROUP BY CAR_ID -- CAR_ID가 같은것들끼리 그룹으로
ORDER BY CAR_ID DESC -- CAR_ID 기준으로 내림차순 정렬