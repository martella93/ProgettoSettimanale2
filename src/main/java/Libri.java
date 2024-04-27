public class Libri extends Editoria{

    private String autore;
    private String genere;


    public Libri(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro: " + getTitolo() + " (ISBN: " + getIsbn() + "), Anno di pubblicazione: " + getAnnoPubblicazione() + ", Numero di pagine: " + getNumeroPagine() + ", Autore: " + getAutore() + ", Genere: " + getGenere();
    }
}


