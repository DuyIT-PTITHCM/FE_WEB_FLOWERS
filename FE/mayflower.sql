create database mayflower;
use mayflower;
CREATE TABLE adminflower (
    idadmin int NOT NULL auto_increment,
    username varchar(50),
    password varchar(50),
    PRIMARY KEY (idadmin)
);
CREATE TABLE roleflower (
    idrole int NOT NULL auto_increment,
	roleadmin varchar(10),
    idadmin int ,
    PRIMARY KEY (idrole),
    FOREIGN KEY (idadmin) REFERENCES adminflower(idadmin)
);
CREATE TABLE comment (
    idcomment int NOT NULL auto_increment,
    content tinytext,
    gmail varchar(100),
    usernamecomment varchar(50),
    PRIMARY KEY (idcomment)
);
CREATE TABLE producttopic (
    idtopic int NOT NULL auto_increment,
    name varchar(50),
    PRIMARY KEY (idtopic)
);
CREATE TABLE catalogflower (
    idcatalog int NOT NULL,
    name varchar(50),
    PRIMARY KEY (idcatalog)
);
CREATE TABLE flower (
    idflower int NOT NULL auto_increment,
    price float,
    name varchar(50),
    idcatalog int ,
    idtopic int,
    PRIMARY KEY (idflower),
	FOREIGN KEY (idcatalog) REFERENCES catalogflower(idcatalog),
    FOREIGN KEY (idtopic) REFERENCES producttopic(idtopic)
);
CREATE TABLE storyflower (
    idstory int NOT NULL auto_increment,
    name varchar(50),
    story tinytext,
    img varchar(100),
    dateupdate varchar(10),
    PRIMARY KEY (idstory)
);
CREATE TABLE cart (
    idcart int NOT NULL,
    iddecive varchar(100),
    status tinyint,
    PRIMARY KEY (idcart)
);

CREATE TABLE detailproduct (
    iddetailproduct int NOT NULL auto_increment,
	idcart int ,
    idflower int ,
    PRIMARY KEY (iddetailproduct),
    FOREIGN KEY (idcart) REFERENCES cart(idcart),
    FOREIGN KEY (idflower) REFERENCES flower(idflower)
);
CREATE TABLE userbuyflower (
    idbuy int NOT NULL auto_increment,
    name varchar(100),
    status tinyint,
    address varchar(100),
    phone varchar(11),
    PRIMARY KEY (idbuy)
);
CREATE TABLE detailbuyproduct (
    iddetailbuyproduct int NOT NULL auto_increment,
	idcart int ,
    idbuy int ,
    PRIMARY KEY (iddetailbuyproduct),
    FOREIGN KEY (idcart) REFERENCES cart(idcart),
    FOREIGN KEY (idbuy) REFERENCES userbuyflower(idbuy)
);
CREATE TABLE eventflower (
    idevent int NOT NULL auto_increment,
	percentdow float ,
    PRIMARY KEY (idevent)
);
CREATE TABLE detailevent (
    iddetailevent int NOT NULL auto_increment,
	idevent int ,
    idflower int ,
    PRIMARY KEY (iddetailevent),
    FOREIGN KEY (idevent) REFERENCES eventflower(idevent),
    FOREIGN KEY (idflower) REFERENCES flower(idflower)
);





