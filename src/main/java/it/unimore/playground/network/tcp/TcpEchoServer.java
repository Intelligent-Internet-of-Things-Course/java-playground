package it.unimore.playground.network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/** TCP echo server.
 * It replies back the received data.
 */
public abstract class TcpEchoServer {

	private static void serve(Socket socket) {
		try {

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			byte[] buffer = new byte[2000];
			int len;

			while ((len=is.read(buffer))>0) {
				System.out.println("from '"+socket.getRemoteSocketAddress()+"': "+new String(buffer,0,len));
				os.write(buffer,0,len);
			}

			socket.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) throws IOException {

		ServerSocket socketServer=new ServerSocket(4000);

		System.out.println("TCP echo server on port: "+socketServer.getLocalPort());
		System.out.println("waiting...");	

		while (true) {
			Socket socket=socketServer.accept();
			new Thread(() -> serve(socket)).start();
		}
	}

}
