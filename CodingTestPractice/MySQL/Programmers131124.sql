-- 그룹별 조건에 맞는 식당 목록 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/131124)

SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE -- P.MEMBER_NAME, R.REVIEW_TEXT, REVIEW_DATE 조회
FROM REST_REVIEW AS R -- REST_REVIEW 테이블에
JOIN MEMBER_PROFILE AS P -- MEMBER_PROFILE 테이블 JOIN
ON R.MEMBER_ID = P.MEMBER_ID -- MEMBER_ID가 같은 조건만
WHERE R.MEMBER_ID = ( -- R.MEMBER_ID가 서브쿼리 값과 같은 것만
    SELECT MEMBER_ID -- MEMBER_ID 조회
    FROM REST_REVIEW -- REST_REVIEW 테이블에서
    GROUP BY MEMBER_ID -- MEMBER_ID가 같은 것들끼리 그룹으로
    ORDER BY COUNT(MEMBER_ID) DESC -- COUNT(MEMBER_ID)를 기준으로 내림차순 정렬
    LIMIT 1 -- 1개만 출력
)
ORDER BY REVIEW_DATE, R.REVIEW_TEXT -- REVIEW_DATE 기준으로 오름차순 정렬, 같으면 R.REVIEW_TEXT 기준으로 오름차순 정렬