insert into users (id, creation_date, update_date, password, role, user_name)
values (1, '2023-02-01', '2023-04-01', '$2a$12$Dk5.myewTKPGpVXCiu0nmOY8tf8DostKvERCY65TLaw/dG57jiWpm', 'SUPERADMIN',
        'superadmin@gmail.com'),
       (2, '2023-02-02', '2023-04-02', '$2a$12$9p6Me6viqzXWZILyhUOjE.a/lCJeAydhHH5SJ.zVyjMyB9uMhkKpa', 'MANAGER',
        'menager@gmail.com');
--superadmin123
--manager123

insert into groups (id, creation_date, update_date, finish_date, status, name, start_date)
VALUES (1, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'JAVA-1', '2023-02-06'),
       (2, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'JS-1', '2023-02-06'),
       (3, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'PYTHON-1', '2023-02-06');

insert into stacks (id, creation_date, update_date, name)
VALUES (1, '2023-02-01', '2023-04-01', 'java'),
       (2, '2023-02-01', '2023-04-01', 'js');

insert into mentors (id, creation_date, update_date, email, first_name, is_billable, last_name, experience, education, skills,phone_number)
VALUES (1, '2023-02-01', '2023-04-01', 'mentor1@gmail.com', 'name1', 'true', 'last_name', ' Frontend Developer PEAKSOFT academy', 'PEAKSOFT academy', 'Integration
Github
Library
Cascading Style Sheets (CSS)
Web Applications
React Redux
JavaScript (Programming Language)
Eslint
Application Programming Interface (API)
React.js
TypeScript
', '0777897856'),
       (2, '2023-02-01', '2023-04-01', 'mentor2@gmail.com', 'name2', 'true', 'last_name2','ItSoft', 'KN University', 'Java, js,Python','0776563478');

insert into mentors_stacks (mentor_id, stack_id)
VALUES (1, 1),
       (2, 2);

insert into interns (id, creation_date, update_date,balance, email, first_name, status, last_name,payment_coast_per_month, phone_number,
                     group_id, mentor_id, stack_id, is_paid_for_first_month, is_paid_for_second_month, is_paid_for_third_month)
VALUES (1, '2023-02-01', '2023-04-01',0, 'intern1@gmail.com', 'name1', 'ACTIVE',  'lastname1',10000, '+996777888111', 1,
        1,1, false, false, false),
       (2, '2023-02-01', '2023-04-01',0, 'intern2@gmail.com', 'name2', 'ACTIVE', 'lastname2',10000, '+996777888222', 2,
        2,1, false, false, false),
       (3, '2023-02-01', '2023-04-01', 0,'intern3@gmail.com', 'name3', 'ACTIVE', 'lastname3', 10000,'+996777888333', 3,
        2,1, false, false, false);

