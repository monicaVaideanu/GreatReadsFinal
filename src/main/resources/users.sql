INSERT INTO user_details(created_at, updated_at, user_id,email, first_name, last_name, middle_name, password, role, username)
VALUES
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','1','vaideanumonica3@gmail.com', 'Popescu', 'Georgel', 'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'ADMIN', 'userAdmin'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','2', 'reader1@gmail.com', 'Pearson', 'Betty', 'Lili', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader1'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','3', 'reader2@gmail.com', 'Nichols', 'George', 'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER','userReader2'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','4', 'reader3@gmail.com', 'Mackenzie', 'Paul', 'Steve', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader3'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','5',  'reader4@gmail.com', 'Fogg', 'Steve', 'Steve', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader4'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','6', 'reader5@gmail.com', 'Hoffman', 'Joseph', 'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader5'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','7', 'reader6@gmail.com', 'Creanmer', 'Norman', 'Didi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader6'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','8', 'admin1@gmail.com', 'Mabry', 'Bill', 'Bryan', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'ADMIN', 'userAdmin2'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','9', 'reader7@gmail.com', 'McClaskey', 'Norma', 'Didi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader7'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','10', 'admin2@gmail.com', 'Duff', 'Bill', 'Cright', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'ADMIN', 'userAdmin3'),
    ('2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','11', 'author1@gmail.com', 'Hoffman', 'Joseph', 'Gigi', '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'AUTHOR', 'authorAuthor')
;
-- INSERT IGNORE INTO authors(author_id, created_at, updated_at, country, description, email, first_name, last_name, middle_name, password, role, username )
-- VALUES ('1','2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463', 'Specialized in poetry', 'Popescu', 'poet1@gmail.com', 'Popescu', 'Georgel', 'Gigi', 'Valid!2#22.I', 'AUTHOR', 'author1'),
-- ('2','2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463', 'Germany', 'Specialized in drama', 'auhtor2@gmail.com', 'Junker', 'Florin', 'Andrei', 'Eedfr345.5!', 'AUTHOR', 'authorReader1'),
-- ('3','2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463', 'Italy', 'Specialized in all genres ', 'author3@gmail.com', 'Muller', 'Dorian', 'Alex', 'EErft$33', 'AUTHOR', 'authorReader2'),
-- ('4','2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','Belgium', 'New to town', 'author4@gmail.com', 'Alexescu', 'Matei', 'Alex', 'Valid!2#22.I', 'AUTHOR', 'authorReader3'),
-- ('5','2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','France', 'Another author in town', 'author5@gmail.com', 'Maria', 'Ion', 'Ion', 'Valid!2#22.I', 'AUTHOR', 'authorReader4'),
-- ('6','2024-04-14 11:26:40.434463','2024-04-14 11:26:40.434463','Portugal', 'Lack of talent in description, my books speak for me', 'author6@gmail.com', 'Siri', 'Siri', 'Siri', 'Valid!2#22.I', 'AUTHOR', 'authorReader5')
-- ;

-- AUTORI CLASICI
INSERT INTO authors(author_id, firstName, lastName, description, country, middleName)
    VALUES
       (
       1, 'George', 'Orwell', 'Was a novelist, poet, essayist, journalist, and critic. His work is characterised by lucid prose, social criticism, opposition to totalitarianism, and support of democratic socialism.', 'United Kingdom', ''),
       (2, 'Fyodor', 'Dostoevsky', 'Was a novelist, short story writer, essayist and journalist. Numerous literary critics regard him as one of the greatest novelists in all of world literature, as many of his works are considered highly influential masterpieces.', 'Russia', 'Mikhailovich'),
       (3, 'Jane', 'Austen', 'Was a novelist known primarily for her six novels, which implicitly interpret, critique, and comment upon the British landed gentry at the end of the 18th century. Austen''s plots often explore the dependence of women on marriage for the pursuit of favourable social standing and economic security. Her works are an implicit critique of the novels of sensibility of the second half of the 18th century and are part of the transition to 19th-century literary realism.', 'United Kingdom', 'Elizabeth'),
       (4, 'Mark', 'Twain', 'Was a writer, humorist and essayist. He was praised as the "greatest humorist the United States has produced," with William Faulkner calling him "the father of American literature." His novels include The Adventures of Tom Sawyer (1876) and its sequel, Adventures of Huckleberry Finn (1884).', 'United States', 'Samuel'),
       (5, 'William', 'Shakespeare', 'Was a playwright, poet, and actor. He is widely regarded as the greatest writer in the English language and the world''s pre-eminent dramatist. He is often called England''s national poet and the "Bard of Avon" (or simply "the Bard").', 'United Kingdom', 'William'),
       (6, 'J. K.', 'Rowling', 'Is an author and philanthropist. She wrote Harry Potter, a seven-volume fantasy series published from 1997 to 2007. The series has sold over 600 million copies, been translated into 84 languages, and spawned a global media franchise including films and video games. The Casual Vacancy (2012) was her first novel for adults. ', 'United Kingdom', 'Rowling'),
       (7, 'Agatha', 'Christie', 'Was a writer known for her 66 detective novels and 14 short story collections, particularly those revolving around fictional detectives Hercule Poirot and Miss Marple. She also wrote the world''s longest-running play, the murder mystery The Mousetrap, which has been performed in the West End of London since 1952', 'United Kingdom', 'Christie')
);
-- AUTORI USERI
INSERT INTO authors(author_id, description, country, middleName, user_id)
       VALUES
       (8, 'Lack of talent in description, my books speak for me', 'Portugal', 'Siri',11);

