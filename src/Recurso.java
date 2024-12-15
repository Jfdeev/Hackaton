public class Recurso {
    private String nome;
    private int quantidade;

    public Recurso(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void monitorarRecurso(){
        System.out.println("Nome do recurso: " + this.nome);
        System.out.println("Quantidade do recurso: " + this.quantidade);
    }

    public void gastoRecurso(){
        setQuantidade(getQuantidade() - 1);
    }

    public void alertaAutomaticoDeRecursos(){
        if(getQuantidade() < 5){
            System.out.println("Alerta de recurso baixo: " + this.nome);
        }
    }
}
