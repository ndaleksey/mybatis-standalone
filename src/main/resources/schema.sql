drop table if exists client cascade;

create table if not exists client
(
    id   bigint unique not null,
    name text          not null,
    age  int,

    primary key (id)
);

drop table if exists car;

create table if not exists car
(
    id        bigint unique not null,
    brand     text          not null,
    model     text          not null,
    client_id bigint,

    primary key (id),
    foreign key (client_id) references client (id) on delete cascade on update cascade
);

insert into client(id, name, age)
values (1, 'Ivan', 34),
       (2, 'Alex', 36);


insert into car(id, brand, model, client_id)
values (1, 'BMW', 'X5', 1),
       (2, 'Haval', 'H9', 2),
       (3, 'KIA', 'Rio', null),
       (4, 'LADA', 'Urban', null),
       (5, 'Honda', 'Civic', null);

