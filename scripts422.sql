-- Создаем таблицу person
CREATE TABLE person (
                        person_id SERIAL PRIMARY KEY,
                        name TEXT NOT NULL,
                        age INTEGER,
                        has_license BOOLEAN NOT NULL DEFAULT FALSE
);

-- Создаем таблицу car
CREATE TABLE car (
                     car_id SERIAL PRIMARY KEY,
                     brand TEXT NOT NULL,
                     model TEXT NOT NULL,
                     price NUMERIC(10, 2) NOT NULL
);

-- Создаем таблицу связи person_car (многие-ко-многим)
CREATE TABLE person_car (
                            person_id INTEGER NOT NULL,
                            car_id INTEGER NOT NULL,
                            PRIMARY KEY (person_id, car_id),
                            CONSTRAINT fk_person_car_person FOREIGN KEY (person_id) REFERENCES person(person_id),
                            CONSTRAINT fk_person_car_car FOREIGN KEY (car_id) REFERENCES car(car_id)
);



INSERT INTO person (name, age, has_license) VALUES
                                                ('Иван Иванов', 30, TRUE),
                                                ('Петр Петров', 25, FALSE),
                                                ('Анна Сидорова', 28, TRUE);

INSERT INTO car (brand, model, price) VALUES
                                          ('Toyota', 'Camry', 2500000.00),
                                          ('Ford', 'Focus', 1200000.00),
                                          ('BMW', 'X5', 4500000.00);


INSERT INTO person_car (person_id, car_id) VALUES
                                               (1, 1), -- Иван -> Toyota Camry
                                               (1, 3), -- Иван -> BMW X5
                                               (2, 2), -- Петр -> Ford Focus
                                               (3, 1); -- Анна -> Toyota Camry

-- 7. Проверка результата
SELECT * FROM person_car;