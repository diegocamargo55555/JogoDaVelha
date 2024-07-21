package jogodavelha;
import entrada_dados.Console;


/**
 * A classe Principal contém o método main e dá início ao jogo.
 */
public class Principal {
    public static void main(String[] args) { 
        int opc = 0;
        Console console = new Console();
        Jogo jogo = new Jogo();
        //HistoricoPartida histpartida = new HistoricoPartida();

        do { 
            System.out.println("Bem vindo ao Jogo da Velha!!\n");
            opc = console.LerDadosint("Jogo <1>\nHistórico de partida<2>\n");
            if(opc > 2){
                System.out.println("Valor inválido, tente novamente: ");
            }
        } while (opc != 2 && opc != 1);
        
        
        if(opc == 1){
            jogo.iniciarJovo();
        }
        //else if(opc == 2){
          //  hispartida();
        //}
        
    
    }
}
