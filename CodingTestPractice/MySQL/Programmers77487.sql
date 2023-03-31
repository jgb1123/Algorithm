-- 헤비 유저가 소유한 장소(https://school.programmers.co.kr/learn/courses/30/lessons/77487)

SELECT ID, NAME, HOST_ID -- ID, NAME, HOST_ID 조회
FROM PLACES -- PLACES 테이블에서
WHERE HOST_ID IN( -- 장소를 2개 이상 대여한 HOST_ID에 해당하는 것들만
    SELECT HOST_ID -- 장소를 2개 이상 대여한 HOST_ID를 조회하는 쿼리
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*)>1
)
ORDER BY ID -- ID를 기준으로 오름차순 정렬