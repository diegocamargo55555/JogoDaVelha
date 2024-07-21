package armazenamento;

import java.io.*;
import jogodavelha.Tabuleiro;

/**
 * A classe Historico é a funcionalidade extra do código, ela mostra o histórico das ultimas partidas jogadas.
 * 
 * O Historico funciona de forma simples, todo fim de jogo, tenha ele terminado em vitória ou empate, é feito uma leitura do tabuleiro
 * e cada um dos caracteres é armazenado em um arquivo txt. Esse arquivo pode ser acessado no menu do jogo "Histórico de partidas <2>".
 * 
 * A funcionalidade foi pensada com o intuito de permitir que os jogadores possam discutir o processo das partidas anteriores, análisar 
 * as vitórias e os empates, estrátegias de jogo - mesmo que seja um jogo simples - ou só conversar sobre os resultados.
 * 
 * Sobre o processo de implementação: Nosso primeiro pensamento era fazer um vetor de matrizes que armazenariam um número limitado de jogos,
 * após uma primeira tentativa decidimos nos inspirar no sistema de pontuação em txt e criamos outro arquivo textual para o histórico. Implementamos
 * a forma de salvar o tabuleira a cada fim de jogo e em seguida como ele iria salvar continuamente os jogos, por fim só precisamos criar o print do txt.
 *  
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411
 */
public class Historico extends Tabuleiro {
    
/**
 * Reseta o arquivo txt.
 */
    public void resetHistoricoMapa() {
        try (FileWriter fw = new FileWriter("historico.txt")) {
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }

/**
 * Imprime o conteúdo do arquivo de histórico, linha por linha.
 */
    public void printMapaHistorico() {
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader("historico.txt"))) {
            // Lê o arquivo txt e imprime cada linha.
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException exc) {
            System.out.println("Erro de I/O: " + exc);
        }
    }

/**
 * Salva um novo tabuleiro no arquivo txt, adicionando ao conteúdo existente.
 * @param mapa o tabuleiro a ser salvo
 */
    public void salvarHistoricoContinuo(Tabuleiro mapa) {
        try (FileWriter fw = new FileWriter("historico.txt", true)) {
            //Escreve o tabuleiro no txt.
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 17; j++) {
                    fw.write(mapa.map[i][j]);
                }
                fw.write('\n');
            }
            fw.write('\n');
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
