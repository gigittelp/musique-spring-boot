use MUSIQUE_DB;

/* liste des artistes */
insert into artist(id, name, bio, fan_number)
    values(1, 'Celtic woman','En 2004, les producteurs Sharon Browne et David Downes, directeur musical...',31760);
insert into artist(id, name, bio, fan_number)
    values(2, 'M. Pokora','Né le 26 septembre 1985 à Strasbourg d''un père footballeur et d''une mère fonctionnaire',1310570);
insert into artist(id, name, bio, fan_number)
    values(3, 'Kendji Girac','Kendji Maillé est né à Périgueux, en Dordogne, le 3 juillet 1996.',1014955);
insert into artist(id, name, bio, fan_number)
    values(4, 'Julien Doré','Julien Doré est né le 7 juillet 1982 à Alès dans le Gard. Après des études ',708365);
insert into artist(id, name, bio, fan_number)
    values(5, 'Patrick Fiori','Patrick Fiori, né le 23 septembre 1969 sous le nom de Jean-François Chouchayan',216351);
insert into artist(id, name, bio, fan_number)
    values(6, 'Trois Cafés Gourmands','rien à dire',167304);
insert into artist(id, name, bio, fan_number)
    values (7, 'Nolwenn Leroy','C''est le 28 septembre 1982 que voit le jour, à Saint-Renan (Finistère) que voile jour Nolwenn Le Magueresse',230900);

/* album Kendji */
insert into album(id, artist_id, title, release_date) 
	values (1, 3, 'Album new Kendji', '2015-05-04');


--- album 3cg    
    insert into album(id, artist_id, title, release_date) 
	values (4, 6, 'first album', '2020-10-03');

--- album Le Meilleur de la Musique Irlandaise	
insert into album(id, artist_id, title, release_date) 
	values (2, 1, 'Le Meilleur de la Musique Irlandaise - Les Plus Beaux Airs Celtiques', '2014-03-03');


--- album Ancient Land 	
insert into album(id, artist_id, title, release_date) 
	values (3, 1, 'Ancient Land', '2018-09-28');

