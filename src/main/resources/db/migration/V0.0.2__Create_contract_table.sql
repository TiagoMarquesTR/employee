CREATE TABLE contract(
	client_id uuid NOT NULL,
	contract_id uuid NOT NULL,
	name VARCHAR,
	admission TIMESTAMP,
	salary DECIMAL,
	PRIMARY KEY(client_id, contract_id)
);