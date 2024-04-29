INSERT INTO books(book_id, name, description, available_to_download, year_publication, publisher, avr_rating)
VALUES (1, 'Harry Potter and the Philosopher''s Stone', 'The first book in the Harry Potter series.', true, '1997',
        'Bloomsbury Publishing', 4.5),
       (2, 'To Kill a Mockingbird', 'A novel by Harper Lee.', false, '1960', 'J.B. Lippincott & Co.', 4.8),
       (3, 'The Great Gatsby', 'A novel by F. Scott Fitzgerald.', true, '1925', 'Charles Scribner''s Sons', 4.7),
       (4, 'Fictitious Book', 'Description of the fictitious book.', true, '2023', 'Fictitious Publishing House', 4.0);

INSERT INTO collections(collection_id, name)
VALUES (1, 'Classic Novels'),
       (2, 'Best Sellers');

INSERT INTO authors(author_id, first_name, last_name, description, country)
VALUES (1, 'J.K.', 'Rowling', 'British author known for the Harry Potter series.', 'United Kingdom'),
       (2, 'Harper', 'Lee', 'American author best known for "To Kill a Mockingbird."', 'United States'),
       (3, 'F. Scott', 'Fitzgerald', 'American author known for "The Great Gatsby."', 'United States'),
       (4, 'John', 'Doe', 'Fictitious author of the Fictitious Book.', 'Unknown');

INSERT INTO books_to_authors(book_id, author_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);

INSERT INTO reviews(user_id, book_id, rating, review_text, publish_date)
VALUES (1, 1, 4.3, 'O carte foarte bună, pentru adolescenți.', NOW()),
       (1, 2, 2.0, 'Nu am nici o idee ce ar trebui să scriu aici.', NOW()),
       (2, 4, 3.1, 'O nouă carte într-un domeniu necunoscut.', NOW());

INSERT INTO wish_read_list(user_id, book_id, add_date, wish)
VALUES (4, 1, NOW(), 'WISH');

INSERT INTO wish_read_list(user_id, book_id, add_date, wish, start_date, end_date)
VALUES (2, 3, NOW(), 'READ', '2024-01-20', '2024-02-28');
