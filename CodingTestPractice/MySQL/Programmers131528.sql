-- 나이 정보가 없는 회원 수 구하기

SELECT COUNT(*) AS USER -- 개수를 구해서 컬럼명 USER로
FROM USER_INFO -- USER_INFO 테이블에서
WHERE AGE IS NULL -- AGE가 NULL인 값들만