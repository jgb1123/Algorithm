-- 재구매가 일어난 상품과 회원 리스트 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/131536)

SELECT USER_ID, PRODUCT_ID -- USER_ID, PRODUCT_ID 조회
FROM ONLINE_SALE -- ONLINE_SALE 테이블에서
GROUP BY USER_ID, PRODUCT_ID -- USER_ID와 PRODUCT_ID가 같은것들끼리 그룹으로
HAVING COUNT(*) > 1 -- 그 수가 2개 이상인 것들만
ORDER BY USER_ID, PRODUCT_ID DESC -- USER_ID기준으로 오름차순 정렬, 같으면 PRODUCT_ID기준으로 내림차순 정렬