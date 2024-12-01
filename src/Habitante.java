public class Habitante {
    private String nome;
    private int idade;
    private String funcao;
    private String especialidade;
    
    public Habitante(String especialidade, String funcao, String nome, int idade) {
        this.especialidade = especialidade;
        this.funcao = funcao;
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
     
    
    

}
