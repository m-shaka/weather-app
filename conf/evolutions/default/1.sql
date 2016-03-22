# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "tempdatum" ("id" SERIAL PRIMARY KEY,"city" VARCHAR(254) NOT NULL,"min" INTEGER NOT NULL,"max" INTEGER NOT NULL,"date" DATE NOT NULL);

# --- !Downs

drop table "tempdatum";

