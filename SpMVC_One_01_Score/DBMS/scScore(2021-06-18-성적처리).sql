USE scScore;

CREATE TABLE tbl_student(
	st_num	VARCHAR(8)	PRIMARY KEY,
	st_name	VARCHAR(20)	NOT NULL,
	st_dept	VARCHAR(20)	NOT NULL,	
	st_grade	INT		NOT NULL,
	st_tel	VARCHAR(15)	NOT NULL,
	st_addr	VARCHAR(125)		
);

DROP TABLE tbl_score;
CREATE TABLE tbl_score(
	sc_seq		BIGINT		PRIMARY KEY		AUTO_INCREMENT,
	sc_stnum	VARCHAR(8)	NOT NULL,
	sc_subject	VARCHAR(20)	NOT NULL,
	sc_score	INT			NOT NULL
);

ALTER TABLE tbl_score
ADD CONSTRAINT fk_student
FOREIGN KEY(sc_stnum)
REFERENCES tbl_student(st_num);

alter table tbl_student drop foreign key fk_student;

DROP VIEW view_리스트;
CREATE VIEW view_리스트 AS (
	SELECT T.st_num AS 학번,
			T.st_name AS 이름,
            T.st_dept AS 전공,
            T.st_grade AS 학년,
            COUNT(C.sc_subject) AS 응시과목,
            SUM(C.sc_score) AS 총점,
            ROUND(SUM(C.sc_score) / COUNT(C.sc_subject), 2) AS 평균
    FROM tbl_student T
		LEFT JOIN tbl_score C
			ON T.st_num = C.sc_stnum
	GROUP BY T.st_num
);
INSERT INTO tbl_student(st_num, st_name, st_dept, st_grade, st_tel, st_addr)
VALUES ('20210001','나나','컴퓨터공학',2,'010-1234-5689','광주광역시');

INSERT INTO tbl_score(sc_stnum, sc_subject, sc_score)
VALUES ('20210001','영어',99);


SELECT * FROM view_리스트;