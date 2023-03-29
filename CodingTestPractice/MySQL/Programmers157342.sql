-- 자동차 평균 대여 기간 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/157342)

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AS AVERAGE_DURATION -- CAR_ID, AVERAGE_DURATION 조회
                                                                                   -- AVERAGE_DURATION은 END_DATE와 START_DATE의 차이 + 1의 평균이고, 소숫점 2째자리에서 반올림
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY -- CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서
GROUP BY CAR_ID -- CAR_ID가 같은 것들끼리 그룹으로
HAVING AVERAGE_DURATION >= 7 -- AVERAGE_DURATION이 7 이상인 것들만
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC -- AVERAGE_DURATION 기준으로 내림차순 정렬, 같으면 CAR_ID 기준으로 내림차순 정렬