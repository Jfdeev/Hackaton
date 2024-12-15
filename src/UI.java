import java.util.Scanner;

public class UI {
    public void userInterface(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de gerenciamento de recursos da base lunar!");
        System.out.println("Digite o numero correspondente a acao que deseja realizar:");
        System.out.println("1 - Cadastrar modulo habitacional");
        System.out.println("2 - Cadastrar modulo de armazenamento");
    }
}
