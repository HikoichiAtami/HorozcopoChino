CREATE DATABASE horoscopo;

USE horoscopo;

CREATE TABLE Horoscopo(
	idHoroscopo NUMERIC NOT NULL,
    nombreSigno VARCHAR(10),
    descripcion VARCHAR(500),
    PRIMARY KEY(idHoroscopo)
);

CREATE TABLE Usuario(
	nombreUsuario VARCHAR(20) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    pass VARCHAR(20) NOT NULL,
    fechaNac DATE NOT NULL,
    id_Horoscopo NUMERIC NOT NULL,
    PRIMARY KEY(nombreUsuario),
    CONSTRAINT horoscopo_FK FOREIGN KEY (id_Horoscopo) 
    REFERENCES Horoscopo (idHoroscopo)
);

INSERT INTO Horoscopo (idHoroscopo,nombreSigno,descripcion)
VALUES ("0","Mono","Animal más parecido al ser humano, es ingenioso, divertido, simpático, de mente rápida y despierta, comprador, persuasivo, sociable, capaces de resolver cualquier problema por difícil que sea con soltura. Sus relaciones amorosas y con los amigos suelen ser conflictivas, pues no soporta que no lo valoren. Gozan de buena salud, aunque sus excesos en las fiestas, alcohol y drogas podrían pasarle factura."),
("1","Gallo","Atractivo y seductor, con talento y apreciado. Son meticulosos, eficientes, ordenados, buenos conversadores, observadores, egoístas, usureros, pragmáticos y muy familiares. En el amor son románticos, obstinados y luchan por el control de su pareja. Suelen destacar como relaciones públicas o como artistas. No prestan demasiada atención a su salud."),
("2","Perro","El perro es un ser dedicado al trabajo, honesto, confiable, diligente, con un gran sentido de la justicia y la lealtad. Cautiva a todos con su personalidad excitante, su buen humor y su gran capacidad para escuchar los problemas de los demás y dar buenos consejos. En el amor son fieles y leales, aunque muy celoso cuando su pareja no está en casa. Los nervios son su mayor problema de salud."),
("3","Cerdo","Es un animal sincero, honesto, confiado, educado, cariñoso, servicial, valiente, decidido, con gran fuerza de voluntad, sin grandes pretensiones ni vanidad, con los pies en la tierra. Son muy agradables y tienen gusto y modales impecables. En el amor son sensuales, apasionado y pacientes, pero hasta un punto. Son muy trabajadores, aunque la falta de atracción por el deporte y la apatía harán que su físico se resienta y engorde en exceso."),
("4","Rata","Los nacidos bajo el signo de la Rata son persona sabias a las que les gusta rodearse de familiares y amigos, a quienes ayudan en sus quehaceres y problemas diarios. Buenas trabajadoras, ahorradores y buenos administradores de su economía."),
("5","Buey","Los búfalos o bueyes son animales pacientes y tranquilos, que irradian mucho cariño y amor e infunden respeto. Grandes trabajadores, se sienten a gusto rodeados del orden y la limpieza y logran el éxito gracias a su esfuerzo."),
("6","Tigre","Las personas de este signo son muy pasionales y llenas de energía. No pasan desapercibidas, son aventureros, independientes, ingeniosos, impulsivos y les gusta la diversión."),
("7","Conejo","Los que nacen en el Año del Conejo reúnen extraordinarias cualidades humanas: son prudentes, inteligentes, afables, discretos, previsores, atentos y benevolentes. Por eso, el signo del conejo es ampliamente aceptado por la gente."),
("8","Dragon","Símbolo del Emperador en China, el dragón es imaginativo, magnánimo, emprendedor, afortunado y poderoso. Está lleno de fuerza y vitalidad. Es un verdadero acumulador de energía y si le enojas, se enfurecerá de tal manera que perderá los estribos."),
("9","Serpiente","Las personas Serpientes son astutas, saben lo que quieren y cómo conseguirlo. Su conversación es elegante y fluida.  Son intensos y prudentes a la vez. Son celosas y posesivas con su familia pero leales. Les gusta mimar a sus amigos y esperan de ellos una actitud recíproca."),
("10","Caballo","Populares, optimistas, llenos de alegría, aventureros, elocuentes, impacientes, emprendedores, entusiastas con la vida, grandes amantes y amigos. Su gran pasión es el dinero y los viajes. Les gusta conocer gente nueva, distintas culturas, hablar idiomas y son el alma de las fiestas. Su atractivo físico y su belleza hace que les sea fácil encontrar el amor: trampa en la que caen sin remedio."),
("11","Cabra","La cabra es creativa, artística, positiva, elegante, femenina, afable, compasiva, llorona, sensible, soñadora, orgullosa y triste. No persiguen la riqueza material y prefieren vivir de sus ensoñaciones. Aman la familia, los niños, el hogar y estar en contacto con la naturaleza. ");

INSERT INTO Usuario (nombre,nombreUsuario,pass,fechaNac,id_Horoscopo)
VALUES("freddy","Hikoichi","12345","1988-06-05","8"),
("alejandro","Alespinoza","12345","2020-01-01","4"),
("carla","Rosse","1234","2020-01-02","4");

SELECT * FROM Usuario;

SELECT nombreSigno, FORMAT((COUNT(id_Horoscopo)*100/(SELECT Count(*) FROM Usuario)) , 2) 
	FROM Usuario JOIN Horoscopo 
	ON(idHoroscopo = id_Horoscopo)
	GROUP BY nombreSigno;


	SELECT nombreSigno, COUNT(id_Horoscopo) FROM Usuario JOIN Horoscopo 
	ON(idHoroscopo = id_Horoscopo)
	GROUP BY nombreSigno
