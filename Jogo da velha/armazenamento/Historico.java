package armazenamento;

import jogodavelha.Tabuleiro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Historico extends Tabuleiro {
    public void salvarNovoTabuleiro(Tabuleiro mapa) {
        try (FileWriter fw = new FileWriter("historico.txt")) {
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

    public void printMapaHistorico() {
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader("historico.txt"))) {
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException exc) {
            System.out.println("Erro de I/O: " + exc);
        }
    }

    public void salvarHistoricoContinuo(Tabuleiro mapa) {
        try (FileWriter fw = new FileWriter("historico.txt", true)) {
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