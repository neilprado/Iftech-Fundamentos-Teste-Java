package iftech.br.edu.ifpb.pistoSongs.services;

import iftech.br.edu.ifpb.pistoSongs.dto.request.AlbumRequest;
import iftech.br.edu.ifpb.pistoSongs.model.Album;
import iftech.br.edu.ifpb.pistoSongs.model.Artista;
import iftech.br.edu.ifpb.pistoSongs.repository.AlbumRepository;
import iftech.br.edu.ifpb.pistoSongs.repository.ArtistaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;
    private ArtistaRepository artistaRepository;

    public AlbumService(AlbumRepository albumRepository, ArtistaRepository artistaRepository) {
        this.albumRepository = albumRepository;
        this.artistaRepository = artistaRepository;
    }

    public Album inserirAlbum(AlbumRequest request){
        Album album = new Album();

        Artista artista = this.artistaRepository.findById(request.getArtistaId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));

        if(request.getAnoGravacao() > LocalDate.now().getYear()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível cadastrar um ano superior a "
                    + LocalDate.now().getYear());
        }else {
            album.setAnoGravacao(request.getAnoGravacao());
        }

        if(this.albumRepository.findByNome(request.getNome()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe um álbum com esse nome");
        }else{
            album.setNome(request.getNome());
        }
        album.setArtista(artista);
        album.setGenero(request.getGenero());


        if(request.getFaixas() >= 0){
            album.setFaixas(request.getFaixas());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não pode haver álbum com quantidade de músicas negativo");
        }

        return this.albumRepository.save(album);
    }

    public Page<Album> listarAlbuns(Pageable pageable){
        return this.albumRepository.findAll(pageable);
    }

    public Album buscarAlbum(Long id){
        Album album = this.albumRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado"));
        return album;
    }

    public Album atualizarAlbum(Long id, AlbumRequest request){
        Album album = this.albumRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado"));

        Artista artista = this.artistaRepository.findById(request.getArtistaId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));

        if(request.getAnoGravacao() > LocalDate.now().getYear()){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível cadastrar um ano superior a "
                    + LocalDate.now().getYear());
        }else {
            album.setAnoGravacao(request.getAnoGravacao());
        }
        album.setNome(request.getNome());
        album.setArtista(artista);
        album.setGenero(request.getGenero());


        if(request.getFaixas() >= 0){
            album.setFaixas(request.getFaixas());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não pode haver álbum com quantidade de músicas negativo");
        }

        return this.albumRepository.save(album);
    }

    public void removerAlbum(Long id){
        Album album = this.albumRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado"));
        this.albumRepository.delete(album);
    }
}
