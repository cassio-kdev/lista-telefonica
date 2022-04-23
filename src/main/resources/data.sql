INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$8W4N48qJ4flwwPhO5ku1RepQUctWhRXL0KFQ6N15eSP6JkrlNHvhi');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$8W4N48qJ4flwwPhO5ku1RepQUctWhRXL0KFQ6N15eSP6JkrlNHvhi');

INSERT INTO PERFIL(id, nome) VALUES (1, 'ROLE_ALUNO');
INSERT INTO PERFIL(id, nome) VALUES (2, 'ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) values(1,1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) values(2,2);

insert into operadora(CATEGORIA ,CODIGO ,NOME,PRECO )values('Celular',15,'Oi',5),('Celular',21,'Vivo',3),('Fixo',55,'Embratel',2);
insert into contato(nome,data,telefone,operadora_id,serial)values('Maria','2021-02-02 12:12:12','12345678',3,':B4OK@N=8['),('Luisa','2020-02-02 12:12:12','12345679',1,'YB4OK@N=8['),('Jacy','2023-02-02 12:12:12','92345678',2,':B4OK@N=8P'),('Cassio','2019-02-02 12:12:12','52345678',1,':A4OK@N=8[');