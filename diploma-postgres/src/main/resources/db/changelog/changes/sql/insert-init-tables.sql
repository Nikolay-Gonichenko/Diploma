insert into documents (series, number, document_type_id)
values (456, 789123, 1);

insert into humans (surname, name, last_name, birth_date, document_id)
values ('Иванов', 'Иван', 'Иванович', '2002-10-10', 1);

insert into routes (location_from_id, location_to_id)
values (1, 2),
       (3, 4),
       (5, 6),
       (7, 8),
       (8, 9),
       (10, 11),
       (12, 13),
       (14, 15),
       (16, 17),
       (18, 19),
       (20, 1),
       (2, 3),
       (4, 5),
       (6, 7),
       (9, 10),
       (1, 3),
       (1, 5),
       (10, 15),
       (13, 19),
       (2, 18),
       (3, 16),
       (5, 20);
