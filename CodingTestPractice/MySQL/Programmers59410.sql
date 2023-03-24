-- NULL 처리하기(https://school.programmers.co.kr/learn/courses/30/lessons/59410)

SELECT ANIMAL_TYPE, IF(NAME IS NULL, 'No name', NAME) AS NAME, SEX_UPON_INTAKE -- ANIMAL_TYPE, NAME, SEX_UPON_INTAKE 조회
                                                                               -- NAME이 NULL이면 No name으로 출력, 컬럼명은 NAME으로
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
ORDER BY ANIMAL_ID -- ANIMAL_ID 기준으로 오름차순 정렬