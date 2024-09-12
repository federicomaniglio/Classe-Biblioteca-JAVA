import biblioteca.Biblioteca;
import biblioteca.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        while (true) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Aggiungi un nuovo libro");
            System.out.println("2. Cerca un libro per titolo");
            System.out.println("3. Visualizza tutti i libri disponibili");
            System.out.println("4. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consumare il newline
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il titolo del libro:");
                    String titolo = scanner.nextLine();
                    System.out.println("Inserisci l'autore del libro:");
                    String autore = scanner.nextLine();
                    System.out.println("Inserisci l'anno di pubblicazione:");
                    int anno = scanner.nextInt();
                    scanner.nextLine(); // Consumare il newline
                    biblioteca.aggiungiLibro(titolo, autore, anno);
                    System.out.println("Libro aggiunto con successo!");
                    break;

                case 2:
                    System.out.println("Inserisci il titolo del libro che vuoi cercare:");
                    String titoloRicerca = scanner.nextLine();
                    System.out.println(biblioteca.cercaLibro(titoloRicerca));
                    break;

                case 3:
                    System.out.println("Libri disponibili:");
                    System.out.println(biblioteca);
                    break;

                case 4:
                    System.out.println("Uscita dal programma.");
                    return;

                default:
                    System.out.println("Scelta non valida, riprova.");
                    break;
            }
        }

//
//        Biblioteca biblioteca = new Biblioteca();
//        biblioteca.aggiungiLibro("Hatty Protter","K.J. Rolling", 2021);
//        biblioteca.aggiungiLibro("Il signore degli Agnelli","Andrea Agnelli", 2013);
//        System.out.println(biblioteca);
//        System.out.println(biblioteca.cercaLibro("Hatty Proteter"));

    }
}