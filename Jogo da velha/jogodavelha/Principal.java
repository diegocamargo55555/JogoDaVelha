package jogodavelha;

import entradadados.*;

/**
 * A classe Principal contém o método main e dá início ao jogo.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411
 */
public class Principal {

    /**
     * O método main é o ponto de entrada do programa.
     * Ele mostra um menu para o usuário escolher entre iniciar o jogo ou visualizar o histórico de partidas.
     * @param args argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        HistoricoJogos historico = new HistoricoJogos();

        while (true) {
            int opc = menu();
            switch (opc) {
                case 1 -> jogo.iniciarJovo();
                case 2 -> historico.mostrarHistorico(); // Mostra o histórico dos últimos 5 jogos
                case 3 -> {
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public static int menu() {
        Console console = new Console();
        int opc;
        clear();
        System.out.println("Bem-vindo ao Jogo da Velha!!");
        System.out.println("1. Iniciar Jogo");
        System.out.println("2. Histórico de Partidas");
        System.out.println("3. Encerrar");

        opc = console.LerDadosint("Escolha uma opção: ");
        return opc;
    }

    /**
    * Serve para limpar o terminal.   
    */
    public static void clear() {
       System.out.print("\033[H\033[2J");
       System.out.flush();
    }
}
