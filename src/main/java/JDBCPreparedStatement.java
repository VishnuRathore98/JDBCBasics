import java.sql.*;

public class JDBCPreparedStatement {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/demo";
        String userName = "admin";
        String password = "admin";
        String sqlQuery = "SELECT * FROM students";
        String create = "INSERT INTO students VALUES(?,?,?)";
        String read = "SELECT sname FROM students WHERE sid=2";
        String update = "UPDATE students SET sname='Max' WHERE sid=3";
        String delete = "DELETE FROM students WHERE sid=5";
        String sname = "Faran";
        int sid = 6;
        int marks = 63;

        Connection connection = DriverManager.getConnection(url,userName,password);

        PreparedStatement preparedStatement = connection.prepareStatement(create);

        preparedStatement.setInt(1, sid);
        preparedStatement.setString(2, sname);
        preparedStatement.setInt(3, marks);

        preparedStatement.execute();

//        while(resultSet.next()){
//            System.out.println(resultSet.getString("sname"));
//        }

        connection.close();
    }
}