INSERT INTO books(book_id, name, description,availbleToDownload,yearPublciation, publisher, avrRating, genres, languages, status, adminId, collection)
VALUES (1,'Numele cărții', 'Descrierea cărții', TRUE, 2022, 'Editura ABC', 4.5, 'PENDING', '/cale/catre/fisier.pdf');

INSERT INTO reviews(user_id,book_id,rating, reviewText, publishedDate ) VALUES ();
--review id is a composed id => ?
INSERT INTO wish_read_list(user_id,book_id, addDate, wish) VALUES ();
-- wishlist id is a composed id => also we need a different scripts for when a book is in done reading or when we started to read the book


INSERT INTO collections(collection_id, name)
VALUES (1, 'Classic Novels'),
       (2, 'Best Sellers'),
       (3, 'Harry Potter'),
       (4, 'Bridgerton'),
       (5,'The Chronicles of Narnia'),
       (6, 'The Lord of the Rings'),
       (7, 'The Hobbit'),
       (8, 'The Worlds Favourite Agatha Christie');

INSERT INTO genres(genre_id, genre_name, description)
VALUES
    (1, 'Detective', 'A genre of fiction in which a detective, either professional or amateur, investigates and solves crimes, often murder mysteries.'),
    (2, 'Fantasy', 'A genre of speculative fiction set in imaginary worlds or universes, often involving magic, mythical creatures, and epic battles between good and evil.'),
    (3, 'Horror', 'A genre of fiction intended to scare, frighten, or disgust the reader, often featuring supernatural elements, monsters, or psychological horror.'),
    (4, 'Mystery', 'A genre of fiction involving the solving of a crime or puzzle, typically by a detective or amateur sleuth, with suspense and surprise elements.'),
    (5, 'Poetry', 'A literary form characterized by rhythmical patterns of language, often conveying emotions, ideas, or experiences with artistic expression.'),
    (6, 'Romance', 'A genre of fiction centered around a romantic relationship between characters, often with themes of love, passion, and happy endings.'),
    (7, 'Science Fiction', 'A genre of speculative fiction often set in the future or in outer space, exploring scientific and technological advancements and their impact on society.'),
    (8, 'Thriller', 'A genre of fiction characterized by suspense, tension, and excitement, often involving dangerous situations, espionage, or criminal activity.'),
    (9, 'Adventure', 'A genre of fiction involving exciting, risky, or daring experiences, often set in exotic locations or involving exploration and discovery.'),
    (10, 'Biography', 'A genre of non-fictional writing that tells the life story of a real person, typically focusing on significant events, achievements, and experiences.'),
    (11, 'Comedy', 'A genre of literature intended to provoke laughter and amusement, often through humorous situations, dialogue, or characters.');

INSERT INTO languages(language_id, code, language_name)
VALUES (1, 'EN', 'English'),
       (2, 'ES', 'Spanish'),
       (3, 'FR', 'French'),
       (4, 'DE', 'German'),
       (5, 'IT', 'Italian')
       (6, 'PL', 'Polish'),
       (7, 'NL', 'Dutch'),
       (8, 'PT', 'Portuguese'),
       (9, 'TR', 'Turkish');