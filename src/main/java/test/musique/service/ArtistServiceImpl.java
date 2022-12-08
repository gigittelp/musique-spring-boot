package test.musique.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.musique.model.Artist;
import test.musique.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository repository;
    
    @Override
    public List<Artist> findAll(String search) {
        if (! "".equals(search))
            return repository.findByNameContaining(search);
        else
            return repository.findAll();
    }
    
    @Override
    public Optional<Artist> findById (Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Artist insert(Artist artist) {
        return repository.save(artist);
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
            return repository.save(artistToUpdate);
        }
        
        return null;
    }
    
    @Override
    public void delete(Long id) {
        Optional<Artist> optionalArtist = this.findById(id);
        if (optionalArtist.isPresent()) {
            repository.delete(optionalArtist.get());
        }
    }

}
