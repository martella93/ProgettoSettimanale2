public class Riviste extends Editoria {

    private Periodicità periodicita;

    public Riviste(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicità getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicità periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista: " + getTitolo() + " (ISBN: " + getIsbn() + "), Anno di pubblicazione: " + getAnnoPubblicazione() + ", Numero di pagine: " + getNumeroPagine() + ", Periodicità: " + getPeriodicita();
    }
}
