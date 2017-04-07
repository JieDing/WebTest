package com.jieding.echoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Socket client = new Socket("192.168.200.219",8191);){
			//client.connect(new InetSocketAddress(InetAddress.getByName("admin-PC"), 8191));
			try(InputStream ins = client.getInputStream();
				OutputStream os = client.getOutputStream();
				Scanner s = new Scanner(ins);
				PrintWriter out = new PrintWriter(os,true);){
				
				System.out.println(s.nextLine());
				BufferedReader buff = new BufferedReader(new InputStreamReader(System.in)); 
				
				out.println(buff.readLine());
				out.flush();
				
				//boolean done = false;
				
				while(s.hasNextLine()){
					
					String line = s.nextLine();
					System.out.println(line);
					String output = buff.readLine();
					out.println(output);
					//if(data.trim().equals("BYE")) done =true;
				}
					
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
