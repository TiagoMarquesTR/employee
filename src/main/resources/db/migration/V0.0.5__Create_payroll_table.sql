CREATE TABLE payroll(
	client_id uuid NOT NULL,
	contract_id uuid NOT NULL,
	competence TIMESTAMP NOT NULL,
	inss_base_amount DECIMAL,
	inss_base_excess_amount DECIMAL,
	fgts_base_amount DECIMAL,
	irrf_base_amount DECIMAL,
	overtime_base_amount DECIMAL,
	gross_pay DECIMAL,
	deductions DECIMAL,
	PRIMARY KEY(client_id, contract_id, competence)
);