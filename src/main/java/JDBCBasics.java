import java.sql.*;

public class JDBCBasics {
    public static void main(String[] args) throws Exception{
//        System.out.println("Learning JDBC with Postgres.");

        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "admin";
        String password = "admin";
        String sqlQuery = "SELECT sname FROM students WHERE sid = 1";
        String sname;

//      Establishing connection with database.
        Connection connection = DriverManager.getConnection(url,userName,password);
        System.out.println("Connection with postgres established.");

//      Creating statement.
        Statement statement = connection.createStatement();

//      Executing the sql get query. To execute put type query we need to use statement.execute(sqlQuery);
        ResultSet resultSet = statement.executeQuery(sqlQuery);

//      Switching pointer to next row.
        resultSet.next();

//      Getting and printing value of mentioned column name out of executed result.
        sname = resultSet.getString("sname");
        System.out.println("Name: "+sname);

//      Closing the connection such that it does not either leak data or consume system memory.
        connection.close();
        System.out.println("Connection closed.");
    }
}

