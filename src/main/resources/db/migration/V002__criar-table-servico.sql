create table servico(
    id integer not null auto_increment,
    nome varchar(255) not null,
    valor double not null,
    categoria_id integer not null,

    primary key (id),
    constraint fk_servico_categoria_categoria_id
                    foreign key(categoria_id) references categoria(id)
);