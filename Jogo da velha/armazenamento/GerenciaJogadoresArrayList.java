package armazenamento;
import java.util.ArrayList;
import jogodavelha.Jogador;

/**
 * A classe GerenciaJogadoresArrayList gerencia a lista de jogadores usando um ArrayList.
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores{
    ArrayList<Jogador> jogadores = new ArrayList<>();

/**
 * @return a lsita de jogadores.
 */
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

/**
 * Define a lista de jogadores.
 * @param jogadores nova lista de jogadores.
 */
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @Override
    public void loadData(ArrayList<Jogador> j) {
        jogadores.add(j.getFirst());
    }

    @Override
    public void printPontos(ArrayList<Jogador> j) {
        for (int i = 0; i < 2; i++) {
            System.out.println(j.get(i).getNome() + " pontos = " + j.get(i).getPontuacao());
        }
    }
}
