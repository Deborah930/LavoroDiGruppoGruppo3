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
        if(risorseInPrestito.contain(r)){
            int posizione = risorseInPrestito.indexOf(r);
            risorseInPrestito.remove(posizione);
        }else{
            System.out.println("Risorsa non trovata");
        }
        
    }

    String stampaRisorse(){
        String messaggio = new String();
        for(Risorsa r : risorseInPrestito){
            messaggio+r.visualizzadettagli(); 
        }
        return messaggio;
    }


    public String toString (){
        String messaggio = new String();
        messaggio= messaggio+"Il nome dell'utente è: "+this.nome; 
        messaggio = messaggio+"L'id utente è: "+ this.idUtente;
        messaggio = messaggio+"La lista delle risorse prese in prestito è: "; 
        for(Risorsa r : risorseInPrestito){
            messaggio= messaggio +r.visualizzadettagli(); 
        }
        return messaggio;
    }

}
