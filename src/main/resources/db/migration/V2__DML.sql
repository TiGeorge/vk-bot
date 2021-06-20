INSERT INTO keyboards (id)
VALUES (1),
       (2);

INSERT INTO communities (id, keyboard_id)
VALUES (205095138, 1);

INSERT INTO actions (id, type, label, link, payload)
VALUES (1, 'CALLBACK', 'Кнопка 1', null, null),
       (2, 'CALLBACK', 'Кнопка 2', null, null),
       (3, 'CALLBACK', 'Кнопка 3', null, null),
       (4, 'CALLBACK', 'Кнопка 4', null, null),
       (5, 'CALLBACK', 'Кнопка 5', null, null);

INSERT INTO buttons (id, row_number, row_order, color, keyboard_id, action_id)
VALUES (1, 1, 1, 'DEFAULT', 1, 1),
       (2, 1, 2, 'PRIMARY', 1, 2),
       (3, 1, 3, 'DEFAULT', 1, 3),
       (4, 2, 1, 'POSITIVE', 1, 4),
       (5, 2, 2, 'NEGATIVE', 1, 5);
