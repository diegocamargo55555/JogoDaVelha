package jogodavelha;

import armazenamento.GerenciaJogadoresArquivo;
import entrada_dados.Console;
import armazenamento.GerenciaJogadoresArrayList;
import armazenamento.Historico;

import java.io.IOException;
import java.util.ArrayList;

public class Testes {
    public static void main(String[] args) throws IOException {
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        Historico hist = new Historico();


        Console console = new Console();
        Tabuleiro mapa = new Tabuleiro();
        Jogada jogada = new Jogada();
        GerenciaJogadoresArquivo arq = new GerenciaJogadoresArquivo();

        Jogador j1 = new Jogador(console.LerDadosString("Qual o nome do jogador 1? ( O ) "));
        j1.setSimbolo('O');

        Jogador j2 = new Jogador(console.LerDadosString("Qual o nome do jogador 2? ( X ) "));
        j2.setSimbolo('X');
        jogadores.add(j1);
        jogadores.add(j2);
        arq.loadData(jogadores);


        j1.adicionarPonto();
        j1.adicionarPonto();
        j1.adicionarPonto();

        j2.adicionarPonto();

        hist.printMapaHistorico();





        arq.pontuar(jogadores);
        arq.printPontos(jogadores);
    }
}
