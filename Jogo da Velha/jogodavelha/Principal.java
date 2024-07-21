package jogodavelha;

import armazenamento.Historico;
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
        Historico historico = new Historico();
        Console console = new Console();

        while (true) {
            clear();
            int opc = menu();
            switch (opc) {
                case 1 -> jogo.iniciarJovo();
                case 2 -> {
                    clear();
                    historico.printMapaHistorico();// Mostra o histórico dos últimos jogos.
                    int menu;
                    do {
                        menu = console.LerDadosint("Deseja voltar ao menu <1> ou encerrar <2>? "); 
                        switch (menu) {
                        // volta pro menu.
                            case 1:
                                break;
                            case 2:
                                System.out.println("Encerrando o programa.");
                                System.exit(0);
                            default:
                                System.out.println("Valor inválido, tente novamente: ");
                                break;
                        }
                    } while (menu > 2);
                    

                }    
                case 3 -> {
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

/**
 * Exibe o menu principal do programa.
 * @return a opção escolhida pelo usuário
 */
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
