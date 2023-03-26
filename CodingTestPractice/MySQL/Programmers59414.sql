-- DATETIME에서 DATE로 형 변환

SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜 -- ANIMAL_ID, NAME, 날짜 조회
                                                                 -- DATE
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
ORDER BY ANIMAL_ID -- ANIMAL_ID 기준으로 오름차순 정렬