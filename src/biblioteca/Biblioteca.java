package biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> listaLibri = new ArrayList();

    public void aggiungiLibro(String titolo, String autore, int annoPubblicazione){
        listaLibri.add(new Libro(titolo, autore, annoPubblicazione));
    }

    public String cercaLibro(String titolo){

        for (Libro libro : listaLibri) {
            if(libro.getTitolo().equals(titolo))
                return "Libro presente:\n" + libro;
        }
        return "Libro non presente\n";
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Libro libro : listaLibri) {
            res.append(libro.toString()).append("\n");
        }
        return res.toString();
    }

}
