package by.vsu;

import java.net.URL;
import java.io.*;
import java.net.*;
import java.util.Objects;
import javax.net.ssl.HttpsURLConnection;
import java.lang.Object;
import java.util.Base64;
import javax.net.ssl.*;


public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Start.");
		InetAddress iAddress = InetAddress.getByName("webdav.yandex.ru");
		Socket ClientSocket = new Socket(iAddress, 80);
		String myrequest = "DELETE /test/ HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic dGVzdHdlYmRhdnZzdTIwMTg6dnN1MjAxOGZtaWl0MjQ=\r\n\r\n";
		OutputStream os = ClientSocket.getOutputStream();
		os.write(myrequest.getBytes());
		os.flush();

		InputStream is = ClientSocket.getInputStream();
		int ch;
		while( (ch=is.read())!= -1)
		    System.out.print((char)ch); 
		

		StringBuilder sb = new StringBuilder();
		while((ch = is.read()) != -1)
		    sb.append((char)ch);	
		System.out.print((char)ch); 	
			
	
		//conn.setDoOutput(true);
        //conn.setRequestMethod("PROPFIND");
        //conn.setRequestProperty("Host", "webdav.yandex.com");
       // conn.setRequestProperty("Accept", "*/*");
        /*conn.setRequestProperty("Depth", "1");
        conn.setRequestProperty("Authorization", "Basic dGVzdHdlYmRhdnZzdTIwMTg6dnN1MjAxOGZtaWl0MjQ=");
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        InputStream is = conn.getInputStream();
        
        OutputStreamWriter osw= new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
   
        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            System.out.println(inputLine);
        }

        br.close();*/
		ClientSocket.close();
		System.out.println("Finish.");
    }
}




