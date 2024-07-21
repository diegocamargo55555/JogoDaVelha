package jogodavelha;
import exceptions.MapaError;

/**
 * A classe Tabuleiro faz a inicialização e o funcionamento do tabuleiro do jogo.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411
 */
public class Tabuleiro {
    public char[][] map;

/**
 * Contrutor que inicializa o tabuleiro.
 */
    public Tabuleiro(){
        map = new char[9][17];
    }
    
/**
 * Retorna o tabuleiro.
 * @return o tabuleiro.
 */
    public char[][] getMap(){
        return map;
    }

/**
 * Preenche o tabuleiro com a sua forma inicial.
 */
    public void iniciaTabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 17; k++) {
                map[i][k] = ' ';
            }
        }
        for (int i = 0; i < 17; i++) {
            map[2][i] = '_';
            map[5][i] = '_';
        }
        for (int i = 0; i < 9; i++) {
            map[i][5] = '|';
            map[i][11] = '|';
        }
        map[1][2] = '-';
        map[1][8] = '-';
        map[1][14] = '-';
    
        map[4][2] = '-';
        map[4][8] = '-';
        map[4][14] = '-';
    
        map[7][2] = '-';
        map[7][8] = '-';
        map[7][14] = '-';
    }

/**
 * Verifica se o tabuleiro está completo.
 * @param mapa tabuleiro.
 * @return true se estiver completo, false se ainda houver posições a serem preenchidas.
 * @throws MapaError se o tabuiro, por algum motivo, estiver nulo ou com dimenções diferentes de 9x17.
 */
    public boolean tabuleiroCompleto(Tabuleiro mapa){
        
        try {

            if (mapa == null || mapa.map == null) {
                throw new MapaError(mapa);
            }
            
            if (mapa.map.length != 9 || mapa.map[0].length != 17) {
                throw new MapaError(mapa);
            }

            for (int i = 0; i < 9; i++) {
                for (int k = 0; k < 17; k++) {
                    if(mapa.map[i][k] == '-'){
                        return false;
                    }
                }
            }
            
        } 
        catch (MapaError e) {
            System.out.println("Houve um problema com as dimenções do mapa, mas o problema já deve ter sido resolvido.");
        }

        return true;
    }

/**
 * Mostra o tabuleiro.
 * @param mapa tabuleiro a ser mostrado.
 */
    public void printTabuleiro(Tabuleiro mapa){
        for (int i = 0; i < 9; i++) {
            System.out.print(String.format("%60s","")); //Deixa centralizado.
            for (int k = 0; k < 17; k++) {
                System.out.print(map[i][k]);
            }
            System.out.print("\n");
        }
    }
}
    