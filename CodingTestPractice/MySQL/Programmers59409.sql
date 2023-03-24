-- 중성화 여부 파악하기(https://school.programmers.co.kr/learn/courses/30/lessons/59409)

SELECT ANIMAL_ID, NAME, -- ANIMAL_ID, NAME, 중성화 여부 조회
IF(SEX_UPON_INTAKE LIKE '%NEUTERED%' OR SEX_UPON_INTAKE LIKE '%SPAYED%', 'O', 'X') AS 중성화 -- 만약 SEX_UPON_INTAKE에 ENEUTERED나 SPAYED가 포함되어있으면 O, 아니면 X로 출력, 컬럼명은 중성화로
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
ORDER BY ANIMAL_ID -- ANIMAL_ID 기준으로 오름차순 정렬