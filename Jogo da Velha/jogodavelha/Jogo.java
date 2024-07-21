package jogodavelha;
import armazenamento.GerenciaJogadoresArquivo;
import armazenamento.Historico;
import entradadados.Console;
import java.util.ArrayList;

/**
 * A classe Jogo gerencia a lógia principal do jogo da velha.
 * @author Giovana04
 * @author diegocamargo55555
 * @version 1.8.0_411
 */
public class Jogo extends Tabuleiro{

    Console console = new Console();
    Tabuleiro mapa = new Tabuleiro();
    Jogada jogada = new Jogada();
    GerenciaJogadoresArquivo arq = new GerenciaJogadoresArquivo();
    ArrayList<Jogador> jogadores = new ArrayList<>();
    Historico hist = new Historico();

/**
 * Serve para limpar o terminal.   
 */
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

/**
 * Inicia o jogo da velha, havendo a opção de carregar os dados anteriores ou iniciar um novo jogo.
 */
    public void iniciarJovo(){
        String resposta;

        resposta = console.LerDadosString("deseja continuar jogo(s/n)?");
        
        if("S".equals(resposta) || "Sim".equals(resposta) || "s".equals(resposta) || "sim".equals(resposta)){ //Continua com os jogadores e pontuações anteriores
            Jogador j1 = new Jogador();
            Jogador j2 = new Jogador();

            jogadores.add(j1);
            jogadores.add(j2);
            arq.loadData(jogadores);
            System.out.println("j1:" + j1.getNome()+ ", pontos: " + j1.getPontuacao() + "\nj2:" + j2.getNome() + ", pontos: " + j2.getPontuacao());
        }
        else{ //Novo jogo
            hist.resetHistoricoMapa();
            if(!"n".equals(resposta)){
                System.out.println("Como a resposta não foi afirmativa, o jogo será reiniciado.");
            }

            Jogador j1 = new Jogador(console.LerDadosString("\nQual o nome do jogador 1? ( O ) "));
            jogadores.add(j1);

            Jogador j2 = new Jogador(console.LerDadosString("\nQual o nome do jogador 2? ( X ) "));
            jogadores.add(j2);
            System.out.println("j1:" + j1.getNome() + "\nj2:" + j2.getNome());
        }
        jogadores.get(0).setSimbolo('X');
        jogadores.get(1).setSimbolo('O');

        boolean continua;

        do { 
            Jogando(jogadores.getFirst(), jogadores.get(1), mapa);
            continua = Continuar();
        } while (continua);

        //Voltar ao menu ou encerrar o programa.
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

/**
 * Método responsável por executar a partida, alterando entre os jogadores até uma vitória ou empate.
 * @param j1 priemiro jogador.
 * @param j2 segundo jogador.
 * @param mapa tabuleiro do jogo.
 */
    public void Jogando(Jogador j1, Jogador j2, Tabuleiro mapa){
        boolean vencedor = false;

        mapa.iniciaTabuleiro();
        while (!vencedor && !tabuleiroCompleto(mapa)){
            clear(); //Limpa a tela.
            System.out.println(j1.getNome() + " (" + j1.getSimbulo() + "), sua vez! \n");
            mapa.printTabuleiro(mapa);
            jogada.mover(j1, mapa); //Move e marca no tabuleiro o símbolo do jogador 1.
            vencedor = verificaVencedor(mapa);
            if(vencedor){
                System.out.println("Parabens " + j2.getNome()+ "!"); //Se o j1 vencer é mostrada a parabenização
                j1.adicionarPonto(); //é inclementado o número de vitórias,
                break; //em seguida a partida é encerrada.
            }

            if(tabuleiroCompleto(mapa)){ //Aqui verificamos se o jogo não terminou em empate
                System.out.println("Jogo terminou em empate!");
                break;
            }

            //Mesma lógica do jogador 1.
            clear();
            System.out.println(j2.getNome() + " (" + j2.getSimbulo() + "), sua vez! \n");
            mapa.printTabuleiro(mapa);
            jogada.mover(j2, mapa);
            vencedor = verificaVencedor(mapa);
            if(vencedor){
                System.out.println("Parabens " + j2.getNome() + "!");
                j2.adicionarPonto();
                break;
            }
        }
        hist.salvarHistoricoContinuo(mapa); //Salva o mapa no histórico.
        arq.pontuar(jogadores); //Atualiza a pontuação no arquivo.
        arq.printPontos(jogadores); //Mostra a nova pontuação.
    }

/**
 * Verifica se houve um vencedor.
 * @param mapa tabuleiro do jogo.
 * @return true se houver um vencedor, false caso contrário.
 */
    public boolean verificaVencedor(Tabuleiro mapa){
        int i = 1;
        while(i<9){ //vitória na vertical.
            if(mapa.map[i][2] == mapa.map[i][8] && mapa.map[i][8] == mapa.map[i][14] && mapa.map[i][14] != '-'){
                return true;
            }
            i += 3;
        }
        i = 2;
        while(i<17){ //Vitória na horizontal.
            if(mapa.map[1][i] == mapa.map[4][i] && mapa.map[4][i] == mapa.map[7][i] && mapa.map[1][i] != '-'){
                return true;
            }
            i += 6;
        }

        //Diagonais.
        if(mapa.map[1][2] == mapa.map[4][8] && mapa.map[1][2] == mapa.map[7][14] && mapa.map[1][2] != '-'){
            return true;
        }

        else if(mapa.map[1][14] == mapa.map[7][2] && mapa.map[1][14] == mapa.map[4][8] && mapa.map[1][14] != '-'){
            return true;
        }

        return false;
    }

/**
 * Marca a jogada no tabuleiro.
 * @param l coordenada da linha.
 * @param c coordenada da coluna.
 * @param s símbolo do jogador.
 * @param mapa tabuleiro.
 * @return true se foi possível fazer a marcação, false caso contrário.
 */
    public boolean marcar(int l, int c, char s, Tabuleiro mapa) {
        //Relaciona os números com as posições corretas
        int[] Linha = {1, 4, 7}; 
        int[] Coluna = {2, 8, 14};
        
        if (l >= 1 && l <= 3 && c >= 1 && c <= 3){ //verifica se os valores foram de 1 à 3.
            //Decrementa 1, pois se o usuário escreveu, por exemplo, 1 então o valor no vetor linha[] é igual a zero.
            int linha = Linha[l - 1]; 
            int coluna = Coluna[c - 1];
    
            if (mapa.map[linha][coluna] == '-') {  //Verifica se a posição está vazia.
                mapa.map[linha][coluna] = s; 
                return true;
            } 
            else {
                System.out.println("Posição já ocupada por:  " + mapa.map[linha][coluna]);
            }
        } 
        //Existe uma exception para valores negativos e não inteiros, aqui é para valores maiores que 3.
        else {
            System.out.println("Linha ou coluna fora dos limites!");
        }
        return false;
    }

/**
 * Verifica se, após o termino de um jogo, os jogadores querem jogar novamente.
 * @return true se a resposta for positiva, false caso o contrário.
 */
    public boolean Continuar(){
        String resposta;
        resposta = console.LerDadosString("Deseja jogar novamente?'S' ou 'N'\n Se a resposta não for positiva, poderá voltar ao menu ou encerrar o aplicativo.");
        return "S".equals(resposta) || "Sim".equals(resposta) || "s".equals(resposta) || "sim".equals(resposta);
    }
    
/**
 * Carrega os dados do jogo a partir de uma lista de jogadores.
 * @param j lista de jogadores.
 */    
    public void loadGame(ArrayList<Jogador> j){
        String resposta;
        resposta = console.LerDadosString("Deseja continuar jogo(s/n) ?");
        if("S".equals(resposta) || "Sim".equals(resposta) || "s".equals(resposta) || "sim".equals(resposta)){
            arq.loadData(j);
        }
        else{
            System.out.println("Como a resposta não foi positiva, será iniciado um novo jogo.");
        }
    }
}