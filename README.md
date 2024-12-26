<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkS10i%2FbtsLzXQlsak%2FcAve228KnwRTeaC1LmvRm1%2Fimg.png"/>

사용자의 정보 데이터를 담는 user 테이블, 강의 정보 데이터를 담는 lecture 테이블, 그리고 사용자가 예약한 강의 정보를 담는 reservation 테이블 총 3개의 테이블로 구성하기로 했습니다.

user 테이블 : id(pk), 아이디(loginId), 비밀번호(password), 이름(name), 전화번호(phoneNumber), 생성일자(createdAt), 수정일자(updatedAt) 
lecture 테이블 : id(pk), 이름(name), 강사명(instructor), 생성일자(createdAt), 수정일자(updatedAt), 등록시작일(enrollment_start_date), 등록마감일(enrollment_end_date), 
            강의 시작일(course_start_date),수강신청 가능인원(max_enrollment) 
reservation 테이블 : id(pk), 사용자아이디(fk1, userId), 강의아이디(fk2, lectureId)

우선 reservation 테이블에는 예약한 사용자의 정보와 강의의 정보를 받아와야 했습니다. 유저테이블의 id인 userId를 fk2, 강의테이블의 id 인 lectureId를 fk2로 받았습니다.
