CREATE TABLE keyboards
(
    id       BIGINT PRIMARY KEY,
    one_time BOOLEAN DEFAULT false,
    inline   BOOLEAN DEFAULT false
);

CREATE TABLE communities
(
    id          INTEGER PRIMARY KEY,
    keyboard_id BIGINT,
    CONSTRAINT communities_fk_keyboard FOREIGN KEY (keyboard_id) REFERENCES keyboards (id)
);

CREATE TABLE actions
(
    id               BIGINT PRIMARY KEY,
    type             VARCHAR(50) NOT NULL,
    label            VARCHAR(50) NOT NULL,
    link             VARCHAR(150),
    payload          VARCHAR,
    link_keyboard_id BIGINT,
    CONSTRAINT actions_fk_link_keyboard FOREIGN KEY (link_keyboard_id) REFERENCES keyboards (id)
);

CREATE TABLE buttons
(
    id          BIGINT PRIMARY KEY,
    row_number  INTEGER DEFAULT 0,
    row_order   INTEGER DEFAULT 0,
    color       VARCHAR(20) NOT NULL,
    keyboard_id BIGINT      NOT NULL,
    action_id   BIGINT      NOT NULL,
    CONSTRAINT buttons_fk_keyboard FOREIGN KEY (keyboard_id) REFERENCES keyboards (id),
    CONSTRAINT buttons_fk_action FOREIGN KEY (action_id) REFERENCES actions (id)
);

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1;
