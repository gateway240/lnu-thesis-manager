CREATE TABLE IF NOT EXISTS role
(
    id   INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(45) DEFAULT NULL
);
CREATE  TABLE users (
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  grade VARCHAR(50) NOT NULL DEFAULT 'No Grade',
  PRIMARY KEY (username)
);


CREATE TABLE IF NOT EXISTS user_roles
(
    user_role_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username     varchar(50) NOT NULL,
    role         varchar(50) NOT NULL,
    UNIQUE (role, username),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);
CREATE TABLE IF NOT EXISTS user_supervisors
(
    user_supervisor_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username    VARCHAR(50) NOT NULL,
    supervisor    VARCHAR(50) NOT NULL,
    status      VARCHAR(50) NOT NULL,
    UNIQUE (username,supervisor),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username),
    CONSTRAINT fk_supervisor FOREIGN KEY (supervisor) REFERENCES users(username)

);
CREATE TABLE IF NOT EXISTS user_coordinators
(
    user_coordinator_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username    VARCHAR(50) NOT NULL,
    coordinator    VARCHAR(50) NOT NULL,
    UNIQUE (username,coordinator),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username),
    CONSTRAINT fk_supervisor FOREIGN KEY (coordinator) REFERENCES users(username)

);

CREATE TABLE IF NOT EXISTS document
(
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    title     VARCHAR(100),
    author    VARCHAR(50),
    file_path VARCHAR(250),
    category  VARCHAR(200),
    CONSTRAINT fk_author
        FOREIGN KEY (author)
            REFERENCES users (username)
);
CREATE TABLE IF NOT EXISTS feedback
(
    id       INTEGER PRIMARY KEY AUTOINCREMENT,
    feedback VARCHAR(2000),
    reviewer VARCHAR(50),
    document INTEGER,
    CONSTRAINT fk_reviewer
        FOREIGN KEY (reviewer)
            REFERENCES users (username),
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
CREATE TABLE IF NOT EXISTS submission
(
  id INTEGER PRIMARY KEY AUTOINCREMENT ,
  user VARCHAR(50),
  title VARCHAR(200),
  degree VARCHAR(50),
  document INTEGER,
--   supervisor VARCHAR(50),
--   coordinator VARCHAR(50),
  date DATETIME,
  deadline INTEGER,
  CONSTRAINT fk_user FOREIGN KEY (user) REFERENCES users(username),
  CONSTRAINT fk_document FOREIGN KEY (document) REFERENCES document(id),
--   CONSTRAINT fk_supervisor FOREIGN KEY (supervisor) REFERENCES users(username),
--   CONSTRAINT fk_coordinator FOREIGN KEY (coordinator) REFERENCES users(username),
  CONSTRAINT fk_deadline FOREIGN KEY (deadline) REFERENCES deadline(id)
);


INSERT INTO users(firstname,lastname,username,email,password,enabled)
VALUES ('Johan','Johansson','coordinator','coordinator@lnu.se','$2a$10$fNwdswb5cT2IBa1.DwdODeM9IY8Ht6cFuehAGTP5vs7jhTMkdth12', true);
INSERT INTO users(firstname,lastname,username,email,password,enabled)
VALUES ('Sven','Svensson','supervisor','supervisor@lnu.se','$2a$10$fNwdswb5cT2IBa1.DwdODeM9IY8Ht6cFuehAGTP5vs7jhTMkdth12', true);
INSERT INTO users(firstname,lastname,username,email,password,enabled)
VALUES ('Olle','Olsson','student','student@lnu.se','$2a$10$fNwdswb5cT2IBa1.DwdODeM9IY8Ht6cFuehAGTP5vs7jhTMkdth12', true);

INSERT INTO user_roles (username, role)
VALUES ('coordinator', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('supervisor', 'ROLE_SUPERVISOR');
INSERT INTO user_roles (username, role)
VALUES ('student', 'ROLE_USER');