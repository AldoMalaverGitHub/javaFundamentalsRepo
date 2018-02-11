/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  DCA
 * Created: 10/02/2018
 */
INSERT INTO 
alumno(nombres, apellidoPaterno, apellidoMaterno, telefono, direccion)
VALUES('Aldo1', 'Malaver', 'Ciudad', '949372097', 'Calle Beatriz Cisneros');

INSERT INTO alumno
VALUES(NULL, 'Aldo2', 'Malaver', 'Ciudad', '949372097', 'Calle Beatriz Cisneros');


INSERT INTO 
alumno(nombres, apellidoPaterno, apellidoMaterno, telefono)
VALUES('Aldo1', 'Malaver', 'Ciudad', '949372097');

SELECT * FROM ALUMNO;

INSERT INTO CURSO(nombre, creditos)
VALUES('Java 8 Fundamentals', 4);

INSERT INTO CURSO(nombre, creditos)
VALUES('Java 8 Web Developer', 5);

INSERT INTO CURSO(nombre, creditos)
VALUES('Java 8 Advanced Developer', 5);

INSERT INTO CURSO(nombre, creditos)
VALUES('Java 8 Architect Developer', 6);

SELECT * FROM CURSO;
SELECT * FROM CURSO WHERE nombre LIKE '%Developer%';

INSERT INTO MATRICULA(idAlumno, fecha, estado)
VALUES((SELECT idAlumno FROM ALUMNO WHERE idAlumno = 1), '2018-02-10', 1);
NOW()

INSERT INTO MATRICULA(idAlumno, fecha, estado)
VALUES((SELECT idAlumno FROM ALUMNO WHERE idAlumno = 2), NOW(), 1);

SELECT * FROM MATRICULA;
INSERT INTO DETALLEMATRICULA(idMatricula, idCurso, horaInicio, horaFin, fechaInicio,
fechaFin)
VALUES(1, 1, 14, 21, '2017-12-10', '2018-02-24');

INSERT INTO DETALLEMATRICULA(idMatricula, idCurso, horaInicio, horaFin, fechaInicio,
fechaFin)
VALUES(2, 1, 14, 21, '2017-12-10', '2018-02-24');

SELECT * FROM DETALLEMATRICULA;


SELECT m.idMatricula, a.nombres, a.apellidoPaterno, a.apellidoMaterno, c.nombre 'Curso'
FROM ALUMNO a, Matricula m, DetalleMatricula dm, Curso c
WHERE a.idAlumno = m.idAlumno
AND m.idMatricula = dm.idMatricula
AND dm.idCurso = c.idCurso
AND a.nombres = 'Aldo';

SELECT m.idMatricula, COUNT(1) 
FROM ALUMNO a INNER JOIN Matricula m
ON a.idAlumno = m.idAlumno
INNER JOIN DetalleMatricula dm
ON m.idMatricula = dm.idMatricula
INNER JOIN Curso c
ON dm.idCurso = c.idCurso
WHERE a.nombres = 'Aldo'
GROUP BY m.idMatricula
HAVING COUNT(1) > 2;