INSERT INTO user_details(created_at, updated_at, user_id, email, first_name, last_name, middle_name, password, role,
                         username)
VALUES ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 1, 'AAAAA@gmail.com', 'Popescu',
        'Georgel', 'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'ADMIN', 'userAdmin'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 2, 'reader1@gmail.com', 'Pearson', 'Betty',
        'Lili', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader1'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 3, 'reader2@gmail.com', 'Nichols', 'George',
        'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader2'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 4, 'reader3@gmail.com', 'Mackenzie', 'Paul',
        'Steve', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader3'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 5, 'reader4@gmail.com', 'Fogg', 'Steve', 'Steve',
        '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader4'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 6, 'reader5@gmail.com', 'Hoffman', 'Joseph',
        'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader5'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 7, 'reader6@gmail.com', 'Creanmer', 'Norman',
        'Didi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader6'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 8, 'admin1@gmail.com', 'Mabry', 'Bill', 'Bryan',
        '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'ADMIN', 'userAdmin2'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 9, 'reader7@gmail.com', 'McClaskey', 'Norma',
        'Didi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader7'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 10, 'admin2@gmail.com', 'Duff', 'Bill', 'Cright',
        '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'ADMIN', 'userAdmin3'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463',11, 'author1@gmail.com', 'Hoffman', 'Joseph',
        'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'AUTHOR', 'authorAuthor')
