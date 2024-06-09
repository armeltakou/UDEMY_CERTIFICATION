CREATE TABLE IF NOT EXISTS ACTOR  (
    ID_ACTOR BIGINT NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(20),
    PRIMARY KEY(ID_ACTOR)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS MOVIE (
    ID_MOVIE BIGINT NOT NULL AUTO_INCREMENT,
    TITRE VARCHAR(20) NOT NULL,
    GENRE VARCHAR(20) NOT NULL,
    DESCRIPTION VARCHAR(255),
    ID_MAIN_ACTOR BIGINT NOT NULL,
    FOREIGN KEY(ID_MAIN_ACTOR) REFERENCES ACTOR(ID_ACTOR),
    PRIMARY KEY(ID_MOVIE)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS MOVIE_SEC_ACTORS(
    ID_MOVIE_SEC_ACTORS BIGINT NOT NULL AUTO_INCREMENT,
    ID_MOVIE BIGINT NOT NULL,
    ID_ACTOR BIGINT NOT NULL,
    PRIMARY KEY (ID_MOVIE_SEC_ACTORS),
    FOREIGN KEY(ID_MOVIE) REFERENCES MOVIE(ID_MOVIE),
    FOREIGN KEY(ID_ACTOR) REFERENCES ACTOR(ID_ACTOR)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS APP_USER(
    ID_APP_USER BIGINT NOT NULL AUTO_INCREMENT,
    USERNAME VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID_APP_USER)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS REVIEW(
    ID_REVIEW BIGINT NOT NULL AUTO_INCREMENT,
    ID_MOVIE BIGINT NOT NULL,
    ID_REVIEWER BIGINT NOT NULL,
    MARK SMALLINT NOT NULL,
    REVIEW_COMMENT VARCHAR(255),
    PRIMARY KEY (ID_REVIEW),
    FOREIGN KEY(ID_MOVIE) REFERENCES MOVIE(ID_MOVIE),
    FOREIGN KEY(ID_REVIEWER) REFERENCES APP_USER(ID_APP_USER)
) ENGINE=InnoDB;


