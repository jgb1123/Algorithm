-- 12세 이하인 여자 환자 목록 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/132201)

SELECT PT_NAME, PT_NO, GEND_CD, AGE, IF(TLNO IS NULL, 'NONE', TLNO) AS TLNO -- PT_NAME, PT_NO, GEND_CD, AGE, TLNO 조회
                                                                            -- TLNO가 NULL이면 NONE으로 컬럼명은 TLNO로 출력
FROM PATIENT -- PATIENT 테이블에서
WHERE AGE <= 12 AND GEND_CD = 'W' -- AGE는 12이하이고, 성별은 W인 것들만
ORDER BY AGE DESC, PT_NAME -- AGE 내림차순, AGE같으면 PT_NAME 오름차순