-- SQL execute link >> https://onecompiler.com/mysql/3y92m8sqt

-- create
CREATE TABLE course (
  id BIGINT PRIMARY KEY,
  name VARCHAR(64) NOT NULL
);
CREATE TABLE student (
  id BIGINT PRIMARY KEY,
  name VARCHAR(64) NOT NULL
);
CREATE TABLE student_score (
  id BIGINT PRIMARY KEY,
  student_id BIGINT NOT NULL,
  course_id BIGINT NOT NULL,
  score FLOAT NOT NULL
);

-- insert
INSERT INTO course VALUES (1, '语文');
INSERT INTO course VALUES (2, '数学');
INSERT INTO course VALUES (3, '英语');

INSERT INTO student VALUES (1, '小李');
INSERT INTO student VALUES (2, '小马');
INSERT INTO student VALUES (3, '小王');
INSERT INTO student VALUES (4, '小张');

-- 小李
INSERT INTO student_score VALUES (1, 1, 1, 80);
INSERT INTO student_score VALUES (2, 1, 2, 90);
INSERT INTO student_score VALUES (3, 1, 3, 70);

-- 小马
INSERT INTO student_score VALUES (4, 2, 1, 70);
INSERT INTO student_score VALUES (5, 2, 2, 90);
INSERT INTO student_score VALUES (6, 2, 3, 90);

-- 小王
INSERT INTO student_score VALUES (7, 3, 1, 80);
INSERT INTO student_score VALUES (8, 3, 2, 90);
INSERT INTO student_score VALUES (9, 3, 3, 90);

-- 小张
INSERT INTO student_score VALUES (10, 4, 1, 70);
INSERT INTO student_score VALUES (11, 4, 2, 80);
INSERT INTO student_score VALUES (12, 4, 3, 80);


-- fetch
-- SELECT * FROM student_score ORDER BY course_id DESC;
-- 视频中的SQL
SELECT c.name AS 课程,t.score AS 最高分分数,s.name AS 学生名 FROM
(SELECT MAX(score) score, course_id FROM student_score ss
GROUP BY course_id) t
RIGHT JOIN
student_score sc
ON sc.score = t.score AND sc.course_id = t.course_id
LEFT JOIN
student s
ON s.id = sc.student_id
LEFT JOIN
course c
ON c.id = sc.course_id
ORDER BY c.id DESC;


-- 下面是正确答案
SELECT c.name AS 课程,t.score AS 最高分分数,s.name AS 学生名 FROM
(SELECT MAX(score) score, course_id FROM student_score ss
GROUP BY course_id) t
LEFT JOIN -- 这里换成LEFT即可
student_score sc
ON sc.score = t.score AND sc.course_id = t.course_id
LEFT JOIN
student s
ON s.id = sc.student_id
LEFT JOIN
course c
ON c.id = sc.course_id
ORDER BY c.id DESC;