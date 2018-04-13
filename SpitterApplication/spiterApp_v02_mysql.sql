/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     4/11/2018 6:32:57 PM                         */
/*==============================================================*/


drop table if exists COMMENTS;

drop table if exists REETWEET;

drop table if exists SPITTER;

drop table if exists SPITTLE;

/*==============================================================*/
/* Table: COMMENTS                                              */
/*==============================================================*/
create table COMMENTS
(
   COMMENT_ID           bigint not null auto_increment,
   SPITTLE_ID           bigint,
   REETWEET_ID          bigint,
   SPITTER_ID           bigint,
   COMMENT_TIMESTAMP    timestamp,
   COMMENT_MESSAGE      varchar(2048),
   COMMENT_LIKES        int,
   primary key (COMMENT_ID)
);

/*==============================================================*/
/* Table: REETWEET                                              */
/*==============================================================*/
create table REETWEET
(
   REETWEET_ID          bigint not null auto_increment,
   SPITTER_ID           bigint,
   SPITTLE_ID           bigint,
   RETWEET_MESSAGE      varchar(2048),
   RETWEET_LONGITUDE    decimal,
   RETWEET_LATITUDE     decimal,
   RETWEET_LIKES        int,
   RETWEET_COMMENTS     int,
   RETWEET_TIMESTAMP    timestamp,
   primary key (REETWEET_ID)
);

/*==============================================================*/
/* Table: SPITTER                                               */
/*==============================================================*/
create table SPITTER
(
   SPITTER_ID           bigint not null auto_increment,
   SPITTER_USERNAME     varchar(1024),
   SPITTER_EMAIL        varchar(1024),
   SPITTER_PASSWORD     varchar(1024),
   SPITTER_PROFILE_PICTURE varchar(1024),
   primary key (SPITTER_ID)
);

/*==============================================================*/
/* Table: SPITTLE                                               */
/*==============================================================*/
create table SPITTLE
(
   SPITTLE_ID           bigint not null,
   SPITTER_ID           bigint,
   SPITTLE_MESSAGE      varchar(2048),
   SPITTLE_TIMESTAMP    timestamp,
   SPITTLE_LONGITUDE    decimal,
   SPITTLE_LATITUDE     decimal,
   SPITTLE_LIKES        int,
   SPITTLE_COMMENTS     int,
   primary key (SPITTLE_ID)
);

alter table COMMENTS add constraint FK_RELATIONSHIP_2 foreign key (SPITTER_ID)
      references SPITTER (SPITTER_ID) on delete restrict on update restrict;

alter table COMMENTS add constraint FK_RELATIONSHIP_3 foreign key (SPITTLE_ID)
      references SPITTLE (SPITTLE_ID) on delete restrict on update restrict;

alter table COMMENTS add constraint FK_RELATIONSHIP_6 foreign key (REETWEET_ID)
      references REETWEET (REETWEET_ID) on delete restrict on update restrict;

alter table REETWEET add constraint FK_RELATIONSHIP_4 foreign key (SPITTER_ID)
      references SPITTER (SPITTER_ID) on delete restrict on update restrict;

alter table REETWEET add constraint FK_RELATIONSHIP_5 foreign key (SPITTLE_ID)
      references SPITTLE (SPITTLE_ID) on delete restrict on update restrict;

alter table SPITTLE add constraint FK_RELATIONSHIP_1 foreign key (SPITTER_ID)
      references SPITTER (SPITTER_ID) on delete restrict on update restrict;

