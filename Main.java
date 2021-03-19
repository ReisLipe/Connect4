package main;

import java.util.*;
import jogador.Jogador;
import partida.Partida;
import tabuleiro.Tabuleiro;



public class Main {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o nome do jogador 1: ");
		String nomeDoJogador1 = sc.nextLine();
		System.out.print("Insira o nome do jogador 2: ");
		String nomeDoJogador2 = sc.nextLine();
		System.out.println();
		
		// Instaciamento dos objetos jogadores
		Jogador j1 = new Jogador(nomeDoJogador1,1);
		Jogador j2 = new Jogador(nomeDoJogador2,2);
		
		// toString dos jogadores
		System.out.println(j1);
		System.out.println(j2);	
		System.out.println();
		
		// Instanciamneto do objeto tabuleiro para que o tabuleiro
		// possa ser impresso antes do instanciamento da partida
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.printaTabuleiro();
		
		// Instaciamento do objeto partida, passando
		//jogador 1 e 2 no construtor
		Partida p1 = new Partida(j1,j2);
		
		// Loop para as jogadas
		do {
			try {
				System.out.println("=======================");
				int posicaoX = sc.nextInt();
				p1.fazerJogada(posicaoX);			
				p1.getJogada();
				p1.getTabuleiro();	
				System.out.println();
				System.out.println("=======================");
			}catch(Exception e) {
				System.out.println("Erro: digite um número interio entre 0 e 6");
				System.out.println("E verifique se a coluna está cheia!");
				sc.nextLine();
			}			
		}while(p1.getFimDeJogo() == false);
		sc.close();
		
		
		if(p1.getEmpate()) {
			System.out.println("Fim de jogo!");
			System.out.println("Resultado: Empate!");
		}else {
			System.out.println("Fim de jogo!");
			System.out.println("Resultado: vitoria de "
			+ p1.getJogadorAtual().getNome());		
		}
		System.exit(0);
	}
}
