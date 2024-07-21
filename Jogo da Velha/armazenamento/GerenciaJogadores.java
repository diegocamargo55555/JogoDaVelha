package armazenamento;

import java.util.ArrayList;
import jogodavelha.Jogador;

/**
 * A interface GerenciaJogadores pré-define os métodos para gerenciar os pontos dos jogadores.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 21.0.3
 * @version
 */
public interface GerenciaJogadores {

    /**
     * Carrega os dados dos jogadores
     * @param j lista cuja a pontuação vai ser atualizada.
     */
    public void loadData(ArrayList<Jogador> j);

    /**
     * Mostra a pontuação atual.
     * @param j lista de jogadores a quem pertence a pontuação.
     */
    public void printPontos(ArrayList<Jogador> j);
}