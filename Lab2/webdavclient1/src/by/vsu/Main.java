package by.vsu;

import java.io.*;
import java.net.*;
import org.xmlpull.v1.builder.xpath.*;
import httpclient.*;
import sdk.src.com.yandex.disk.client.exceptions.*;;

public class Main {
	public static void main(String[] args){
		try {
			System.out.println("Start.");
			InetAddress iAddress = InetAddress.getByName("webdav.yandex.ru");
			Socket ClientSocket = new Socket(iAddress, 443);
		
			System.out.println("Finish.");
		} catch (IOException e) {
			System.out.println("catch.");
            throw new RuntimeException(e);
        }
	}
}




