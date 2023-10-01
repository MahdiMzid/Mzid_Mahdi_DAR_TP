package ClientPackage;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {

	public static void main(String[] args) {

		try {
			
			//Connexion
			int port=1234;
			InetAddress server= InetAddress.getLocalHost();
			System.out.println("Je suis un client pas encore connecté...");
			Socket socket = new Socket(server,port);
			System.out.println("Je suis un client connecté");
			
			// Lecture d'un entier
			Scanner scanner = new Scanner(System.in);
			System.out.println("Donner un entier");
			int x = scanner.nextInt();
			
			// Envoie du entier vers le server
			OutputStream os = socket.getOutputStream();
			os.write(x);
			
			//Reçoit du résultat
			InputStream is = socket.getInputStream();
			int result = is.read();
			
			//Afficahge du résultat
			System.out.println("Multiple de "+ x +" est "+result);
			
			//Fermeture du Connexion
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
