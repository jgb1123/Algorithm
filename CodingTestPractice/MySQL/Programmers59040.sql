-- 고양이와 개는 몇 마리 있을까(https://school.programmers.co.kr/learn/courses/30/lessons/59040)

SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS count -- ANIMAL_TYPE, ANIMAL_TYPE 수 조회
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
GROUP BY ANIMAL_TYPE -- ANIMAL_TYPE이 같은 것들끼리 그룹으로
ORDER BY ANIMAL_TYPE -- ANIMAL_TYPE 기준으로 오름차순 정렬(CAT이 먼저 옴)