-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO SERVICE_SPECIFICATION (dbid, href, id, name, version) VALUES (1, 'href1', 'id1', 'name1', 'version1');
INSERT INTO SERVICE_SPECIFICATION (dbid, href, id, name, version) VALUES (2, 'href2', 'id2', 'name2', 'version2');

INSERT INTO SERVICE_ORDER (dbid, href, id) VALUES (1, 'href1', 'id1');
INSERT INTO SERVICE_ORDER (dbid, href, id) VALUES (2, 'href2', 'id2');

INSERT INTO SERVICE (dbid, name, href, category, is_stateful, SERVICE_ORDER_DBID, SERVICE_SPECIFICATION_DBID) VALUES (1, 'name1', 'href1', 'RFS', true, 2, 1);
INSERT INTO SERVICE (dbid, name, href, category, is_stateful, SERVICE_ORDER_DBID, SERVICE_SPECIFICATION_DBID) VALUES (2, 'name2', 'href2', 'CFS', false, 2, 2);

INSERT INTO RELATED_PARTY (dbid, href, id, name, role, valid_for) VALUES (1, 'href1', 'id1', 'name1', 'role1', 'validFor1');
INSERT INTO RELATED_PARTY (dbid, href, id, name, role, valid_for) VALUES (2, 'href2', 'id2', 'name2', 'role2', 'validFor2');

INSERT INTO SERVICE_RELATED_PARTY (service_dbid, related_party_dbid) VALUES (1, 1);
INSERT INTO SERVICE_RELATED_PARTY (service_dbid, related_party_dbid) VALUES (1, 2);
INSERT INTO SERVICE_RELATED_PARTY (service_dbid, related_party_dbid) VALUES (2, 2);

INSERT INTO PLACE (DBID, HREF, ROLE, SERVICE_dbID) VALUES (1, 'HREF1', 'ROLE1', 1);
INSERT INTO PLACE (DBID, HREF, ROLE, SERVICE_dbID) VALUES (2, 'HREF2', 'ROLE2', 1);
INSERT INTO PLACE (DBID, HREF, ROLE, SERVICE_dbID) VALUES (3, 'HREF3', 'ROLE3', 2);

INSERT INTO NOTE (DBID, author, date, text, SERVICE_dbID) VALUES (1, 'author1', 'date1','text1', 1);
INSERT INTO NOTE (DBID, author, date, text, SERVICE_dbID) VALUES (2, 'author2', 'date2','text2', 1);
INSERT INTO NOTE (DBID, author, date, text, SERVICE_dbID) VALUES (3, 'author3', 'date3','text3', 2);