-- 년, 월, 성별 별 상품 구매 회원 수 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/131532)

SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, GENDER, COUNT(DISTINCT I.USER_ID) AS USERS -- YEAR, MONTH, GENDER, USERS 조회
                                                                                                        -- USERS는 중복을 제외한 USER_ID의 수
FROM ONLINE_SALE AS S -- ONLINE_SALE 테이블에
JOIN USER_INFO AS I -- USER_INFO 테이블 JOIN
ON S.USER_ID = I.USER_ID -- USER_ID가 같은 조건만
WHERE GENDER IS NOT NULL -- GENDER가 NULL이 아닌 것들만
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER -- YEAR, MONTH, GENDER가 같은것들끼리 그룹으로
ORDER BY YEAR(SALES_DATE), MONTH(SALES_DATE), GENDER -- YEAR 기준으로 오름차순 정렬, 같으면 MONTH 기준으로 오름차순 정렬, 같으면 GENDER 기준으로 오름차순 정렬