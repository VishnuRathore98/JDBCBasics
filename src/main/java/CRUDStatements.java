import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDStatements {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "admin";
        String password = "admin";
        String sqlQuery = "SELECT * FROM students";
        String create = "INSERT INTO students VALUES(6,'Faran',86)";
        String read = "SELECT sname FROM students WHERE sid=2";
        String update = "UPDATE students SET sname='Max' WHERE sid=3";
        String delete = "DELETE FROM students WHERE sid=5";

        Connection connection = DriverManager.getConnection(url,userName,password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while(resultSet.next()){
            System.out.println(resultSet.getString("sname"));
        }

        connection.close();
    }
}
