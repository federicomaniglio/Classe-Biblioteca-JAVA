package biblioteca;

public class Libro {
    private String titolo;
    private String autore;
    private int annoPubblicazione;

    public Libro(){
        this.titolo = "How to master JAVA";
        this.autore = "Federico Maniglio";
        this.annoPubblicazione = 2024;
    }

    public Libro(String titolo, String autore, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String toString(){
        return "Titolo: " + titolo + "\n" + "Autore: " + autore + "\n" + "Anno di pubblicazione: " +annoPubblicazione + "\n";
    }
}
