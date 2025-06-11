-- Ensure the 'student' table exists
CREATE TABLE IF NOT EXISTS student
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    date_of_birth   DATE                NOT NULL,
    registered_date DATE                NOT NULL
);

-- Insert well-known UUIDs for specific students
INSERT INTO student (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'John Doe',
       'john.doe@example.com',
       '123 Main St, Springfield',
       '1998-06-15',
       '2025-06-10'
WHERE NOT EXISTS (SELECT 1
                  FROM student
                  WHERE id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO student (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Jane Smith',
       'jane.smith@example.com',
       '456 Elm St, Shelbyville',
       '2001-09-23',
       '2024-12-01'
WHERE NOT EXISTS (SELECT 1
                  FROM student
                  WHERE id = '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO student (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Alice Johnson',
       'alice.johnson@example.com',
       '789 Oak St, Capital City',
       '2000-03-12',
       '2025-05-20'
WHERE NOT EXISTS (SELECT 1
                  FROM student
                  WHERE id = '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO student (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174003',
       'Bob Brown',
       'bob.brown@example.com',
       '321 Pine St, Springfield',
       '2001-11-30',
       '2025-05-14'
WHERE NOT EXISTS (SELECT 1
                  FROM student
                  WHERE id = '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO student (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174004',
       'Emily Davis',
       'emily.davis@example.com',
       '654 Maple St, Shelbyville',
       '2003-02-05',
       '2025-03-01'
WHERE NOT EXISTS (SELECT 1
                  FROM student
                  WHERE id = '123e4567-e89b-12d3-a456-426614174004');