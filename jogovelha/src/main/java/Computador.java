public class Computador extends Jogador {

    private int placar;
    private String marcador;
    private String nome;
    private String tipo;

    public Computador() {

    }

    public Computador(int i) {

        placar = 0;

        if (i == 1){
            marcador = "X";
        } else {
            marcador = "O";
        }
        tipo = "Computador";
        nome = "Computador " + marcador;

    }

    @Override
    public boolean jogar(int x, int y, Tabuleiro tab) {



        return super.jogar(x, y, tab);
    }

    @Override
    public int getPlacar() {
        return placar;
    }

    @Override
    public void setPlacar(int placar) {
        this.placar = placar;
    }

    @Override
    public String getMarcador() {
        return marcador;
    }

    @Override
    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
