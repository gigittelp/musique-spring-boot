package test.musique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.musique.model.Album;
import test.musique.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService  {

	
	
	@Autowired
	private AlbumRepository repository;
	
	@Override
	public List<Album> findAll(String search) {
		if (! "".equals(search))
			return repository.findByTitleIgnoreCaseContaining(search);
		else
			return repository.findAll();
	}
	
	@Override
	public List<Album> findByArtist(Long id) {
		return repository.findByArtistId(id);
	}
	
	@Override
	public Album insert(Album album) {
		return repository.save(album);
	}
	
	
}
