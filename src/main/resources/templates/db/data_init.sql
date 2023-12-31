insert into users (id, creation_date, update_date, password, role, user_name)
values (1, '2023-02-01', '2023-04-01', '$2a$12$Dk5.myewTKPGpVXCiu0nmOY8tf8DostKvERCY65TLaw/dG57jiWpm', 'SUPERADMIN',
        'superadmin@gmail.com'),
       (2, '2023-02-02', '2023-04-02', '$2a$12$9p6Me6viqzXWZILyhUOjE.a/lCJeAydhHH5SJ.zVyjMyB9uMhkKpa', 'MANAGER',
        'manager@gmail.com');
--superadmin123
--manager123

insert into groups (id, creation_date, update_date, finish_date, status, name, start_date)
VALUES (1, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'JAVA-1', '2023-02-06'),
       (2, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'JAVA SCRIPT-1', '2023-02-06'),
       (3, '2023-02-01', '2023-04-01', '2024-02-01', 'ACTIVE', 'PYTHON-1', '2023-02-06');

insert into stacks (id, creation_date, update_date, name)
VALUES (1, '2023-02-01', '2023-04-01', 'Java'),
       (2, '2023-02-01', '2023-04-01', 'Java Script'),
       (3, '2023-02-01', '2023-04-01', 'Python');

INSERT INTO mentors (id, creation_date, update_date, email, first_name, is_billable, last_name, experience, education, skills, phone_number)
VALUES
    (1, '2023-02-01', '2023-04-01', 'mentor1@gmail.com', 'Aidana', 'true', 'Akimova', 'Frontend Developer PEAKSOFT academy', 'PEAKSOFT academy', 'Integration, Github ,Library ,React Redux ,JavaScript (Programming Language),React.js,TypeScript', '0777897856'),
    (2, '2023-02-01', '2023-04-01', 'mentor2@gmail.com', 'Adil', 'true', 'Aitbaev', 'ItSoft', 'KN University', 'Java, js, Python', '0776563478'),
    (3, '2023-02-01', '2023-04-01', 'mentor3@gmail.com', 'Kutman', 'true', 'Kaseiinov', 'Tech Solutions', 'University of Computer Science', 'C++, Python, SQL', '0778562463'),
    (4, '2023-02-01', '2023-04-01', 'mentor4@gmail.com', 'Kauhar', 'true', 'Aripova', 'Software Engineer', 'Tech College', 'Java, Spring, Hibernate', '0773482156'),
    (5, '2023-02-01', '2023-04-01', 'mentor5@gmail.com', 'Begimai', 'true', 'Keldibekova', 'Full Stack Developer', 'Tech Institute', 'Python, Django, JavaScript', '0779365487');



insert into mentors_stacks (mentor_id, stack_id)
VALUES (1, 1),
       (2, 2);

INSERT INTO interns (id, creation_date, update_date, balance, email, first_name, status, last_name,
                     payment_coast_per_month, phone_number, group_id, mentor_id, stack_id, is_paid_for_first_month,
                     is_paid_for_second_month, is_paid_for_third_month)
VALUES (100, '2022-10-31', '2023-01-30', 23546, 'rmcfie0@gmail.com', 'Rodie', 'PENDING', 'McFie', 12661,
        '+996(517)755432', 3, 1, 1, true, true, false),
       (200, '2022-11-27', '2023-05-12', 16267, 'bgowler1@gmail.com', 'Brynne', 'APPROVED', 'Gowler', 5713,
        '+996(274)454138', 2, 2, 2, true, false, false),
       (300, '2023-04-16', '2023-05-02', 3060, 'dvarfolomeev2@gmail.com', 'Desiree', 'ACTIVE', 'Varfolomeev', 8080,
        '+996(187)667853', 3, 3, 3, false, true, false),
       (400, '2023-06-30', '2023-08-10', 34621, 'bianeillo3@gmail.com', 'Bonnie', 'FINISHED', 'Ianiello', 12452,
        '+996(913)713953', 1, 4, 1, true, false, false),
       (500, '2022-12-10', '2023-05-19', 49832, 'ygurnell4@gmail.com', 'Yvette', 'REJECTED', 'Gurnell', 11466,
        '+996(672)720366', 1, 5, 2, true, false, false),
       (600, '2022-11-04', '2023-01-05', 9404, 'bsapauton5@gmail.com', 'Britteny', 'PENDING', 'Sapauton', 5820,
        '+996(582)933708', 3, 1, 3, false, false, false),
       (700, '2022-11-08', '2023-02-28', 40802, 'aoliver6@gmail.com', 'Ava', 'PENDING', 'Oliver', 9618, '+996(657)511526',
        3, 1, 1, true, true, true),
       (800, '2023-03-01', '2023-05-23', 33329, 'cgulleford7@gmail.com', 'Cristal', 'PENDING', 'Gulleford', 10681,
        '+996(305)559697', 1, 2, 1, false, true, false),
       (900, '2022-11-16', '2023-07-04', 11998, 'zdoby8@gmail.com', 'Zulema', 'APPROVED', 'Doby', 12536,
        '+996(202)727702', 3, 3, 2, false, true, false),
       (1000, '2022-12-17', '2023-09-08', 17042, 'maslie9@gmail.com', 'Mair', 'ACTIVE', 'Aslie', 9323, '+996(941)804906',
        1, 1, 3, true, false, false),
       (1100, '2022-12-26', '2023-05-08', 30359, 'aboysona@gmail.com', 'Agna', 'REJECTED', 'Boyson', 6844,
        '+996(233)241710', 1, 4, 3, true, false, false),
       (1200, '2023-05-19', '2023-07-01', 39971, 'rwaterhousb@gmail.com', 'Rosette', 'HIRED', 'Waterhous', 11202,
        '+996(983)837203', 3, 5, 1, true, false, true),
       (1300, '2023-05-23', '2023-04-05', 41973, 'kcankettc@gmail.com', 'Kelsy', 'HIRED', 'Cankett', 14239,
        '+996(668)191914', 2, 1, 2, false, true, true),
       (1400, '2023-07-22', '2023-09-06', 14337, 'dpoundfordd@gmail.com', 'Doretta', 'HIRED', 'Poundford', 10349,
        '+996(383)783195', 1, 2, 3, false, true, true),
       (1500, '2023-07-23', '2022-11-24', 14655, 'zteffreye@gmail.com', 'Zabrina', 'HIRED', 'Teffrey', 12508,
        '+996(506)316193', 1, 5, 2, true, false, true);

