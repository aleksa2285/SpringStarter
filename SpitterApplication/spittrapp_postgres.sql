/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2/21/2018 6:42:36 PM                         */
/*==============================================================*/


drop index RELATIONSHIP_2_FK;

drop index COMMENTS_PK;

drop table COMMENTS;

drop index SPITTER_PK;

drop table SPITTER;

drop index RELATIONSHIP_3_FK;

drop index RELATIONSHIP_1_FK;

drop index SPITTLE_PK;

drop table SPITTLE;

/*==============================================================*/
/* Table: COMMENTS                                              */
/*==============================================================*/
create table COMMENTS (
   COMMENT_ID           SERIAL not null,
   SPITTER_ID           INT8                 null,
   COMMENT_TIMESTAMP    DATE                 null,
   COMMENT_MESSAGE      VARCHAR(2048)        null,
   COMMENT_LIKES        INT4                 null,
   constraint PK_COMMENTS primary key (COMMENT_ID)
);

/*==============================================================*/
/* Index: COMMENTS_PK                                           */
/*==============================================================*/
create unique index COMMENTS_PK on COMMENTS (
COMMENT_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on COMMENTS (
SPITTER_ID
);

/*==============================================================*/
/* Table: SPITTER                                               */
/*==============================================================*/
create table SPITTER (
   SPITTER_ID           SERIAL not null,
   SPITTER_USERNAME     VARCHAR(1024)        null,
   SPITTER_EMAIL        VARCHAR(1024)        null,
   SPITTER_PASSWORD     VARCHAR(1024)        null,
   SPITTER_PROFILE_PICTURE VARCHAR(1024)        null,
   constraint PK_SPITTER primary key (SPITTER_ID)
);

/*==============================================================*/
/* Index: SPITTER_PK                                            */
/*==============================================================*/
create unique index SPITTER_PK on SPITTER (
SPITTER_ID
);

/*==============================================================*/
/* Table: SPITTLE                                               */
/*==============================================================*/
create table SPITTLE (
   SPITTLE_ID           SERIAL not null,
   COMMENT_ID           INT8                 null,
   SPITTER_ID           INT8                 null,
   SPITTLE_MESSAGE      VARCHAR(2048)        null,
   SPITTLE_TIMESTAMP    DATE                 null,
   SPITTLE_LONGITUDE    DECIMAL              null,
   SPITTLE_LATITUDE     DECIMAL              null,
   SPITTLE_LIKES        INT4                 null,
   SPITTLE_COMMENTS     INT4                 null,
   constraint PK_SPITTLE primary key (SPITTLE_ID)
);

/*==============================================================*/
/* Index: SPITTLE_PK                                            */
/*==============================================================*/
create unique index SPITTLE_PK on SPITTLE (
SPITTLE_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on SPITTLE (
SPITTER_ID
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on SPITTLE (
COMMENT_ID
);

alter table COMMENTS
   add constraint FK_COMMENTS_RELATIONS_SPITTER foreign key (SPITTER_ID)
      references SPITTER (SPITTER_ID)
      on delete restrict on update restrict;

alter table SPITTLE
   add constraint FK_SPITTLE_RELATIONS_SPITTER foreign key (SPITTER_ID)
      references SPITTER (SPITTER_ID)
      on delete restrict on update restrict;

alter table SPITTLE
   add constraint FK_SPITTLE_RELATIONS_COMMENTS foreign key (COMMENT_ID)
      references COMMENTS (COMMENT_ID)
      on delete restrict on update restrict;

