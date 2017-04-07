package com.jieding.echoServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(ServerSocket server = new ServerSocket(8191);) {
			
			System.out.println("server is running");
			try(Socket incoming = server.accept();
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream,true);){
					
					System.out.println(incoming.getInetAddress().getHostAddress());
					out.println("hello, enter BYE to exit.");
					
					boolean done = false;
					while(!done && in.hasNextLine()){
						String line = in.nextLine();
						if(line.trim().equals("BYE")){ 
							done =true;
							break;
						}
						out.println("Echo From the Server: "+line);
						
					}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
