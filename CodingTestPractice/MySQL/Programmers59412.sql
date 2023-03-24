-- 입양 시각 구하기(1)(https://school.programmers.co.kr/learn/courses/30/lessons/59412)

SELECT HOUR(DATETIME) AS HOUR, COUNT(HOUR(DATETIME)) AS COUNT -- HOUR(DATETIME), COUNT(HOUR(DATETIME)) 조회
                                                              -- 컬럼명은 HOUR, COUNT로
FROM ANIMAL_OUTS -- ANIMAL_OUTS 테이블에서
GROUP BY HOUR(DATETIME) -- HOUR(DATETIME)이 같은 것들끼리 그룹으로
HAVING HOUR >= 9 AND HOUR < 20 -- HOUR이 9이상이고, 20보다 작은 것들만
ORDER BY HOUR -- HOUR기준으로 오름차순 정렬