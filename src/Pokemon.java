
public abstract class Pokemon implements IEvolucao {
	
	protected String nome;
	private double hp, dano = 0;
	private boolean ehEvolucao;
	
	public Pokemon(String nome, double hp, boolean ehEvolucao) {
		this.nome = nome;
		this.hp = hp;
		this.ehEvolucao = ehEvolucao;
	}
	
	public void receberAtaque(double dano) {
		this.hp -= dano;
	}
	//GETs
	public String getNome() {
		return this.nome;
	}
	public double getHp() {
		return this.hp;
	}
	public boolean getEhEvolucao() {
		return this.ehEvolucao;
	}
	
	public double danoPokemon(String tipoPokemon) {
		if(tipoPokemon == "Agua" || tipoPokemon == "Eletrico" || tipoPokemon == "Terra") {
			return 10;
		} 
		return 12;
	}
	
	//Método da class Object;
	@Override
	public String toString() {
		return "Nome: " + this.nome + " Life: " + this.hp + "HP " + "Tipo: " + this.getTipo() + " Evoluido: " + this.getEhEvolucao();
	}
	//Método da Interface IEvolucao;
	@Override
	public void calcularDanoExtra(boolean ehEvolucao, String pokemonTipo ) {
		if(ehEvolucao) { 
			if(pokemonTipo == "Eletrico" || pokemonTipo == "Terra" || pokemonTipo == "Voador") {
				this.dano = 0.3;
			} else if(pokemonTipo == "Fogo" || pokemonTipo == "Agua" || pokemonTipo == "Grama") {
				this.dano = 0.5;
			}
		} 
	}
	
	public double getDanoExtra() {
		return this.dano;
	}
	
	//Method Abstracts
	public abstract double calcularDano(Pokemon tipoAdversario);
	public abstract String getTipo();
	public abstract double getDanoInicial();
	
}
