package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Db_model {

	

	private static Connection conexion;
	public static  String cadenaConexion;
	public static  String username;
	public static  String password;
	//"jdbc:mysql://192.168.1.190:3306","remote","Saraysofia2010*"
	

	public Db_model(String cadenaConexion, String username, String password) {
		this.cadenaConexion = cadenaConexion;
		this.username = username;
		this.password = password;
	}
	

	public void startConnection() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(cadenaConexion,username,password);

			System.out.println("serverConnected");
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	

	public static void closeConnection() {

		try {
			conexion.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	

	public void useDB(String db_nombre) {
		String query;
		Statement st;
		
		try {
			st = conexion.createStatement();

			query = "USE " + db_nombre + ";";
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			//System.err.println(e);

			Logger.getLogger(Db_model.class.getName()).log(Level.SEVERE, null, e);

	
		}
	}

	public void insertData(String query, String table) {
		try {
			
			Statement st = conexion.createStatement();
			
			System.out.println(query);

			st.executeUpdate(query);
			System.out.println("Datos introducidos en la tabla " + table +  ": correctamente");
			
			
		} catch (SQLException e) {

			Logger.getLogger(Db_model.class.getName()).log(Level.SEVERE, null, e);

		}
		
		
	}
	
	

	public ResultSet getData(String nombreTabla, String subQuerySelect , String subQueryWhere) {
		
		try {
			
		if(subQuerySelect ==  null)
			subQuerySelect = "*";
		if(subQueryWhere == null)
			subQueryWhere = ";";
		
		String query = "select " + subQuerySelect + " from " + nombreTabla  + subQueryWhere;
		Statement st = conexion.createStatement();

		System.out.println(query);

		ResultSet resultSet;
		
		resultSet = st.executeQuery(query);
		
		
		return resultSet;
		
		}catch (SQLException e) {

			Logger.getLogger(Db_model.class.getName()).log(Level.SEVERE, null, e);

			return null;
		}

		
	}
	
	public void deleteData(String campo, String value, String table) {
		
		try {
			String query = "Delete FROM " + table  + " where " + campo + " = " + value;
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {

			Logger.getLogger(Db_model.class.getName()).log(Level.SEVERE, null, e);

		}
	}
	
	
	public void updateData(String query) {
		
		try {

			
			System.out.println(query);

			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {

			Logger.getLogger(Db_model.class.getName()).log(Level.SEVERE, null, e);

		}
	}
	
	
}
