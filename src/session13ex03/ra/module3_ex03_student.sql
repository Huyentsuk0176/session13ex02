CREATE TABLE students (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          full_name VARCHAR(100) NOT NULL,
                          date_of_birth DATE NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE
);

DELIMITER $$

CREATE PROCEDURE add_student(
    IN in_full_name VARCHAR(100),
    IN in_date_of_birth DATE,
    IN in_email VARCHAR(100)
)
BEGIN
INSERT INTO students(full_name, date_of_birth, email)
VALUES (in_full_name, in_date_of_birth, in_email);
END $$

DELIMITER ;
CALL add_student('Nguyen Van A', '2000-05-10', 'a@gmail.com');
CALL add_student('Tran Thi B', '2001-03-15', 'b@gmail.com');
CALL add_student('Le Van C', '1999-12-20', 'c@gmail.com');

DELIMITER $$

CREATE PROCEDURE get_all_students()
BEGIN
SELECT * FROM students;
END $$

DELIMITER ;

CALL get_all_students();


DELIMITER $$

CREATE PROCEDURE update_student(
    IN in_id INT,
    IN in_full_name VARCHAR(100),
    IN in_date_of_birth DATE,
    IN in_email VARCHAR(100)
)
BEGIN
UPDATE students
SET full_name = in_full_name,
    date_of_birth = in_date_of_birth,
    email = in_email
WHERE id = in_id;
END $$

DELIMITER ;

CALL update_student(
        1,
        'Nguyen Van A Updated',
        '2000-06-01',
        'a_updated@gmail.com'
     );

CALL get_all_students();


DELIMITER $$

CREATE PROCEDURE delete_student(
    IN in_id INT
)
BEGIN
DELETE FROM students WHERE id = in_id;
END $$

DELIMITER ;

CALL delete_student(2);

CALL get_all_students();


select *from students;
