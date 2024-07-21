package exceptions;

import jogodavelha.Tabuleiro;

/**
 * Classe de exceção personalizada para um mapa null ou com dimenções diferentes de 9x17.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 21.0.3
 */
public class MapaError extends Exception {
    Tabuleiro map = new Tabuleiro();

/**
 * Construtor que inicializa a exceção e corrige o mapa.
 * @param mapa o tabuleiro que causou a exceção.
 */
    public MapaError(Tabuleiro mapa) {
        super();
        map.iniciaTabuleiro();
        mapa = map;
    }

/**
 * Corrige e retorna o mapa.
 * @param mapa o tabuleiro a ser corrigido.
 * @return o tabuleiro corrigido.
 */
    public Tabuleiro arrumaMapa(Tabuleiro mapa){
        return mapa;
    }
}
