package partida;

import jogador.Jogador;
import tabuleiro.Tabuleiro;

public class Partida {
	
	private Jogador jogador1;
	private Jogador jogador2;
	private boolean fimDeJogo;
	private boolean vencedor;
	private boolean empate;
	private int contador;
	private Tabuleiro tabuleiro;
	// Atributo "tabuleiro" torna poss�vel utilizar e modificar um objeto tabuleiro
	private int posicaoX;
	private Jogador jogadorAtual = new Jogador("", 0);
	// Tanto "posicaoX" quanto "jogadorAtual" deixaram de ser tempor�rios no m�todo
	// "fazerJogada" para que tamb�m possam ser usados em "getTabuleiro" e "getJogada"

	public Partida(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		// Identifica qual dos jogadores inseridos � o jogador 1
		// e qual � o jogador 2
		this.contador = this.jogador1.getValorDoJogador();
		// Atribui o valor do jogador 1 para "contador", tornando-o o primeiro a jogar
		this.tabuleiro = new Tabuleiro();
		// Instacia um objeto tabuleiro, que ent�o � passado para o atributo
		// tabuleiro da classe
	}

	public void fazerJogada(int posicaoX) throws Exception {
		this.posicaoX = posicaoX;
		// Armazena a posi��o inserida no atributo "posicaoX"
		if (this.tabuleiro.checaPosicaoX(this.posicaoX) == this.posicaoX) {
			this.jogadorAtual = this.vezDeJogada();
			// Atributo "jogadorAtual" assume o valor do jogador atual
			this.tabuleiro.jogada(this.posicaoX, this.jogadorAtual.getValorDoJogador());
			// A jogada � realizada
			this.setVencedor(this.tabuleiro.checaVitoria(posicaoX, jogadorAtual.getValorDoJogador()));
			this.setEmpate(this.tabuleiro.checaEmpate());
			if (this.getEmpate() || this.getVencedor()) {
				//Se empate ou vencedor forem "true", o jogo est� encerrado
				this.setFimDeJogo(true);
			}
		} 
	}

	// O nome do m�todo foi modificado para que n�o fosse confundido com o o m�todo
	// "getJogadorAtual"
	private Jogador vezDeJogada() {		
		if (this.contador == 1) {
			this.contador++;
			return this.jogador1;
		} else {
			this.contador--;
			return this.jogador2;
		}
	}

	// Getters e setters
	public boolean getEmpate() {
		return empate;
	}

	public void setEmpate(boolean empate) {
		this.empate = empate;
	}

	// O print do tabuleiro foi retirado de "fazerJogada" para que possa ser chamado
	// separadamente na main
	public void getTabuleiro() {		
		this.tabuleiro.printaTabuleiro();
	}

	public Jogador getJogadorAtual() {
		return this.jogadorAtual;
	}

	// Visto que estamos trabalhando com exce��es, n�o h� mais a necessidade de uma 
	// condicional em "getJogada"
	public void getJogada() throws Exception{		
		System.out.println();
		System.out.println("Jogador " + jogadorAtual.getValorDoJogador() 
		+ " jogou na posicao " + this.posicaoX);
	}
	
	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

	public void setFimDeJogo(boolean fimDeJogo) {
		this.fimDeJogo = fimDeJogo;
	}

	public boolean getFimDeJogo() {
		return this.fimDeJogo;
	}

	public boolean getVencedor() {
		return this.vencedor;
	}
}
