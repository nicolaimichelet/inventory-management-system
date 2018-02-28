
INSERT INTO places (id, href, role) VALUES (1, 'http://www.google.com/', 'USA');

INSERT INTO servicecharacteristics (id, name, value) VALUES (1, 'speed', '16M');

INSERT INTO servicerelationship (id, type) VALUES (1, 'contains');

INSERT INTO serviceref (id, href, servicerelationship_id) VALUES (44, 'http://server:port/serviceInventoryManagement/service/44', 1);

INSERT INTO supportingservices (category, href, name) VALUES (59, 'http://server:port/serviceManagement/service/59', 'serviceName');

INSERT INTO services (id, href, category, name, description, is_service_enabled, has_started, start_mode, is_stateful, state, place_id) VALUES (42, 'http://server:port/', 'CFS', 'asd', 'Description of Broadband service', true, true, '0', false, 'active', 1);

INSERT INTO service_supportingservices (service_id, supportingservice_id) VALUES (42, 59);

INSERT INTO servicespecificationrefs (id, href, name, version, service_id) VALUES (4, 'http://server:port/serviceCatalogManagement/serviceSpecification/4', 'name', 'version', 42);
