package iftech.br.edu.ifpb.pistoSongs.dto.request;

public class AlbumRequest {
    private String nome;
    private int faixas;
    private int anoGravacao;
    private String genero;
    private long artistaId;

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

    public long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(long artistaId) {
        this.artistaId = artistaId;
    }
}
