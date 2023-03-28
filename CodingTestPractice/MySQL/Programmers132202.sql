-- 진료과별 총 예약 횟수 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/132202)

SELECT MCDP_CD AS 진료과코드, COUNT(*) AS 5월예약건수 -- MCDP_CD 컬럼명 진료과 코드로, 해당 그룹의 수를 컬럼명 5월의예약건수로 조회
FROM APPOINTMENT -- APPOINTMENT 테이블에서
WHERE APNT_YMD LIKE '2022-05-%' -- APNT_YMD가 2022-05-로 시작하는 것들만
GROUP BY MCDP_CD -- MCDP_CD가 같은것들끼리 그룹으로
ORDER BY 5월예약건수, 진료과코드 -- 5월예약건수 기준으로 오름차순 정렬, 같으면 진료과코드 기준으로 오름차순 정렬