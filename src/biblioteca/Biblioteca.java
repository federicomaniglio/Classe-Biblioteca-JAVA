package biblioteca;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> listaLibri = new ArrayList();

    public void aggiungiLibro(String titolo, String autore, int annoPubblicazione) {
        listaLibri.add(new Libro(titolo, autore, annoPubblicazione));
    }

    public String cercaLibro(String titolo) {

        for (Libro libro : listaLibri) {
            if (libro.getTitolo().equals(titolo))
                return "Libro presente:\n" + libro;
        }
        return "Libro non presente\n";
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Libro libro : listaLibri) {
            res.append(libro.toString()).append("\n");
        }
        return res.toString();
    }

    public String cercaLibroOnline(String titoloRicercaOnline) {

        titoloRicercaOnline = titoloRicercaOnline.replace(" ", "-");
        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + titoloRicercaOnline;
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNext()) {
                result.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject jsonObject = new JSONObject(result.toString());
            JSONArray items = jsonObject.getJSONArray("items");

            StringBuilder bookDetails = new StringBuilder();
            for (int i = 0; i < items.length(); i++) {
                JSONObject volumeInfo = items.getJSONObject(i).getJSONObject("volumeInfo");
                String titolo = volumeInfo.optString("title", "Titolo non disponibile");
                String autore = volumeInfo.has("authors") ? volumeInfo.getJSONArray("authors").join(", ") : "Autore non disponibile";
                String annoPubblicazione = volumeInfo.optString("publishedDate", "Anno di pubblicazione non disponibile");

                bookDetails.append("Titolo: ").append(titolo)
                        .append("\nAutore: ").append(autore)
                        .append("\nAnno di pubblicazione: ").append(annoPubblicazione)
                        .append("\n\n");
            }
            return bookDetails.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Errore durante la ricerca del libro online.";
        } catch (JSONException e) {
            e.printStackTrace();
            return "Errore durante la parsificazione del JSON.";
        }
    }
    

}
