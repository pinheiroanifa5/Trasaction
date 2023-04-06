
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsereTabela {
    // Classe User
    public static class User {
        private int id;
        private String nome;
        // Outros atributos do usuário

        // Getters e Setters

        // Construtores
        public User(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }
    }

    // Classe Transaction
    public static class Transaction {
        private int id;
        private int userId;
        private double valor;
        // Outros atributos da transação

        // Getters e Setters

        // Construtores
        public Transaction(int id, int userId, double valor) {
            this.id = id;
            this.userId = userId;
            this.valor = valor;
        }
    }
//criaçao de tabela User/cliente
    public static void main(String[] args) {
        try {
            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/my_sql", "root", "scutyany");
            Statement statement = connection.createStatement();

            // Criação da tabela "user"
            String createUserTableQuery = "CREATE TABLE IF NOT EXISTS user (" +"id INT PRIMARY KEY , " + "nome VARCHAR(50) )";
            statement.execute(createUserTableQuery);

            // Criação da tabela "transaction"
            String createTransactionTableQuery = "CREATE TABLE IF NOT EXISTS transaction (" + "id INT PRIMARY KEY , " + "userId INT , " +
            "valor DECIMAL(10,2) NOT NULL, " +"FOREIGN KEY (userId) REFERENCES user(id))";
            statement.execute(createTransactionTableQuery);

            System.out.println("Tabelas criadas com sucesso!");

            // Fechar conexão com o banco de dados
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}

