-- 조건에 부합하는 중고거래 상태 조회하기(https://school.programmers.co.kr/learn/courses/30/lessons/164672)

SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, -- BOARD_ID, WRITER_ID, TITLE, PRICE, STATUS 조회
       CASE WHEN (STATUS = 'SALE') THEN '판매중' -- STATUS는 SALE이면 판매중, RESERVED면 예약중, 그외에는 거래완료로
            WHEN (STATUS = 'RESERVED') THEN '예약중'
            ELSE '거래완료'
       END AS 'STATUS' -- 컬럼명은 STATUS로
FROM USED_GOODS_BOARD -- USED_GOODS_BOARD 테이블에서
WHERE DATE_FORMAT(CREATED_DATE, '%Y-%m-%d') = '2022-10-05' -- CREATED_DATE가 2022-10-05인 것들만
ORDER BY BOARD_ID DESC -- BOARD_ID 기준으로 내림차순 정렬