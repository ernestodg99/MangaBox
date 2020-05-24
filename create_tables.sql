CREATE DATABASE mangabox;

USE mangabox;

CREATE TABLE usuarios (   
`dni` varchar(255) NOT NULL,   
`nombre` varchar(255) NOT NULL,   
`apellidos` varchar(255) NOT NULL,  
`email` varchar(255) NOT NULL,   
`fechanacimiento` DATE NOT NULL,
`usuario` varchar(255) NOT NULL,   
`contraseña` varchar(255) NOT NULL,
`foto` varchar(255) NOT NULL,
`activo` boolean NOT NULL,
UNIQUE (`usuario`),
PRIMARY KEY (dni) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1; 

CREATE TABLE personal (   
`dni` varchar(255) NOT NULL, 
`nombre` varchar(255) NOT NULL,  
`rol` varchar(255) NOT NULL, 
`contraseña` varchar(255) NOT NULL,
PRIMARY KEY (dni)
) ENGINE=InnoDB DEFAULT CHARSET=latin1; 

INSERT INTO personal VALUES ("12345000F", "Jhon", "administrador", "jhonadmin");

CREATE TABLE series (   
`nombre` varchar(255) NOT NULL,
`autor` varchar(255) NOT NULL,
`categoria` varchar(255) NOT NULL,
`logo` varchar(255) NULL, 
`logo2` varchar(255) NULL,   
`descripcion` varchar(1500) NULL,
`fechaserializacion` varchar(255) NULL,
`administrador` varchar(255) NULL,
`personalserie` varchar(255) NOT NULL,
`visible` boolean NOT NULL,
PRIMARY KEY (nombre),
FOREIGN KEY (administrador) REFERENCES personal(dni)
ON DELETE CASCADE 
ON UPDATE CASCADE,
FOREIGN KEY (personalserie) REFERENCES personal(dni)
ON DELETE CASCADE 
ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1; 

CREATE TABLE capitulos(
`idcapitulo` int(10) NOT NULL AUTO_INCREMENT,
`capitulonumero` int(10) NOT NULL,
`nombre` varchar(255) NOT NULL,
`descripcion` varchar(255) NOT NULL,
`nombreserie` varchar(255) NOT NULL,
`administrador` varchar(255) NOT NULL,
`personalserie` varchar(255) NOT NULL,
`visible` boolean NOT NULL,
PRIMARY KEY (idcapitulo),
FOREIGN KEY (nombreserie) REFERENCES series(nombre)
ON DELETE CASCADE 
ON UPDATE CASCADE,
FOREIGN KEY (administrador) REFERENCES personal(dni)
ON DELETE CASCADE 
ON UPDATE CASCADE,
FOREIGN KEY (personalserie) REFERENCES personal(dni)
ON DELETE CASCADE 
ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE imagenes(
`id` int(10) NOT NULL AUTO_INCREMENT,
`imagen` varchar(255) NOT NULL,
`idcapitulo` int(10) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (idcapitulo) REFERENCES capitulos(idcapitulo)
ON DELETE CASCADE 
ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE comentarios(
`id` int(10) NOT NULL AUTO_INCREMENT,
`idcapitulo` int(10) NOT NULL,
`usuario` varchar(255) NOT NULL,
`comentario` varchar(255) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (idcapitulo) REFERENCES capitulos(idcapitulo)
ON DELETE CASCADE 
ON UPDATE CASCADE,
FOREIGN KEY (usuario) REFERENCES usuarios(usuario)
ON DELETE CASCADE 
ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE favoritos(
`nombreserie` varchar(255) NOT NULL,
`usuario` varchar(255) NOT NULL,
CONSTRAINT PK_fav PRIMARY KEY (nombreserie, usuario),
FOREIGN KEY (nombreserie) REFERENCES series(nombre)
ON DELETE CASCADE 
ON UPDATE CASCADE,
FOREIGN KEY (usuario) REFERENCES usuarios(usuario)
ON DELETE CASCADE 
ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
