package iftech.br.edu.ifpb.pistoSongs.services;

import iftech.br.edu.ifpb.pistoSongs.dto.request.MusicaRequest;
import iftech.br.edu.ifpb.pistoSongs.model.Album;
import iftech.br.edu.ifpb.pistoSongs.model.Musica;
import iftech.br.edu.ifpb.pistoSongs.repository.AlbumRepository;
import iftech.br.edu.ifpb.pistoSongs.repository.MusicaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MusicaService {
    private MusicaRepository musicaRepository;
    private AlbumRepository albumRepository;

    public MusicaService(MusicaRepository musicaRepository, AlbumRepository albumRepository) {
        this.musicaRepository = musicaRepository;
        this.albumRepository = albumRepository;
    }

    public Musica cadastrarMusica(MusicaRequest request){
        Musica musica = new Musica();

        Album album = this.albumRepository.findById(request.getAlbumId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado"));

        musica.setNome(request.getNome());
        musica.setAlbum(album);
        musica.setDuracao(request.getDuracao());

        return this.musicaRepository.save(musica);
    }

    public Page<Musica> listarMusicas(Pageable pageable){
        return this.musicaRepository.findAll(pageable);
    }

    public Musica buscarMusica(Long id){
        Musica musica = this.musicaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Música não encontrada"));
        return musica;
    }

    public Musica atualizarMusica(Long id, MusicaRequest request){
        Musica musica = this.musicaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Música não encontrada"));

        Album album = this.albumRepository.findById(request.getAlbumId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album não encontrado"));

        musica.setNome(request.getNome());
        musica.setAlbum(album);
        musica.setDuracao(request.getDuracao());

        return this.musicaRepository.save(musica);
    }

    public void removerMusica(Long id){
        Musica musica = this.musicaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Música não encontrada"));
        this.musicaRepository.delete(musica);
    }
}
