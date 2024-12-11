CREATE TABLE book
(
    id     UUID PRIMARY KEY,
    title  VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn   VARCHAR(13)  NOT NULL
);

CREATE TABLE client
(
    id          UUID PRIMARY KEY,
    full_name   VARCHAR(255) NOT NULL,
    birth_date  DATE         NOT NULL
);

CREATE TABLE book_order
(
    id          UUID PRIMARY KEY,
    client_id   UUID      NOT NULL,
    book_id     UUID      NOT NULL,
    borrow_date TIMESTAMP NOT NULL DEFAULT NOW(),
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);
