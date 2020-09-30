package it.unimore.playground.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * Program that sends a message to a TCP server and receives the reply.
 */
public abstract class TcpClient {

	public static void main(String[] args) throws IOException {

		String destAddr = "127.0.0.1";
		int destPort = 4000;

		//Send Message
		byte[] data = "test".getBytes();

		Socket socket = new Socket(destAddr,destPort);

		OutputStream os = socket.getOutputStream();
		os.write(data);

		System.out.println("sent: " + new String(data));

		//Receive Message
		InputStream is = socket.getInputStream();

		byte[] buffer = new byte[2000];

		int len = is.read(buffer);

		System.out.println("received: "+new String(buffer,0,len));

		socket.close();
	}

}
