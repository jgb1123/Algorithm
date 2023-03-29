-- 조건에 맞는 도서와 저자 리스트 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/144854)

SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE -- B.BOOK_ID, A.AUTHOR_NAME, B.PUBLISHED_DATE 조회
                                                                                             -- B.PUBLISHED_DATE는 %Y-%m-%d 형식으로, 컬렴명은 PUBLISHED_DATE로
FROM BOOK AS B -- BOOK 테이블에
JOIN AUTHOR AS A -- AUTHOR 테이블 조인
ON B.AUTHOR_ID = A.AUTHOR_ID -- B.AUTHOR_ID와 A.AUTHOR_ID가 같은 조건들만
WHERE CATEGORY = '경제' -- CATEGORY가 경제인 것들만
ORDER BY B.PUBLISHED_DATE -- B.PUBLISHED_DATE기준으로 오름차순 정렬렬