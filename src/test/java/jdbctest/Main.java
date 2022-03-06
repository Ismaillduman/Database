package jdbctest;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@18.233.164.111:1521:xe" ;
        String dbuserName = "HR";
        String dbPassword = "hr";

        //CREATE CONNECTION
        Connection connection = DriverManager.getConnection(dbUrl, dbuserName, dbPassword);

        //create statement object
        Statement statement = connection.createStatement();

        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from departments");

        //move pointer to first  row
          //resultSet.next();
        //System.out.println(resultSet.getString("region_name"));
        //System.out.println(resultSet.getString(2));
        //System.out.println(resultSet.getInt(1) + " - " + resultSet.getString("region_name"));

        //resultSet.next();

        //System.out.println(resultSet.getString("region_name"));
        //System.out.println(resultSet.getString(2));
        //System.out.println(resultSet.getInt(1) + " - " + resultSet.getString("region_name"));


while(resultSet.next()){
    System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2)+" - "+resultSet.getString(3)
            +" - "+resultSet.getString(4));
}



        //close all the connection
        resultSet.close();
        statement.close();
        connection.close();








    }
}
