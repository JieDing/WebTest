package com.jieding.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 通过Socket(String host, int port)构建的套接字在未抵达目的地之前会一直阻塞
		 */
	/*	try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13);
				InputStream inStream = s.getInputStream();
				Scanner in = new Scanner(inStream);){
			
			while(in.hasNextLine()){
				String line = in.nextLine();
				System.out.println(line);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		InputStream inStream=null;
		Scanner in = null;
		try (Socket s = new Socket();){
			s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13),30000);
			inStream=s.getInputStream();
			in = new Scanner(inStream);
			
			while(in.hasNextLine()){
				String line = in.nextLine();
				System.out.println(line);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
		}
		
		
	}

}
