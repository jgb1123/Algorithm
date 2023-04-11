-- 취소되지 않은 진료 예약 조회하기(https://school.programmers.co.kr/learn/courses/30/lessons/132204)

SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD -- A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD 조회
FROM APPOINTMENT AS A -- APPOINTMENT 테이블에
JOIN PATIENT AS P -- PATIENT 테이블 JOIN
ON P.PT_NO = A.PT_NO -- PT_NO가 같은 조건만
JOIN DOCTOR AS D -- DOCTOR 테이블 JOIN
ON D.DR_ID = A.MDDR_ID -- D.DR_ID와 A.MDDR_ID가 같은 조건만
WHERE DATE_FORMAT(A.APNT_YMD, '%Y-%m-%d') = '2022-04-13' -- 2022년 4월 13이고,
      AND A.APNT_CNCL_YN = 'N' -- A.APNT_CNCL_YN이 N이고,
      AND A.APNT_CNCL_YMD IS NULL -- A.APNT_CNCL_YMD가 NULL인 것들만
ORDER BY A.APNT_YMD, P.PT_NO -- A.APNT_YMD 기준으로 오름차순 정렬, 같으면 P.PT_NO 기준으로 오름차순 정렬