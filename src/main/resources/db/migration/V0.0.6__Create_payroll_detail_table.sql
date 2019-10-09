CREATE TABLE payroll_detail(
	client_id uuid NOT NULL,
	contract_id uuid NOT NULL,
	rubric_id uuid NOT NULL,
	competence TIMESTAMP NOT NULL,
	reference_value DECIMAL,
	calculated_value DECIMAL,
	PRIMARY KEY(client_id, contract_id, rubric_id, competence)
);