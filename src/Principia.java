import java.io.*;

public class Principia {

	public static void main(String[] args) throws IOException {
		//String url = "/Users/Roberto/Desktop/txtxtx/JavaTXT/teste33.csv";
		//File f = new File(url);
		
		Conexao conx = new Conexao();
		
		conx.Select();
		
		//conx.Conect();
		//conx.Select();
		//conx.Fechar();
		
		/*try {
			FileWriter fw = new FileWriter(f);
			for (int i = 0; i <= 10; i++) {
				fw.write("dfjsd,jfdfjds,jfhsj\n");
			}

			fw.flush();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Nao foi");
		}*/

		//System.out.println("Vim printar txt");

	}

}
