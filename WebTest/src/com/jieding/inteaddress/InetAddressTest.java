package com.jieding.inteaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress[] addresses = InetAddress.getAllByName("admin-PC");
			for(InetAddress a: addresses){
				System.out.println(a);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------");
		try {
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress.getHostName());
			System.out.println(localHostAddress.getCanonicalHostName());
			System.out.println(localHostAddress.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
