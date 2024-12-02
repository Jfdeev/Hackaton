import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<ModuloHabitacionial> modulos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String escolha;
        String identificacao;
        boolean moduloCadastrado;
        boolean finalidadeCoerente;

        do {
            System.out.println("\n1 - Cadastrar Modulo\n2 - Cadastrar Habitante\n3 - Cadastrar Recurso\n4 - Cadastrar Projeto de Pesquisa\n5 - Visualizar Modulo por Tipo\n6 - Consultar Status de Pesquisa\n7 - Nivel Atual de Recurso\n8 - Visualizar habitantes por modulo\n9 - Exportar Arquivo Txt\n10- - Abastecer Modulos\n11 - Sair");
            escolha = sc.nextLine();

            if("1".equals(escolha)){
                boolean moduloExiste = false;

                System.out.println("\nIdentificaco do Modulo: ");
                identificacao = sc.nextLine();

                for(ModuloHabitacionial modulo : modulos){
                    if(modulo.getIdentificacao().equals(identificacao)){
                        System.out.println("\nEsse modulo ja foi cadastrado!");
                        moduloExiste = true;
                    }
                }

                if(moduloExiste == false){
                    System.out.println("\nLocalizacao: ");
                    String localizacao = sc.nextLine();

                    System.out.println("\nCapacidade maxima: ");

                    if(sc.hasNextInt()){
                        int capMaxima = sc.nextInt();
                        sc.nextLine();

                        if(capMaxima <= 0){
                            System.out.println("\nOpcao invalida, digite um valor maior que zero na proxima!");
                        }else{
                            System.out.println("\nFinalidade:\n");
                            System.out.println("1 - Habitacao\n2 - Laboratorio\n3 - Armazenamento");
                            String finalidade = sc.nextLine();

                            if("1".equals(finalidade)){
                                ModuloHabitacionial habitacao = new ModuloHabitacionial(identificacao, localizacao, capMaxima, "Habitacao");
                                modulos.add(habitacao);
                                System.out.println("\nModulo Habitacional Cadastrado!");
                            }else if("2".equals(finalidade)){
                                ModuloHabitacionial laboratorio = new ModuloHabitacionial(identificacao, localizacao, capMaxima, "Laboratorio");
                                modulos.add(laboratorio);
                                System.out.println("\nModulo Habitacional Cadastrado!");
                            }else if("3".equals(finalidade)){
                                ModuloHabitacionial armazenamento = new ModuloHabitacionial(identificacao, localizacao, capMaxima, "Armazenamento");
                                modulos.add(armazenamento);
                                System.out.println("\nModulo Habitacional Cadastrado!");
                            }else{
                                System.out.println("\nOpcao invalida!");
                            }
                        }
                    }else{
                        System.out.println("\nOpcao invalida, digite um valor inteiro na proxima!");
                        sc.nextLine();
                    }
                }
            }else if("2".equals(escolha)){
                moduloCadastrado = false;
                finalidadeCoerente = false;

                System.out.println("\nIdentificacao do modulo habitacional: ");
                identificacao = sc.nextLine();

                for(ModuloHabitacionial modulo : modulos){
                    if(modulo.getIdentificacao().equals(identificacao)){
                        moduloCadastrado = true;

                        if(modulo.verificarCapacidadeMaxima() == true){
                            System.out.println("\nO modulo habitacional " + modulo.getIdentificacao() + " atingiu o maximo de sua capacidade!");
                            break;
                        }else{
                            if("Habitacao".equals(modulo.getFinalidade()) || "Laboratorio".equals(modulo.getFinalidade()) || "Armazenamento".equals(modulo.getFinalidade())){
                                finalidadeCoerente = true;

                                System.out.println("\nNome completo do habitante: ");
                                String nome = sc.nextLine();

                                for(Habitante habitante : modulo.getHabitantes()){
                                    if(habitante.getNome().equals(nome)){
                                        System.out.println("\nJa existe um habitante com esse nome!");
                                        break;
                                    }
                                }

                                System.out.println("\nIdade do habitante: ");

                                if(sc.hasNextInt()){
                                    int idade  = sc.nextInt();
                                    sc.nextLine();

                                    if(idade <= 0){
                                        System.out.println("\nValor invalido, digite um valor maior que zero da proxima!");
                                    }else{
                                        System.out.println("\nFuncao do habitante:\n1 - Cientista\n2 - Engenheiro\n3 - Tecnico");
                                        String funcao = sc.nextLine();

                                        if("Laboratorio".equals(modulo.getFinalidade()) && "2".equals(funcao) || "Laboratorio".equals(modulo.getFinalidade()) && "3".equals(funcao) || "Habitacao".equals(modulo.getFinalidade()) && "1".equals(funcao)){
                                            System.out.println("\nA funcao do habitante nao corresponde a finalidade desse modulo!");
                                        }else{
                                            System.out.println("\nEspecialidade: ");
                                            String especialidade = sc.nextLine();

                                            if("Habitacao".equals(modulo.getFinalidade()) && "2".equals(funcao)){
                                                Habitante engenheiro = new Engenheiro(especialidade, "Engenheiro", nome, idade);
                                                modulo.getHabitantes().add(engenheiro);
                                                System.out.println("\nO habitante foi cadastrado!");
                                                modulo.setCapacidade(modulo.getCapacidade() + 1);
                                            }else if("Habitacao".equals(modulo.getFinalidade()) && "3".equals(funcao)){
                                                Habitante arquiteto = new Tecnico(especialidade, "Tecnico", nome, idade);
                                                modulo.getHabitantes().add(arquiteto);
                                                System.out.println("\nO habitante foi cadastrado!");
                                                modulo.setCapacidade(modulo.getCapacidade() + 1);
                                            }else if("Laboratorio".equals(modulo.getFinalidade()) && "1".equals(funcao)){
                                                Habitante cientista = new Cientista(especialidade, "Cientista", nome, idade);
                                                modulo.getHabitantes().add(cientista);
                                                System.out.println("\nO habitante foi cadastrado!");
                                                modulo.setCapacidade(modulo.getCapacidade() + 1);
                                            }else{
                                                System.out.println("\nO habitante nao corresponde a esse modulo!");
                                            }
                                        }
                                    }
                                }else{
                                    System.out.println("\nValor invalido, digite um numero inteiro e maior que zero na proxima!");
                                    sc.nextLine();
                                }
                            }
                            break;
                        }
                    }
                    moduloCadastrado = false;
                    finalidadeCoerente = false;
                }

                if(moduloCadastrado == false){
                    System.out.println("\nO modulo nao foi cadastrado!");
                }else{
                    if(finalidadeCoerente == false){
                        System.out.println("\nO modulo nao possui finalidade de habitacao ou laboratorio!");
                    }
                }
            }else if("3".equals(escolha)){
                moduloCadastrado = false;
                finalidadeCoerente = false;

                System.out.println("\nIdentificacao do modulo habitacional: ");
                identificacao = sc.nextLine();

                for(ModuloHabitacionial modulo : modulos){
                    if(modulo.getIdentificacao().equals(identificacao)){
                        moduloCadastrado = true;
                        if(modulo.getFinalidade().equals("Armazenamento")){
                            finalidadeCoerente = true;

                            System.out.println("\nRecursos:\n1 - Agua\n2 - Oxigenio\n3 - Energia\n4 - Alimento");
                            String recurso = sc.nextLine();

                            System.out.println("\nQuantidade: ");

                            if(sc.hasNextDouble()){
                                double quantidade = sc.nextDouble();

                                if(quantidade <= 0){
                                    System.out.println("\nValor invalido, digite um valor maior que zero na proxima");
                                }else{
                                    if("1".equals(recurso)){
                                        modulo.getAgua().setQuantidade(quantidade);
                                    }else if("2".equals(recurso)){
                                        modulo.getOxigenio().setQuantidade(quantidade);
                                    }else if("3".equals(recurso)){
                                        modulo.getEnergia().setQuantidade(quantidade);
                                    }else if("4".equals(recurso)){
                                        modulo.getComida().setQuantidade(quantidade);
                                    }else{
                                        System.out.println("\nOpcao invalida!");
                                        break;
                                    }
    
                                    System.out.println("\nRecurso Cadastrado!");
                                }
                            }else{
                                System.out.println("\nOpcao invalida, digite um valor maior que zero na proxima!");
                            }
                            break;
                        }
                    }
                    moduloCadastrado = false;
                    finalidadeCoerente = false;
                }

                if(moduloCadastrado == false){
                    System.out.println("\nO modulo nao foi cadastrado!");
                }else{
                    if(finalidadeCoerente == false){
                        System.out.println("\nO modulo nao possui finalidade de armazenamento!");
                    }
                }
                sc.nextLine();
            }else if("4".equals(escolha)){
                moduloCadastrado = true;
                finalidadeCoerente = true;

                System.out.println("\nIdentificacao do modulo habitacional: ");
                identificacao = sc.nextLine();

                for(ModuloHabitacionial modulo : modulos){
                    if(modulo.getIdentificacao().equals(identificacao)){
                        moduloCadastrado = true;
                        if(modulo.getFinalidade().equals("Laboratorio")){
                            finalidadeCoerente = true;

                            System.out.println("\nProjeto de Pesquisa:\n");
                            System.out.println("Titulo: ");
                            String titulo = sc.nextLine();

                            System.out.println("\nEquipe Responsavel: ");
                            String equipeResponsavel = sc.nextLine();

                            System.out.println("\nDuracao estimada (horas): ");
                            double duracaoEstimada = sc.nextDouble();

                            System.out.println("\nRequisitos de Equipamento: ");
                            String requisitosDeEqipamentos = sc.nextLine();
                            sc.next();

                            System.out.println("\nStatus\n1 - Planejada\n2 - Andamento\n3 - Concluida");
                            String status = sc.nextLine();

                            if("1".equals(status)){
                                ProjetosDePesquisa pesquisa = new ProjetosDePesquisa(titulo, equipeResponsavel, duracaoEstimada, requisitosDeEqipamentos, "Planejada");
                                modulo.setPesquisa(pesquisa);
                            }else if("2".equals(status)){
                                ProjetosDePesquisa pesquisa = new ProjetosDePesquisa(titulo, equipeResponsavel, duracaoEstimada, requisitosDeEqipamentos, "Andamento");
                                modulo.setPesquisa(pesquisa);
                            }else if("3".equals(status)){
                                ProjetosDePesquisa pesquisa = new ProjetosDePesquisa(titulo, equipeResponsavel, duracaoEstimada, requisitosDeEqipamentos, "Concluida");
                                modulo.setPesquisa(pesquisa);
                            }else{
                                System.out.println("\nOpcao invalida!");
                                break;
                            }
                            System.out.println("\nProjeto Cadastrado!");
                            break;
                        }
                    }
                    moduloCadastrado = false;
                    finalidadeCoerente = false;
                }

                if(moduloCadastrado == false){
                    System.out.println("\nO modulo nao foi cadastrado!");
                }else{
                    if(finalidadeCoerente == false){
                        System.out.println("\nO modulo nao possui finalidade de armazenamento!");
                    }
                }
                sc.nextLine();
            }else if("5".equals(escolha)){
                boolean temHabitacional = false;
                boolean temLabolatorio = false;
                boolean temArmazenamento = false;

                if(modulos.isEmpty()){
                    System.out.println("\nNao ha nenhum modulo cadastrado!");
                }else{
                    System.out.println("\nModulos por Tipo:");

                    System.out.println("\nHabitacional:");

                    for(ModuloHabitacionial modulo : modulos){
                        if("Habitacao".equals(modulo.getFinalidade())){
                            System.out.println("\nIdentificacao: " + modulo.getIdentificacao());
                            System.out.println("Localizacao: " + modulo.getLocalizacao());
                            System.out.println("Quantidade de Habitantes: " + modulo.getCapacidade());
                            System.out.println("Capacidade Maxima de Habitantes: " + modulo.getCapMaxima());
                            temHabitacional = true;
                        }
                    }

                    if(temHabitacional == false){
                        System.out.println("\nNao ha modulo cadastrado com essa finalidade!");
                    }

                    System.out.println("\nLaboratorio:");

                    for(ModuloHabitacionial modulo : modulos){
                        if("Laboratorio".equals(modulo.getFinalidade())){
                            System.out.println("\nIdentificacao: " + modulo.getIdentificacao());
                            System.out.println("Localizacao: " + modulo.getLocalizacao());
                            System.out.println("Quantidade de Habitantes: " + modulo.getCapacidade());
                            System.out.println("Capacidade Maxima de Habitantes: " + modulo.getCapMaxima());
                            temLabolatorio = true;
                        }
                    }

                    if(temLabolatorio == false){
                        System.out.println("\nNao ha modulo cadastrado com essa finalidade!");
                    }

                    System.out.println("\nArmazenamento:");

                    for(ModuloHabitacionial modulo : modulos){
                        if("Armazenamento".equals(modulo.getFinalidade())){
                            System.out.println("\nIdentificacao: " + modulo.getIdentificacao());
                            System.out.println("Localizacao: " + modulo.getLocalizacao());
                            System.out.println("Quantidade de Habitantes: " + modulo.getCapacidade());
                            System.out.println("Capacidade Maxima de Habitantes: " + modulo.getCapMaxima());
                            temArmazenamento = true;
                        }
                    }

                    if(temArmazenamento == false){
                        System.out.println("\nNao ha modulo cadastrado com essa finalidade!");
                    }
                }
            }else if("6".equals(escolha)){
                boolean temLaboratorio = false;

                System.out.println("\nProjetos de Pesquisa:");

                for(ModuloHabitacionial modulo : modulos){
                    if("Laboratorio".equals(modulo.getFinalidade())){
                        temLaboratorio = true;

                        if("nao tem".equals(modulo.getPesquisa().getStatus())){
                            System.out.println("\nNao ha projeto de pesquisa no modulo " + modulo.getIdentificacao() + "!");
                        }else{
                            System.out.println("\nIdentificacao: " + modulo.getIdentificacao());
                            System.out.println("\nTitulo: " + modulo.getPesquisa().getTitulo());
                            System.out.println("Equipe Responsavel: " + modulo.getPesquisa().getEquipeResponsavel());
                            System.out.println("Duracao Estimada: " + modulo.getPesquisa().getDuracaoEstimada());
                            System.out.println("Requisito de Equipamentos: " + modulo.getPesquisa().getRequisitosDeEquipamentos());
                            System.out.println("\nStatus: " + modulo.getPesquisa().getStatus());
                        }
                    }
                }

                if(temLaboratorio == false){
                    System.out.println("\nNao ha modulo Laboratorio cadastrado!");
                }
            }else if("7".equals(escolha)){
                System.out.println("\nNivel de Recursos:");

                for(ModuloHabitacionial modulo : modulos){
                        System.out.println("\nIdentificacao: " + modulo.getIdentificacao());
    
                        System.out.println("\nAgua: " + modulo.getAgua().getQuantidade() + " litros");
                        System.out.println("Oxigenio: " + modulo.getOxigenio().getQuantidade() + " litros");
                        System.out.println("Energia: " + modulo.getEnergia().getQuantidade() + " watts");
                        System.out.println("Alimento: " + modulo.getComida().getQuantidade() + " gramas");
                }
            }else if("8".equals(escolha)){
                    boolean temHabitacional = false;
                    boolean temLabolatorio = false;
                    boolean temArmazenamento = false;


                    System.out.println("\nHabitacao:");

                    for(ModuloHabitacionial modulo : modulos){
                        if(modulos.isEmpty()){
                            System.out.println("\nNao ha nenhum modulo cadastrado!");
                            break;
                        }
                        if("Habitacao".equals(modulo.getFinalidade())){
                            temHabitacional = true;
                            System.out.println("\nIdentficacao: " + modulo.getIdentificacao());

                            if(modulo.getHabitantes().isEmpty()){
                                System.out.println("\nNao ha nenhum habitante cadastrado nesse modulo!");
                            }else{
                                for(Habitante habitante : modulo.getHabitantes()){
                                    System.out.println("\nNome: " + habitante.getNome());
                                    System.out.println("Idade: " + habitante.getIdade());
                                    System.out.println("Funcao: " + habitante.getFuncao());
                                    System.out.println("Especialidade: " + habitante.getEspecialidade());
                                }
                            }
                        }
                    }

                    if (temHabitacional == false){
                        System.out.println("\nNao ha modulo cadastrado com essa finalidade!");
                    }

                    System.out.println("\nLaboratorio");

                    for(ModuloHabitacionial modulo : modulos){
                        if(modulos.isEmpty()){
                            System.out.println("\nNao ha nenhum modulo cadastrado!");
                            break;
                        }

                        if("Laboratorio".equals(modulo.getFinalidade())){
                            System.out.println("\nIdentficacao: " + modulo.getIdentificacao());

                            if(modulo.getHabitantes().isEmpty()){
                                temLabolatorio = true;
                                System.out.println("\nNao ha nenhum habitante cadastrado nesse modulo!");
                            }else{
                                for(Habitante habitante : modulo.getHabitantes()){
                                    System.out.println("\nNome: " + habitante.getNome());
                                    System.out.println("Idade: " + habitante.getIdade());
                                    System.out.println("Funcao: " + habitante.getFuncao());
                                    System.out.println("Especialidade: " + habitante.getEspecialidade());
                                }
                            }
                        }
                    }

                    if(temLabolatorio == false){
                        System.out.println("\nNao ha modulo cadastrado com essa finalidade!");
                    }

                    System.out.println("\nArmazenamento");

                    for(ModuloHabitacionial modulo : modulos){
                        if(modulos.isEmpty()){
                            System.out.println("\nNao ha nenhum modulo cadastrado!");
                            break;
                        }
                        
                        if("Armazenamento".equals(modulo.getFinalidade())){
                            temArmazenamento = true;
                            System.out.println("\nIdentficacao: " + modulo.getIdentificacao());

                            if(modulo.getHabitantes().isEmpty()){
                                System.out.println("\nNao ha nenhum habitante cadastrado nesse modulo!");
                            }else{
                                for(Habitante habitante : modulo.getHabitantes()){
                                    System.out.println("\nNome: " + habitante.getNome());
                                    System.out.println("Idade: " + habitante.getIdade());
                                    System.out.println("Funcao: " + habitante.getFuncao());
                                    System.out.println("Especialidade: " + habitante.getEspecialidade());
                                }
                            }
                        }
                    }

                    if(temArmazenamento == false){
                        System.out.println("\nNao ha modulo cadastrado com essa finalidade!");
                    }

            }else if ("9".equals(escolha)) {
                try (FileWriter arquivo = new FileWriter("arquivo.txt"); 
                     PrintWriter gravarArquivo = new PrintWriter(arquivo)) {
            
                    gravarArquivo.println("Modulos Cadastrados:");
            
                    for (ModuloHabitacionial modulo : modulos) {
                        gravarArquivo.println("\nIdentificacao: " + modulo.getIdentificacao());
                        gravarArquivo.println("Localizacao: " + modulo.getLocalizacao());
                        gravarArquivo.println("Capacidade Maxima: " + modulo.getCapMaxima());
                        gravarArquivo.println("Finalidade: " + modulo.getFinalidade());
            
                        if (modulo.getHabitantes().isEmpty()) {
                            gravarArquivo.println("\nNao ha habitantes cadastrados nesse modulo!");
                        } else {
                            gravarArquivo.println("\nHabitantes:");
            
                            for (Habitante habitante : modulo.getHabitantes()) {
                                gravarArquivo.println("\nNome: " + habitante.getNome());
                                gravarArquivo.println("Idade: " + habitante.getIdade());
                                gravarArquivo.println("Funcao: " + habitante.getFuncao());
                                gravarArquivo.println("Especialidade: " + habitante.getEspecialidade());
                            }
                        }
            
                        gravarArquivo.println("\nRecursos:");
            
                        gravarArquivo.println("\nAgua: " + modulo.getAgua().getQuantidade());
                        gravarArquivo.println("Oxigenio: " + modulo.getOxigenio().getQuantidade());
                        gravarArquivo.println("Energia: " + modulo.getEnergia().getQuantidade());
                        gravarArquivo.println("Alimento: " + modulo.getComida().getQuantidade());
            
                        if ("Laboratorio".equals(modulo.getFinalidade())) {
                            gravarArquivo.println("\nProjeto de Pesquisa:");
            
                            if ("nao tem".equals(modulo.getPesquisa().getStatus())) {
                                gravarArquivo.println("\nNao ha projeto de pesquisa nesse modulo!");
                            } else {
                                gravarArquivo.println("\nTitulo: " + modulo.getPesquisa().getTitulo());
                                gravarArquivo.println("Equipe Responsavel: " + modulo.getPesquisa().getEquipeResponsavel());
                                gravarArquivo.println("Duracao Estimada: " + modulo.getPesquisa().getDuracaoEstimada());
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("\nErro ao criar arquivo: " + e.getMessage());
                }
            }else if ("10".equals(escolha)) {
                System.out.println("\nAbastecer Modulos:");
                System.out.println("\nDe qual modulo voce deseja transferir os recursos?");
                String moduloOrigem = sc.nextLine();
                System.out.println("\nPara qual modulo voce deseja transferir os recursos?");
                String moduloDestino = sc.nextLine();
                for (ModuloHabitacionial modulo : modulos) {
                    if (modulo.getIdentificacao().equals(moduloOrigem)) {
                        for (ModuloHabitacionial modulo2 : modulos) {
                            if (modulo2.getIdentificacao().equals(moduloDestino)) {
                                modulo.abastecerModulos(modulo, modulo2);
                            }
                        }
                    }
                }
                
        
            }else if("11".equals(escolha)){
                System.out.println("\nObrigado por utilizar o Sistema de Colonias Submarinas!");
            }else{
                System.out.println("\nOpcao invalida!");
            }

            if(!"11".equals(escolha)){
                for (ModuloHabitacionial modulo : modulos) {
                    modulo.gastoDeRecursos();
                    modulo.alertaRecursos();
                }
            }

        } while (!"11".equals(escolha));

        System.out.println("\nPrograma Encerrado!");
    }
}

