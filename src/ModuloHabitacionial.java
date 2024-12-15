import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ModuloHabitacionial {
    private String identificacao;
    private String localizacao;
    private int capacidade;
    private int capMaxima;
    private String finalidade;
    private ArrayList<Recurso> recursos = new ArrayList<>();
    private ArrayList<Habitante> habitantes = new ArrayList<>();
    private ArrayList<ProjetosDePesquisa> projetos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
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
    

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(ArrayList<Recurso> recursos) {
        this.recursos = recursos;
    }

    public ArrayList<ProjetosDePesquisa> getProjetos() {
        return projetos;
    }

    public void setProjetos(ArrayList<ProjetosDePesquisa> projetos) {
        this.projetos = projetos;
    }

    public boolean verificarCapacidadeMaxima(){
        return this.capacidade >= this.capMaxima;
    }

    public void cadastrarModulo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDigite a identificacao do modulo: ");
        this.identificacao = sc.nextLine();
        System.out.println("\nDigite a localizacao do modulo: ");
        this.localizacao = sc.nextLine();
        System.out.println("\nDigite a capacidade maxima do modulo: ");
        this.capMaxima = sc.nextInt();
        System.out.println("\nDigite a finalidade do modulo: ");
        this.finalidade = sc.nextLine();

    }
    
    public void mostrarModulosPorTipo(){
        System.out.println("Digite o tipo de modulo que deseja visualizar: ");
        System.out.println("1 - Habitacional");
        System.out.println("2 - Armazenamento");
        System.out.println("3 - Laboratorial");
        String tipo = sc.nextLine();
        if("Habitacional".equals(tipo)){
            System.out.println("\nIdentificacao: " + this.identificacao);
            System.out.println("\nLocalizacao: " + this.localizacao);
            System.out.println("\nCapacidade: " + this.capacidade);
            System.out.println("\nCapacidade maxima: " + this.capMaxima);
            System.out.println("\nFinalidade: " + this.finalidade);
        
       } else if("Armazenamento".equals(tipo)){
            System.out.println("\nIdentificacao: " + this.identificacao);
            System.out.println("\nLocalizacao: " + this.localizacao);
            System.out.println("\nCapacidade: " + this.capacidade);
            System.out.println("\nCapacidade maxima: " + this.capMaxima);
            System.out.println("\nFinalidade: " + this.finalidade);
        }   else if("Laboratorial".equals(tipo)){
            System.out.println("\nIdentificacao: " + this.identificacao);
            System.out.println("\nLocalizacao: " + this.localizacao);
            System.out.println("\nCapacidade: " + this.capacidade);
            System.out.println("\nCapacidade maxima: " + this.capMaxima);
            System.out.println("\nFinalidade: " + this.finalidade);
        } else {
            System.out.println("\nTipo de modulo invalido!");
        }
    }

    public void cadastrarHabitante(){
        System.out.println("\nDigite a indentificação do modulo para o habitante: ");
        String identificacao = sc.nextLine();
        if(this.identificacao.equals(identificacao) && verificarCapacidadeMaxima() == false){
            System.out.println("\nDigite o nome do habitante: ");
            String nome = sc.nextLine();
            System.out.println("\nDigite a idade do habitante: ");
            int idade = sc.nextInt();
            System.out.println("\nDigite a funcao do habitante: ");
            String funcao = sc.nextLine();
            System.out.println("\nDigite a especialidade do habitante: ");
            String especialidade = sc.nextLine();
            Habitante habitante = new Habitante(especialidade, funcao, nome, idade);
            this.habitantes.add(habitante);
        } else {
            System.out.println("\nModulo nao encontrado!");
        }
    }

    public void cadastrarRecurso(){
        System.out.println("\nDigite a indentificação do modulo para o recurso: ");
        String identificacao = sc.nextLine();
        if(this.identificacao.equals(identificacao)){
            System.out.println("\nDigite o nome do recurso: ");
            String nome = sc.nextLine();
            System.out.println("\nDigite a quantidade do recurso: ");
            int quantidade = sc.nextInt();
            Recurso recurso = new Recurso(nome, quantidade);
            recursos.add(recurso);
        } else {
            System.out.println("\nModulo nao encontrado!");
        }
    }

    public void cadastrarProjetoPesquisa(){
        System.out.println("\nDigite a indentificação do modulo para o projeto de pesquisa: ");
        String identificacao = sc.nextLine();
        if(this.identificacao.equals(identificacao) && finalidade.equals("Laboratorial")){
            System.out.println("\nDigite o titulo do projeto: ");
            String titulo = sc.nextLine();
            System.out.println("\nDigite a equipe responsavel pelo projeto: ");
            String equipeResponsavel = sc.nextLine();
            System.out.println("\nDigite a duracao estimada do projeto: ");
            double duracaoEstimada = sc.nextDouble();
            System.out.println("\nDigite os requisitos de equipamentos do projeto: ");
            String requisitosDeEquipamentos = sc.nextLine();
            System.out.println("\nDigite o status do projeto: ");
            String status = sc.nextLine();
            ProjetosDePesquisa projeto = new ProjetosDePesquisa(titulo, equipeResponsavel, duracaoEstimada, requisitosDeEquipamentos, status);
            projetos.add(projeto);
        } else {
            System.out.println("\nModulo Laboratorial nao encontrado!");
        }
    }

}
