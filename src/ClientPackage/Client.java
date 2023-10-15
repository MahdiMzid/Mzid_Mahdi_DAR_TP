package ClientPackage;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {

	public static void main(String[] args) {

		try {
			
			//Connexion
			System.out.println("Je suis un client pas encore connecté...");
			InetAddress ia = InetAddress.getByName("10.25.12.183");
			InetSocketAddress isa = new InetSocketAddress(ia,1234);
			Socket socket = new Socket();
			socket.connect(isa);
			System.out.println("Je suis un client connecté");
			
			// Lecture d'un entier
			Scanner scanner = new Scanner(System.in);
			
			// Flux de communication
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			
			// Flux de traitement
			PrintWriter pw = new PrintWriter(os,true);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//Envoie du premier entier
			System.out.println("Taper Le premier entier");
			int nb1 = scanner.nextInt();
			pw.println(nb1);
			
			//Envoie du deuxieme entier
			System.out.println("Taper le deuxieme entier");
			int nb2 = scanner.nextInt();
			pw.println(nb2);
			
			//Envoie du type d'operation
			String op;
			do {
				System.out.println("Choix d'operation:");
				op = scanner.nextLine();
			} while (!(op.equals("+")) && !(op.equals("-")) && !(op.equals("*"))&& !(op.equals("/")));
			pw.println(op);

			
			
			//Reçoit du résultat
			String s = br.readLine();
			int result = Integer.parseInt(s);
			
			//Afficahge du résultat
			System.out.println(nb1+" "+op+" "+nb2+"="+result);
			
		
			
			//Fermeture du Connexion
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
