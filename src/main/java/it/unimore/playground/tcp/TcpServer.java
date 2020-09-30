package it.unimore.playground.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * TCP server that receives a textual message.
 */
public abstract class TcpServer {

	public static void main(String[] args) throws IOException {

		ServerSocket socketServer=new ServerSocket(4000);

		System.out.println("TCP server on port: "+socketServer.getLocalPort());
		System.out.println("waiting...");

		Socket socket = socketServer.accept();
		socketServer.close();

		InputStream is = socket.getInputStream();

		byte[] buffer=new byte[2000];

		int len;

		while ((len = is.read(buffer))>0) {
			System.out.println("from '"+socket.getRemoteSocketAddress()+"': "+new String(buffer,0,len));
		}

		socket.close();
	}

}
