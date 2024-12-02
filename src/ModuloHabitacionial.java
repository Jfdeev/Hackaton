import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ModuloHabitacionial {
    private String identificacao;
    private String localizacao;
    private int capacidade;
    private int capMaxima;
    private String finalidade;
    private ArrayList<Habitante> habitantes = new ArrayList<>();
    private Recurso agua = new Recurso();
    private Recurso oxigenio = new Recurso();
    private Recurso comida = new Recurso();
    private Recurso energia = new Recurso();
    private ProjetosDePesquisa pesquisa = new ProjetosDePesquisa();
    
    public ModuloHabitacionial(String identificacao, String localizacao, int capMaxima, String finalidade) {
        this.identificacao = identificacao;
        this.localizacao = localizacao;
        this.capMaxima = capMaxima;
        this.finalidade = finalidade;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(int capMaxima) {
        this.capMaxima = capMaxima;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public ArrayList<Habitante> getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(ArrayList<Habitante> habitantes) {
        this.habitantes = habitantes;
    }

    public Recurso getAgua() {
        return agua;
    }

    public void setAgua(Recurso agua) {
        this.agua = agua;
    }

    public Recurso getOxigenio() {
        return oxigenio;
    }

    public void setOxigenio(Recurso oxigenio) {
        this.oxigenio = oxigenio;
    }

    public Recurso getComida() {
        return comida;
    }

    public void setComida(Recurso comida) {
        this.comida = comida;
    }

    public Recurso getEnergia() {
        return energia;
    }

    public void setEnergia(Recurso energia) {
        this.energia = energia;
    }

    public ProjetosDePesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(ProjetosDePesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    public boolean verificarCapacidadeMaxima(){
        return this.capacidade >= this.capMaxima;
    }

    public void monitorarRecursos(){
        if ("Armazenamento".equals(getFinalidade())) {
            System.out.println("\nIdentificacao: " + this.identificacao);
    
            if(this.agua.getQuantidade() == -1){
                System.out.println("\nO recurso agua nao foi cadastrado no modulo: " + this.identificacao);
            }else{
                System.out.println("\nAgua: " + this.agua.getQuantidade() + " litros");
            }
            if(this.oxigenio.getQuantidade() == -1){
                System.out.println("\nO recurso oxigenio nao foi cadastrado no modulo: " + this.identificacao);
            }else{
                System.out.println("\nOxigenio: " + this.oxigenio.getQuantidade() + " litros");
            }
            if(this.oxigenio.getQuantidade() == -1){
                System.out.println("\nO recurso energia nao foi cadastrado no modulo: " + this.identificacao);
            }else{
                System.out.println("\nEnergia: " + this.energia.getQuantidade() + "%");
            }
            if(this.comida.getQuantidade() == -1){
                System.out.println("\nO recurso comida nao foi cadastrado no modulo: " + this.identificacao);
            }else{
                System.out.println("\nComida: " + this.comida.getQuantidade() + " latas de diferentes tipos de alimento");
            }   
            
        }
    }

    public void alertaRecursos(){
        if(this.agua != null && "Armazem".equals(this.finalidade)){
            if(this.agua.getQuantidade() <= 20 && this.agua.getQuantidade() >= 0){
                System.out.println("\nA agua do modulo " + this.identificacao + " esta em um nivel critico de quantidade!");
            }
        }
        if(this.oxigenio != null && "Armazem".equals(this.finalidade)){
            if(this.oxigenio.getQuantidade() <= 20 && this.oxigenio.getQuantidade() >= 0){
                System.out.println("\nO oxigenio do modulo " +  this.identificacao + " esta em um nivel critico de quantidade!");
            }
        }
        if(this.comida != null && "Armazem".equals(this.finalidade)){ 
            if(this.comida.getQuantidade() <= 20 &&  this.comida.getQuantidade() >= 0){
                System.out.println("\nA comida do modulo " +  this.identificacao + " esta em um nivel critico de quantidade!");
            }
        }
        if(this.energia != null && "Armazem".equals(this.finalidade)){
            if(this.energia.getQuantidade() <= 20 && this.energia.getQuantidade() >= 0){
                System.out.println("\nA energia do modulo " +  this.identificacao + " em um nivel critico de quantidade!");
            }
        } 
    }

    public void gastoDeRecursos(){
        getAgua().setQuantidade(getAgua().getQuantidade() - getCapacidade());
        getOxigenio().setQuantidade(getOxigenio().getQuantidade() - getCapacidade());
        getComida().setQuantidade(getComida().getQuantidade() - getCapacidade());
        getEnergia().setQuantidade(getEnergia().getQuantidade() - getCapacidade());
    }

    public void abastecerModulos(ModuloHabitacionial modulo, ModuloHabitacionial modulo2){
        modulo2.getAgua().setQuantidade(modulo.getAgua().getQuantidade());
        modulo2.getOxigenio().setQuantidade(modulo.getOxigenio().getQuantidade());
        modulo2.getComida().setQuantidade(modulo.getComida().getQuantidade());
        modulo2.getEnergia().setQuantidade(modulo.getEnergia().getQuantidade());
        modulo.getAgua().setQuantidade(0);
        modulo.getOxigenio().setQuantidade(0);
        modulo.getComida().setQuantidade(0);
        modulo.getEnergia().setQuantidade(0);
    }
}
