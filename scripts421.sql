

-- 1. Возраст студента не может быть меньше 16 лет
ALTER TABLE student ADD CONSTRAINT chk_student_age CHECK (age >= 16);

-- 2. Имена студентов должны быть уникальными и не равны нулю
ALTER TABLE student ALTER COLUMN name SET NOT NULL;
ALTER TABLE student ADD CONSTRAINT uq_student_name UNIQUE (name);

-- 3. Пара "название" - "цвет факультета" должна быть уникальной
ALTER TABLE faculty ADD CONSTRAINT uq_faculty_name_color UNIQUE (name, color);

-- 4. При создании студента без возраста ему автоматически должно присваиваться 20 лет
ALTER TABLE student ALTER COLUMN age SET DEFAULT 20;