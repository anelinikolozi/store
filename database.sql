create database store;




----------------------------------------------------------------------------------------------------
create table categories
(
    id bigserial,
    parent_id bigint,
    category_name text not null
);

create unique index categories_id_uindex
    on categories (id);

alter table categories
    add constraint categories_pk
        primary key (id);

create table makers
(
    id bigserial,
    "makerName" text not null
);

create unique index makers_id_uindex
    on makers (id);

create unique index makers_makername_uindex
    on makers ("makerName");

alter table makers
    add constraint makers_pk
        primary key (id);



create table purchases
(
    id bigserial,
    product_id bigint not null,
    purchase_price numeric(10,3) not null,
    purchase_date text not null
);

create unique index purchases_id_uindex
    on purchases (id);

alter table purchases
    add constraint purchases_pk
        primary key (id);

create table sales
(
    id bigserial,
    product_id bigint not null,
    sell_price numeric(10,3) not null,
    sell_date text not null
);

create unique index sales_id_uindex
    on sales (id);

alter table sales
    add constraint sales_pk
        primary key (id);

create table products
(
    ean_code bigserial,
    product_name text not null,
    description text,
    maker_id bigint not null
        constraint products_makers_id_fk
            references makers,
    category_id bigint not null
        constraint products_categories_id_fk
            references categories,
    sell_price numeric(10,3) not null,
    remaining int not null
);

create unique index products_ean_code_uindex
    on products (ean_code);

alter table products
    add constraint products_pk
        primary key (ean_code);

alter table purchases
    add constraint purchases_products_ean_code_fk
        foreign key (product_id) references products;

alter table sales
    add constraint sales_products_ean_code_fk
        foreign key (product_id) references products;
alter table purchases alter column purchase_date set default now();
alter table purchases alter column purchase_date drop not null;

alter table purchases alter column purchase_date drop default;












