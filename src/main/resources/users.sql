INSERT INTO user_details(created_at, updated_at, user_id, email, first_name, last_name, middle_name, password, role,
                         username)
VALUES ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 1, 'monavaideanu@yahoo.com', 'Popescu', 'Georgel', 'Gigi',
        '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'ADMIN', 'userAdmin'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 2, 'reader1@gmail.com', 'Pearson', 'Betty', 'Lili',
        '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'READER', 'userReader1'),
       ('2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463', 3, 'reader2@gmail.com', 'Nichols', 'George', 'Gigi',
        '$2a$10$YOcywZh5rXginmE9RPmoKukLuUvLmcOPCv2Ehq5gZ.km/osRjqpb.', 'AUTHOR', 'userAuthor1');

INSERT INTO authors (author_id, first_name, last_name, description, country, middle_name, created_at, updated_at)
VALUES (1, 'George', 'Orwell',
        'Was a novelist, poet, essayist, journalist, and critic. His work is characterised by lucid prose, social criticism, opposition to totalitarianism, and support of democratic socialism.',
        'United Kingdom', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (2, 'Fyodor', 'Dostoevsky',
        'Was a novelist, short story writer, essayist and journalist. Numerous literary critics regard him as one of the greatest novelists in all of world literature, as many of his works are considered highly influential masterpieces.',
        'Russia', 'Mikhailovich', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (3, 'Jane', 'Austen',
        'Was a novelist known primarily for her six novels, which implicitly interpret, critique, and comment upon the British landed gentry at the end of the 18th century. Austen''s plots often explore the dependence of women on marriage in the pursuit of favourable social standing and economic security.',
        'United Kingdom', 'Elizabeth', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (4, 'Mark', 'Twain',
        'Was a writer, humorist, and essayist. He was praised as the "greatest humorist the United States has produced," with William Faulkner calling him "the father of American literature."',
        'United States', 'Samuel', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (5, 'William', 'Shakespeare',
        'Was a playwright, poet, and actor. He is widely regarded as the greatest writer in the English language and the world''s pre-eminent dramatist.',
        'United Kingdom', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (6, 'J. K.', 'Rowling',
        'Is an author and philanthropist. She wrote the Harry Potter series, a seven-volume fantasy series published from 1997 to 2007. The series has sold over 600 million copies, been translated into 84 languages, and spawned a global media franchise.',
        'United Kingdom', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (7, 'Agatha', 'Christie',
        'Was a writer known for her 66 detective novels and 14 short story collections, particularly those revolving around her fictional detectives Hercule Poirot and Miss Marple.',
        'United Kingdom', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (8, 'Charles', 'Dickens',
        'Was an English writer and social critic. He created some of the world''s best-known fictional characters and is regarded by many as the greatest novelist of the Victorian era.',
        'United Kingdom', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (9, 'Leo', 'Tolstoy',
        'Was a Russian writer who is regarded as one of the greatest authors of all time. He is best known for "War and Peace" (1869) and "Anna Karenina" (1877).',
        'Russia', 'Nikolayevich', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (10, 'Ernest', 'Hemingway',
        'Was an American novelist, short-story writer, and journalist. His economical and understated style had a strong influence on 20th-century fiction.',
        'United States', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (11, 'Virginia', 'Woolf',
        'Was an English writer, considered one of the most important modernist 20th-century authors and also a pioneer in the use of stream of consciousness as a narrative device.',
        'United Kingdom', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (12, 'Gabriel', 'García Márquez',
        'Was a Colombian novelist, short-story writer, screenwriter, and journalist, known affectionately as Gabo throughout Latin America.',
        'Colombia', 'José', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (13, 'Haruki', 'Murakami',
        'Is a contemporary Japanese writer. His books and stories have been bestsellers in Japan as well as internationally, with his work being translated into 50 languages and selling millions of copies outside his native country.',
        'Japan', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (14, 'Chinua', 'Achebe',
        'Was a Nigerian novelist, poet, professor, and critic. His first novel "Things Fall Apart" (1958) is the most widely read book in modern African literature.',
        'Nigeria', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (15, 'Isabel', 'Allende',
        'Is a Chilean writer. Allende, whose works sometimes contain aspects of the genre of "magical realism", is famous for novels such as "The House of the Spirits" and "City of the Beasts."',
        'Chile', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (16, 'Franz', 'Kafka',
        'Was a German-speaking Bohemian novelist and short-story writer, widely regarded as one of the major figures of 20th-century literature. His work fuses elements of realism and the fantastic.',
        'Czech Republic', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (17, 'Marcel', 'Proust',
        'Was a French novelist, critic, and essayist best known for his monumental novel "In Search of Lost Time"; it was published in seven parts between 1913 and 1927.',
        'France', 'Valentin Louis Georges Eugène Marcel', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (18, 'Toni', 'Morrison',
        'Was an American novelist, essayist, editor, teacher, and professor emeritus at Princeton University. Morrison won the Pulitzer Prize and the American Book Award in 1988 for "Beloved."',
        'United States', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (19, 'Orhan', 'Pamuk',
        'Is a Turkish novelist, screenwriter, academic and recipient of the 2006 Nobel Prize in Literature. One of Turkey''s most prominent novelists, his work has sold over thirteen million books in sixty-three languages.',
        'Turkey', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (20, 'Louise', 'Erdrich',
        'Is an American author, writer of novels, poetry, and children''s books featuring Native American characters and settings. She is an enrolled member of the Turtle Mountain Band of Chippewa Indians, a band of the Anishinaabe (also known as Ojibwe and Chippewa).',
        'United States', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (21, 'Alice', 'Munro',
        'Is a Canadian short story writer who won the Nobel Prize in Literature in 2013. Munro''s work has been described as having revolutionized the architecture of short stories, especially in its tendency to move forward and backward in time.',
        'Canada', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463'),
       (22, 'Mo', 'Yan',
        'Is a Chinese novelist and short story writer. Donald Morrison of the U.S. news magazine Time referred to him as "one of the most famous, oft-banned and widely pirated of all Chinese writers.", and he was awarded the Nobel Prize in Literature in 2012.',
        'China', '', '2024-04-14 11:26:40.434463', '2024-04-14 11:26:40.434463');
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
INTO books(book_id, name, description, available_to_download, year_publication, publisher, avr_rating, status, admin_id,
           collection_id)
VALUES (1, 'Pride and Justice',
        'A novel of manners, it follows the character development of Elizabeth Bennet, the protagonist of the book, who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.',
        FALSE, 1813, 'T. Egerton, Whitehall', 4.5, 'ACCEPTED', 1, 1),
       (2, 'The Mysterious Affair at Styles',
        'Is the first detective novel by British writer Agatha Christie, introducing her fictional detective Hercule Poirot.',
        FALSE, 1920, 'John Lane', 4.3, 'ACCEPTED', 1, 8),
       (3, 'And Then There Were None',
        'Is a mystery novel by the English writer Agatha Christie, who described it as the most difficult of her books to write.',
        FALSE, 1939, 'Collins Crime Club', 3.9, 'ACCEPTED', 1, 8),
       (4, '1984', 'A dystopian social science fiction novel and cautionary tale by English writer George Orwell. ',
        FALSE, 1949, 'Secker & Warburg', 4.7, 'ACCEPTED', 1, 2),
       (5, 'Animal Farm', 'An allegorical novella by George Orwell, first published in England on 17 August 1945. ',
        FALSE, 1945, 'Secker and Warburg', 4.6, 'ACCEPTED', 1, 1),
       (6, 'Crime and Punishment', 'A novel by the Russian author Fyodor Dostoevsky. ', FALSE, 1866,
        'The Russian Messenger', 4.8, 'ACCEPTED', 1, 1),
       (7, 'The Brothers Karamazov',
        'A passionate philosophical novel set in 19th-century Russia, that enters deeply into the ethical debates of God, free will, and morality. ',
        FALSE, 1880, 'The Russian Messenger', 4.9, 'ACCEPTED', 1, 1),
       (8, 'Sense and Sensibility',
        'A novel by Jane Austen, published in 1811. It was published anonymously; By A Lady appears on the cover page where the author''s name might have been. ',
        FALSE, 1811, 'Thomas Egerton, Military Library', 4.5, 'ACCEPTED', 1, 1),
       (9, 'Pride and Prejudice', 'An 1813 romantic novel of manners by Jane Austen. ', FALSE, 1813,
        'T. Egerton, Whitehall', 4.7, 'ACCEPTED', 1, 1),
       (10, 'Adventures of Huckleberry Finn',
        'A novel by Mark Twain, published in the United Kingdom in 1884 and in the United States in 1885. ', FALSE,
        1884, 'Charles L. Webster And Company', 4.6, 'ACCEPTED', 1, 1),
       (11, 'The Adventures of Tom Sawyer', 'A novel by Mark Twain published in 1876. ', FALSE, 1876,
        'American Publishing Company', 4.4, 'ACCEPTED', 1, 1);
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

INSERT INTO book_genre (book_id, genre_id)
VALUES (1, 6),
       (2, 1),
       (3, 1),
       (4, 7),
       (5, 7),
       (6, 4),
       (7, 4),
       (8, 6),
       (9, 6),
       (10, 9),
       (11, 9);

INSERT INTO book_language(book_id, language_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (1, 2),
       (1, 3),
       (2, 5),
       (3, 5),
       (3, 6),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 1);
INSERT INTO books_to_authors(author_id, book_id)
VALUES (3, 1),
       (7, 2),
       (7, 3),
       (1, 4),
       (1, 5),
       (2, 6),
       (2, 7),
       (3, 8),
       (3, 9),
       (4, 10),
       (4, 11);

INSERT INTO reviews(user_id, book_id, rating, review_text, published_date)
VALUES (1, 1, 5, 'This is a great book', '2024-04-14 11:26:40.434463'),
       (1, 2, 3.9, 'This is a good book', '2024-04-14 11:26:40.434463'),
       (1, 3, 4.2, 'Good for a beginner', '2024-04-14 11:26:40.434463'),
       (2, 1, 3.5, 'Not so great', '2024-04-14 11:26:40.434463'),
       (2, 2, 3.7, 'Good for a summer day', '2024-04-14 11:26:40.434463'),
       (2, 3, 3.9, 'nice', '2024-04-14 11:26:40.434463'),
       (3, 1, 2.1, 'Boring', '2024-04-14 11:26:40.434463'),
       (3, 2, 3.7, 'This is a good book', '2024-04-14 11:26:40.434463'),
       (3, 3, 4.1, 'This is a great book', '2024-04-14 11:26:40.434463'),
       (1, 4, 3.9, 'This is a good book', '2024-04-14 11:26:40.434463'),
       (1, 5, 4.2, 'Good for a beginner', '2024-04-14 11:26:40.434463'),
       (2, 6, 3.5, 'Not so great', '2024-04-14 11:26:40.434463');

insert into wish_read_list(add_date, book_id, user_id, wish)
VALUES(localtime(), 1,1,wish);
(localtime(), 2,1,wish),
(localtime(), 3,1,wish),
(localtime(), 4,1,wish),
(localtime(), 5,1,wish),
(localtime(), 6,1,wish),
(localtime(), 1,2,wish),
(localtime(), 2,2,wish),
(localtime(), 3,2,wish),
(localtime(), 1,3,wish),
(localtime(), 2,3,wish),
(localtime(), 3,3,wish);