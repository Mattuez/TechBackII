SET foreign_key_checks = 0;

DELETE
    FROM categoria;

SET foreign_key_checks = 1;

ALTER TABLE categoria
    AUTO_INCREMENT = 1;

INSERT INTO categoria(id, nome)
    VALUES (1, "produto X"),
           (2, "produto y");