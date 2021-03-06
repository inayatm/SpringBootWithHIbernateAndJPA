-- CREATE TABLE activity ( 
--    id INT NOT NULL, 
--    description VARCHAR(50) NOT NULL, 
--    duration VARCHAR(20) NOT NULL, 
--    activity_date DATE ,
--    PRIMARY KEY(id)
-- );



-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1001,'cardio','30min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1002,'workout','30min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1003,'running','30min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1005,'running5','10min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1006,'running6','10min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1007,'running7','10min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1008,'running8','10min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1009,'running9','10min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1010,'running10','10min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1011,'running11','10min',SYSDATE,sysdate(),sysdate());
-- INSERT INTO ACTIVITY(ID,DESCRIPTION,DURATION,ACTIVITY_DATE,created_date,lastupdated_date) values(1012,'running12','10min',SYSDATE,sysdate(),sysdate());


INSERT INTO COURSE(ID,NAME,DURATION,created_date,lastupdated_date) values(1001,'spring Boot Intro','10min',sysdate(),sysdate());
INSERT INTO COURSE(ID,NAME,DURATION,created_date,lastupdated_date) values(1002,'ReactJS Intro','10min',sysdate(),sysdate());
INSERT INTO COURSE(ID,NAME,DURATION,created_date,lastupdated_date) values(1003,'Spring MVC','2h',sysdate(),sysdate());
INSERT INTO COURSE(ID,NAME,DURATION,created_date,lastupdated_date) values(1004,'Spring with JPA and Hibernate','4h',sysdate(),sysdate());



INSERT INTO PASSPORT(ID,NUMBER) VALUES(2004,'B0912894');
INSERT INTO PASSPORT(ID,NUMBER) VALUES(2001,'B0912891');
INSERT INTO PASSPORT(ID,NUMBER) VALUES(2002,'B0912892');
INSERT INTO PASSPORT(ID,NUMBER) VALUES(2003,'B0912893');



INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(4001,'WILL SMITH',2001);
INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(4002,'JSON HEMPH',2002);
INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(4003,'LEONARDO DEPARIO',2003);
INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(4004,'WASHINGTON FREEMAN',2004);




INSERT INTO REVIEW(ID,DESCRIPTION,RATING,COURSE_ID) VALUES(3001,'good','3',1001);
INSERT INTO REVIEW(ID,DESCRIPTION,RATING,COURSE_ID) VALUES(3002,'ok','2',1001);
INSERT INTO REVIEW(ID,DESCRIPTION,RATING,COURSE_ID) VALUES(3003,'great','4',1004);
INSERT INTO REVIEW(ID,DESCRIPTION,RATING,COURSE_ID) VALUES(3004,'Amazing','5',1004);



INSERT INTO STUDENT_COURSE(STUDENT_ID,COURSE_ID) VALUES(4002,1002);
INSERT INTO STUDENT_COURSE(STUDENT_ID,COURSE_ID) VALUES(4003,1004);
INSERT INTO STUDENT_COURSE(STUDENT_ID,COURSE_ID) VALUES(4004,1004);

