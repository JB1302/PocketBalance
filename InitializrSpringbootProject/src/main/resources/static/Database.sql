-- Eliminar si ya existe
DROP SCHEMA IF EXISTS finanzas;
DROP USER IF EXISTS 'usuario_finanzas'@'%';

-- Crear esquema y usuario
CREATE SCHEMA finanzas;
CREATE USER 'usuario_finanzas'@'%' IDENTIFIED BY 'Tostada';

-- Asignar privilegios
GRANT ALL PRIVILEGES ON finanzas.* TO 'usuario_finanzas'@'%';
FLUSH PRIVILEGES;

-- Usar la base de datos
USE finanzas;

-- Crear tabla con TIMESTAMP auto-update
CREATE TABLE cuentas (
  id_transaccion    INT          NOT NULL AUTO_INCREMENT,
  periodo           INT          NOT NULL,
  nombre            VARCHAR(30)  NOT NULL,
  monto             INT          NOT NULL,
  cantidad          INT          NOT NULL,
  ultima_actualizacion TIMESTAMP NOT NULL
    DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id_transaccion)
) DEFAULT CHARSET = utf8mb4;

INSERT INTO cuentas (periodo, nombre, monto, cantidad) VALUES
  (1, 'Salario',         800000, 1),
  (1, 'Renta',           200000, 1),
  (1, 'Internet',         30000, 1),
  (1, 'Electricidad',     45000, 1),
  (1, 'Comida',           60000, 3),
  (2, 'Transporte',       15000, 2),
  (2, 'Entretenimiento',  20000, 2),
  (2, 'Salud',            25000, 1),
  (2, 'Educación',        40000, 1),
  (2, 'Ahorros',         100000, 1);
