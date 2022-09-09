-- 1 para modo safe(original)
SET SQL_SAFE_UPDATES = 0;

drop database if exists db_BancoDelt;
Create database db_BancoDelt;
use db_BancoDelt;

create table if not exists banco(
	id_agencia int unsigned not null auto_increment,
    agencia varchar(4) not null,
    primary key (id_agencia),
    unique key (agencia)
);

create table if not exists estilo_conta(
	id_estilo int unsigned not null auto_increment,
    estilo_acc varchar(15) not null,
    primary key (id_estilo),
    unique key (estilo_acc)
);

create table if not exists usuario(
	id_usuario int unsigned not null auto_increment,
    fk_agencia int not null references banco(id_agencia),
    fk_TipoAcc int not null references estilo_conta(id_estilo),
    conta varchar(11) not null, 
    cpf varchar(14) not null,
    email varchar(100) not null,
    celular varchar(14)not null,
    nome_titular varchar(75) not null,
    sexo enum('Prefiro não dizer','Masculino','Feminino') not null,
    senha text not null,
    dNascimento varchar(10) not null,
    dCriacao varchar(10) not null,
    saldo double,
    primary key (id_usuario),
    unique key (cpf),
    unique key (email),
    unique key (celular),
    unique key (nome_titular)
);

create table if not exists extrato(
	id_extrato int unsigned not null auto_increment,
    data_transacao varchar(10) not null,
    tipo_transacao varchar(20) not null,
    valor_transacao double not null,
    saldo_anterior double not null,
    saldo_posterior double not null,
    fk_usuario int not null references usuario(id_usuario),
    primary key (id_extrato)
);

-- um usuario pode ter varias chaves pix
create table if not exists pix(
	id_pix int not null auto_increment,
    chave_pix varchar(30),
    fk_usuario int references usuario(id_usuario),
    primary key (id_pix),
    unique key (chave_pix)
);

insert into banco (agencia) values
('0001');

insert into estilo_conta (id_estilo, estilo_acc) values
(1, 'Conta Poupanca'),
(2, 'Conta Corrente');

insert into usuario (fk_agencia, fk_tipoacc, conta, cpf, email, celular, nome_titular, sexo, senha, dnascimento, dcriacao, saldo) values 
(1, 1, '01011123-1', '000.000.000-01', '01@gmail.com','(41)12345-6789','ADMIN POUPANÇA','Masculino','123','01/01/2022','01/01/2022',1.33),
(1, 2, '01011123-2', '000.000.000-02', '02@gmail.com','(42)12345-6789','ADMIN CORRENTE','Masculino','123','02/02/2022','02/02/2022',247760.84);

-- PROCEDURE PARA REGISTRAR usuario
delimiter $
create procedure registra_titular (fk_agencia int, fk_tipoacc int, conta varchar(11), cpf varchar(14), email varchar(100), celular varchar(14), nome_titular varchar(75), sexo enum('Prefiro não dizer','Masculino','Feminino'), senha text, dnascimento varchar(10), dcriacao varchar(10), saldo long)
begin
	insert into usuario values(id_usuario, fk_agencia, fk_tipoacc, conta, cpf, email, celular, nome_titular, sexo, senha, dnascimento, dcriacao, saldo);
end $
delimiter ;

call registra_titular (1, 1, '01011123-3', '000.000.000-03', '03@gmail.com','(43)12345-6789','ADMIN procedure call','Masculino','1234','01/01/2022','01/01/2022',135.45);


select usuario.*, banco.agencia from usuario, banco where cpf='000.000.000-01';
select * from usuario where cpf='000.000.000-01';
select usuario.*, banco.agencia from usuario, banco;

update usuario set saldo=2 where conta='01011123-1';

select saldo from usuario where conta='01011123-1';


update usuario set saldo=49 where conta='01011123-1';
update usuario set saldo=2 where conta='01011123-2';


