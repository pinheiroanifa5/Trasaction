import java.sql.*;

public class ExemploJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_sql";
        String usuario = "root";
        String senha = "scutyany";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM clientes";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String telefone = resultado.getString("telefone");
                
                System.out.printf("\nCliente #", id, nome, email, telefone);
                System.out.printf(id + "\n");
                System.out.printf(nome + "\n");
                System.out.printf(email  + "\n");
                System.out.printf(telefone  + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar consulta SQL: " + e.getMessage());
        }
    }
}
