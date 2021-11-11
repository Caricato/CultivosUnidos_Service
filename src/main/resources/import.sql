INSERT INTO ts_usuario(rol, state, nombre_usuario) VALUES('SUPERVISOR', true, '12345678');
COMMIT;

INSERT INTO tp_supervisor(dni, email, apellido_paterno, nombre, apellido_materno, id_usuario) VALUES('12345678', 'juandiegovd99@gmail.com', 'ALLASI', 'DAVID', 'BARDALES', 1);
COMMIT;

INSERT INTO tp_comunidad_agricola(nom_comunidad, id_supervisor) VALUES('Tambo Seco', 1);
COMMIT;

INSERT INTO ts_parametros_generales(duracion_cronograma, id_comunidad) VALUES (6, 1);
COMMIT;

INSERT INTO ts_unidad_metrica(nombre, estado, id_comunidad) VALUES ('KILOGRAMOS', true, 1);
INSERT INTO ts_unidad_metrica(nombre, estado, id_comunidad) VALUES ('GRAMOS', true, 1);
INSERT INTO ts_unidad_metrica(nombre, estado, id_comunidad) VALUES ('LITROS', true, 1);
INSERT INTO ts_unidad_metrica(nombre, estado, id_comunidad) VALUES ('UNIDADES', true, 1);
COMMIT;