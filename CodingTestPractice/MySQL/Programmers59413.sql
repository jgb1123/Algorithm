-- 입양 시각 구하기(2)(https://school.programmers.co.kr/learn/courses/30/lessons/59413)

SET @HOUR := -1; -- @HOUR 변수 선언, 값은 -1

SELECT (@HOUR := @HOUR + 1) AS HOUR, -- +1씩 시간대가 증가
       (SELECT COUNT(*)  -- 수를 구함
        FROM ANIMAL_OUTS  -- ANIMAL_OUTS 테이블에서
        WHERE HOUR(DATETIME) = @HOUR) AS COUNT -- DATETIME의 시간이 @HOUR과 같은 것들만
FROM ANIMAL_OUTS -- ANIMAL_OUTS 테이블에서
WHERE @HOUR < 23 -- @HOUR이 23보다 작을때까지만