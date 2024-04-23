package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the phone : ");
		long phone = scanner.nextLong();
		System.out.println("Enter the Address : ");
		String address = scanner.next();
		System.out.println("Enter the Marks : ");
		double marks = scanner.nextDouble();
		System.out.println("Enter the id : ");
		int id = scanner.nextInt();
		
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "root";
        String sql = "UPDATE STUDENT SET PHONE = ?, ADDRESS = ?, MARKS = ? WHERE ID = ?";
        
        Class.forName(className);
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setLong(1, phone);
        preparedStatement.setString(2, address);
        preparedStatement.setDouble(3, marks);
        preparedStatement.setInt(4, id);
        
        int result = preparedStatement.executeUpdate();
        if(result!=0)
        {
        	System.out.println("Data Updated!");
        }
        else
        {
        	System.out.println("Data not Updated!");
        }
        
        connection.close();
	}

}
