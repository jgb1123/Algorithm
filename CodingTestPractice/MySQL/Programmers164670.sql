-- 조건에 맞는 사용자 정보 조회하기(https://school.programmers.co.kr/learn/courses/30/lessons/164670)

SELECT DISTINCT U.USER_ID, U.NICKNAME, -- U.USER_ID, U.NICKNAME, 전체주소, 전화번호 조회
    CONCAT_WS(' ', U.CITY,U.STREET_ADDRESS1,U.STREET_ADDRESS2) AS 전체주소, -- 공백으로 U.CITY, U.STREET_ADDRESS1, U.STREET_ADDRESS2 이어붙이기, 컬럼명은 전체주소로
    CONCAT_WS('-', SUBSTRING(TLNO, 1, 3), SUBSTRING(TLNO, 4, 4), SUBSTRING(TLNO, 8, 4)) AS 전화번호 -- 1~3번째 글자, 4~7번째 글자, 8~11번째 글짜 '-'로 이어붙이기, 컬럼명은 전화번호로
FROM USED_GOODS_BOARD AS B -- USER_GOODS_BOARD 테이블에
JOIN USED_GOODS_USER AS U -- USED_GOODS_USER 테이블 JOIN
ON B.WRITER_ID = U.USER_ID -- B.WRITER_ID와 U.USER_ID가 같은 조건들만
WHERE U.USER_ID IN ( -- 서브쿼리에 해당하는 것들만
    SELECT WRITER_ID -- WRITER_ID 조회
    FROM USED_GOODS_BOARD -- USED_GOODS_BOARD 테이블에서
    GROUP BY WRITER_ID -- WRITER_ID가 같은 것들끼리 그룹으로
    HAVING COUNT(*) >= 3 -- 그 WRITER_ID 수가 3개 이상인 것들만
)
ORDER BY U.USER_ID DESC; -- U.USER_ID 기준으로 내림차순 정렬