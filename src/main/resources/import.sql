
-- INSERT  INTO services (id, href, category, name, description, is_service_enabled, has_started, start_mode, is_stateful, state)
        -- VALUES (42, "http://server:port/", "CFS", "Broadband", "Description of broadband service", "true", "true", "0", "false", "active");

INSERT INTO places (id, href, role) VALUES (1, "http://www.google.com/", "USA");
INSERT INTO services (id, href, category, name, description, is_service_enabled, has_started, start_mode, is_stateful, state, place_id) VALUES (42, "http://server:port/", "CFS", "asd", "Description of Broadband service", "true", "true", "0", "false", "active", 1);
