package tabuleiro;

public class Tabuleiro {
	
	private final int x = 7;
	private final int y = 6;
	private int[][] tab = new int[x][y];
	// Matriz que servir� de tabuleiro
	private int ultimaJogadaY;
	// Atributo que permite armazenar a posi��o y da �ltima jogada para que a verifica��o
	// horizontal seja poss�vel
	

	public void jogada(int posicaoX, int valorDoJogador) {
		// "jogada" recebe uma posicao x e verifica se j� existe algum valor naquela
		// posi��o, se sim, a verifica��o vai para uma casa acima e � realizada
		// novamente at� todas as posi��es da coluna serem analisadas. Quando � 
		// encontrado um espa�o vazio, � atribuido o valor do jogador � posi��o e o la�o
		// � encerrado
		for (int y = this.y - 1; y >= 0;) {
			if (tab[posicaoX][y] == 0) {
				tab[posicaoX][y] = valorDoJogador;
				this.ultimaJogadaY = y;
				y = -1;
			} else
				y--;
		}
	}

	// O m�todo "printaTabuleiro" printa o tabuleiro e o indicador de posi��es acima dele
	public void printaTabuleiro() {
		for (int y = -1; y < this.y; y++) {
			for (int x = 0; x < this.x; x++) {
				if (y == -1) {
					System.out.print("(" + x + ")");
				} else
					System.out.print("|" + tab[x][y] + "|");
			}
			System.out.println();
		}
	}

	// O m�todo "posicaoValida" analisa se a posi��o inserida pelo jogador est�
	// entre 0 e 6, e se a coluna da posi��o inserida ja est� completa, retornando uma 
	// exce��o caso contr�rio
	public int checaPosicaoX(int posicaoX) throws Exception {
		if (posicaoX >= 0 && posicaoX < this.x && tab[posicaoX][this.y - this.y] == 0) {
			return posicaoX;
		} else {
			throw new Exception();
		}
	}
	
	// O m�todo checa empate analisa se todos as sete casas da linha do topo da matriz
	// est�o ocupadas, se sim � um empate.
	public boolean checaEmpate() {
		int contador = 0;
		for(int i = 0; i < this.x; i++) {
			if(tab[i][0] != 0) {
				contador++;
			}else contador = 0;
		}
		if(contador == 7) {
			return true;
		}else return false;
	}

	public boolean checaVitoria(int posicaoX, int valorDoJogador) {
		int contador = 0;
		// Checagem horizontal:
		for (int i = 0; i < this.x; i++) {
			if(tab[i][this.ultimaJogadaY] == valorDoJogador) {
				contador++;
			}else {
				contador = 0;
			}
			if(contador >= 4) {
				return true;
			}
		}
		// Checagem vertical:
		for (int i = 0; i < this.y; i++) {
			if(tab[posicaoX][i] == valorDoJogador) {
				contador++;
			}else {
				contador = 0;
			}
			if(contador >= 4) {
				return true;
			}
		}
		// Esq - Dir: Linha Inferior 
		for(int linhaInic = 0, colunaFinal = 5; linhaInic <= 2 && colunaFinal >= 3;
				linhaInic++, colunaFinal--) {
			for(int linha = linhaInic, coluna = 0; linha <= 5 && coluna <= colunaFinal; 
					linha++, coluna++) {
				if(tab[coluna][linha] == valorDoJogador) {
					contador++;
				}else contador = 0;	
				if(contador >= 4){
				return true;
			    }
			}
		}
		// Esq - Dir: Linha Superior
		for(int colunaInic = 1, linhaFinal = 5; colunaInic <= 3 && linhaFinal >= 3;
				colunaInic++, linhaFinal--) {
			for(int coluna = colunaInic, linha = 0; coluna <= 6 && linha <= linhaFinal;
					coluna++, linha++) {
				if(tab[coluna][linha] == valorDoJogador) {
					contador++;
				}else contador = 0;
				if(contador >= 4) {
					return true;
				}
			}
		}
		// Dir - Esq: Linha Inferior
		for(int linhaInic = 0, colunaFinal = 1; linhaInic <= 2 && colunaFinal <= 3;
				linhaInic++, colunaFinal++) {
			for(int linha = linhaInic, coluna = 6; linha <= 5 && coluna >= colunaFinal;
					linha++, coluna--) {
				if(tab[coluna][linha] == valorDoJogador) {
					contador++;
				}else contador = 0;
				if(contador >= 4) {
					return true;
				}
			}
		}
		// Dir - Esq: Linha Superior
		for(int linhaFinal = 5, colunaInic = 5; linhaFinal >= 3 && colunaInic >= 3;
				linhaFinal--, colunaInic--) {
			for(int linha = 0, coluna = colunaInic; linha <= linhaFinal && coluna >= 0;
					linha++, coluna--) {
				if(tab[coluna][linha] == valorDoJogador) {
					contador++;
				}else contador = 0;
				if(contador >= 4) {
					return true;
				}
			}
		}
		return false;
	}
}
