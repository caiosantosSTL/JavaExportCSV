import java.sql.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

	// String url = "jdbc:sqlite:/Users/Roberto/Desktop/escol/JavaDB/javadb.db";
	String url = "jdbc:sqlite:/Users/Roberto/Documents/ECLIPSE PROYECTOS/ReportTXT/src/DBpasta/exportDB.db";
	Connection con;

	Scanner skan = new Scanner(System.in);

	int idx;
	String nomx;
	String colox;
	String idstr;
	String[] tetx =new String[8];
	int i= 0;
	
	ArrayList<String> info = new ArrayList<>();

	/// ******************************************************** Conex
	public Connection Conect() {
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conex foi");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("nao foi conex " + e);
		}
		return con;
	}

	/// ******************************************************** Insert
	public void Insert(String name) {
		String sql = "INSERT INTO TabelaT(nome) VALUES(?)";

		try (Connection conn = this.Conect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name); // numero de array da tabela
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/// ******************************************************** Select
	public void Select() throws IOException {
		String sql = "SELECT id, nome, color FROM TabelaX";
		
		  FileWriter fileWriter = new
		  FileWriter("/Users/Roberto/Desktop/txtxtx/JavaTXT/teste396.csv");

		// String url = "/Users/Roberto/Desktop/txtxtx/JavaTXT/teste319.csv";
		// File f = new File(url);

		try {

			Connection conn = this.Conect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// loop through the result set
			while (rs.next()) {

				idx = rs.getInt("id");
				nomx = rs.getString("nome");
				colox = rs.getString("color");
				idstr = Integer.toString(idx);
				tetx[i] = idstr + " , " + nomx + " , " + colox + " \n";
				i+=1;

				System.out.println(rs.getInt("id") + " , " + rs.getString("nome") + 
						" , " + rs.getString("color"));
			
				
			}

		} catch (Exception e) {
			// TODO: handle exception

		}
		

		
		try {
			Connection conn = this.Conect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			for (int i = 0; rs.next(); i++) {
				System.out.println("** "+tetx[i]);// aqui 
				  fileWriter.write(tetx[i]);

			}
			  fileWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}


		// ===============

		System.out.println("Vim printar txt");

	}//end metodo select
	
	/// ******************************************************** Select 2
	public void Select2() throws IOException {
		
		String sql = "SELECT id, nome, color FROM TabelaX";
		
		  FileWriter fileWriter = new
		  FileWriter("/Users/Roberto/Desktop/txtxtx/JavaTXT/teste316.csv");
		  
			try {

				Connection conn = this.Conect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				// loop through the result set
				while (rs.next()) {

					idx = rs.getInt("id");
					nomx = rs.getString("nome");
					colox = rs.getString("color");
					idstr = Integer.toString(idx);
					String hh = idstr + " , " + nomx + " , " + colox + " \n";
					info.add(hh);

					System.out.println(rs.getInt("id") + " , " + rs.getString("nome") + 
							" , " + rs.getString("color"));
				
					
				}

			} catch (Exception e) {
				// TODO: handle exception

			}
			
			//88888888888
			
			try {
				Connection conn = this.Conect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				for (int i = 0; rs.next(); i++) {
					System.out.println("** "+info.get(i));// aqui 
					  fileWriter.write(info.get(i));

				}
				  fileWriter.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		
	}

	/// ******************************************************** Fechar db
	public void Fechar() {
		try {
			con.close();
			System.out.println("fechou conex ");
		} catch (Exception e) {
			// TODO: handle exception

			Logger.getLogger(con.getClass().getName()).log(Level.SEVERE, null, e);
		}
	}

	/// ******************************************************** Delete linha
	public void Delete(int id) {
		String sql = "DELETE FROM TabelaT WHERE id = ?";

		try (Connection conn = this.Conect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setInt(0, id);
			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// ===========================================

//	  public static void UsingFileWriter(String txtx) throws IOException { String
//		  fileContent = txtx;
//		  
//		  FileWriter fileWriter = new
//		  FileWriter("/Users/Roberto/Desktop/txtxtx/JavaTXT/teste345.txt");
//		  
//		  fileWriter.write(fileContent); 
//		  fileWriter.close();
//		  
//		  System.out.println("fofof");
//	  
//	  }
	 

}// end class
