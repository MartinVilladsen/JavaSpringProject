CREATE TABLE IF NOT EXISTS Game (
    id INT NOT NULL,
    opponent varchar(256) NOT NULL,
    gameStart timestamp NOT NULL,
    gameEnd timestamp NOT NULL,
    location varchar(10) NOT NULL,
    PRIMARY KEY (id)
);