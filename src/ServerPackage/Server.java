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
			
			//Recoie du type de service
			int op = is.read();
			
			//Calcul
			int x = 0;
			switch (op) {
			case 1:
				x = nb+5;
				break;
			case 2:
				x = nb-5;
				break;
			case 3:
				x = nb*5;
				break;
			case 4:
				x = nb/5;
				break;
				

			default:
				break;
			}
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
