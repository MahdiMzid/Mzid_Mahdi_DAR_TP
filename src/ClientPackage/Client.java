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
			System.out.println("Taper un entier");
			int nb = scanner.nextInt();
			
			// Envoie du entier vers le server
			OutputStream os = socket.getOutputStream();
			os.write(nb);
			
			// Choix du service
			int x=0;
			while(x<1 || x>4)
				{
				System.out.println("Spécifer le type de calcul");
				System.out.println("1 pour l'addition");
				System.out.println("2 pour la soustraction");
				System.out.println("3 pour la multiplication");
				System.out.println("4 pour la division");
				x = scanner.nextInt();
				}
			
			
			//Envoie le type de service
			os.write(x);
			
			
			//Reçoit du résultat
			InputStream is = socket.getInputStream();
			int result = is.read();
			
			//Afficahge du résultat
			switch (x) {
			case 1:
				System.out.println("Le resultat de "+nb+" + 5 = "+result);
				break;
			case 2:
				System.out.println("Le resultat de "+nb+" - 5 = "+result);				
				break;
			case 3:
				System.out.println("Le resultat de "+nb+" * 5 = "+result);
				break;
			case 4:
				System.out.println("Le resultat de "+nb+" / 5 = "+result);
				break;

			default:
				break;
			}
			
			//Fermeture du Connexion
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
