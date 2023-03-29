-- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/151137)

SELECT CAR_TYPE, COUNT(*) AS CARS -- CAR_TYPE, CAR_TYPE들의 수 조회
FROM CAR_RENTAL_COMPANY_CAR -- CAR_RENTAL_COMPANY_CAR 테이블에서
WHERE OPTIONS LIKE '%통풍시트%' OR OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%가죽시트%' -- OPTIONS에 통풍시트나 열선시트나 가죽시트가 포함된 것들만
GROUP BY CAR_TYPE -- CAR_TYPE이 같은 것들끼리 그룹으로
ORDER BY CAR_TYPE -- CAR_TYPE기준으로 오름차순 정렬