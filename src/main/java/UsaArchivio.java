
import java.util.List;
import java.util.Scanner;


public class UsaArchivio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Libri l1 = new Libri("fer785", "Moby dick", 2010, 320, "Luca", "Fnatascienza");
        Libri l2 = new Libri("gte587", "Harry Potter", 2002, 560, "J.K.Rowling", "Fnatascienza");
        Libri l3 = new Libri("fsa698", "Il codice da vinci", 1999, 450, "Dan Brown", "Thriller");
        Riviste r1 = new Riviste("dre456", "Undici", 2023, 60, Periodicità.MENSILE);
        Riviste r2 = new Riviste("hju213", "Giallo zafferano", 2021, 40, Periodicità.SETTIMANALE);
        Riviste r3 = new Riviste("pol563", "Forbes", 2024, 100, Periodicità.SEMESTRALE);

        Archivio libreria = new Archivio();

        libreria.nuovoElemento(l1);
        libreria.nuovoElemento(l2);
        libreria.nuovoElemento(l3);
        libreria.nuovoElemento(r1);
        libreria.nuovoElemento(r2);
        libreria.nuovoElemento(r3);

        int scelta;
        do {
            System.out.println("BENVENUTO NELL'ARCHIVIO. Seleziona un'operazione:");
            System.out.println("1. Visualizza l'archivio");
            System.out.println("2. Elimina un elemento");
            System.out.println("3. Cerca per ISBN (codice univoco)");
            System.out.println("4. Cerca per anno");
            System.out.println("5. Cerca per autore");
            System.out.println("6. Scrivi su file");
            System.out.println("7. Leggi da file");
            System.out.println("8. Esci");

            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 1:
                    System.out.println("***ARCHIVIO***");
                    System.out.println(libreria.report());
                    break;
                case 2:
                    System.out.print("Inserisci l'ISBN dell'elemento da eliminare: ");
                    String isbnToDelete = scanner.nextLine();
                    Editoria elementoRimosso = libreria.eliminaElemento(isbnToDelete);
                    if (elementoRimosso != null) {
                        System.out.println("Elemento con ISBN " + isbnToDelete + " rimosso con successo: ");
                        System.out.println(elementoRimosso.reportString());
                    } else {
                        System.out.println("ISBN non valido o elemento non trovato. Riprova.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Inserisci l'ISBN da cercare: ");
                    String isbnToSearch = scanner.nextLine();
                    Editoria x = libreria.cercaConIsbn(isbnToSearch);
                    if (x != null) {
                        System.out.println(x.reportString());
                    } else {
                        System.out.println("Nessun elemento trovato con l'ISBN specificato.");
                    }
                    break;
                case 4:
                    System.out.print("Inserisci l'anno da cercare: ");
                    int annoDaCercare = scanner.nextInt();
                    List<Editoria> p = libreria.ricercaPerAnno(annoDaCercare);
                    if (p.isEmpty()) {
                        System.out.println("Nessun libro trovato per l'anno: " + annoDaCercare);
                    } else {
                        p.stream().map(Editoria::reportString).forEach(System.out::println);
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Inserisci l'autore: ");
                    String autoreToSearch = scanner.nextLine();
                    List<Libri> p2 = libreria.ricercaPerAutore(autoreToSearch);
                    if (p2.isEmpty()){
                        System.out.println("Nessun libro trovato per l'autore: " + autoreToSearch);
                    }
                    else {
                        p2.stream().map(Editoria::reportString).forEach(System.out::println);
                    }
                    break;
                case 6:
                    libreria.scriviSuFile("./archivio.txt");
                    System.out.println();
                    break;
                case 7:
                    System.out.println("File");
                    libreria.leggiDaFile("./archivio.txt");
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Esci");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }while (scelta != 8);




        }

    }


