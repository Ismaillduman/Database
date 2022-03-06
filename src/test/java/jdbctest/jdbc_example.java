package jdbctest;

import org.testng.annotations.Test;

import java.sql.*;

public class jdbc_example {

    String dbUrl = "jdbc:oracle:thin:@18.233.164.111:1521:xe" ;
    String dbuserName = "HR";
    String dbPassword = "hr";

    @Test
            public void test1() throws SQLException {
        //CREATE CONNECTION
        Connection connection = DriverManager.getConnection(dbUrl, dbuserName, dbPassword);

        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from departments");

resultSet.last();
int rowCount= resultSet.getRow();;
        System.out.println("rowCount = " + rowCount);

//we need move before first row to get full list since we are at the last row right now
        resultSet.beforeFirst();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));

        }

        resultSet.close();
        connection.close();
        statement.close();
    }

}
