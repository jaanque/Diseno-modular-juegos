package DiseñoModularJuegos;

import java.util.Scanner;

public class colgado {

	public static void colgado(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("¡Bienvenidos al juego del Colgado!");

		// Solicito el número de jugadores
		System.out.print("¿Cuántos jugadores quieren jugar? (mínimo 2): ");
		int numJugadores = s.nextInt();
		s.nextLine();

		// Si no hay 2 jugadores salta este print
		if (numJugadores < 2) {
			System.out.println("Debe haber al menos 2 jugadores para jugar.");
			return;
		}

		// Solicito el nombres de los jugadores
		String[] jugadores = new String[numJugadores];
		int[] puntajes = new int[numJugadores];
		for (int i = 0; i < numJugadores; i++) {
			System.out.print("Introduce el nombre del jugador " + (i + 1) + ": ");
			jugadores[i] = s.nextLine();
		}

		// Solicito el número de rondas
		System.out.print("¿Cuántas rondas quieren jugar?: ");
		int numRondas = s.nextInt();
		s.nextLine();

		// Inicio las rondas
		for (int ronda = 1; ronda <= numRondas; ronda++) {
			System.out.println("\n--- Ronda " + ronda + " ---");

			// PIdo la palabra secreta
			System.out.print("Administrador, introduce la palabra secreta: ");
			String palabraSecreta = s.nextLine().toLowerCase();
			String palabraOculta = "_".repeat(palabraSecreta.length());

			// Ronda activa
			boolean palabraAdivinada = false;
			int[] intentosRestantes = new int[numJugadores];
			for (int i = 0; i < numJugadores; i++) {
				intentosRestantes[i] = 6;
			}

			// Bucle para iniciar la ronda
			while (!palabraAdivinada) {
				for (int i = 0; i < numJugadores; i++) {
					if (intentosRestantes[i] > 0) {
						System.out.println("\nTurno de " + jugadores[i]);
						System.out.println("Palabra: " + palabraOculta);
						System.out.println("Intentos restantes: " + intentosRestantes[i]);
						System.out.print("Introduce una letra: ");
						char letra = s.nextLine().toLowerCase().charAt(0);

						// Verifico si la letra está en la palabra
						boolean acierto = false;
						String nuevaPalabraOculta = "";
						for (int j = 0; j < palabraSecreta.length(); j++) {
							if (palabraSecreta.charAt(j) == letra) {
								nuevaPalabraOculta += letra;
								acierto = true;
							} else {
								nuevaPalabraOculta += palabraOculta.charAt(j);
							}
						}
						palabraOculta = nuevaPalabraOculta;

						if (acierto) {
							System.out.println("¡Correcto!");
						} else {
							System.out.println("¡Incorrecto!");
							intentosRestantes[i]--;
						}

						// Verifico si se adivinó la palabra
						if (palabraOculta.equals(palabraSecreta)) {
							System.out.println("¡" + jugadores[i] + " ha adivinado la palabra!");
							puntajes[i]++;
							palabraAdivinada = true;
							break;
						}
					}
				}

				// Verifico si todos se quedaron sin intentos
				boolean quedanIntentos = false;
				for (int intentos : intentosRestantes) {
					if (intentos > 0) {
						quedanIntentos = true;
						break;
					}
				}
				if (!quedanIntentos) {
					System.out.println("\nTodos se quedaron sin intentos.");
					System.out.println("La palabra secreta era: " + palabraSecreta);
					break;
				}
			}
		}

		// Muestro los resultados finales
		System.out.println("\n--- Resultados Finales ---");
		for (int i = 0; i < numJugadores; i++) {
			System.out.println(jugadores[i] + ": " + puntajes[i] + " rondas ganadas");
		}

		// Determino el ganador
		int maxPuntaje = 0;
		String ganador = "";
		for (int i = 0; i < numJugadores; i++) {
			if (puntajes[i] > maxPuntaje) {
				maxPuntaje = puntajes[i];
				ganador = jugadores[i];
			}
		}
		System.out.println("El ganador es: " + ganador);
		System.out.println("¡Gracias por jugar!");

		s.close();
	}
}