insert into vendors (id, address, contact_number, email, image, information, name)
VALUES (1, 'Чикаго, США', '+1 967 773 332 22', 'sucerberg@gmail.com', 'image_url',
        'Facebook - американская технологическая компания, чтобы акцентировать внимание на метавселенной и виртуальной реальности.',
        'Facebook'),
       (2, 'Лос-Анджелес, США', '+1 967 773 332 22', 'ilonmask@gmail.com', 'image',
        'Tesla - компания, создающая электрические автомобили и энергетические решения. Основана Илоном Маском.',
        'Tesla'),
       (3, 'Бишкек, Кыргызстан', '+9960455445', 'biz@gmail.com', 'image_biz',
        'BIZ - американская технологическая компания. Основана Кутманом и Адилом.', 'BIZ');
insert into vacancy(id, release_day, requirements, vacancy_name, level, vendor_id)
VALUES (1, '2023-02-01', 'Key Responsibilities: Design, develop, and maintain Java applications, ensuring high performance, responsiveness, and scalability. Collaborate with product managers, designers, and other developers to create efficient and user-friendly software solutions.Write clean, maintainable, and well-documented code, adhering to best practices and coding standards.',
                                 'Java Developer', 'JUNIOR', 1),
       (2, '2023-02-01', 'We are seeking a highly motivated and skilled JavaScript Developer to become an integral part of our development team at X Company. ' ||
                                       'In this role, you''ll be responsible for creating dynamic, user-friendly web applications using JavaScript, and you''ll play a crucial' ||
                                       ' role in ensuring our products are of the highest quality.', 'Java Script Developer', 'SENIOR', 2),
       (3, '2023-02-01', 'We are in search of a highly skilled and motivated Python Developer to join our development team at X Company. As a Python Developer,' ||
                                       ' you will play a pivotal role in designing,developing, and maintaining Python-based applications. Your work will be integral to the success of our projects,' ||
                                       ' contributing to the continued innovation and growth of our products.', 'Python Developer', 'MIDDLE', 3);

insert into event (id, description, date, meeting_name, start_time, end_time, group_id, location)
VALUES (1, 'This is a meeting for all interns', '2023-02-01', 'Interns Meeting', '10:00', '12:00', 1, 'Bishkek'),
       (2, 'This is a meeting for all interns', '2023-02-01', 'Interns Meeting', '10:00', '12:00', 2, 'Bishkek'),
       (3, 'This is a meeting for all interns', '2023-02-01', 'Interns Meeting', '10:00', '12:00', 3, 'Bishkek');

insert into interview (id, name_of_interview, start_date, start_time, end_time, description, location)
VALUES (1, 'Interview', '2023-02-01', '10:00', '12:00', 'This is an interview for all interns', 'Bishkek'),
       (2, 'Interview', '2023-02-01', '10:00', '12:00', 'This is an interview for all interns', 'Bishkek'),
       (3, 'Interview', '2023-02-01', '10:00', '12:00', 'This is an interview for all interns', 'Bishkek');


insert into interview_interns (interview_id, interns_id)
values (1, 100),
       (2, 200),
       (3, 300);