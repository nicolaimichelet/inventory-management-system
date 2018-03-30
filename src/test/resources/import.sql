INSERT INTO SERVICE_SPECIFICATION (dbid, href, id, name, version) VALUES (1, 'href1', 'id1', 'name1', 'version1');
INSERT INTO SERVICE_SPECIFICATION (dbid, href, id, name, version) VALUES (2, 'href2', 'id2', 'name2', 'version2');

INSERT INTO SERVICE_ORDER (dbid, href, id) VALUES (1, 'href1', 'id1');
INSERT INTO SERVICE_ORDER (dbid, href, id) VALUES (2, 'href2', 'id2');

INSERT INTO SERVICE (dbid, category, description, end_date, has_started, href, id, is_service_enabled, is_stateful, name, order_date, start_date, start_mode, state, type, service_order_dbid, service_specification_dbid) VALUES (1, 'category1', 'description1', 'endDate1', true, 'href1', 'id1', true, true, 'name1', 'orderDate1', 'startDate1', 'startMode1', 'state1', 'type1', 2, 1);
INSERT INTO SERVICE (dbid, category, description, end_date, has_started, href, id, is_service_enabled, is_stateful, name, order_date, start_date, start_mode, state, type, service_order_dbid, service_specification_dbid) VALUES (2, 'category2', 'description2', 'endDate2', false, 'href2', 'id2', false, false, 'name2', 'orderDate2', 'startDate2', 'startMode2', 'state2', 'type2', 1, 2);

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

INSERT INTO SERVICE_CHARACTERISTIC (dbID, NAME, VALUE, SERVICE_DBID) VALUES (1, 'name1', 'value1', 1);
INSERT INTO SERVICE_CHARACTERISTIC (dbID, NAME, VALUE, SERVICE_DBID) VALUES (2, 'name2', 'value2', 2);
INSERT INTO SERVICE_CHARACTERISTIC (dbID, NAME, VALUE, SERVICE_DBID) VALUES (3, 'name3', 'value3', 2);

INSERT INTO SERVICE_REF (dbid, href, id) VALUES (1, 'href1', 'id1');
INSERT INTO SERVICE_REF (dbid, href, id) VALUES (2, 'href2', 'id2');
INSERT INTO SERVICE_REF (dbid, href, id) VALUES (3, 'href3', 'id3');

INSERT INTO SERVICE_RELATIONSHIP (dbID, TYPE, SERVICE_DBID, SERVICE_REF_DBID) VALUES (1, 'type1', 1, 1);
INSERT INTO SERVICE_RELATIONSHIP (dbID, TYPE, SERVICE_DBID, SERVICE_REF_DBID) VALUES (2, 'type2', 2, 2);
INSERT INTO SERVICE_RELATIONSHIP (dbID, TYPE, SERVICE_DBID, SERVICE_REF_DBID) VALUES (3, 'type3', 1, 3);

INSERT INTO SUPPORTING_RESOURCE (dbid, href, id, name) VALUES (1, 'href1', 'id1', 'name1');
INSERT INTO SUPPORTING_RESOURCE (dbid, href, id, name) VALUES (2, 'href2', 'id2', 'name2');
INSERT INTO SUPPORTING_RESOURCE (dbid, href, id, name) VALUES (3, 'href3', 'id3', 'name3');

INSERT INTO SERVICE_SUPPORTING_RESOURCE (SERVICE_DBID, SUPPORTING_RESOURCE_DBID) VALUES (1, 2);
INSERT INTO SERVICE_SUPPORTING_RESOURCE (SERVICE_DBID, SUPPORTING_RESOURCE_DBID) VALUES (2, 2);
INSERT INTO SERVICE_SUPPORTING_RESOURCE (SERVICE_DBID, SUPPORTING_RESOURCE_DBID) VALUES (1, 3);
INSERT INTO SERVICE_SUPPORTING_RESOURCE (SERVICE_DBID, SUPPORTING_RESOURCE_DBID) VALUES (1, 1);
INSERT INTO SERVICE_SUPPORTING_RESOURCE (SERVICE_DBID, SUPPORTING_RESOURCE_DBID) VALUES (2, 1);

INSERT INTO SUPPORTING_SERVICE (dbid, category, href, id, name) VALUES (1, 'category1', 'href1', 'id1', 'name1');
INSERT INTO SUPPORTING_SERVICE (dbid, category, href, id, name) VALUES (2, 'category2', 'href2', 'id2', 'name2');
INSERT INTO SUPPORTING_SERVICE (dbid, category, href, id, name) VALUES (3, 'category3', 'href3', 'id3', 'name3');

INSERT INTO SERVICE_SUPPORTING_SERVICE (SERVICE_DBID, SUPPORTING_SERVICE_DBID) VALUES (1, 2);
INSERT INTO SERVICE_SUPPORTING_SERVICE (SERVICE_DBID, SUPPORTING_SERVICE_DBID) VALUES (2, 2);
INSERT INTO SERVICE_SUPPORTING_SERVICE (SERVICE_DBID, SUPPORTING_SERVICE_DBID) VALUES (1, 3);
INSERT INTO SERVICE_SUPPORTING_SERVICE (SERVICE_DBID, SUPPORTING_SERVICE_DBID) VALUES (1, 1);
INSERT INTO SERVICE_SUPPORTING_SERVICE (SERVICE_DBID, SUPPORTING_SERVICE_DBID) VALUES (2, 1);

