CREATE TABLE IF NOT EXISTS role
(
    id   INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(45) DEFAULT NULL
);
CREATE TABLE users
(
    first_name VARCHAR(200),
    last_name  VARCHAR(200),
    role       VARCHAR(100),
    email      VARCHAR(200),
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled  TINYINT      NOT NULL DEFAULT 1,
    PRIMARY KEY (username)
);

CREATE TABLE user_roles
(
    user_role_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username     varchar(45) NOT NULL,
    role         varchar(45) NOT NULL,
    UNIQUE (role, username),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);

CREATE TABLE IF NOT EXISTS document
(
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    title     VARCHAR(100),
    author    VARCHAR(50),
    file_path VARCHAR(250),
    CONSTRAINT fk_author
        FOREIGN KEY (author)
            REFERENCES users (username)
);
CREATE TABLE IF NOT EXISTS feedback
(
    id       INTEGER PRIMARY KEY AUTOINCREMENT,
    feedback VARCHAR(2000),
    reviewer INTEGER,
    document INTEGER,
    CONSTRAINT fk_reviewer
        FOREIGN KEY (reviewer)
            REFERENCES user (id),
    CONSTRAINT fk_document
        FOREIGN KEY (document)
            REFERENCES document (id)
);
CREATE TABLE IF NOT EXISTS deadline
(
    id         INTEGER PRIMARY KEY AUTOINCREMENT,
    name       VARCHAR(100),
    start_date DATETIME,
    end_date   DATETIME
);

INSERT INTO users(username, password, enabled)
VALUES ('coordinator20', '$2a$10$fNwdswb5cT2IBa1.DwdODeM9IY8Ht6cFuehAGTP5vs7jhTMkdth12', true);
INSERT INTO users(username, password, enabled)
VALUES ('student20', '$2a$10$fNwdswb5cT2IBa1.DwdODeM9IY8Ht6cFuehAGTP5vs7jhTMkdth12', true);

INSERT INTO user_roles (username, role)
VALUES ('coordinator20', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('coordinator20', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('student20', 'ROLE_USER');