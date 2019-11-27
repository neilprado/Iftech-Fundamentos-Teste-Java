package iftech.br.edu.ifpb.pistoSongs.services;

import iftech.br.edu.ifpb.pistoSongs.dto.request.ArtistaRequest;
import iftech.br.edu.ifpb.pistoSongs.model.Artista;
import iftech.br.edu.ifpb.pistoSongs.repository.ArtistaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ArtistaService {
    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public Artista inserirArtista(ArtistaRequest artistaRequest){
        Artista artista = new Artista();

        artista.setDataNascimento(artistaRequest.getDataNascimento());
        artista.setNacionalidade(artistaRequest.getNacionalidade());
        if(this.artistaRepository.findByNome(artistaRequest.getNome()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Artista já cadastrado com esse nome");
        }else {
            artista.setNome(artistaRequest.getNome());
        }

        return this.artistaRepository.save(artista);
    }

    public Page<Artista> listarArtistas(Pageable pageable){
        return this.artistaRepository.findAll(pageable);
    }

    public Artista buscarArtista(long id){
        Artista artista = this.artistaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));
        return artista;
    }

    public Artista atualizarArtista(long id, ArtistaRequest request){
        Artista artista = this.artistaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));
        artista.setNome(request.getNome());
        artista.setDataNascimento(request.getDataNascimento());
        artista.setNacionalidade(request.getNacionalidade());


        return this.artistaRepository.save(artista);
    }

    public void removerArtista(long id){
           Artista artista = this.artistaRepository.findById(id).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));
        this.artistaRepository.delete(artista);
    }
}
