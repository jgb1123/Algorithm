-- 이름에 el이 들어가는 동물 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/59047)

SELECT ANIMAL_ID, NAME -- ANIMAL_ID, NAME 조회
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
WHERE ANIMAL_TYPE = 'Dog' AND NAME LIKE '%el%' -- ANIMAL_TYPE이 Dog이면서, NAME에 el이 들어가는 것들만
ORDER BY NAME -- NAME을 기준으로 오름차순 정렬