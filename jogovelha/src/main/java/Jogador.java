public class Jogador {

    private int placar;
    private String marcador;
    private String nome;
    private String tipo;

    public Jogador() {

    }

    public Jogador(int i) {

        placar = 0;

        if (i == 1){
            marcador = "X";
        } else {
            marcador = "O";
        }

        tipo = "Jogador";

        nome = "Jogador " + marcador;
    }

    public boolean jogar(int x, int y, Tabuleiro tab) {

        tab.marcarJogada(x,y);
        return true;

    }

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
