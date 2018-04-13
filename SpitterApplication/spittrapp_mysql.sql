/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2/21/2018 6:46:05 PM                         */
/*==============================================================*/


drop table if exists COMMENTS;

drop table if exists SPITTER;

drop table if exists SPITTLE;

/*==============================================================*/
/* Table: COMMENTS                                              */
/*==============================================================*/
create table COMMENTS
(
   COMMENT_ID           bigint not null auto_increment,
   SPITTLE_ID           bigint,
   SPITTER_ID           bigint,
   COMMENT_TIMESTAMP    timestamp,
   COMMENT_MESSAGE      varchar(2048),
   COMMENT_LIKES        int,
   primary key (COMMENT_ID)
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
   SPITTLE_ID           bigint not null auto_increment,
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

alter table SPITTLE add constraint FK_RELATIONSHIP_1 foreign key (SPITTER_ID)
      references SPITTER (SPITTER_ID) on delete restrict on update restrict;

