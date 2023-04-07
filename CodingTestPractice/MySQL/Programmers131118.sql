-- 서울에 위치한 식당 목록 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/131118)

SELECT R.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(R.REVIEW_SCORE), 2) AS SCORE -- R.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, SCORE 조회
                                                                                                           -- R.REVIEW_SCORE의 평균을 구하고 소숫점 3째자리에서 반올림, 컬럼명은 SCORE로
FROM REST_REVIEW AS R -- REST_REVIEW 테이블에
JOIN REST_INFO AS I -- REST_INFO 테이블 JOIN
ON R.REST_ID = I.REST_ID -- REST_ID가 같은 조건만
WHERE I.ADDRESS LIKE '서울%' -- I.ADDRESS에 서울이 포함되는 것들만
GROUP BY R.REST_ID -- R.REST_ID가 같은것들끼리 그룹으로
ORDER BY SCORE DESC, I.FAVORITES DESC -- SCORE 기준으로 내림차순 정렬, 같으면 I.FAVORITES 기준으로 내림차순 정렬