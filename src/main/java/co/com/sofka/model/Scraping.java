package co.com.sofka.model;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Scraping {
    public static final String url = "https://www.grupobancolombia.com/personas/tarjetas-de-credito/";

    public static void main(String args[]) {

        if (getStatusConnectionCode(url) == 200) {

            Document document = getHtmlDocument(url);


            Elements entradas = document.select("div.col-md-4.col-xs-12").not("div.col-md-offset-2.col-md-4.col-xs-12");
            System.out.println("Número de entradas en la página inicial de Jarroba: " + entradas.size() + "\n");

            // Paseo cada una de las entradas
            for (Element elem : entradas) {
                String titulo = elem.getElementsByClass("tituloPost").text();
                String autor = elem.getElementsByClass("autor").toString();
                String fecha = elem.getElementsByClass("fecha").text();

                System.out.println(titulo + "\n" + autor + "\n" + fecha + "\n\n");

                // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
                // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
            }

        } else
            System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(url));
    }

    public static Document getHtmlDocument(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }
        return doc;
    }

    public static int getStatusConnectionCode(String url) {

        Connection.Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Chrome").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }
}
