// Añado el package
package DiseñoModularJuegos;

// Importo el Scanner para que el usuario pueda escoger la opcion del menu
import java.util.Scanner;

public class DiseñoModularJuegos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creo la variable per a triar una opcio del menu
        int opcion;

        do {
            System.out.println("====== Menú Principal ======");
            System.out.println("1. Jugar al Colgado");
            System.out.println("2. Jugar a Piedra, Papel, Tijera, Lagarto, Spock");
            System.out.println("3. Jugar al Tres en Raya");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            // Guardo la opcio triada
            opcion = scanner.nextInt();

            // Amb el switch, segons el valor de "opcion" truco una funcio o una altra i l'executo
            switch (opcion) {
                case 1:
                	colgado colgado = new colgado();
                    colgado.colgado(args);
                    break;
                case 2:
                	piedraPapelTijera piedraPapelTijera = new piedraPapelTijera();
                	piedraPapelTijera.piedraPapelTijera(args);
                    break;
                case 3:
                	tresEnRaya tresenraya = new tresEnRaya(); 
                    tresEnRaya.tresenraya(args);
                    break;
                case 4:
                    System.out.println("¡Gracias por jugar! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
            }
        }
        // repeteixo el menu fins que el usuari escolleixi la opcio 4 per sortir
        while (opcion != 4); 
        scanner.close();
    }
}
