package ClientPackage;
import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) {

		try {
			
			// La première étape
			int port=1234;
			InetAddress server= InetAddress.getLocalHost();
			System.out.println("Je suis un client pas encore connecté...");
			Socket socket = new Socket(server,port);
			System.out.println("Je suis un client connecté");
			
			// La dernière étape
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}

}
