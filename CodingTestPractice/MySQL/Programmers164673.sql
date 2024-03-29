-- 조건에 부합하는 중고거래 댓글 조회하기

SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, -- b의 TITLE, b의 BOARD_ID, r의 REPLY_ID, r의 WRITER_ID, r의 CONTENTS, r의 CREATED_DATE 조회
       DATE_FORMAT(r.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE -- r의 CREATED_DATE는 %Y-%m-%d 형식으로, 컬럼명은 CREATED_DATE로
FROM USED_GOODS_BOARD AS b -- USED_GOODS_BOARD 테이블에 (b)
JOIN USED_GOODS_REPLY AS r -- USED_GOODS_REPLY 테이블 JOIN (r)
ON b.BOARD_ID = r.BOARD_ID -- b의 BOARD_ID와 r의 BOARD_ID가 일치하는 조건만
WHERE b.CREATED_DATE LIKE '2022-10%' -- b의 CREATED_DATE가 2022-10으로 시작하는 것들만
ORDER BY r.CREATED_DATE, b.TITLE -- r의 CREATED_DATE를 기준으로 오름차순 정렬, 같으면 b의 TITLE을 기준으로 오름차순 정렬