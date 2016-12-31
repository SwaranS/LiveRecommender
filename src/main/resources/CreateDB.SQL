-- Database: liverecommender

-- DROP DATABASE liverecommender;

CREATE DATABASE liverecommender
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United Kingdom.1252'
    LC_CTYPE = 'English_United Kingdom.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.jobs

-- DROP TABLE public.jobs;

CREATE TABLE public.jobs
(
  skillid integer NOT NULL,
  jobid integer NOT NULL DEFAULT nextval('jobs_jobid_seq'::regclass),
  CONSTRAINT jobs_jobid_pk PRIMARY KEY (jobid),
  CONSTRAINT jobs_skills_skillid_fk FOREIGN KEY (skillid)
  REFERENCES public.skills (skillid) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.jobs
  OWNER to postgres;

-- Index: jobs_JOBID_uindex

-- DROP INDEX public."jobs_JOBID_uindex";

CREATE UNIQUE INDEX "jobs_JOBID_uindex"
  ON public.jobs USING btree
  (jobid)
TABLESPACE pg_default;


-- Table: public.skills

-- DROP TABLE public.skills;

CREATE TABLE public.skills
(
  skillname character varying(50) COLLATE pg_catalog."default",
  skillid integer NOT NULL DEFAULT nextval('skills_skillid_seq'::regclass),
  CONSTRAINT skills_skillid_pk PRIMARY KEY (skillid)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.skills
  OWNER to postgres;

-- Index: skills_SKILLID_uindex

-- DROP INDEX public."skills_SKILLID_uindex";

CREATE UNIQUE INDEX "skills_SKILLID_uindex"
  ON public.skills USING btree
  (skillid, skillid)
TABLESPACE pg_default;

-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
  firstname character varying(50) COLLATE pg_catalog."default",
  lastname character varying(50) COLLATE pg_catalog."default",
  skillid integer,
  userid integer NOT NULL DEFAULT nextval('users_userid_seq'::regclass),
  CONSTRAINT users_userid_pk PRIMARY KEY (userid),
  CONSTRAINT users_skills_skillid_fk FOREIGN KEY (skillid)
  REFERENCES public.skills (skillid) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
  OWNER to postgres;

-- Index: users_USERID_uindex

-- DROP INDEX public."users_USERID_uindex";

CREATE UNIQUE INDEX "users_USERID_uindex"
  ON public.users USING btree
  (userid)
TABLESPACE pg_default;

