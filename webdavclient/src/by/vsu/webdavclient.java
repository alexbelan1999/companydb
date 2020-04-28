package by.vsu;

import java.net.*; 
import java.io.*; 
import java.util.*; 
import javax.net.ssl.*;
import java.security.*;
import java.security.MessageDigest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.Base64;
public class webdavclient {
	
	public static void main(String[] arstring) {
		try {
			System.out.println("Start work.");
			System.out.println("Введите логин: ");
			Scanner sc = new Scanner(System.in);
			String login = sc.nextLine();
            System.out.println("Введите пароль: ");
            String password = sc.nextLine();
            String logpass = login + ":" + password;
			byte[] bytes = logpass.getBytes("UTF-8") ;
			String encoded = Base64.getEncoder().encodeToString(bytes);
			
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("webdav.yandex.ru", 443);
			
			OutputStream outputstream = sslsocket.getOutputStream();
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
			BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
			int action = 0;
			System.out.println("Выберете необходимое действие для работы: 0 - Выход; 1 - MKCOL; 2 - COPY; 3 - MOVE; 4 - DELETE; 5 - PROPFIND; 6 - GET; 7 - PUT");
			action = sc.nextInt();
		
			
				switch (action) {
				case 0: {
					
					break;
				}
				case 1:{
					String path = null;
					System.out.println("Введите путь для создания каталога: /");
					path = sc.next();
					String string = "MKCOL /" + path + " HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic " + encoded + "\r\n\r\n";
					bufferedwriter.write(string);
					bufferedwriter.flush();
					InputStream is = sslsocket.getInputStream();
			        int ch;
					while( (ch=is.read())!= -1) {
						
					    System.out.print((char)ch); 
					    if ((char)ch == ')') {
					    	break;	
					    }
					    action = 0;
					}
					
					is.close();
					break;
				}
				case 2:
				{
					String path1 = null;
					System.out.println("Введите путь к файлу: /");
					path1 = sc.next();
					String path2;
					System.out.println("Введите путь куда скопировать файл: /");
					path2 = sc.next();
					String rewrite;
					System.out.println("Разрешить перезапись файла: Да - T; Нет - F ");
					rewrite = sc.next();
					String string = "COPY /" + path1 + " HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic " + encoded + "\r\nDestination: /" + path2 + "\r\nOverwrite: "+rewrite+"\r\n\r\n";
					bufferedwriter.write(string);
					bufferedwriter.flush();
					InputStream is = sslsocket.getInputStream();
			        int ch;
					while( (ch=is.read())!= -1) {
						
					    System.out.print((char)ch); 
					    if ((char)ch == ')') {
					    	break;	
					    }
					    
					}
					
					is.close();
					break;
				}
				case 3:
				{
					String path1 = null;
					System.out.println("Введите путь к файлу: /");
					path1 = sc.next();
					String path2;
					System.out.println("Введите путь куда переместить файл | изменить его название : /");
					path2 = sc.next();
					String rewrite;
					System.out.println("Разрешить перезапись файла: Да - T; Нет - F ");
					rewrite = sc.next();
					String string = "MOVE /" + path1 + " HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic " + encoded + "\r\nDestination: /" + path2 + "\r\nOverwrite: " + rewrite + "\r\n\r\n";
					bufferedwriter.write(string);
					bufferedwriter.flush();
					InputStream is = sslsocket.getInputStream();
			        int ch;
					while( (ch=is.read())!= -1) {
						
					    System.out.print((char)ch); 
					    if ((char)ch == ')') {
					    	break;	
					    }
					    
					}
					
					is.close();
					break;
					
				}
				case 4:
				{
					String path = null;
					System.out.println("Введите путь для удаления папки|файла: /");
					path = sc.next();
					String string = "DELETE /" + path + " HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic " + encoded + "\r\n\r\n";
					bufferedwriter.write(string);
					bufferedwriter.flush();
					InputStream is = sslsocket.getInputStream();
			        int ch;
					while( (ch=is.read())!= -1) {
						
					    System.out.print((char)ch); 
					    if ((char)ch == ')') {
					    	break;	
					    }
					    
					}
					
					is.close();
					break;

				}
				case 5:
				{
					String path = null;
					System.out.println("Введите путь для получения информации о  папке|файле: /");
					path = sc.next();
					String string = "PROPFIND /" + path + " HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic " + encoded + "\r\n\r\n";
					bufferedwriter.write(string);
					bufferedwriter.flush();
					InputStream is = sslsocket.getInputStream();
					
			        int ch;
					while( (ch=is.read())!= -1) {
						
					    System.out.print((char)ch); 
							}	
					is.close();
					break;

				}
				case 6:
				{
					String path = null;
					System.out.println("Введите путь к файлу: /");
					path = sc.next();
					String path1 = null;
					System.out.println("Введите путь для сохранения файла: ");
					path1 = sc.next();
					FileOutputStream out = new FileOutputStream(path1);
					InputStream in = sslsocket.getInputStream();
					String string = "GET /" + path +" HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic "+ encoded+ "\r\n\r\n";
					bufferedwriter.write(string);
					bufferedwriter.flush();
			
			        int read ;
			        int count = 1;
			        int index;
			        byte[] buffer = new byte[4096];
			       
			        while((read = in.read(buffer, 0 ,4096)) != -1){
			        	String response = new String(buffer);
			        	index = response.indexOf("\r\n\r\n");
			        	System.out.println(read);
			        	if (count == 1) {
			        		out.write(buffer,index+4, read-index-4);
			        	}else
			        	{
			        	out.write(buffer,0 , read);
			        	}
			            count++;
			            if (read != 4096) {
			            	break;
			            }
			        }
			        
			        out.close();
			        in.close();
			        break;
				}
				case 7:
				{	
					String path1 = null;
					String path2 = null;
					System.out.println("Введите путь к файлу: /");
					path1 = sc.next();
					System.out.println("Введите путь для сохранения файла: /");
					path2 = sc.next();
					Path path = Paths.get(path1);
			         
					byte[] data = Files.readAllBytes(path);
					System.out.println(data.length);
					
					MessageDigest md = MessageDigest.getInstance("MD5");
					MessageDigest sha = MessageDigest.getInstance("SHA-256");
				    FileInputStream fis = new FileInputStream(path1);

				    byte[] dataBytes = new byte[4096];

				    int nread = 0;
				    while ((nread = fis.read(dataBytes)) != -1) {
				        md.update(dataBytes, 0, nread);
				        sha.update(dataBytes, 0, nread);
				    };
				    byte[] mdbytes = md.digest();
				    byte[] shabytes = sha.digest();
				    StringBuffer sb1 = new StringBuffer();
				    StringBuffer sb2 = new StringBuffer();
				    for (int i = 0; i < mdbytes.length; i++) {
				        sb1.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
				    }
				    for (int i = 0; i < shabytes.length; i++) {
				        sb2.append(Integer.toString((shabytes[i] & 0xff) + 0x100, 16).substring(1));
				    }
				    int size = data.length;
				    String sizestr = Integer.toString(size);
				    String str = new String(data);
				    String string = "PUT /" + path2 + " HTTP/1.1\r\nHost: webdav.yandex.com\r\nAccept: */*\r\nAuthorization: Basic "+ encoded +"\r\nEtag: " + sb1.toString() + "\r\nSha256: " + sb2.toString() + "\r\nExpect: 100-continue\r\nContent-Type: application/binary\r\nContent-Length: " + sizestr +"\r\n\r\n" + str;
				    //System.out.println(string);
				    
				
		
				    bufferedwriter.write(string);
				    bufferedwriter.flush();
				    InputStream is = sslsocket.getInputStream();
				    
			        int ch;
					while( (ch=is.read())!= -1) {
						
					    System.out.print((char)ch); 
							}	
					is.close();
					break;
				    
				}
				default:{
					System.out.println("Выберете необходимое действие для работы: 0 - Выход; 1 - MKCOL; 2 - COPY; 3 - MOVE; 4 - DELETE; 5 - PROPFIND; 6 - GET;7 - PUT;");
					
				}
				break;
				}
			
			
			sslsocket.close();
			System.out.println("\r\nFinish.");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
