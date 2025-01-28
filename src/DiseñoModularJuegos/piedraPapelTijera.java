package DiseñoModularJuegos;

// Importo el Scanner
import java.util.Scanner;

public class piedraPapelTijera {

	public static void piedraPapelTijera(String[] args) {
		// TODO Auto-generated method stub
		
		// Creo el Scanner
		Scanner scanner = new Scanner(System.in);
        
        // Utilizo un bucle para que los jugadores seleccionen lo que quieren tirar y puedan jugar otra ronda si quieren
        while (true) {
            System.out.println("Jugador 1, elige (Piedra, Papel, Tijeras, Lagarto, Spock):");
            String jugada1 = scanner.nextLine().trim();
            
            System.out.println("Jugador 2, elige (Piedra, Papel, Tijeras, Lagarto, Spock):");
            String jugada2 = scanner.nextLine().trim();
            
            
            if (jugada1.equalsIgnoreCase(jugada2)) {
                System.out.println("¡Empate!");
            } else if (ganador(jugada1, jugada2)) {
                System.out.println("Jugador 1 gana");
            } else {
                System.out.println("Jugador 2 gana");
            }
            
            System.out.println("¿Quieres jugar otra ronda? (si/no):");
            String respuesta = scanner.nextLine().trim();
            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }
        }
        System.out.println("¡Gracias por jugar!");
    }

    // Verifico si el jugador 1 gana
    public static boolean ganador(String jugada1, String jugada2) {
        return (jugada1.equalsIgnoreCase("Piedra") && (jugada2.equalsIgnoreCase("Lagarto") || jugada2.equalsIgnoreCase("Tijeras"))) ||
               (jugada1.equalsIgnoreCase("Papel") && (jugada2.equalsIgnoreCase("Piedra") || jugada2.equalsIgnoreCase("Spock"))) ||
               (jugada1.equalsIgnoreCase("Tijeras") && (jugada2.equalsIgnoreCase("Papel") || jugada2.equalsIgnoreCase("Lagarto"))) ||
               (jugada1.equalsIgnoreCase("Lagarto") && (jugada2.equalsIgnoreCase("Spock") || jugada2.equalsIgnoreCase("Papel"))) ||
               (jugada1.equalsIgnoreCase("Spock") && (jugada2.equalsIgnoreCase("Piedra") || jugada2.equalsIgnoreCase("Tijeras")));
    }
}