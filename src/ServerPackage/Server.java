package ServerPackage;
import java.net.*;
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
			
			//Reçoie du entier
			InputStream is = socket.getInputStream();
			int nb = is.read();
			
			//Calcule du produit
			int x = nb*5;
			
			//Envoie du résultat
			OutputStream os = socket.getOutputStream();
			os.write(x);
			
			// La dernière étape : Fermer socket
			socket.close();
			socketServer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


					
		
		

	}

}
