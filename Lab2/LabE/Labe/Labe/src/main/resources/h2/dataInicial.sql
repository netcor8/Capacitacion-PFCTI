INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, ESTADO, PAIS_NACIMIENTO) VALUES ('PEREZ', '1', 'ROBERTO', '093939393', true, 'CR');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, ESTADO, PAIS_NACIMIENTO) VALUES ('SANCHEZ', '2', 'RAUL', '093223333', true, 'CR');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, ESTADO, PAIS_NACIMIENTO) VALUES ('SANCHEZ PAZMINO', '11', 'PATRICIO', '092222', true, 'CR');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, ESTADO, PAIS_NACIMIENTO) VALUES ('SANCHEZ SALAZAR', '111', 'MAURICIO', '0933333', true, 'CR');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, ESTADO, PAIS_NACIMIENTO) VALUES ('SANCHEZ SALAZAR', '1111', 'HORACIO', '0934555', true, 'HN');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, ESTADO, PAIS_NACIMIENTO) VALUES ('DOE', '1111', 'JOHN', '0934555', true, 'GT');
INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO, ESTADO, PAIS_NACIMIENTO) VALUES ('SHOW', '1100', 'JOHN', '0937566757', true, 'BR');

INSERT INTO DIRECCION (DIRECCION, NOMENCLATURA, CLIENTE_ID) VALUES ('10 de agosto', 'n31', 1);
INSERT INTO DIRECCION (DIRECCION, NOMENCLATURA, CLIENTE_ID) VALUES ('Av. Amazonas', 'n100', 1);
INSERT INTO DIRECCION (DIRECCION, NOMENCLATURA, CLIENTE_ID) VALUES ('Av. Prensa', 'n1', 2);

INSERT INTO CUENTA (NUMERO, TIPO, CLIENTE_ID, ESTADO) VALUES ('22222', 'AHORRO', 1, true);
INSERT INTO CUENTA (NUMERO, TIPO, CLIENTE_ID, ESTADO) VALUES ('33333', 'CORRIENTE', 1, false);

INSERT INTO TARJETA (NUMERO, TIPO, CLIENTE_ID, ESTADO) VALUES ('121212', 'AHORRO', 4, true);
INSERT INTO TARJETA (NUMERO, TIPO, CLIENTE_ID, ESTADO) VALUES ('131313', 'CORRIENTE', 5, false);