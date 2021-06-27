INSERT INTO keyboards (id)
VALUES (1),
       (2);

INSERT INTO communities (id, keyboard_id)
VALUES (205095138, 1);

INSERT INTO actions (id, type, label, link, payload, link_keyboard_id)
VALUES (1, 'CALLBACK', 'Кнопка 1', null, '{"type": "show_snackbar", "text": "Это исчезающее сообщение"}', null),
       (2, 'TEXT', 'Кнопка 2', null, null, null),
       (3, 'TEXT', 'Кнопка 3', null, null, null),
       (4, 'TEXT', 'Кнопка 4', null, null, null),
       (5, 'TEXT', 'На клавиатуру 2', null, null, 2),
       (6, 'TEXT', 'Нет', null, null, null),
       (7, 'TEXT', 'Да', null, null, null),
       (8, 'TEXT', 'На клавиатуру 1', null, null, 1);

INSERT INTO buttons (id, row_number, row_order, color, keyboard_id, action_id)
VALUES (1, 1, 1, 'PRIMARY', 1, 1),
       (2, 1, 2, 'DEFAULT', 1, 2),
       (3, 1, 3, 'DEFAULT', 1, 3),
       (4, 2, 1, 'POSITIVE', 1, 4),
       (5, 2, 2, 'NEGATIVE', 1, 5),
       (6, 1, 1, 'NEGATIVE', 2, 6),
       (7, 1, 2, 'POSITIVE', 2, 7),
       (8, 2, 1, 'PRIMARY', 2, 8);

