-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO SERVICE_SPECIFICATION (dbid, href, id, name, version) VALUES (1, 'href1', 'id1', 'name1', 'version1');
INSERT INTO SERVICE_SPECIFICATION (dbid, href, id, name, version) VALUES (2, 'href2', 'id2', 'name2', 'version2');


INSERT INTO SERVICE (dbid, name, href, category, is_stateful, SERVICE_SPECIFICATION_DBID) VALUES (1, 'name1', 'href1', 'RFS', true, 1);
INSERT INTO SERVICE (dbid, name, href, category, is_stateful, SERVICE_SPECIFICATION_DBID) VALUES (2, 'name2', 'href2', 'CFS', false, 2);

INSERT INTO PLACE (DBID, HREF, ROLE, SERVICE_dbID) VALUES (1, 'HREF1', 'ROLE1', 1);
INSERT INTO PLACE (DBID, HREF, ROLE, SERVICE_dbID) VALUES (2, 'HREF2', 'ROLE2', 1);
INSERT INTO PLACE (DBID, HREF, ROLE, SERVICE_dbID) VALUES (3, 'HREF3', 'ROLE3', 2);