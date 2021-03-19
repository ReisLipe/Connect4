package jogador;

public class Jogador extends Pessoa {
	
	private int valorDoJogador;

	public Jogador(String nome, int valorDoJogador) {
		super(nome);
		this.setValorDoJogador(valorDoJogador);
	}

	@Override
	public String toString() {
		return "(" + valorDoJogador + ")" + super.toString();
	}

	// Getters e setters
	public void setValorDoJogador(int valorDoJogador) {
		this.valorDoJogador = valorDoJogador;
	}

	public int getValorDoJogador() {
		return this.valorDoJogador;
	}
}
