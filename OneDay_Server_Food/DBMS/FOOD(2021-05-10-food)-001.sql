-- food 접속
DROP TABLE tbl_foods;
CREATE TABLE tbl_foods(
    fd_fcode	CHAR(7)		PRIMARY KEY,
    fd_fname	nVARCHAR2(125)	NOT NULL,
    fd_year NUMBER	NOT NULL,
    fd_ccode	CHAR(6)	NOT NULL,	
    fd_icode	CHAR(4)	NOT NULL,
    fd_one	NUMBER	NOT NULL,
    fd_total	NUMBER	NOT NULL,	
    fd_energy	NUMBER	NOT NULL,	
    fd_protein	NUMBER	NOT NULL,
    fd_fat	NUMBER	NOT NULL,	
    fd_car	NUMBER	NOT NULL,
    fd_sugar	NUMBER	NOT NULL
);

CREATE TABLE tbl_company(
    cp_code	CHAR(6)		PRIMARY KEY,
    cp_com	nVARCHAR2(125)	NOT NULL
);

CREATE TABLE tbl_items(
    it_code	CHAR(6)		PRIMARY KEY,
    it_name	nVARCHAR2(50)	NOT NULL	
);

-- N table -> tbl_foods
-- FK 이름 : fk_ccode
-- N table -> fd_ccode / 1 table -> cp_code
ALTER TABLE tbl_foods
ADD CONSTRAINT fk_ccode
FOREIGN KEY(fd_ccode)
REFERENCES tbl_company(cp_code);

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_icode
FOREIGN KEY(fd_icode)
REFERENCES tbl_items(it_code);

CREATE VIEW view_식품정보 AS
(
    SELECT F.fd_year AS 출시연도,
            F.fd_fname AS 식품명,
            C.cp_com AS 제조사명,
            I.it_name AS 분류명,
            F.fd_one AS "1회제공량",
            F.fd_total AS "총내용량(g)",
            F.fd_energy AS "에너지(㎉)",
            F.fd_protein AS "단백질(g)",
            F.fd_fat AS "지방(g)",
            F.fd_car AS "탄수화물(g)",
            F.fd_sugar AS "총당류(g)",
            F.fd_fcode AS 식품코드,
            C.cp_code AS 제조사코드,
            I.it_code AS 분류코드
    FROM tbl_foods F
        LEFT JOIN tbl_company C
            ON F.fd_ccode = C.cp_code
        LEFT JOIN tbl_items I
            ON F.fd_icode = I.it_code
);

DROP TABLE tbl_myfoods;
CREATE TABLE tbl_myfoods(
    mf_date	VARCHAR2(10)	NOT NULL,
    mf_fcode	CHAR(7)		NOT NULL,
    mf_intake	NUMBER	NOT NULL,
    mf_seq	NUMBER		PRIMARY KEY
);

DROP SEQUENCE seq_book_rent;
CREATE SEQUENCE food_seq -- seq 이름
START WITH 1 -- 시작값
INCREMENT BY 1; -- 자동증가값

INSERT INTO tbl_myfoods(mf_seq, mf_date, mf_fcode, mf_intake)
VALUES(food_seq.NEXTVAL, '2021-05-09', 'PD00017', '1');

INSERT INTO tbl_myfoods(mf_seq, mf_date, mf_fcode, mf_intake)
VALUES(food_seq.NEXTVAL, '2021-05-09', 'PD00102', '2');

INSERT INTO tbl_myfoods(mf_seq, mf_date, mf_fcode, mf_intake)
VALUES(food_seq.NEXTVAL, '2021-05-09', 'PD00222', '1');

-- CREATE VIEW view_myfood AS
-- (
   /* SELECT *
    FROM view_식품정보 V
        LEFT JOIN tbl_myfoods M
            ON V."식품코드" = m.mf_fcode;
            */
-- );
COMMIT;

DROP VIEW view_나의섭취정보;
CREATE VIEW view_나의섭취정보 AS
(
SELECT  m.mf_seq AS 일련번호,
        m.mf_date AS 날짜,
        m.mf_fcode AS 식품코드,
        f.fd_fname AS 식품명,
        m.mf_intake AS 섭취량,
        (f.fd_total * m.mf_intake) AS 총내용량,
        (f.fd_energy * m.mf_intake) AS 에너지,
        (f.fd_protein * m.mf_intake) AS 단백질,
        (f.fd_fat * m.mf_intake) AS 지방,
        (f.fd_car * m.mf_intake) AS 탄수화물,
        (f.fd_sugar * m.mf_intake) AS 총당류
FROM tbl_myfoods M
    LEFT JOIN tbl_foods F
        ON m.mf_fcode = f.fd_fcode
);
COMMIT;