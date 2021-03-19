package tabuleiro;

public class Tabuleiro {
	
	private final int x = 7;
	private final int y = 6;
	private int[][] tab = new int[x][y];
	// Matriz que servirá de tabuleiro
	private int ultimaJogadaY;
	// Atributo que permite armazenar a posição y da última jogada para que a verificação
	// horizontal seja possível
	

	public void jogada(int posicaoX, int valorDoJogador) {
		// "jogada" recebe uma posicao x e verifica se já existe algum valor naquela
		// posição, se sim, a verificação vai para uma casa acima e é realizada
		// novamente até todas as posições da coluna serem analisadas. Quando é 
		// encontrado um espaço vazio, é atribuido o valor do jogador à posição e o laço
		// é encerrado
		for (int y = this.y - 1; y >= 0;) {
			if (tab[posicaoX][y] == 0) {
				tab[posicaoX][y] = valorDoJogador;
				this.ultimaJogadaY = y;
				y = -1;
			} else
				y--;
		}
	}

	// O método "printaTabuleiro" printa o tabuleiro e o indicador de posições acima dele
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

	// O método "posicaoValida" analisa se a posição inserida pelo jogador está
	// entre 0 e 6, e se a coluna da posição inserida ja está completa, retornando uma 
	// exceção caso contrário
	public int checaPosicaoX(int posicaoX) throws Exception {
		if (posicaoX >= 0 && posicaoX < this.x && tab[posicaoX][this.y - this.y] == 0) {
			return posicaoX;
		} else {
			throw new Exception();
		}
	}
	
	// O método checa empate analisa se todos as sete casas da linha do topo da matriz
	// estão ocupadas, se sim é um empate.
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
