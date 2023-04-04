-- 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기(https://school.programmers.co.kr/learn/courses/30/lessons/164671)

SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH -- /home/grep/src, F.BOARD_ID, /, F.FILE_ID/F, FILE_NAME, F.FILE_EXT
FROM USED_GOODS_FILE AS F -- USED_GOODS_FILE 테이블에
JOIN USED_GOODS_BOARD AS B -- USED_GOODS_BOARD 테이블 JOIN
ON F.BOARD_ID = B.BOARD_ID -- BOARD_ID가 같은 조건만
WHERE VIEWS = ( -- VIEWS가 가장 큰 것들만
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD
)
ORDER BY FILE_ID DESC -- FILE_ID를 기준으로 내림차순 정렬