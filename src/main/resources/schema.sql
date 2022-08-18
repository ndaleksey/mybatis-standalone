drop table if exists client cascade;

create table if not exists client
(
    id   serial unique not null,
    name text          not null,
    age  int,

    primary key (id)
);

drop table if exists car;

create table if not exists car
(
    id        serial unique not null,
    brand     text          not null,
    model     text          not null,
    client_id bigint,

    primary key (id),
    foreign key (client_id) references client (id) on delete cascade on update cascade
);

insert into client( name, age)
values ('Ivan', 34),
       ('Alex', 36);


insert into car(brand, model, client_id)
values ('BMW', 'X5', 1),
       ('Haval', 'H9', 2),
       ('KIA', 'Rio', null),
       ('LADA', 'Urban', null),
       ('Honda', 'Civic', null);

