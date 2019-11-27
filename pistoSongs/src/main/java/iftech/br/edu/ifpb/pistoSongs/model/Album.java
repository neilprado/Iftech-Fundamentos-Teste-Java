package iftech.br.edu.ifpb.pistoSongs.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int faixas;
    private int anoGravacao;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "artista_id", nullable = false, foreignKey = @ForeignKey(name = "fk_album_artista_id"))
    private Artista artista;

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

    public int getFaixas() {
        return faixas;
    }

    public void setFaixas(int faixas) {
        this.faixas = faixas;
    }

    public int getAnoGravacao() {
        return anoGravacao;
    }

    public void setAnoGravacao(int anoGravacao) {
        this.anoGravacao = anoGravacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
