package exceptions;


/**
 * Classe de exceção personalizada para tratar valores negativos.
 */
public class ValorNegativo extends Exception {
    public ValorNegativo(String mensagem) {
        super(mensagem);
    }
}
