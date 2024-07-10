--
-- PostgreSQL database dump
--

-- Dumped from database version 15.6
-- Dumped by pg_dump version 15.6

-- Started on 2024-07-10 15:42:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3324 (class 1262 OID 34957)
-- Name: dadoscriptografados; Type: DATABASE; Schema: -; Owner: postgres
--

--CREATE DATABASE dadoscriptografados WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';


--ALTER DATABASE dadoscriptografados OWNER TO postgres;

--\connect dadoscriptografados

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 34968)
-- Name: tb_operation; Type: TABLE; Schema: public; Owner: dev
--

CREATE TABLE public.tb_operation (
    id bigint NOT NULL,
    credit_card_token character varying(255) NOT NULL,
    user_document character varying(255) NOT NULL,
    value bigint
);


ALTER TABLE public.tb_operation OWNER TO dev;

--
-- TOC entry 215 (class 1259 OID 34967)
-- Name: tb_operation_id_seq; Type: SEQUENCE; Schema: public; Owner: dev
--

ALTER TABLE public.tb_operation ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_operation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3176 (class 2606 OID 34974)
-- Name: tb_operation tb_operation_pkey; Type: CONSTRAINT; Schema: public; Owner: dev
--

ALTER TABLE ONLY public.tb_operation
    ADD CONSTRAINT tb_operation_pkey PRIMARY KEY (id);


-- Completed on 2024-07-10 15:42:52

--
-- PostgreSQL database dump complete
--
