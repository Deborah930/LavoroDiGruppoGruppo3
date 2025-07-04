
import java.util.ArrayList;



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
 class Utente {
    

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
        for(Risorsa risorsa : risorseInPrestito){
            String codice1 = r.getCodice();
            String codice2 = risorsa.getCodice();
            if(codice1.equals(codice2)){
                risorseInPrestito.remove(risorsa);
                break;
            }
        }
           
    }

    void stampaRisorse(){
        System.out.println("Le risorse in prestito di "+ this.nome +" sono: ");
        for(Risorsa r : risorseInPrestito){
            r.visualizzaDettagli(); 
        }
        
    }


}

 
//parte deborah
// classe Biblioteca
public class Biblioteca {
    // attributi
    private String nome;

    // Costruttore
    Biblioteca(String nome) {
        this.nome = nome;
    }

    ArrayList<Risorsa> prestito = new ArrayList<>();// arrayList di risorsa
    ArrayList<Utente> utenti = new ArrayList<>();// arrayList di utente

    // metodo per aggiungere una Risorsa all'arrayList prestito
    public void addRisorsa(Risorsa risorsa) {
        if (risorsa.equals(risorsa)) {
            prestito.add(risorsa);
        } else {
            System.out.println("Risorsa non presente.");
        }

    }

    // metodo per aggiungere un Utente all'arrayList utenti
    public void addUtenti(Utente utente)
    {
     if(utente.equals(utente))
     {
        utenti.add(utente);
     }else{
        System.out.println("Utente non presente.");
     }

    
    }

    // override del metodo visualizzaDettagli per visualizzare gli arrayList Risorsa
    // e Utente
 
     public void visualizzaDettagli()
    {
         for(Risorsa r : prestito)
         {
            r.visualizzaDettagli();
         }
         for(Utente u : utenti)
         {
            u.stampaRisorse();;
         }
    }

    // Ricerca risorse per titolo
    public void cercaRisorse(Risorsa risorsa) {
        for (Risorsa r : prestito)// foreach che ricerca una risorsa per titolo
        {
            if (risorsa.getTitolo().equals(r.getTitolo())) {
                System.out.println("Risorsa trovata: " + r.getTitolo());
            }
        }
    }
}
class main
{
    public static void main(String[] args) {
      Utente utente1  = new Utente("Luca", "Gd6798");
      
      Utente utente2 = new Utente("Paolo", "G6msi9");
      Libro libro= new Libro("Girasole", 2020, "676555", "A1");
      Rivista rivista=new Rivista("Cioè", 2015, "476", 20);
      Ebook ebook= new Ebook("Harry potter", 2000, "At768", "Digitale");
      utente1.inPrestito(libro);
      utente2.inPrestito(rivista);
      utente1.inPrestito(ebook);
      utente1.stampaRisorse();
      utente2.stampaRisorse();
      libro.visualizzaDettagli();
      rivista.visualizzaDettagli();
      ebook.visualizzaDettagli();
    }
}
