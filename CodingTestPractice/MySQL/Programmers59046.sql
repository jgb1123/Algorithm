SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE -- ANIMAL_ID, NAME, SEX_UPON_INTAKE 조회
FROM ANIMAL_INS -- ANIMAL_INS 테이블에서
WHERE NAME IN('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty') -- NAME이 IN안에 있는 것들만