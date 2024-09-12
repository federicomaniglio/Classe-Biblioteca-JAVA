package biblioteca;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BibliotecaTest {

    @Test
    void testRicerca() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.aggiungiLibro("Ciao", "Bello", 54);
        Assertions.assertEquals("Libro presente:\n" +"Titolo: " + "Ciao" + "\n" + "Autore: " + "Bello" + "\n" + "Anno di pubblicazione: " +"54" + "\n", biblioteca.cercaLibro("Ciao"));

    }
  
}