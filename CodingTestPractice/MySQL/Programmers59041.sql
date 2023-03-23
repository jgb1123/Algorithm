-- 동명 동물 수 찾기

SELECT NAME, COUNT(NAME) AS COUNT -- NAME, NAME의 수 조회
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
WHERE NAME IS NOT NULL -- NAME이 NULL이 아닌 것들만
GROUP BY NAME -- NAME이 같은 것들끼리 그룹으로
HAVING COUNT(NAME) > 1 -- COUNT(NAME)이 1보다 큰 것들만
ORDER BY NAME -- NAME을 기준으로 오름차순 정렬