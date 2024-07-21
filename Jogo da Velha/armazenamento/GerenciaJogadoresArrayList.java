package armazenamento;
import java.util.ArrayList;
import jogodavelha.Jogador;

/**
 * A classe GerenciaJogadoresArrayList gerencia a lista de jogadores usando um ArrayList.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores{
    ArrayList<Jogador> jogadores = new ArrayList<>();

/**
 * Retorna a lista de jogadores.
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

/**
 * Carrega os dados dos jogadores.
 * @param j a lista de jogadores cuja pontuação será atualizada
 */
    @Override
    public void loadData(ArrayList<Jogador> j) {
        // Adiciona o primeiro jogador da lista txt à lista interna.
        jogadores.add(j.getFirst());
    }

/**
 * Mostra a pontuação atual dos jogadores.
 * @param j a lista de jogadores cujas pontuações serão exibidas
 */
    @Override
    public void printPontos(ArrayList<Jogador> j) {
        for (int i = 0; i < 2; i++) {
            System.out.println(j.get(i).getNome() + " pontos = " + j.get(i).getPontuacao());
        }
    }


}