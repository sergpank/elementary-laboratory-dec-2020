CREATE TABLE students
(
    id         INTEGER PRIMARY KEY,
    first_name NVARCHAR(64),
    last_name  NVARCHAR(64)
);

CREATE TABLE classes
(
    id          INTEGER PRIMARY KEY,
    title       NVARCHAR(128),
    description TEXT
);

CREATE TABLE enrollments
(
    enrollment_id INTEGER PRIMARY KEY,
    class_id      INTEGER REFERENCES classes (id),
    student_id    INTEGER REFERENCES students (id)
);

CREATE TABLE marks
(
    student_id INTEGER REFERENCES students (id),
    class_id   INTEGER REFERENCES students (id),
    mark       INTEGER,
    PRIMARY KEY (student_id, class_id)
);

INSERT INTO students (first_name, last_name)
VALUES ('Александр', 'Егоров'),
       ('Игорь', 'Бабаян'),
       ('Александр', 'Голумбиевский'),
       ('Владислав', 'Паламарчук'),
       ('Дмитрий', 'Окишор'),
       ('Евгений', 'Царенко'),
       ('Дмитрий', 'Разно'),
       ('Алексей', 'Захарченко'),
       ('Валерия', 'Кириллова'),
       ('Олег', 'Кузьмин'),
       ('Роман', 'Чернешенко');

INSERT INTO classes (title, description)
VALUES ('SQL', 'основы баз данных'),
       ('Java', 'Java Core and Frameworks'),
       ('HTML, CSS, JS', 'Основы веб дизайна');

INSERT INTO enrollments (class_id, student_id)
VALUES (1, 2),
       (1, 4),
       (1, 6),
       (1, 8),
       (1, 10),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (2, 10),
       (2, 11),
       (3, 1),
       (3, 3),
       (3, 5),
       (3, 7),
       (3, 9),
       (3, 11);

INSERT INTO marks(class_id, student_id, mark)
VALUES (1, 2, 9),
       (1, 4, 8),
       (1, 6, 9),
       (1, 8, 8),
       (1, 10, 8),
       (2, 1, 9),
       (2, 2, 8),
       (2, 3, 9),
       (2, 4, 8),
       (2, 5, 9),
       (2, 6, 8),
       (2, 7, 9),
       (2, 8, 8),
       (2, 9, 9),
       (2, 10, 8),
       (2, 11, 9),
       (3, 1, 8),
       (3, 3, 9),
       (3, 5, 8),
       (3, 7, 9),
       (3, 9, 8),
       (3, 11, 9);