public abstract class Jogador {

    protected int placar;
    protected String marcador;
    protected String nome;
    protected String tipo;

    public abstract boolean jogar(int x, int y); //JogoVelha.getTabuleiro().marcarJogada(int x, int y)

    public int getPlacar() {
        return placar;
    }

    public void setPlacar(int placar) {
        this.placar = placar;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


