-- Файл: scripts423.sql
-- Задача: JOIN-запросы для получения информации о студентах Хогвартса

-- ЗАПРОС 1: Информация обо всех студентах и их факультетах
-- Получаем имя, возраст студента и название факультета
SELECT
    s.name AS student_name,
    s.age,
    f.name AS faculty_name
FROM student s
         JOIN faculty f ON s.faculty_id = f.faculty_id;


-- ЗАПРОС 2: Студенты, у которых есть аватарки
-- Получаем только имя и возраст тех студентов, у которых есть запись в таблице avatar
SELECT
    s.name AS student_name,
    s.age
FROM student s
         JOIN avatar a ON s.student_id = a.student_id;