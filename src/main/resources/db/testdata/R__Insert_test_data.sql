CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

--Empresa
INSERT INTO client VALUES(uuid_generate_v4(), 'Empresa A');

--Empregado
INSERT INTO contract (client_id, contract_id, name, admission, salary)
	SELECT client.client_id, uuid_generate_v4(), 'Empregado A', '2019-01-01', 1000.00
	  FROM client as client
	 WHERE client.name = 'Empresa A'
	   AND NOT EXISTS(SELECT 1 FROM contract WHERE name = 'Empregado A');

--Rubricas
INSERT INTO rubric (client_id, rubric_id, name, type, unit, consists_net_pay, inss_base, fgts_base, irrf_base, overtime_base, calculation_base, rate)
	SELECT client.client_id, uuid_generate_v4(), 'Horas Trabalhadas', 'P', 'H', 'Y', 'Y', 'Y', 'Y', 'Y', 1, 0.00
	  FROM client as client
	 WHERE client.name = 'Empresa A'
	   AND NOT EXISTS(SELECT 1 FROM rubric WHERE name = 'Horas Trabalhadas');

INSERT INTO rubric (client_id, rubric_id, name, type, unit, consists_net_pay, inss_base, fgts_base, irrf_base, overtime_base, calculation_base, rate)
	SELECT client.client_id, uuid_generate_v4(), 'Horas-extras', 'P', 'H', 'Y', 'Y', 'Y', 'N', 'N', 5, 150.00
	  FROM client as client
	 WHERE client.name = 'Empresa A'
	   AND NOT EXISTS(SELECT 1 FROM rubric WHERE name = 'Horas-extras');

INSERT INTO rubric (client_id, rubric_id, name, type, unit, consists_net_pay, inss_base, fgts_base, irrf_base, overtime_base, calculation_base, rate)
	SELECT client.client_id, uuid_generate_v4(), 'FGTS', 'D', 'V', 'N', 'N', 'N', 'N', 'N', 3, 8.00
	  FROM client as client
	 WHERE client.name = 'Empresa A'
	   AND NOT EXISTS(SELECT 1 FROM rubric WHERE name = 'FGTS');

INSERT INTO rubric (client_id, rubric_id, name, type, unit, consists_net_pay, inss_base, fgts_base, irrf_base, overtime_base, calculation_base, rate)
	SELECT client.client_id, uuid_generate_v4(), 'INSS', 'D', 'V', 'Y', 'N', 'N', 'Y', 'N', 2, 0.00
	  FROM client as client
	 WHERE client.name = 'Empresa A'
	   AND NOT EXISTS(SELECT 1 FROM rubric WHERE name = 'INSS');

INSERT INTO rubric (client_id, rubric_id, name, type, unit, consists_net_pay, inss_base, fgts_base, irrf_base, overtime_base, calculation_base, rate)
	SELECT client.client_id, uuid_generate_v4(), 'IRRF', 'D', 'V', 'Y', 'N', 'N', 'N', 'N', 4, 0.00
	  FROM client as client
	 WHERE client.name = 'Empresa A'
	   AND NOT EXISTS(SELECT 1 FROM rubric WHERE name = 'IRRF');