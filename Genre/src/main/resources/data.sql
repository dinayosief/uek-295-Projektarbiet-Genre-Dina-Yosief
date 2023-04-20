INSERT INTO genre (name, popularity , description)
VALUES  ('Pop-Musik', 'wrwtrg', 'ergdfrss'),
        ('Hip-Hop','rgtrewrtwr','ewtwerghng'),
        ('jegfuze','esgfearhgffg','gsfsrgfuefuewfzgw');


INSERT INTO role (role_name) VALUES ('ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO role (role_name) VALUES ('USER') ON CONFLICT DO NOTHING;

INSERT INTO users (user_id, username, password, user_role) VALUES (1, 'Dina', '1234', 1) ON CONFLICT DO NOTHING;
INSERT INTO users (user_id, username, password, user_role) VALUES (2, 'Jasmin', '4321', 2) ON CONFLICT DO NOTHING;

INSERT INTO authority (name) VALUES ('CREATE');
INSERT INTO authority (name) VALUES ('READ');
INSERT INTO authority (name) VALUES ('UPDATE');
INSERT INTO authority (name) VALUES ('DELETE');


INSERT INTO role_authority VALUES (2, 1) ON CONFLICT DO NOTHING;
INSERT INTO role_authority VALUES (2, 2) ON CONFLICT DO NOTHING;
INSERT INTO role_authority VALUES (2, 3) ON CONFLICT DO NOTHING;
INSERT INTO role_authority VALUES (2, 4) ON CONFLICT DO NOTHING;
INSERT INTO role_authority VALUES (1, 2) ON CONFLICT DO NOTHING;