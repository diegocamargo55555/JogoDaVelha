package jogodavelha;

import entradadados.Console;

/**
 * A classe Jogada gerencia a movimentação dos jogadores.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411 
 */
public class Jogada{

    private final Console console;

/**
 * Contrutor que inicializa o console.
 */
    public Jogada(){
        console = new Console();
    }
/**
 * Faz com que o jogador chegue na posição desejada, para isso
 * é solicitado que o jogador defina as coordenadas (linha, coluna)
 * e em seguida marca a no tabuleiro a jogada (se forem válidas).
 * @param j o jogador que está fazendo a jogada.
 * @param mapa tabuleiro do jogo.
 */
    public void mover(Jogador j, Tabuleiro mapa){
        int linha, coluna;
        Jogo tabuleiro = new Jogo();
        
        do { 
            linha = console.LerDadosint("Informe a linha desejada (1 a 3): ");
            coluna = console.LerDadosint("Informe a coluna desejada (1 a 3): ");
        } while (!tabuleiro.marcar(linha, coluna, j.getSimbulo(), mapa));
        
    }
    
}
