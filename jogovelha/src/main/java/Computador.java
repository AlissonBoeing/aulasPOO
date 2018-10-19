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

        int tabu[][] = tab.getTabuleiro();
        int somalinhas[] = new int[3];
        int somacolunas[] = new int[3];
        int somadiagonal[] = new int[3];
        int comp = 0;
        int Marcador = 0;
        int teste = 0;

        if (x != 5 && y != 5) {
            tab.marcarJogada(x,y);
            return true;
        }

        System.out.println(x+ " " + y);;
        if(tab.isJogadorDaVez()) {
            Marcador = 1;
            comp = 20;
            teste = 2;
        } else {
            Marcador = 10;
            comp = 2;
            teste = 20;
        }


            for(int i =0; i<3;i++) {
                for(int j =0; j<3; j++) {
                    somalinhas[i] =  somalinhas[i] + tabu[i][j];
                    somacolunas[j] = somacolunas[j] + tabu[i][j];
                }
            }

            somadiagonal[0] = tabu[0][0] + tabu[1][1] + tabu[2][2];
            somadiagonal[1] = tabu[0][2] + tabu[1][1] + tabu[2][0];
            somadiagonal[2] = 0;

            for(int i = 0; i<3; i++) {

                if(somalinhas[i] == comp || somalinhas[i] == teste ) {
                   for(int j =0; j<3; j++) {
                       if(tabu[i][j] == 0) {
                           //tabu[i][j] = Marcador;
                           tab.marcarJogada(i,j);
                            return true;
                       }
                   }
                } else if (somacolunas[i] ==  comp || somacolunas[i] == teste) {

                    for(int j =0; j<3; j++) {
                        if(tabu[j][i] == 0) {
                           // tabu[j][i] = Marcador;
                            tab.marcarJogada(j,i);
                            return true;
                        }
                    }

                } else if (somadiagonal[i] == comp || somadiagonal[i] == teste) {
                    if(i == 0) {
                        int k = i;
                        for (int j=0; j < 3; j++) {
                                if(tabu[k][j] == 0) {
                                    //tabu[k][j] = Marcador;
                                    tab.marcarJogada(k,j);
                                    return true;
                                }
                                k++;
                        }
                    } else if (i == 1) {
                        int k = 2;
                        for (int j=0; j<3; j++) {
                            if(tabu[j][k] == 0) {
                                //tabu[j][k] = Marcador;
                                tab.marcarJogada(j,k);
                                return true;
                            }
                            k--;
                        }
                    }
                } else {
                    for(int c = 0; c<3; c++) {
                        for(int j=0; j<3; j++) {
                            if(tabu[c][j] == 0) {
                                //tabu[c][j] = Marcador;
                                tab.marcarJogada(c,j);
                                return true;
                            }
                        }
                    }

                }
            }
    return false;
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
