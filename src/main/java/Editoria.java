public abstract class Editoria {
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;


    public Editoria(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String reportString() {
        if (this instanceof Libri) {
            Libri libro = (Libri) this;
            return String.format("ISBN: %s, Titolo: %s, Autore: %s, Anno di pubblicazione: %d, Numero di pagine: %d, Genere: %s%n",
                    isbn, titolo, libro.getAutore(), libro.getAnnoPubblicazione(), libro.getNumeroPagine(), this.getClass().getSimpleName());
        } else if (this instanceof Riviste) {
            Riviste rivista = (Riviste) this;
            return String.format("ISBN: %s, Titolo: %s, Periodicità: %s, Anno di pubblicazione: %d, Numero di pagine: %d, Genere: %s%n",
                    isbn, titolo, rivista.getPeriodicita(), rivista.getAnnoPubblicazione(), rivista.getNumeroPagine(), this.getClass().getSimpleName());
        }
        return "";

    }
}
