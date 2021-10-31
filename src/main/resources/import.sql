INSERT INTO ts_usuario(rol, state, nombre_usuario) VALUES('SUPERVISOR', true, '12345678');
COMMIT;

INSERT INTO tp_supervisor(dni, email, apellido_paterno, nombre, apellido_materno, id_usuario) VALUES('12345678', 'davidAllasi@cultivos.com', 'ALLASI', 'DAVID', 'BARDALES', 1);
COMMIT;

INSERT INTO tp_comunidad_agricola(nom_comunidad, id_supervisor) VALUES('Tambo Seco', 1);
COMMIT;

INSERT INTO ts_parametros_generales(duracion_cronograma) VALUES (6);
COMMIT;