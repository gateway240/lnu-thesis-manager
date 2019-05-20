CREATE TABLE IF NOT EXISTS user
(
    user_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name VARCHAR(200),
    last_name  VARCHAR(200),
    role       VARCHAR(100)

);
CREATE TABLE IF NOT EXISTS document
(
    doc_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    title     VARCHAR(100),
    author    INTEGER,
    file_path VARCHAR(250),
    CONSTRAINT fk_author
        FOREIGN KEY (author)
            REFERENCES user (user_id)
);
CREATE TABLE IF NOT EXISTS deadline
(
    name VARCHAR(100) PRIMARY KEY,
    start_date DATETIME,
    end_date DATETIME
)
