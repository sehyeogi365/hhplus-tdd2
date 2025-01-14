
![image](https://github.com/user-attachments/assets/d3357746-c912-4d55-b3b7-db778086b5a8)

강의 정보 데이터를 담는 lecture 테이블, 그리고 사용자가 예약한 강의 정보를 담는 reservation 테이블, 강의예약기록을 담는 restvation_history 총 3개의 테이블로 구성하기로 했습니다.

lecture 테이블 : id(pk), 이름(name), 강사명(instructor), 생성일자(createdAt), 수정일자(updatedAt), 등록시작일(enrollment_start_date), 등록마감일(enrollment_end_date), 
            강의 시작일(course_start_date),수강신청 가능인원(max_enrollment) 
reservation 테이블 : id(pk), 사용자아이디(fk1, userId), 강의아이디(fk2, lectureId)
reservation_history 테이블 : id(pk), 사용자아이디(fk1, userId), 강의아이디(fk2, lectureId), 강의명(name), 예약 상태(atatus)

우선 reservation 테이블에는 예약한 사용자의 정보와 강의의 정보를 받아와야 했습니다. 유저테이블의 id인 userId를 fk1, 강의테이블의 id 인 lectureId를 fk2로 받았습니다.
reservation_history 테이블은 예약한 사용자의 정보와 강의의 정보를 받아오고 강의 명과 강의 예약 상태정보를 담습니다.
