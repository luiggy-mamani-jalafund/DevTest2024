create extension if not exists "pgcrypto";

create table if not exists polls (
    id UUID primary key default gen_random_uuid(),
    name varchar(100) not null
);

create table if not exists poll_options (
    id UUID primary key default gen_random_uuid(),
    name varchar(100) not null,

    poll_id UUID not null,
    constraint fk_poll_id foreign key (poll_id) references polls(id) on delete cascade
);

create table if not exists poll_votes (
    id UUID primary key default gen_random_uuid(),
    user_email varchar(100) not null,

    poll_option_id UUID not null,
    constraint fk_poll_option_id foreign key (poll_option_id) references poll_options(id) on delete cascade
);