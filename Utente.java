import java.util.ArrayList;


public class Utente {
    public static void main(String[] args) {
        
    }

    private String nome;
    private String idUtente;
    //attributi della classe

    Utente(String nome, String idUtente ){
        this.nome = nome;
        this.idUtente = idUtente;
        this.risorseInPrestito = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    ArrayList<Risorsa> risorseInPrestito;
    //lista delle risorse in prestito
    
    void inPrestito(Risorsa r){
        risorseInPrestito.add(r);
    }

    void restituzione(Risorsa r){
        boolean trovato;
        for(Risorsa risorsa : risorseInPrestito)
            if(r.codice.equals(risorsa.codice)){
                risorseInPrisorseInPrestito.
                risorseInPrisorseInPrestito.delete(risorseInPrestito.In)
            }
        if(risorseInPrestito.contains(r)){
            int posizione = risorseInPrestito.indexOf(r);
            risorseInPrestito.remove(posizione);
        }else{
            System.out.println("Risorsa non trovata");
        }
        
    }

    void stampaRisorse(){
        System.out.println("Le risorse in prestito di "+ this.nome +" sono: ");
        for(Risorsa r : risorseInPrestito){
            r.visualizzaDettagli(); 
        }
        
    }


}

 class Risorsa{
    private String titolo;
    private int annoPubblicazione;
    private String codice;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        if(!this.codice.equals(codice)){
        this.codice = codice;
        }
        else{
            System.out.println("codice già esistente");
        }
    }
    
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    Risorsa(String titolo, int annoPubblicazione, String codice){
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.codice = codice;
    }

    public void visualizzaDettagli(){
        System.out.println("Titolo " + titolo + "anno pubblicazione: " + annoPubblicazione + " codice: " + codice);
    }
}

class Libro extends Risorsa{

    private String autore;
    
    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    Libro(String titolo, int annoPubblicazione, String codice, String autore){
        super(titolo, annoPubblicazione, codice);
        this.autore = autore;
    }

    @Override
     public void visualizzaDettagli(){
        System.out.println("Titolo " + getTitolo() + "anno pubblicazione: " + getAnnoPubblicazione() + " codice: " + getCodice() + " Autore " + getAutore());
    }


}

class Rivista extends Risorsa{

    private int numero;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    Rivista(String titolo, int annoPubblicazione, String codice, int numero){
        super(titolo, annoPubblicazione, codice);
        this.numero = numero;
    }

    @Override
     public void visualizzaDettagli(){
        System.out.println("Titolo " + getTitolo() + "anno pubblicazione: " + getAnnoPubblicazione() + " codice: " + getCodice() + " Numero della rivista " + getNumero());
    }


}

class Ebook extends Risorsa{

    String formato;
    
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    Ebook(String titolo, int annoPubblicazione, String codice, String formato){
        super(titolo, annoPubblicazione, codice);
        this.formato = formato;
    }

    @Override
     public void visualizzaDettagli(){
        System.out.println("Titolo " + getTitolo() + "anno pubblicazione: " + getAnnoPubblicazione() + " codice: " + getCodice() + " Formato "  + getFormato());
    }


}