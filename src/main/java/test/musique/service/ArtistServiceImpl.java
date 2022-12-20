package test.musique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import test.musique.common.AppException;
import test.musique.model.Album;
import test.musique.model.Artist;
import test.musique.repository.AlbumRepository;
import test.musique.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

    
    private ArtistRepository repositoryArtist;
    
    private AlbumRepository repositoryAlbum;
    
  
    public ArtistServiceImpl(@Autowired ArtistRepository repositoryArtist, @Autowired AlbumRepository repositoryAlbum) {
		super();
		// TODO Auto-generated constructor stub
		this.repositoryAlbum = repositoryAlbum;
		this.repositoryArtist = repositoryArtist;
		
		
	}

	@Override
    public List<Artist> findAll(String search) {
        if (! "".equals(search))
            return repositoryArtist.findByNameContaining(search);
        else
            return repositoryArtist.findAll();
    }
    
    @Override
    public Optional<Artist> findById (Long id) {
        return repositoryArtist.findById(id);
    }
    
    @Override
    public Artist insert(Artist artist) {
        return repositoryArtist.save(artist);
    }
    
    @Override
    public Artist update(Long id, Artist artist) {
        
        
        Optional<Artist> optionalArtist = this.findById(id);
        
        if(optionalArtist.isPresent()) {
            
            Artist artistToUpdate = optionalArtist.get(); 
            artistToUpdate.setName(artist.getName());
            if (artist.getBio() != null)
                artistToUpdate.setBio(artist.getBio());
            if (artist.getFanNumber() != null)
                artistToUpdate.setFanNumber(artist.getFanNumber());
            return repositoryArtist.save(artistToUpdate);
        }
        
        return null;
    }
    
    @Override
    public void delete(Long id) {
        Optional<Artist> optionalArtist = this.findById(id);
       
        if (optionalArtist.isPresent()) {
        	
        	List <Album> albums = repositoryAlbum.findByArtistId(id);
        	if (!albums.isEmpty())
				throw new AppException("Invalid Delete", "Artist with Albums");
        		//  n'affiche pas mon message mais celui "record already exist"
        		// throw new DataIntegrityViolationException("Artist with Albums"); 
        	
            repositoryArtist.delete(optionalArtist.get());
        }
    }

}
