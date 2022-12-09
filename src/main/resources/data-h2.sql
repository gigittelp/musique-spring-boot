use MUSIQUE_DB;

/* liste des artistes */
insert into artist(name, bio, fan_number)
    values('Celtic woman','En 2004, les producteurs Sharon Browne et David Downes, directeur musical...',31760);
insert into artist(name, bio, fan_number)
    values('M. Pokora','Né le 26 septembre 1985 à Strasbourg d''un père footballeur et d''une mère fonctionnaire',1310570);
insert into artist(name, bio, fan_number)
    values('Kendji Girac','Kendji Maillé est né à Périgueux, en Dordogne, le 3 juillet 1996.',1014955);
insert into artist(name, bio, fan_number)
    values('Julien Doré','Julien Doré est né le 7 juillet 1982 à Alès dans le Gard. Après des études ',708365);
insert into artist(name, bio, fan_number)
    values('Patrick Fiori','Patrick Fiori, né le 23 septembre 1969 sous le nom de Jean-François Chouchayan',216351);
insert into artist(name, bio, fan_number)
    values('Trois Cafés Gourmands','',167304);
insert into artist(name, bio, fan_number)
    values ('Nolwenn Leroy','C''est le 28 septembre 1982 que voit le jour, à Saint-Renan (Finistère) que voile jour Nolwenn Le Magueresse',230900);

/* album Kendji */
insert into album(id, artist_id, title, release_date) 
	values (1, 3, 'Kendji', '2015-05-04');

/* album Le Meilleur de la Musique Irlandaise */	
insert into album(id, artist_id, title, release_date) 
	values (2, 1, 'Le Meilleur de la Musique Irlandaise - Les Plus Beaux Airs Celtiques', '2014-03-03');


/* album Ancient Land */	
insert into album(id, artist_id, title, release_date) 
	values (3, 1, 'Ancient Land', '2018-09-28');

