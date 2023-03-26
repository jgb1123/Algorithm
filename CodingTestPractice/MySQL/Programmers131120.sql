-- 3월에 태어난 여성 회원 목록 출력하기(https://school.programmers.co.kr/learn/courses/30/lessons/131120)

SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH -- MEMBER_ID, MEMBER_NAME, GENDER, DATE_OF_BIRTH
                                                                                               -- DATE_OF_BIRTH는 %Y-%m-%d 형식으로, 컬럼명은 DATE_OF_BIRTH로
FROM MEMBER_PROFILE -- MEMBER_PROFILE 테이블에서
WHERE DATE_OF_BIRTH LIKE '%-03-%' AND GENDER = 'W' AND TLNO IS NOT NULL -- DATE_OF_BIRTH가 -03-이 들어가면서, GENDER는 W면서, TLNO는 NULL이 아닌 것들만
ORDER BY MEMBER_ID -- MEMBER_ID 기준으로 오름차순 정렬