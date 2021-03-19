package jogador;

public abstract class Pessoa {
	
	    // Classe foi considerada abstract, já que não precisou ser instanciada em nenhum 
		// momento no código
		
		protected final String nome;

		public Pessoa(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "O nome do jogador é " + this.nome;
		}

		public String getNome() {
			return nome;
		}
}
