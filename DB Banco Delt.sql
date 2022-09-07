drop database if exists db_BancoDelt;
Create database db_BancoDelt;
use db_BancoDelt;

create table if not exists banco(
	id_agencia int unsigned not null auto_increment,
    agencia varchar(4) not null,
    primary key (id_agencia),
    unique key (agencia)
);
insert into banco (agencia) values
('0001');


create table if not exists estilo_conta(
	id_estilo int not null auto_increment,
    estilo_acc varchar(15) not null,
    fk_banco int references banco(id_agencia),
    primary key (id_estilo),
    unique key (estilo_acc)
);
insert into estilo_conta (id_estilo, estilo_acc, fk_banco) values
(1, 'Conta Poupanca', 1),
(2, 'Conta Corrente', 1);


create table if not exists usuario(
	id_usuario int not null auto_increment,
    fk_agencia int not null references banco(id_agencia),
    fk_TipoAcc int not null references estilo_conta(id_estilo),
    id_conta varchar(11) not null, 
    cpf varchar(14) not null,
    email varchar(100) not null,
    celular varchar(14)not null,
    nome_titular varchar(75) not null,
    sexo enum('Prefiro não dizer','Masculino','Feminino') not null,
    senha text not null,
    dNascimento varchar(10) not null,
    dCriacao varchar(10) not null,
    saldo long,
    primary key (id_usuario),
    unique key (cpf),
    unique key (email),
    unique key (celular),
    unique key (nome_titular)
);
insert into usuario (fk_agencia, fk_tipoacc, id_conta, cpf, email, celular, nome_titular, sexo, senha, dnascimento, dcriacao, saldo) values 
(1, 1, '01011123-1', '000.000.000-01', '01@gmail.com','(41)12345-6789','ADMIN POUPANÇA','Masculino','123','01/01/2022','01/01/2022',10000),
(1, 2, '01011123-2', '000.000.000-02', '02@gmail.com','(42)12345-6789','ADMIN CORRENTE','Masculino','123','02/02/2022','02/02/2022',200000);

select cpf, senha, fk_tipoacc from usuario where cpf='000.000.000-01';

select * from usuario where cpf='000.000.000-01';
select * from banco where id_agencia=1;

