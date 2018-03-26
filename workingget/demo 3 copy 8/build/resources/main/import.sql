INSERT INTO SERVICESPECIFICATION (dbid, href, id, name, version)
VALUES (1, 'href1', 'id1', 'name1', 'version1');
INSERT INTO SERVICESPECIFICATION (dbid, href, id, name, version)
VALUES (2, 'href2', 'id2', 'name2', 'version2');


INSERT INTO SERVICE (dbid, name, href, category, is_stateful, service_specification) VALUES (1, 'name1', 'href1', 'RFS', true, 1);
INSERT INTO SERVICE (dbid, name, href, category, is_stateful, service_specification) VALUES (2, 'name2', 'href2', 'CFS', false, 1);
