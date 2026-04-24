import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando projeto CRUD");

        try {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/crud_usuarios",
                    "root",
                    "Daniel,231014"
            );
            System.out.println("Conectado ao banco!");

            Scanner scanner = new Scanner(System.in);
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
                        cadastrar(conexao, scanner);
                        break;
                    case 2:
                        listar(conexao);
                        break;
                    case 3:
                        deletar(conexao, scanner);
                        break;
                    case 4:
                        atualizar(conexao, scanner);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public static void listar(Connection conexao) throws SQLException {
        String sql = "SELECT * FROM usuarios";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " + rs.getString("nome"));
        }
    }

    public static void deletar(Connection conexao, Scanner scanner) throws SQLException {
        System.out.println("Digite o id do usuário que deseja deletar:");
        int id = scanner.nextInt();

        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        System.out.println("Usuário deletado com sucesso!");
    }

    public static void atualizar(Connection conexao, Scanner scanner) throws SQLException {
        System.out.println("Digite o id do usuário que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo nome:");
        String nome = scanner.nextLine();

        String sql = "UPDATE usuarios SET nome = ? WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, id);
        stmt.executeUpdate();

        System.out.println("Usuário atualizado com sucesso!");
    }

    public static void cadastrar(Connection conexao, Scanner scanner) throws SQLException {
        System.out.println("Digite o nome do novo usuário:");
        scanner.nextLine();
        String nome = scanner.nextLine();

        String sql = "INSERT INTO usuarios (nome) VALUES (?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.executeUpdate();

        System.out.println("Usuário cadastrado com sucesso!");
    }
}