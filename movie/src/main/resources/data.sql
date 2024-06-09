INSERT INTO MOVIE (TITRE,GENRE,DESCRIPTION,ID_MAIN_ACTOR) VALUES
  ('Toys Story 3','ANIMATION',"Les créateurs des très populaires films Toy Story ouvrent à nouveau le coffre à jouets et invitent les spectateurs à retrouver le monde délicieusement magique de Woody et Buzz au moment où Andy s'apprête à partir pour l'université.",1),
  ('Rasta Rocket','COMEDIE',"Comment une équipe de la Jamaïque, après de multiples aventures, va participer à l'épreuve de bobsleigh à quatre aux Jeux Olympiques d'hiver de Calgary.",2),
  ('Braveheart','DRAME',"Edouard Ier, roi d'Angleterre, s'empare du trône après avoir réglé un conflit avec le personnage fantoche qu'il y avait auparavant placé. William Wallace prend la tête d'une révolte paysanne.",3),
  ('Moonraker','THRILLER',"L'agent secret britannique James Bond enquête sur la disparition d'une navette spatiale americaine, Moonraker, confiee au gouvernement britannique. 007 se rend aux Etats-Unis pour interroger le responsable de la construction de la navette, Sir Hugo Drax.",4);

INSERT INTO REVIEW (ID_MOVIE,ID_REVIEWER,MARK,REVIEW_COMMENT) VALUES 
  (1,1,2,"Franchement ce film est pas terrible"),
  (1,2,5,"Super cool pour les enfants !"),
  (1,3,5,NULL),
  (2,1,4,"J'ai bien rigolé"),
  (2,2,3,NULL),
  (3,3,1,"Ce film est trop violent pour moi."),
  (3,4,5,NULL),
  (3,1,4,"Ca c'est du cinéma");