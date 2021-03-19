package jogador;

public abstract class Pessoa {
	
	    // Classe foi considerada abstract, j� que n�o precisou ser instanciada em nenhum 
		// momento no c�digo
		
		protected final String nome;

		public Pessoa(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "O nome do jogador � " + this.nome;
		}

		public String getNome() {
			return nome;
		}
}
