import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando projeto CRUD");
        Scanner scanner = new Scanner(System.in);
        int iddelete=0;
        int idmodification=0;
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
                    System.out.println("Digite o id do usuário que deseja deletar:");
                    iddelete= scanner.nextInt();
                    boolean encontrado = false;

                    for (Usuario u: usuarios){
                        if (iddelete == u.getId()){
                            usuarios.remove(u);
                            encontrado = true;
                            System.out.println("Usuário removido com sucesso!");
                            break;
                        }
                    }

                    if (!encontrado){
                        System.out.println("Usuário não encontrado!");
                    }break;

                case 4:
                    System.out.println("Digite o id do usuário que deseja fazer as modificções:");
                    idmodification= scanner.nextInt();
                    scanner.nextLine();
                    boolean encontradomodi=false;
                    for (Usuario u: usuarios){
                        if (idmodification == u.getId()){
                            System.out.println("Digite aqui o novo nome desse usuário:");
                            String new_name = scanner.nextLine();
                            u.setNome(new_name);
                            System.out.println("O novo nome desse usuário é:"+ new_name);
                            encontradomodi = true;
                            System.out.println("Usuário modificado com sucesso!");
                            break;
                        }

                    }
                    if (!encontradomodi){
                        System.out.println("Usuário não encontrado!");
                    }

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

