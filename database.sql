create table categories
(
    id bigserial
        constraint categories_pk
            primary key,
    parent_id bigint,
    category_name text not null
);

alter table categories owner to "user";

create unique index categories_id_uindex
    on categories (id);

create table makers
(
    id bigserial
        constraint makers_pk
            primary key,
    "makerName" text not null
);

alter table makers owner to "user";

create unique index makers_id_uindex
    on makers (id);

create unique index makers_makername_uindex
    on makers ("makerName");

create table products
(
    ean_code bigserial
        constraint products_pk
            primary key,
    product_name text not null,
    description text,
    maker_id bigint not null
        constraint products_makers_id_fk
            references makers,
    category_id bigint not null
        constraint products_categories_id_fk
            references categories,
    sell_price numeric(10,3) not null,
    remaining integer not null
);

alter table products owner to "user";

create table purchases
(
    id bigserial
        constraint purchases_pk
            primary key,
    product_id bigint not null
        constraint purchases_products_ean_code_fk
            references products,
    purchase_price numeric(10,3) not null,
    purchase_date timestamp
);

alter table purchases owner to "user";

create unique index purchases_id_uindex
    on purchases (id);

create table sales
(
    id bigserial
        constraint sales_pk
            primary key,
    product_id bigint not null
        constraint sales_products_ean_code_fk
            references products,
    sell_price numeric(10,3) not null,
    sell_date timestamp not null
);

alter table sales owner to "user";

create unique index sales_id_uindex
    on sales (id);

create unique index products_ean_code_uindex
    on products (ean_code);











