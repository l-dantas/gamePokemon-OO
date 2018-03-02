import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

		System.out.println("Carregando os competidores...");
		List<Pokemon> duelistas = new ArrayList<Pokemon>();
		duelistas.add(new PokemonAgua("Psyduck", 97, false));
		duelistas.add(new PokemonEletrico("Pikachu", 86, true));
		duelistas.add(new PokemonTerra("Dugtrio", 101, false));
		duelistas.add(new PokemonVoador("Pidgeot", 108, false));
		duelistas.add(new PokemonFogo("Vulpix", 81, false));
		duelistas.add(new PokemonGrama("Bubassauro", 92, true));

		System.out.println("\n** Duelo de Pokemons! **");
		System.out.println("\nPokemons dispon�veis: ");
	
		int cont = 0;
		for (Pokemon p : duelistas) {
			System.out.println("( " + cont + " ) " + p.toString());
			cont++;
		}
	
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEscolha o primeiro pokemon: ");
		Pokemon player1 = duelistas.get(sc.nextInt());
		System.out.print("Escolha o segundo pokemon: ");
		Pokemon player2 = duelistas.get(sc.nextInt());
	
		System.out.println("\nO duelo ir� come�ar com os seguintes duelistas: ");
		System.out.println(player1.getNome() + " x " + player2.getNome());
	
		double danoPlayer1, danoPlayer2;
	
		cont = 1;
		while ((player1.getHp() > 0) && (player2.getHp() > 0)) {
			System.out.println("Rodada #" + cont);
			// calculando o dano a ser dado por cada duelistas
			danoPlayer1 = player1.calcularDano(player2);
			danoPlayer2 = player2.calcularDano(player1);
	
			player2.receberAtaque(danoPlayer1);
			System.out.println(player1.getNome() + " ataca. Dano de " + danoPlayer1 + " em " + player2.getNome() + ".");		
			if (player2.getHp() <= 0) {
				// partida acabou e quem ganhou foi o player 1
				System.out.println("\nDuelo encerrado! O ganhador foi " + player1.getNome() + "!!" + " Life: " + player1.getHp());
				break;
			}
	
			player1.receberAtaque(danoPlayer2);
			System.out.println(player2.getNome() + " ataca. Dano de " + danoPlayer2 + " em " + player1.getNome());	
			if (player1.getHp() <= 0) {
				// partida acabou e quem ganhou foi o player 2
				System.out.println("\nDuelo encerrado! O ganhador foi " + player2.getNome() + "!!" + " Life: " + player2.getHp());
				break;
			}
			cont++;
		}
		
		
    }
}