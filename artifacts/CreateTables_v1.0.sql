CREATE TABLE IF NOT EXISTS role
(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    description VARCHAR(200)
);
CREATE TABLE IF NOT EXISTS user
(
    id    INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name VARCHAR(200),
    last_name  VARCHAR(200),
    role       INTEGER,
    CONSTRAINT fk_role
        FOREIGN KEY (role)
            REFERENCES role(id)

);
CREATE TABLE IF NOT EXISTS document
(
    id    INTEGER PRIMARY KEY AUTOINCREMENT,
    title     VARCHAR(100),
    author    INTEGER,
    file_path VARCHAR(250),
    CONSTRAINT fk_author
        FOREIGN KEY (author)
            REFERENCES user (id)
);
CREATE TABLE IF NOT EXISTS deadline
(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(100),
    start_date DATETIME,
    end_date DATETIME
)
