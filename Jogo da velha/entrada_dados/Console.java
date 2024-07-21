package entrada_dados;

import exceptions.ValorNegativo;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A Classe console tem os métodos para ler dois tipos de entrada do usuário.
 */

public class Console {
    private final Scanner myobj;

/**
 * Contrutor que inicializa a leitura.
 */
    public Console() {
        myobj = new Scanner(System.in);
    }

/**
 * Lê uma string como entrada de usuário.
 * @param mensagem mostra mensagem a ser exibida antes de aceitar uma entrada.
 * @return A string digitada pelo usuário.
 */
    public String LerDadosString(String mensagem){
        System.out.println(mensagem);
        return myobj.nextLine();
    }

/**
 * Lê um inteiro como entrada de usuário.
 * Continua pedindo novas entradas até que alguma seja válida.
 * @param mensagem mostra a mensagem a ser exibida antes de aceitar uma entrada.
 * @return o valor inteiro válido digitado pelo usuário.
 * @throws ValorNegativo se o valor digitado for negativo ou igual a zero.
 */    
    public int LerDadosint(String mensagem){  
        int valor;
        System.out.println(mensagem);
        
        while (true) { // Loop infinito até receber um valor válido
            try {
                valor = myobj.nextInt(); // Tenta ler um valor inteiro
                if (valor < 1) {
                    throw new ValorNegativo("O valor não pode ser menor que 1 ."); // Lança exceção se o valor for negativo
                }
                return valor; // Retorna o valor se for válido e quebra o loop
            } catch (InputMismatchException e) { //Se o valor não for um inteiro
                System.out.println("Entrada não é um valor inteiro! Tente novamente: ");
                myobj.next(); // Limpa a entrada inválida
            } catch (ValorNegativo ex) {
                System.out.println(ex.getMessage() + " Tente novamente: ");
            }
        }
    }
}
