import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando projeto CRUD");
        Scanner scanner = new Scanner(System.in);
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
                    cadastrar(usuarios,scanner);
                    break;

                case 2:
                    listar(usuarios);
                    break;

                case 3:
                    deletar(usuarios,scanner);
                    break;


                case 4:
                    atualizar(usuarios,scanner);

                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }

    }
    public  static  void listar(ArrayList<Usuario> usuarios){
        for (Usuario u : usuarios) {
            System.out.println(u);
        }

    }
    public static void deletar(ArrayList<Usuario>usuarios, Scanner scanner){
        System.out.println("Digite o id do usuário que deseja deletar:");
        int iddelete= scanner.nextInt();
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
        }

    }
    public static void atualizar(ArrayList<Usuario>usuarios,Scanner scanner){
        System.out.println("Digite o id do usuário que deseja fazer as modificções:");
        int idmodification= scanner.nextInt();
        scanner.nextLine();
        boolean encontrado=false;
        for (Usuario u: usuarios){
            if (idmodification == u.getId()){
                System.out.println("Digite aqui o novo nome desse usuário:");
                String new_name = scanner.nextLine();
                u.setNome(new_name);
                System.out.println("O novo nome desse usuário é:  "+ new_name);
                encontrado = true;
                System.out.println("Usuário modificado com sucesso!");
                break;
            }

        }
        if (!encontrado){
            System.out.println("Usuário não encontrado!");
        }
    }
    public static void cadastrar(ArrayList<Usuario>usuarios,Scanner scanner){
        System.out.println("Digite o ID no novo usuário:");
        int idnew= scanner.nextInt();
        scanner.nextLine();

        boolean encontrado=false;
        for (Usuario u: usuarios){
            if (idnew==u.getId()){
                encontrado=true;
                break;
            }
        }
        if (encontrado){
            System.out.println("Usuário já cadastrado!");
        }else{
            System.out.println("Digite um nome para esse novo usuário:");
            String namenew= scanner.nextLine();

            usuarios.add(new Usuario(idnew,namenew));
            System.out.println("Usuário cadastrado com sucesso!");
        }


    }
}

