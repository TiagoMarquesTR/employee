CREATE TABLE rubric_entry(
	client_id uuid NOT NULL,
	contract_id uuid NOT NULL,
	rubric_id uuid NOT NULL,
	competence TIMESTAMP NOT NULL,
	setted_value DECIMAL,
	PRIMARY KEY(client_id, contract_id, rubric_id, competence)
);