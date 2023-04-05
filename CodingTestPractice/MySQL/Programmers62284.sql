-- 우유와 요거트가 담긴 장바구니(https://school.programmers.co.kr/learn/courses/30/lessons/62284)

SELECT CART_ID -- CART_ID 조회
FROM CART_PRODUCTS -- CART_PRODUCTS 테이블에서
WHERE NAME IN('Milk', 'Yogurt') -- Milk나 Yogurt가 포함된 것들만
GROUP BY CART_ID -- CART_ID가 같은것들끼리 그룹으로
HAVING COUNT(DISTINCT NAME) = 2 -- 중복을 제거하고 그 수가 2개인 것만(우유와 밀크가 모두 하나씩은 들어있는 경우만)