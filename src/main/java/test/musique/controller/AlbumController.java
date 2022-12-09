package test.musique.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.musique.model.Album;
import test.musique.service.AlbumService;

@RestController
@RequestMapping("/test.musique")
public class AlbumController {
	@Autowired
	AlbumService service;
	
	
	/**
	 * Liste des albums
	 * @param search : critère de recherche
	 * @return liste des albums
	 */
	
	@GetMapping("/albums")
	public ResponseEntity<List<Album>> getAllAlbum(@RequestParam(value="search", defaultValue="") String search) {
		List<Album> listAlbum;
		try {
			listAlbum = service.findAll(search);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listAlbum);
	}
	
	
	@GetMapping("/artists/{id}/albums")
	public ResponseEntity<List<Album>> getAllAlbum(@PathVariable(value = "id") long id) {
		List<Album> listAlbum;
		try {
			listAlbum = service.findByArtist(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listAlbum);
	}
	
	
	
	
}
