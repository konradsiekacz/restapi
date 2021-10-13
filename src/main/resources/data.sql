INSERT INTO post(title, content, created) values ('dupa', 'Content 1', CURRENT_TIMESTAMP);
-- INSERT INTO post(id, title, content, created) values (2, 'Test post 2', 'Content 2', CURRENT_TIMESTAMP);
-- INSERT INTO post(id, title, content, created) values (3, 'Test post 3', 'Content 3', CURRENT_TIMESTAMP);
-- INSERT INTO post(id, title, content, created) values (4, 'Test post 4', 'Content 4', CURRENT_TIMESTAMP);
-- INSERT INTO post(id, title, content, created) values (5, 'Test post 5', 'Content 5', CURRENT_TIMESTAMP);


INSERT INTO comment(content, created) values ('Komentarz 1', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (2, 'Komentarz 2', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (3, 'Komentarz 3', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (4, 'Komentarz 4', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (5, 'Komentarz 5', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (6, 'Komentarz 6', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (7, 'Komentarz 7', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (8, 'Komentarz 8', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (9, 'Komentarz 9', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (10, 'Komentarz 10', CURRENT_TIMESTAMP );
-- INSERT INTO comment(id, content, created) values (11, 'Komentarz 11', CURRENT_TIMESTAMP );

INSERT INTO post_comments(post_id, comments_id) values (1,1);
-- INSERT INTO post_comments(post_id, comments_id) values (1,2);
-- INSERT INTO post_comments(post_id, comments_id) values (1,3);
-- INSERT INTO post_comments(post_id, comments_id) values (2,4);
-- INSERT INTO post_comments(post_id, comments_id) values (2,5);
-- INSERT INTO post_comments(post_id, comments_id) values (3,6);
-- INSERT INTO post_comments(post_id, comments_id) values (3,7);
-- INSERT INTO post_comments(post_id, comments_id) values (4,8);
-- INSERT INTO post_comments(post_id, comments_id) values (4,9);
-- INSERT INTO post_comments(post_id, comments_id) values (5,10);
-- INSERT INTO post_comments(post_id, comments_id) values (5,11);

-- CREATE TABLE POST
-- (
--     id       PRIMARY KEY,
--     title   VARCHAR(400)  NOT NULL,
--     content VARCHAR(2000) NULL,
--     created timestamp
-- );
--
-- CREATE TABLE COMMENT
-- (
--     id      PRIMARY KEY,
--     content VARCHAR(2000) NULL,
--     created timestamp
-- );

-- ALTER TABLE COMMENT
--     ADD CONSTRAINT comment_post_id
--         FOREIGN KEY (post_id) REFERENCES post (id)
