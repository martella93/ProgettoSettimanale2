import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Archivio {
    private Map<String, Editoria> listaArchivio = new HashMap<>();

    public void nuovoElemento(Editoria elemento) {
        listaArchivio.put(elemento.getIsbn(), elemento);
    }
    public Editoria eliminaElemento(String isbn){
        return listaArchivio.remove(isbn);
    }
    public Editoria cercaConIsbn(String isbn) {
        return listaArchivio.get(isbn);
    }

    public List<Editoria> ricercaPerAnno (int anno){
        Collection<Editoria> x = listaArchivio.values();
        return x.stream().filter(p->p.getAnnoPubblicazione()==anno).collect(Collectors.toList());
    }
    public List<Libri> ricercaPerAutore (String autore){
        return listaArchivio.values().stream().filter(p->p.getClass()==Libri.class).
                map(p->(Libri)p).filter(p->p.getAutore().toLowerCase().equals(autore)).collect(Collectors.toList());
    }
    public void scriviSuFile(String percorsoFile) {
        try {
            File file = new File(percorsoFile);

            String reportString = listaArchivio.values().stream()
                    .map(Editoria::toString)
                    .collect(Collectors.joining("\n"));

            FileUtils.writeStringToFile(file, reportString, Charset.defaultCharset(), false);

            System.out.println("Scrittura nel file completata.");
        } catch (IOException e) {
            System.err.println("Impossibile scrivere nel file: " + e.getMessage());
        }
    }

    public void leggiDaFile(String percorsoFile) {
        try {
            File file = new File(percorsoFile);

            String str = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] prodottiStr =  str.split("#");

            Arrays.stream(prodottiStr).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Impossibile leggere il file: " + e.getMessage());
        }
    }

    String report() {
        return listaArchivio.values().stream().map(Editoria::reportString).collect(Collectors.joining());
    }




}
