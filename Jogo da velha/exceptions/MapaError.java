package exceptions;

import jogodavelha.Tabuleiro;

/**
 * Classe de exceção personalizada para um mapa null ou com dimenções diferentes de 9x17.
 */
public class MapaError extends Exception {
    Tabuleiro map = new Tabuleiro();

    public MapaError(Tabuleiro mapa) {
        super();
        map.iniciaTabuleiro();
        mapa = map;
    }

    public Tabuleiro arrumaMapa(Tabuleiro mapa){
        return mapa;
    }
}
