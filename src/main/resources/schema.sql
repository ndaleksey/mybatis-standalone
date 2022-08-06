drop table if exists car;

create table if not exists car
(
    id    bigint unique not null,
    brand text          not null,
    model text          not null,
    primary key (id)
);

insert into car(id, brand, model)
values (1, 'BMW', 'X5'),
       (2, 'Haval', 'H9'),
       (3, 'KIA', 'Rio'),
       (4, 'LADA', 'Urban'),
       (5, 'Honda', 'Civic');

