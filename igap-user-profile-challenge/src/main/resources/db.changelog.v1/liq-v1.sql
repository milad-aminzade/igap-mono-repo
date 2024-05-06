--liquibase formatted sql
--changeset author:aminizadeh-v0-1-0;
create table address (
                         city_id bigint,
                         created_date bigint,
                         modified_date bigint,
                         id binary(16) not null,
                         created_by varchar(255),
                         latitude varchar(255),
                         location varchar(255),
                         longitude varchar(255),
                         modified_by varchar(255),
                         primary key (id));

create table city (
                      created_date bigint,
                      id bigint not null,
                      modified_date bigint,
                      province_id bigint,
                      created_by varchar(255),
                      modified_by varchar(255),
                      title varchar(255),
                      primary key (id));

create table city_seq (
    next_val bigint
);

insert into city_seq values ( 1 );

create table mobile_numbers (
                                created_date bigint,
                                last_inquiry datetime(6),
                                last_otp datetime(6),
                                modified_date bigint,
                                id binary(16) not null,
                                person_id binary(16),
                                created_by varchar(255),
                                mobile_no varchar(255),
                                modified_by varchar(255),
                                primary key (id));

create table person (
                        is_enabled bit not null,
                        birthdate bigint,
                        created_date bigint,
                        modified_date bigint,
                        address_id binary(16),
                        id binary(16) not null,
                        person_id binary(16),
                        bio varchar(255),
                        created_by varchar(255),
                        email varchar(255),
                        father varchar(255),
                        mobile varchar(255),
                        modified_by varchar(255),
                        name varchar(255),
                        picture_path varchar(255),
                        surname varchar(255),
                        username varchar(255),
                        primary key (id));

create table province (
                          created_date bigint,
                          id bigint not null,
                          modified_date bigint,
                          created_by varchar(255),
                          modified_by varchar(255),
                          title varchar(255),
                          primary key (id));

create table province_seq (
    next_val bigint);

insert into province_seq values ( 1 );

alter table mobile_numbers
    add constraint UK_17lkf9j52kq54s0wj4og20bbn unique (person_id);

alter table mobile_numbers
    add constraint UK_gqjcv444x8q85pp719ilttsve unique (mobile_no);

alter table address
    add constraint FKpo044ng5x4gynb291cv24vtea
        foreign key (city_id)
            references city (id);

alter table city
    add constraint FKll21eddgtrjc9f40ueeouyr8f
        foreign key (province_id)
            references province (id);

alter table mobile_numbers
    add constraint FK7xcr57y9p51wwi6oae0rwj0ja
        foreign key (person_id)
            references person (id);

alter table person
    add constraint FKk7rgn6djxsv2j2bv1mvuxd4m9
        foreign key (address_id)
            references address (id);

alter table person
    add constraint FKql92wwj4pd5sx6b7t17vpo6uf
        foreign key (person_id)
            references person (id);