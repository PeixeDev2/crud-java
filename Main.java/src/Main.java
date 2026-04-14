import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando projeto CRUD");
        Scanner scanner = new Scanner(System.in);
        int idRemover = 1;
        int idUpdate = 2;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "Daniel"));
        usuarios.add(new Usuario(2, "Luiz"));
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("Digite uma opção: ");
            System.out.println("1-Cadastrar");
            System.out.println("2-Listar");
            System.out.println("3-Deletar");
            System.out.println("4-Atualizar");
            System.out.println("5-Sair");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    // cadastrar
                    break;

                case 2:
                    for (Usuario u : usuarios) {
                        System.out.println(u);
                    }
                    break;

                case 3:
                    // deletar
                    break;

                case 4:
                    // atualizar
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }

    }
}

