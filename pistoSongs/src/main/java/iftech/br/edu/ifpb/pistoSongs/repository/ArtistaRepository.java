package iftech.br.edu.ifpb.pistoSongs.repository;

import iftech.br.edu.ifpb.pistoSongs.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNome(String nome);
}
