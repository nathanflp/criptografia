
CREATE TABLE public.tb_operation (
    id bigint NOT NULL,
    credit_card character varying(255) NOT NULL,
    user_document character varying(255) NOT NULL,
    value bigint
);

ALTER TABLE public.tb_operation OWNER TO dev;

ALTER TABLE public.tb_operation ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_operation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);

SELECT pg_catalog.setval('public.tb_operation_id_seq', 3, true);


ALTER TABLE ONLY public.tb_operation
    ADD CONSTRAINT tb_operation_pkey PRIMARY KEY (id);


