-- 조건에 맞는 도서 리스트 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/144853)

SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE -- BOOK_ID, PUBLISHED_DATE 조회
                                                                          -- PUBLISHED_DATE 는 %Y-%m-%d 형식으로 출력, 컬럼명은 PUBLISHED_DATE로
FROM BOOK -- BOOK 테이블에서
WHERE CATEGORY = '인문' AND PUBLISHED_DATE LIKE '2021%' -- CATEGORY는 인문이면서, PUBLISHED_DATE는 2021로 시작하는
ORDER BY PUBLISHED_DATE -- PUBLISHED_DATE 기준으로 오름차순 정렬