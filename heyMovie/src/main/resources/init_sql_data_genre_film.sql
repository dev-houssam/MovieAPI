-- =========================
-- INITIALISATION DES GENRES
-- =========================

INSERT INTO genre (id, name) VALUES
                                 (1, 'Action'),
                                 (2, 'Science Fiction'),
                                 (3, 'Drama'),
                                 (4, 'Comedy'),
                                 (5, 'Adventure'),
                                 (6, 'Fantasy'),
                                 (7, 'Thriller'),
                                 (8, 'Mystery'),
                                 (9, 'Romance'),
                                 (10, 'Animation'),
                                 (11, 'Family'),
                                 (12, 'History'),
                                 (13, 'War'),
                                 (14, 'Biography'),
                                 (15, 'Sport'),
                                 (16, 'Music'),
                                 (17, 'Documentary'),
                                 (18, 'Crime'),
                                 (19, 'Western'),
                                 (20, 'Philosophy');

-- =========================
-- INITIALISATION DES FILMS
-- =========================

INSERT INTO movie
(id, titre, annee_realisation, prix_location, age_minimum, ouvert_location)
VALUES
    (1, 'The Matrix', 1999, 4.99, 12, true),

    (2, 'Interstellar', 2014, 5.99, 10, true),

    (3, 'The Social Network', 2010, 3.99, 12, true),

    (4, 'The Pursuit of Happyness', 2006, 3.99, 10, true),

    (5, 'The Grand Budapest Hotel', 2014, 4.50, 10, false);

-- =========================
-- RELATIONS MOVIE <-> GENRE
-- =========================

INSERT INTO movies_genres (movie_id, genre_id) VALUES

-- Matrix
(1,1),   -- Action
(1,2),   -- Science Fiction

-- Interstellar
(2,2),   -- Science Fiction
(2,3),   -- Drama

-- Social Network
(3,3),   -- Drama

-- Pursuit of Happyness
(4,3),   -- Drama

-- Grand Budapest Hotel
(5,4);   -- Comedy