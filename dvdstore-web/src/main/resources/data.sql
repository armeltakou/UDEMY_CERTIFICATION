DELETE FROM REVIEW;
DELETE FROM APP_USER;
DELETE FROM MOVIE;
DELETE FROM ACTOR;

INSERT INTO ACTOR(LAST_NAME, FIRST_NAME) VALUES 
  ("L'éclair", "Buzz"),(NULL, "Woody"),(NULL, "Jessie"),("Robinson", "Leon"),("Candy", "John"),("Yoba", "Malik"),
  ("Gibson", "Mel"),("Marceau", "Sophie"),("Moore", "Roger"),("Lonsdale", "Michael");

INSERT INTO MOVIE (TITRE,GENRE,DESCRIPTION,ID_MAIN_ACTOR) VALUES
  ('Toys Story 3','ANIMATION',"Les créateurs des très populaires films Toy Story ouvrent à nouveau le coffre à jouets et invitent les spectateurs à retrouver le monde délicieusement magique de Woody et Buzz au moment où Andy s'apprête à partir pour l'université.",(select ID_ACTOR from ACTOR where FIRST_NAME="Buzz")),
  ('Rasta Rocket','COMEDIE',"Comment une équipe de la Jamaïque, après de multiples aventures, va participer à l'épreuve de bobsleigh à quatre aux Jeux Olympiques d'hiver de Calgary.",(select ID_ACTOR from ACTOR where FIRST_NAME="Leon")),
  ('Braveheart','DRAME',"Edouard Ier, roi d'Angleterre, s'empare du trône après avoir réglé un conflit avec le personnage fantoche qu'il y avait auparavant placé. William Wallace prend la tête d'une révolte paysanne.",(select ID_ACTOR from ACTOR where FIRST_NAME="Mel")),
  ('Moonraker','THRILLER',"L'agent secret britannique James Bond enquête sur la disparition d'une navette spatiale americaine, Moonraker, confiee au gouvernement britannique. 007 se rend aux Etats-Unis pour interroger le responsable de la construction de la navette, Sir Hugo Drax.",(select ID_ACTOR from ACTOR where FIRST_NAME="Roger"));

INSERT INTO APP_USER (USERNAME) VALUES ('John Doe'),('Tom Pike'),('Elton James'),('Bobby Wing');

INSERT INTO REVIEW (ID_MOVIE,ID_REVIEWER,MARK,REVIEW_COMMENT) VALUES 
  ((select ID_MOVIE from MOVIE where TITRE="Toys Story 3"),(select ID_APP_USER from APP_USER where USERNAME='John Doe'),2,"Franchement ce film est pas terrible"),
  ((select ID_MOVIE from MOVIE where TITRE="Toys Story 3"),(select ID_APP_USER from APP_USER where USERNAME='Tom Pike'),5,"Super cool pour les enfants !"),
  ((select ID_MOVIE from MOVIE where TITRE="Toys Story 3"),(select ID_APP_USER from APP_USER where USERNAME='Elton James'),5,NULL),
  ((select ID_MOVIE from MOVIE where TITRE="Rasta Rocket"),(select ID_APP_USER from APP_USER where USERNAME='John Doe'),4,"J'ai bien rigolé"),
  ((select ID_MOVIE from MOVIE where TITRE="Rasta Rocket"),(select ID_APP_USER from APP_USER where USERNAME='Tom Pike'),3,NULL),
  ((select ID_MOVIE from MOVIE where TITRE="Braveheart"),(select ID_APP_USER from APP_USER where USERNAME='Elton James'),1,"Ce film est trop violent pour moi."),
  ((select ID_MOVIE from MOVIE where TITRE="Moonraker"),(select ID_APP_USER from APP_USER where USERNAME='Bobby Wing'),5,NULL),
  ((select ID_MOVIE from MOVIE where TITRE="Moonraker"),(select ID_APP_USER from APP_USER where USERNAME='Tom Pike'),4,"Ca c'est du cinéma");