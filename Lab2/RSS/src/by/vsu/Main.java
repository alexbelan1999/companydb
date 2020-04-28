package by.vsu;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {

            Scanner sc = new Scanner(System.in);

            String URL = sc.nextLine();

            int t = URL.indexOf("/");

            String host;

            String page;

            if (t == -1) {
                host = URL;
                page = "/";
            } else {
                host = URL.substring(0, t);
                page = URL.substring(t);
            }

            try {
                InetAddress iAddress = InetAddress.getByName(host);
                Socket ClientSocket = new Socket(iAddress, 80);

                BufferedReader br = null;
                PrintWriter pw = null;
                br = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(ClientSocket.getOutputStream())), true);

                StringBuilder request = new StringBuilder();
                request.append("GET ").append(page).append(" HTTP/1.1\r\nHost: ").append(host).append("\r\n\r\n");

                pw.println(request.toString());
                char[] buf = new char[100000000];

                int l = br.read(buf);
                String response = new String(buf);
                StringBuilder s = new StringBuilder(response);
                s.replace(l, s.length(), "");
                response = s.toString();
                pw.close();
                ClientSocket.close();

                System.out.println(response.substring(0, response.indexOf("\r\n")));
                response = response.substring(response.indexOf("<item>"));
                // System.out.println(response);

                while (response.contains("<item>") && response.contains("</item>")) {
                	String str = response.substring(response.indexOf("<title>") + 7,response.indexOf("</title>"));
                	PrintStream printStream = new PrintStream(System.out, true, "utf-8"); 
                	printStream.println(str);
                	System.out.println(str);
                    System.out.println(response.substring(response.indexOf("<link>") + 6,response.indexOf("</link>")));
                    System.out.println(response.substring(response.indexOf("<pubDate>") + 9,response.indexOf("</pubDate>")) + "\n\n");
                    response = response.replace(response.substring(response.indexOf("<item>"),response.indexOf("</item>") + 7), "");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }
}

