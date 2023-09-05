insert into users (id, creation_date, update_date, password, role, user_name)
values (1, '2023-02-01', '2023-04-01', '$2a$04$2ZrUs.tLVfXY8vTjPsMPoeZgr5JmdJuwuXXBHGAroSp79B9SdL1A.', 'SUPERADMIN',
        'superadmin@gmail.com'),
       (2, '2023-02-02', '2023-04-02', '$2a$04$taHO005AAGMbr9RQ1jb6he.GCbMcqm5a.WEW7phbTjWoRdUfYHmeq', 'MANAGER',
        'menager@gmail.com');

insert into groups (id, creation_date, update_date, finish_date, status, name, start_date)
VALUES (1, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'JAVA-1', '2023-02-06'),
       (2, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'JS-1', '2023-02-06'),
       (3, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'PYTHON-1', '2023-02-06');

insert into stacks (id, creation_date, update_date, name)
VALUES (1, '2023-02-01', '2023-04-01', 'java'),
       (2, '2023-02-01', '2023-04-01', 'js');

insert into mentors (id, creation_date, update_date, email, first_name, is_billable, last_name, phone_number)
VALUES (1, '2023-02-01', '2023-04-01', 'mentor1@gmail.com', 'name1', 'true', 'last_name', '+996777888333'),
       (2, '2023-02-01', '2023-04-01', 'mentor2@gmail.com', 'name2', 'true', 'last_name2', '+996777888222');

insert into mentors_stacks (mentor_id, stack_id)
VALUES (1, 1),
       (2, 2);

insert into interns (id, creation_date, update_date, email, first_name, status, is_paid, last_name, phone_number,
                     group_id, mentor_id, stack_id)
VALUES (1, '2023-02-01', '2023-04-01', 'intern1@gmail.com', 'name1', 'ACTIVE', 'true', 'lastname1', '+996777888111', 1,
        1,1),
       (2, '2023-02-01', '2023-04-01', 'intern2@gmail.com', 'name2', 'ACTIVE', 'true', 'lastname2', '+996777888222', 2,
        2,1),
       (3, '2023-02-01', '2023-04-01', 'intern3@gmail.com', 'name3', 'ACTIVE', 'true', 'lastname3', '+996777888333', 3,
        2,1);

