package test.musique.service;

import java.util.List;


import test.musique.model.Album;



public interface AlbumService {
	
	List<Album> findAll(String search);
	List<Album> findByArtist(Long id);
	Album insert(Album album);
	
}
