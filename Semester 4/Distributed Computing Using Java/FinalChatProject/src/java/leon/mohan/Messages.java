package leon.mohan;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author leonm
 */
@Stateless
public class Messages {

    private String dbURL = "jdbc:postgresql://localhost:5432/messages";
    private String username = "postgres";
    private String password = "1234";
    
    public void insertMessage(String message){
        try
        {
            Connection connection = DriverManager.getConnection(dbURL, username, password);

            String sql = "INSERT INTO messages (message) VALUES ('" + message + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    
    public String getMessages(){
        try
        {
            Connection connection = DriverManager.getConnection(dbURL, username, password);

            String sql = "SELECT * FROM messages";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            String messages = "";
            
            while(result.next()){
                messages += "<p>" + result.getString("message") + "</p>";
            }
            
            connection.close();
            
            return messages;
            
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public void deleteMessages()
    {
        try
        {
            Connection connection = DriverManager.getConnection(dbURL, username, password);

            String sql = "DELETE FROM messages COMMIT";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
