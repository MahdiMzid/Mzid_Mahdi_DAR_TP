package ServerPackage;
import java.net.*;
import java.util.Scanner;

import OperationPackage.Operation;

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

			/**
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
			**/
			
			//Communication par objet Sérializable
			// Flux de traitement
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// Reçoie d'objet
			Operation o = (Operation)ois.readObject();
			
			// Récupération des parameters
			int nb1 = o.getOp1();
			int nb2 = o.getOp2();
			char op = o.getOperation();
			
			// Calcul
			switch (op) {
			case '+':
				o.setResult(nb1 + nb2);
				break;
			case '-':
				o.setResult(nb1 - nb2);
				break;
			case '*':
				o.setResult(nb1 * nb2);
				break;
			case '/':
				o.setResult(nb1 / nb2);
				break;
				

			default:
				break;
			}
			
			// Envoie d'objet
			oos.writeObject(o);
			
			
			// La dernière étape : Fermer socket
			socket.close();
			socketServer.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


					
		
		

	}

}
