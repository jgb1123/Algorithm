-- 흉부외과 또는 일반외과 의사 목록 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/132203

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD -- DR_NAME, DR_ID, MCDP_CD, HIRE_YMD 조회
                                                                              -- HIRE_YMD는 %Y-%m-%d 형식으로 출력, 컬럼명 HIRE_YMD로
FROM DOCTOR -- DOCTOR 테이블에서
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS' -- MCDP_CD가 CS 혹은 GS인 것들만
ORDER BY HIRE_YMD DESC, DR_NAME -- HIRE_YMD 기준으로 내림차순 정렬, 같으면 DR_NAME 기준으로 오름차순 정렬