;
-- AUTORI CLASICI
INSERT INTO authors (author_id, first_name, last_name, description, country, middle_name, created_at, updated_at)
VALUES
    (1, 'George', 'Orwell', 'Was a novelist, poet, essayist, journalist, and critic. His work is characterised by lucid prose, social criticism, opposition to totalitarianism, and support of democratic socialism.', 'United Kingdom', ' ', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
    (2, 'Fyodor', 'Dostoevsky', 'Was a novelist, short story writer, essayist and journalist. Numerous literary critics regard him as one of the greatest novelists in all of world literature, as many of his works are considered highly influential masterpieces.', 'Russia', 'Mikhailovich', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
    (3, 'Jane', 'Austen', 'Was a novelist known primarily for her six novels, which implicitly interpret, critique, and comment upon the British landed gentry at the end of the 18th century. Austen''s plots often explore the dependence of women on marriage for the pursuit of favourable social standing and economic security. Her works are an implicit critique of the novels of sensibility of the second half of the 18th century and are part of the transition to 19th-century literary realism.', 'United Kingdom', 'Elizabeth', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
    (4, 'Mark', 'Twain', 'Was a writer, humorist and essayist. He was praised as the "greatest humorist the United States has produced," with William Faulkner calling him "the father of American literature." His novels include The Adventures of Tom Sawyer (1876) and its sequel, Adventures of Huckleberry Finn (1884).', 'United States', 'Samuel', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
    (5, 'William', 'Shakespeare', 'Was a playwright, poet, and actor. He is widely regarded as the greatest writer in the English language and the world''s pre-eminent dramatist. He is often called England''s national poet and the "Bard of Avon" (or simply "the Bard").', 'United Kingdom', 'William',    '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
    (6, 'J. K.', 'Rowling', 'Is an author and philanthropist. She wrote Harry Potter, a seven-volume fantasy series published from 1997 to 2007. The series has sold over 600 million copies, been translated into 84 languages, and spawned a global media franchise including films and video games. The Casual Vacancy (2012) was her first novel for adults.', 'United Kingdom', 'Rowling', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
    (7, 'Agatha', 'Christie', 'Was a writer known for her 66 detective novels and 14 short story collections, particularly those revolving around fictional detectives Hercule Poirot and Miss Marple. She also wrote the world''s longest-running play, the murder mystery The Mousetrap, which has been performed in the West End of London since 1952', 'United Kingdom', 'Christie', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463');

-- AUTORI USERI
INSERT INTO authors(author_id, description, country, middle_Name, user_id, created_at, updated_at,first_name, last_name)
VALUES (8, 'Lack of talent in description, my books speak for me', 'Portugal', 'Siri', 11, '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 'Hoffman', 'Joseph');

INSERT INTO collections(collection_id, name)
VALUES (1, 'Classic Novels'),
       (2, 'Best Sellers'),
       (3, 'Harry Potter'),
       (4, 'Bridgerton'),
       (5, 'The Chronicles of Narnia'),
       (6, 'The Lord of the Rings'),
       (7, 'The Hobbit'),
       (8, 'The Worlds Favourite Agatha Christie');
INSERT
INTO books(book_id, name, description, available_to_download, year_publication, publisher, avr_rating, status, admin_id, collection_id)
VALUES (1, 'Pride and Justice',
        'A novel of manners, it follows the character development of Elizabeth Bennet, the protagonist of the book, who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.',
        FALSE, 1813, 'T. Egerton, Whitehall', 4.5, 'ACCEPTED', 1, 1),
       (2, 'The Mysterious Affair at Styles',
        'Is the first detective novel by British writer Agatha Christie, introducing her fictional detective Hercule Poirot.',
        FALSE, 1920, 'John Lane', 4.3, 'ACCEPTED', 1, 8),
       (3, 'And Then There Were None',
        'Is a mystery novel by the English writer Agatha Christie, who described it as the most difficult of her books to write.',
        FALSE, 1939, 'Collins Crime Club', 3.9, 'ACCEPTED', 1, 8);

INSERT INTO genres(genre_id, genre_name, description)
VALUES (1, 'Detective',
        'A genre of fiction in which a detective, either professional or amateur, investigates and solves crimes, often murder mysteries.'),
       (2, 'Fantasy',
        'A genre of speculative fiction set in imaginary worlds or universes, often involving magic, mythical creatures, and epic battles between good and evil.'),
       (3, 'Horror',
        'A genre of fiction intended to scare, frighten, or disgust the reader, often featuring supernatural elements, monsters, or psychological horror.'),
       (4, 'Mystery',
        'A genre of fiction involving the solving of a crime or puzzle, typically by a detective or amateur sleuth, with suspense and surprise elements.'),
       (5, 'Poetry',
        'A literary form characterized by rhythmical patterns of language, often conveying emotions, ideas, or experiences with artistic expression.'),
       (6, 'Romance',
        'A genre of fiction centered around a romantic relationship between characters, often with themes of love, passion, and happy endings.'),
       (7, 'Science Fiction',
        'A genre of speculative fiction often set in the future or in outer space, exploring scientific and technological advancements and their impact on society.'),
       (8, 'Thriller',
        'A genre of fiction characterized by suspense, tension, and excitement, often involving dangerous situations, espionage, or criminal activity.'),
       (9, 'Adventure',
        'A genre of fiction involving exciting, risky, or daring experiences, often set in exotic locations or involving exploration and discovery.'),
       (10, 'Biography',
        'A genre of non-fictional writing that tells the life story of a real person, typically focusing on significant events, achievements, and experiences.'),
       (11, 'Comedy',
        'A genre of literature intended to provoke laughter and amusement, often through humorous situations, dialogue, or characters.');

INSERT INTO languages(language_id, code, language_name)
VALUES (1, 'EN', 'English'),
       (2, 'ES', 'Spanish'),
       (3, 'FR', 'French'),
       (4, 'DE', 'German'),
       (5, 'IT', 'Italian'),
       (6, 'PL', 'Polish'),
       (7, 'NL', 'Dutch'),
       (8, 'PT', 'Portuguese'),
       (9, 'TR', 'Turkish');

INSERT INTO book_genre(book_id, genre_id)
VALUES (1, 6),
       (2, 1),
       (3, 1);
INSERT INTO book_language(book_id, language_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (1, 2),
       (1, 3),
       (2, 5),
       (3, 5),
       (3, 6);
INSERT INTO books_to_authors(author_id, book_id)
VALUES (3, 1),
       (7, 2),
       (7, 3);

INSERT INTO reviews(user_id, book_id, rating, review_text, published_date)
VALUES (1, 1, 5, 'This is a great book',    '2024-04-14 11:26:40.434463'),
       (1, 2, 3.9, 'This is a good book',  '2024-04-14 11:26:40.434463'),
       (1, 3, 4.2, 'This is a great book', '2024-04-14 11:26:40.434463'),
       (2, 1, 4.5, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (2, 2, 3.5, 'This is a good book',  '2024-04-14 11:26:40.434463'),
       (2, 3, 3.9, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (3, 1, 3.2, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (3, 2, 3.7, 'This is a good book',   '2024-04-14 11:26:40.434463'),
       (3, 3, 4.1, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (4, 1, 4.3, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (4, 2, 4.0, 'This is a good book',   '2024-04-14 11:26:40.434463'),
       (4, 3, 4.5, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (5, 1, 3.1, 'This is a great book','2024-04-14 11:26:40.434463'),
       (5, 2, 3.1, 'This is a good book',   '2024-04-14 11:26:40.434463'),
       (5, 3, 3.1, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (6, 1, 4.1, 'This is a great book',  '2024-04-14 11:26:40.434463'),
       (6, 2, 3.2, 'This is a good book',   '2024-04-14 11:26:40.434463');