package armazenamento;

import java.io.*;
import jogodavelha.Tabuleiro;

/**
 * A classe Historico herda de Tabuleiro e gerencia o histórico dos tabuleiros em um arquivo txt.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411
 */
public class Historico extends Tabuleiro {
    
/**
 * Salva um novo tabuleiro no arquivo de histórico.
 * @param mapa o tabuleiro a ser salvo
 */
    public void salvarNovoTabuleiro(Tabuleiro mapa) {
        try (FileWriter fw = new FileWriter("historico.txt")) {
            //Percorre a matriz e salva cada caracter no txt.
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 17; j++) {
                    fw.write(mapa.map[i][j]);
                }
                // Adiciona uma nova linha após cada linha do tabuleiro.
                fw.write('\n');
            }
            // Adiciona uma linha em branco para separar diferentes tabuleiros.
            fw.write('\n');
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