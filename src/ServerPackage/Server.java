package ServerPackage;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		try {
			
			//Lance du server
			ServerSocket socketServer = new ServerSocket(1234);
			System.out.println("Je suis un serveur en attente la connexion d'un client");
			
			//Accepte du connexion
			Socket socket = socketServer.accept();
			System.out.println("un client est connecté");
			
			// Flux de comunication
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//Reçoie du premier entier
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			int e1 = Integer.parseInt(s);
			
			// Reçcoie du deuxieme entier
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			s = br.readLine();
			int e2 = Integer.parseInt(s);
			
			
			//Recoie du type d'operation
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			s = br.readLine();
			
			//Calcul
			int r=0;
			switch (s) {
			case "+":
				r = e1 + e2;
				break;
			case "-":
				r = e1 - e2;
				break;
			case "*":
				r = e1 * e2;
				break;
			case "/":
				r = e1 / e2;
				break;
				

			default:
				break;
			}
			//Envoie du résultat
			
			PrintWriter pw = new PrintWriter(os,true);
			pw.println(r);
			
			// La dernière étape : Fermer socket
			socket.close();
			socketServer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


					
		
		

	}

}
