package pl.kurcaba.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client implements Runnable {
	
	private void updateRequest(String aUserId)
	{
		try {
			Socket socket = new Socket("192.168.99.100",6666);
			PrintWriter socketWriter = new PrintWriter(socket.getOutputStream());
			socketWriter.write(aUserId + "\n\r");
			socketWriter.flush();
			BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = socketReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		Random rand = new Random();
		String aUserId = String.valueOf(rand.nextInt(100) + 1);
		long startTime = System.nanoTime();
		updateRequest(aUserId);
		long elapsedTime = (System.nanoTime() - startTime) / 1000000;
		System.out.print(elapsedTime + ", ");
	}
	
}
