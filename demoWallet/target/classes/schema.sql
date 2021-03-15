drop table if exists walletaccounts;

create table walletaccounts
(
    walletId           bigint auto_increment primary key not null,
    userId 				VARCHAR(10)                      NOT NULL,
    money               decimal                            NOT NULL
);

drop table if exists transactions;

create table transactions
(
    transactionId           bigint auto_increment primary key not null,
    sourceId 				bigint                   			NOT NULL,
    destId					bigint							 NOT NULL ,
    money               decimal                            NOT NULL
);
