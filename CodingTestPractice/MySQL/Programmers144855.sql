-- 카테고리 별 도서 판매량 집계하기(https://school.programmers.co.kr/learn/courses/30/lessons/144855)

SELECT B.CATEGORY, SUM(BS.SALES) AS TOTAL_SALES --B.CATEGORY, BS.SALES의 합 조회
FROM BOOK AS B -- BOOK 테이블에
JOIN BOOK_SALES AS BS -- BOOK_SALES 테이블 JOIN
ON B.BOOK_ID = BS.BOOK_ID -- BOOK_ID가 같은 조건만
WHERE BS.SALES_DATE LIKE '2022-01%' -- BS.SALES_DATE에 2022-01이 포함되는 것들만
GROUP BY B.CATEGORY -- B.CATEGORY가 같은것들끼리 그룹으로
ORDER BY B.CATEGORY -- B.CATEGORY기준으로 오름차순 정렬