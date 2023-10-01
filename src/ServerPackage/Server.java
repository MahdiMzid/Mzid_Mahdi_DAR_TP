package ServerPackage;
import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		try {
			
			// La première étape
			ServerSocket socketServer = new ServerSocket(1234);
			System.out.println("Je suis un serveur en attente la connexion d'un client");
			
			// La deuxième étape
			Socket socket = socketServer.accept();
			System.out.println("un client est connecté");
			
			// La dernière étape : Fermer socket
			socket.close();
			socketServer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


					
		
		

	}

}
