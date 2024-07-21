package exceptions;


/**
 * Classe de exceção personalizada para tratar valores negativos.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411
 */
public class ValorNegativo extends Exception {

/**
 * Construtor que inicializa a exceção com uma mensagem específica. 
 * @param mensagem a mensagem de erro associada à exceção.
 */
    public ValorNegativo(String mensagem) {
        super(mensagem);
    }
}
