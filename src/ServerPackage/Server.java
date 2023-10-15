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
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();

			
			// Flux de traitement
			PrintWriter pw = new PrintWriter(os,true);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			//Reçoie du premier entier
			String s = br.readLine();
			int e1 = Integer.parseInt(s);
			
			// Reçcoie du deuxieme entier
			s = br.readLine();
			int e2 = Integer.parseInt(s);
			
			
			//Recoie du type d'operation
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
			pw.println(r);
			
			// La dernière étape : Fermer socket
			socket.close();
			socketServer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


					
		
		

	}

}
