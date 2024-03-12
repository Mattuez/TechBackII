SET foreign_key_checks = 0;

DELETE
    FROM categoria;
DELETE
    FROM servico;

SET foreign_key_checks = 1;

ALTER TABLE categoria
    AUTO_INCREMENT = 1;
ALTER TABLE servico
    AUTO_INCREMENT = 1;

INSERT INTO categoria(id, nome)
    VALUES (1, "categoria X"),
           (2, "categoria y");
INSERT INTO servico(id, nome, valor, categoria_id)
    VALUES(1, "servico 1", 10, 1),
          (2, "servico 2", 20, 2);