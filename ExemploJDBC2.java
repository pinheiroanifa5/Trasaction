import java.sql.*;

public class ExemploJDBC2  {
    private static int client_id;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_sql";
        String usuario = "root";
        String senha = "scutyany";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            conexao.setAutoCommit(false); // Desativa o modo autocommit

                    
           // o nome do cliente com ID = 2
           String sqlObterNomeCliente = "SELECT nome FROM clientes WHERE id = ?";
           PreparedStatement statementObterNomeCliente = conexao.prepareStatement(sqlObterNomeCliente);
           statementObterNomeCliente.setInt(1, 2);
           ResultSet resultadoObterNomeCliente = statementObterNomeCliente.executeQuery();
           resultadoObterNomeCliente.next();
           String nomeCliente = resultadoObterNomeCliente.getString("nome");

           // Consulta para obter o valor da última transação do cliente
        String sqlConsultaTransacao = "SELECT valor FROM transaction WHERE userid = ?";
        PreparedStatement statementConsultaTransacao = conexao.prepareStatement(sqlConsultaTransacao);
        statementConsultaTransacao.setInt(1,client_id);
        ResultSet resultadoConsultaTransacao = statementConsultaTransacao.executeQuery();
        if (resultadoConsultaTransacao.next()) {
        double valorTransacao = resultadoConsultaTransacao.getDouble("valor");
        System.out.printf("Transação de %.2fECV realizada com sucesso para o cliente %s.\n", valorTransacao, nomeCliente);
        } else {
         System.out.println("Nenhuma transação encontrada para o(a) cliente " + nomeCliente);
}


            conexao.commit(); // Confirma a transação

            //System.out.printf("\nTransação concluída com sucesso! \n Cliente: %s\n Valor transferido: $%.1f ECV.%n\n", nomeCliente, 1000.0);
        } catch (SQLException e) {
            System.out.println("Erro ao executar transação! " + e.getMessage());
        }
    }
}
//Um facto interressante deste trabalho seria adicionar um requisito que seria mostar para conta de quem o valor vai ser transferido.