CREATE TABLE irrf_calculation_table(
	competence TIMESTAMP NOT NULL,
	limit_value DECIMAL NOT NULL,
	rate DECIMAL,
	discount DECIMAL,
	PRIMARY KEY(competence, limit_value)
);