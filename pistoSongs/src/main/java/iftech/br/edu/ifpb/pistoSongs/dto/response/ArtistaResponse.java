package iftech.br.edu.ifpb.pistoSongs.dto.response;

import iftech.br.edu.ifpb.pistoSongs.model.Artista;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ArtistaResponse {
    private long id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static ArtistaResponse from(Artista artista){
        ArtistaResponse response = new ArtistaResponse();

        response.setDataNascimento(artista.getDataNascimento());
        response.setId(artista.getId());
        response.setNacionalidade(artista.getNacionalidade());
        response.setNome(artista.getNome());

        return response;
    }

    public static Page<ArtistaResponse> from(Page<Artista> artistas){
        Page<ArtistaResponse> responses = artistas.map(artista -> {
            ArtistaResponse response = new ArtistaResponse();

            response.setDataNascimento(artista.getDataNascimento());
            response.setId(artista.getId());
            response.setNacionalidade(artista.getNacionalidade());
            response.setNome(artista.getNome());

            return response;
        });

        return responses;
    }
}
