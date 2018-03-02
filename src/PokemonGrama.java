
public class PokemonGrama extends Pokemon {

	private String tipo;
	private double danoInicial, danoExtra;
	
	//Método construtor
	public PokemonGrama(String nome, double hp, boolean ehEvolucao) {
		super(nome, hp, ehEvolucao);
		this.tipo = "Grama";
		this.danoInicial = danoPokemon(this.getTipo());
		calcularDanoExtra(this.getEhEvolucao(), this.getTipo());
		this.danoExtra = this.getDanoExtra();
	}
	
	@Override
	public double getDanoInicial() {
		return this.danoInicial + (this.danoInicial * this.danoExtra);
	}
	
	//Métodos da class Pokemon
	public double calcularDano(Pokemon tipoAdversario) {
		if(tipoAdversario.getTipo() == "Agua"){
			return this.getDanoInicial() + (this.getDanoInicial() * 0.5 ) ; 
		} else if(tipoAdversario.getTipo() == "Fogo"){
			return this.getDanoInicial() - (this.getDanoInicial() * 0.5 ) ; 
		} else if(tipoAdversario.getTipo() == "Voador"){
			return this.getDanoInicial() - (this.getDanoInicial() * 0.5 ) ; 
		}
		return this.getDanoInicial();
	}
	
	public String getTipo() {
		return this.tipo;
	}
}
