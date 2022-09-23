import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresSQL extends Database
{
    @Override
    public void insertMessage(String message){
        String dbURL = "jdbc:postgresql://localhost:5432/messages";
        String username = "postgres";
        String password = "1234";

        try
        {
            Connection connection = DriverManager.getConnection(dbURL, username, password);

            String sql = "INSERT INTO messages (message) VALUES ('" + message + "')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);

            if(rows>0)
            {
                System.out.println("A row has been inserted into the PostgresSQL database");
            }

            connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
