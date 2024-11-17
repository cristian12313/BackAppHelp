INSERT INTO roles (name) VALUES ('ROLE_DONANTE');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_DAMNIFICADO');
INSERT INTO usuario(username, password,apellidos,correo,dni,telefono) VALUES ('donante1','$2a$12$bQAGr4OV/7WPJ3w2H3Bsbu8HJn.7hzFdjhSRs1ojo6A0wBkxRFhm2','carlos','car@','21232','123123');
INSERT INTO usuario(username, password,apellidos,correo,dni,telefono) VALUES ('admin1','$2a$12$bQAGr4OV/7WPJ3w2H3Bsbu8HJn.7hzFdjhSRs1ojo6A0wBkxRFhm2','alvere','admin@','123123','123213');
INSERT INTO usuario(username, password,apellidos,correo,dni,telefono) VALUES ('damnificado1','$2a$12$bQAGr4OV/7WPJ3w2H3Bsbu8HJn.7hzFdjhSRs1ojo6A0wBkxRFhm2','serpa','dam@','34434','34568');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1); -- user1 with ROLE_Donante
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- admin with ROLE_ADMIN
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3); -- user1 with ROLE_Damnificado
--  INSERT INTO tipodonacion (idTipodonacion, nombre) VALUES (1, 'Monetaria');
--  INSERT INTO tipodonacion (idTipodonacion, nombre) VALUES (2, 'Viveres');
--  INSERT INTO tipodonacion (idTipodonacion, nombre) VALUES (3, 'Voluntariado');