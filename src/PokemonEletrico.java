
public class PokemonEletrico extends Pokemon{
	
	private String tipo;
	private double danoInicial, danoExtra;
	
	//Método construtor
	public PokemonEletrico(String nome, double hp, boolean ehEvolucao) {
		super(nome, hp, ehEvolucao);
		this.tipo = "Eletrico";
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
		if(tipoAdversario.getTipo() == "Voador") {
			return this.getDanoInicial() + (this.getDanoInicial() * 0.5 ) ; 
		} else if(tipoAdversario.getTipo() == "Agua"){
			return this.getDanoInicial() + (this.getDanoInicial() * 0.2 ) ; 
		} else if(tipoAdversario.getTipo() == "Terra"){
			return this.getDanoInicial() - (this.getDanoInicial() * 0.5 ) ; 
		}
		return this.getDanoInicial();
	}
	
	public String getTipo() {
		return this.tipo;
	}

}
