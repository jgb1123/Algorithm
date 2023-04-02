-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기(https://school.programmers.co.kr/learn/courses/30/lessons/157340)

SELECT CAR_ID, -- CAR_ID, AVAILABILITY 조회
       CASE
            WHEN CAR_ID IN( -- 서브쿼리에 해당하는 CAR_ID일 경우
                SELECT CAR_ID -- CAR_ID 조회
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY -- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
                WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' -- START_DATE가 2022-10-16 이하이고, END_DATE가 2022-10-16 이상이면
            ) THEN '대여중' -- 대여중
            ELSE '대여 가능' -- 그외에는 대여 가능
       END AS 'AVAILABILITY' -- 컬럼명은 AVAILABILITY로
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY -- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
GROUP BY CAR_ID -- CAR_ID가 같은것들끼리 그룹으로
ORDER BY CAR_ID DESC -- CAR_ID기준으로 내림차순 정렬렬