CREATE TABLE rubric(
	client_id uuid NOT NULL,
	rubric_id uuid NOT NULL,
	name VARCHAR,
	type CHAR,
	unit CHAR,
	consists_net_pay CHAR,
	inss_base CHAR,
	fgts_base CHAR,
	irrf_base CHAR,
	overtime_base CHAR,
	calculation_base INTEGER,
	rate DECIMAL,
	PRIMARY KEY(client_id, rubric_id)
);