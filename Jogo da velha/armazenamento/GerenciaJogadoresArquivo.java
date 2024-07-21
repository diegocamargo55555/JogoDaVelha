package armazenamento;
import java.io.*;
import java.util.ArrayList;
import jogodavelha.Jogador;

/**
 * A classe GerenciaJogadoresArquivo implementa a interface GerenciaJogadores
 * e gerencia a leitura e escrita dos pontos dos jogadores em um arquivo txt.
 */
public class GerenciaJogadoresArquivo implements GerenciaJogadores{
/**
 * Escreve a pontuação dos jogadores em um arquivo txt.
 * @param j a lista de jogadores cujas pontuações serão salvas.
 */
    public void pontuar(ArrayList<Jogador> j){
        try (FileWriter fw = new FileWriter("pontos.txt")) {
            for (int i = 0; i <= 1 ; i++) {
                String pontos = String.valueOf((j.get(i)).getPontuacao());
                String name = (j.get(i)).getNome();
                fw.write(name + "\n");
                fw.write(pontos + "\n");
            }
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }

/**
 * Lê e imprime a pontuação dos jogadores a partir de um arquivo txt.
 * @param j a lista de jogadores que a pontuação será mostrada.
 */
    @Override
    public void printPontos(ArrayList<Jogador> j){
        String name;
        String pontos;

        // Cria e usa um FileReader encapsulado em um BufferedReader.
        try (BufferedReader br = new BufferedReader(new FileReader("pontos.txt"))) {
            for (int i = 0; i < 2; i++) {
                name = br.readLine();
                pontos = br.readLine();

                System.out.println(name + " pontos = " + pontos);
            }
        } catch (IOException exc) {
            System.out.println("Erro de I/O: " + exc);
        }
    }

/**
 * Carrega os dados dos jogadores a partir do arquivo txt e atualiza a lista de jogadores.
 * @param j a lista de jogadores que é atualizada.
 */
    @Override
    public void loadData (ArrayList<Jogador> j){
        String ss;
        int numbern = 0;
        // Cria e usa um FileReader encapsulado em um BufferedReader.
        try (BufferedReader br = new BufferedReader(new FileReader("pontos.txt"))) {
            for (int i = 0; i < 2; i++) {
                ss = br.readLine();
                j.get(i).setNome(ss);
                ss = br.readLine();
                try {
                    numbern = Integer.parseInt(ss);
                }
                catch (NumberFormatException e) {
                    System.out.println("inteiro invalido");
                }
                j.get(i).setVitorias(numbern);
            }
        } catch (IOException exc) {
            System.out.println("Erro de I/O: " + exc);
        }
    }

}
