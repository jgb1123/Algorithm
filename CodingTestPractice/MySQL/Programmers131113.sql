-- 조건별로 분류하여 주문상태 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/131113)
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE, -- ORDER_ID, PRODUCT_ID, OUT_DATE, 출고여부 조회
       CASE WHEN DATEDIFF(OUT_DATE, '2022-05-01') <= 0 THEN '출고완료' -- 2022-05-01과의 차이가 0이하이면 출고완료
            WHEN DATEDIFF(OUT_DATE, '2022-05-01') > 0 THEN '출고대기' -- 2022-05-01과의 차이가 0보다 크면 출고대기
            ELSE '출고미정' END AS 출고여부 -- 그외에는 출고 미정, 컬럼명은 출고 여부로
FROM FOOD_ORDER -- FOOD_ORDER 테이블에서
ORDER BY ORDER_ID -- ORDER_ID기준으로 오름차순 정렬