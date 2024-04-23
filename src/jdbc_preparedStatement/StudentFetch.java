package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import java.sql.PreparedStatement;

public class StudentFetch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
       String className = "com.mysql.cj.jdbc.Driver";
       String url = "jdbc:mysql://localhost:3306/studentdb";
       String user = "root";
       String password = "root";
       String sql = "SELECT * FROM STUDENT WHERE ID = ?";
       
       Class.forName(className);
       Connection connection = DriverManager.getConnection(url, user, password);
       Statement statement =  connection.createStatement();
       
       //preparedStatement.setInt(1, id);
       ResultSet resultSet = statement.executeQuery(sql);
       while(resultSet.next())
       {
       	System.out.print(resultSet.getInt("id")+".  ");
       	System.out.print(resultSet.getString("student_name")+"  ");
       	System.out.print(resultSet.getDouble("father_name")+"  ");
       	System.out.print(resultSet.getDouble("mother_name")+"  ");
       	System.out.print(resultSet.getString("phone")+"  ");
       	System.out.print(resultSet.getString("address")+"  ");
       	System.out.print(resultSet.getString("marks")+"  ");
       	System.out.println();
       }
       connection.close();    
	}

}
