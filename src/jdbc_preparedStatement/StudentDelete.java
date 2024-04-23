package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class StudentDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the ID : ");
     int id = sc.nextInt();
		
     String className = "com.mysql.cj.jdbc.Driver";
     String url = "jdbc:mysql://localhost:3306/studentdb";
     String user = "root";
     String password = "root";
     String sql = "DELETE FROM STUDENT WHERE ID = ?";
     
     Class.forName(className);
     Connection connection = DriverManager.getConnection(url, user, password);
     PreparedStatement preparedStatement = connection.prepareStatement(sql);
     
	  preparedStatement.setInt(1, id);
	  int result = preparedStatement.executeUpdate();
	  if(result!=0)
	  {
		  System.out.println("Data Deleted!");
	  }
	  else
	  {
		  System.out.println("Data not Deleted");
	  }
	  connection.close();
	}

}
