package iftech.br.edu.ifpb.pistoSongs.repository;

import iftech.br.edu.ifpb.pistoSongs.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
