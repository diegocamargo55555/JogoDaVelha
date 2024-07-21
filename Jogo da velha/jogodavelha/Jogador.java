package jogodavelha;

/**
 * Classe Jogador representa um jogador do jogo da velha.
 */
public class Jogador{
    private String nome;
    private int vitorias;
    private char simbolo;

/**
 * Construtor que inicializa jogador, associando ele à um nome. 
 * @param nome nome do jogador.
 */    
    public Jogador(String nome){
        this.nome = nome;
        this.vitorias = 0;
    }
/**
 * Contrutor que inicializa o jogador caso a opção "continuar jogo" seja selecionada.
 */
    public Jogador(){
        this.nome = "";
        this.vitorias = 0;
    }

/**
 * Define (X) ou (O).
 * @param simbolo símbulo do jogador.
 */
    public void setSimbolo(char simbolo){
        this.simbolo = simbolo;
    }

/**
 * Define o nome do jogador.
 * @param nome do jogador.
 */
    public void setNome(String nome) {
        this.nome = nome;
    }

/**
 * @return Retorno o nome do jogador.
*/
    public String getNome() {
        return nome;
    }

/**
 * @return Returna o símbulo do jogador.
 */
    public char getSimbulo() {
        return simbolo;
    }

/**
 * Incrementa o número de vitorias do jogador.
 */
    public void adicionarPonto() {
        this.vitorias++;
    }

/**
 * Define o número de vitórias do usuário, no caso quando ele já possui 
 * vitórias de jogos anteriores.
 * @param vitorias número de vitórias.
 */
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

/**
 * @return Retorna o número de vitórias.
 */
    public int getPontuacao() {
        return vitorias;
    }

}
