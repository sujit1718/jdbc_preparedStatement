package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id : ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Student Name ");
		String studentName = scanner.nextLine();
		System.out.println("Enter the Father Name ");
		String fatherName = scanner.nextLine();
		System.out.println("Enter the Mother Name ");
		String motherName = scanner.nextLine();
		System.out.println("Enter the Phone Number ");
		long phone = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the Address ");
		String address = scanner.next();
		System.out.println("Enter the Marks ");
		double marks = scanner.nextDouble();
				
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "root";
        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?)";
        
        Class.forName(className);
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, id); 
        preparedStatement.setString(2, studentName);
        preparedStatement.setString(3, fatherName);
        preparedStatement.setString(4, motherName);
        preparedStatement.setLong(5, phone);
        preparedStatement.setString(6, address);
        preparedStatement.setDouble(7, marks);
        
        int result = preparedStatement.executeUpdate();
        if(result != 0)
        {
        	System.out.println("Data Inserted!");
        }
        else
        {
        	System.out.println("Data not Inserted!");
        }
        connection.close();
	}

}
