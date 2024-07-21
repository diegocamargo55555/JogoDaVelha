package jogodavelha;

import entradadados.Console;
import java.util.LinkedList;

public class HistoricoJogos {
    private LinkedList<char[][]> historico;
    private final Console console = new Console();

    public HistoricoJogos() {
        historico = new LinkedList<>();
    }

    public void adicionarJogo(Tabuleiro tabuleiro) {
        if (historico.size() == 5) {
            historico.removeFirst(); // Remove o jogo mais antigo se já houver 5 jogos
        }
        char[][] copiaTabuleiro = new char[9][17];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(tabuleiro.map[i], 0, copiaTabuleiro[i], 0, 17);
        }

        historico.addLast(copiaTabuleiro);
    }

    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhum jogo registrado no histórico.");
            return;
        }

        int jogoNumero = 1;
        for (char[][] tabuleiro : historico) {
            System.out.println("Jogo " + jogoNumero + ":");
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int k = 0; k < tabuleiro[i].length; k++) {
                    System.out.print(tabuleiro[i][k]);
                }
                System.out.println();
            }
            System.out.println();
            jogoNumero++;
        }

        int menu = console.LerDadosint("Deseja voltar ao menu <1> ou encerrar <2>? ");
        if (menu == 1) {
            // Aqui você pode reiniciar o jogo ou voltar ao menu
        } else {
            System.out.println("Encerrando o programa.");
            System.exit(0);
        }
    }
    

    public LinkedList<char[][]> getHistorico() {
        return historico;
    }

    public void setHistorico(LinkedList<char[][]> historico) {
        this.historico = historico;
    }
}

