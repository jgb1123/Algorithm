-- 저자 별 카테고리 별 매출액 집계하기(https://school.programmers.co.kr/learn/courses/30/lessons/144856)

SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM((S.SALES * B.PRICE)) AS TOTAL_SALES -- A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, TOTAL_SALES 조회
                                                                                       -- TOTAL_SALES는 S.SALES * B.PRICE
FROM BOOK_SALES S -- BOOK_SALES 테이블에
JOIN BOOK B -- BOOK 테이블 JOIN
ON S.BOOK_ID = B.BOOK_ID -- BOOD_ID가 같은 조건만
JOIN AUTHOR A -- AUTHOR 테이블 JOIN
ON B.AUTHOR_ID = A.AUTHOR_ID -- AUTHOR_ID가 같은 조건만
WHERE S.SALES_DATE LIKE '2022-01%' -- S.SALES_DATE에 2022-01이 포함된 것들만
GROUP BY B.CATEGORY, A.AUTHOR_ID -- B.CATEGORY와, A.AUTHOR_ID가 같은 것들끼리 그룹으로
ORDER BY A.AUTHOR_ID, B.CATEGORY DESC -- A.AUTHOR_ID 기준으로 오름차순 정렬, 같으면 B.CATEGORY 기준으로 내림차순 정렬