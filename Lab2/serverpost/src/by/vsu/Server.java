package by.vsu;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server extends Thread{

    private static BufferedReader br = null;
    private static PrintWriter pw = null;
    private static final int port  = 110;
    private String TEMPL_CONN = "The client closed the connection";
    private String USR = "alex";
    private String PASS = "1234";
    private static String[][] LIST = new String[10][10];
    private static String[][] MESSAGE = new String[10][10];
    private Socket socket;
    private int num;
    private static char[] buf = new char[1000];
    public static void systemSend(String buf)
    {
        pw.println(buf);
    }

    public static void work(String str)
    {
        String COMMAND;
        COMMAND = str;
        if(COMMAND.contains("LIST")) {
            int count = 0;
            int i = 0;
            pw.println("+OK scan listing follows");
            while(i < buf.length){
                if(buf[i] == '\r' && buf[i+1] == '\n' && buf[i+2] == '\r' && buf[i+3] == '\n'){
                    pw.println(count);
                    count++;
                    i += 4;
                }
                i++;
            }
            if(count == 0){
                pw.println(".");
            }

        }
        else if(COMMAND.contains("RETR")){
            int count = 0;
            int i = 0;
            int cnt = 0;
            boolean flag = false;
            String b = String.valueOf(count);
            while(i < buf.length){
            	if(buf[i] == '\r' && buf[i+1] == '\n' && buf[i+2] == '\r' && buf[i+3] == '\n'){
                    if(COMMAND.substring(5,COMMAND.length()).equals(b)){
                        flag = true;
                        pw.println();
                        for(int k = cnt; k < i; k++){
                            pw.print(buf[k]);
                        }
                    }
                    count++;
                    b = b.valueOf(count);
                    i += 4;
                    cnt = i;
                }
                i++;
            }
            if(!flag){
                pw.println();
                pw.println("-ERR no such message");
                pw.println();
            }
            pw.println();
        }
        else if(COMMAND.contains("DELE")){
            int count = 0;
            int count1 = 0;
            int i = 0;
            int n = 0;
            int cnt = 0;
            File sourceFile = new File("c:\\Users\\\\Алексей\\eclipse-workspace\\serverpost\\src\\by\\vsu\\mail.txt");
            File outputFile = new File("c:\\Users\\Алексей\\eclipse-workspace\\serverpost\\src\\by\\vsu\\buf.txt");
            boolean flag = false;
            String b = String.valueOf(count);
            while(n < buf.length){
            	if(buf[n] == '\r' && buf[n+1] == '\n' && buf[n+2] == '\r' && buf[n+3] == '\n'){
                    count1++;
                    n += 4;
                }
                n++;
            }
            //pw.println(count1);
            while(i < buf.length){
            	if(buf[i] == '\r' && buf[i+1] == '\n' && buf[i+2] == '\r' && buf[i+3] == '\n'){
                    if(COMMAND.substring(5,COMMAND.length()).equals(b)){
                        flag = true;
                        String myStr1 = new String(buf);
                        String myStr2;
                        String myStr3;
                        if(i + 6 < myStr1.length()) {
                            myStr2 = myStr1.substring(0, cnt);
                            myStr3 = myStr1.substring(i + 4, myStr1.length());
                            myStr1 = myStr2 + myStr3;
                            myStr1 = myStr1.substring(0, myStr1.length() - 2);
                        }
                        else{
                            myStr2 = myStr1.substring(0, cnt);
                            myStr1 = myStr2;
                        }
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(new File("c:\\Users\\Алексей\\eclipse-workspace\\serverpost\\src\\by\\vsu\\mail.txt")));
                            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("c:\\Users\\Алексей\\eclipse-workspace\\serverpost\\src\\by\\vsu\\buf.txt")));
                            if(count1 == 1) {
                            	reader.close();
                                writer.close();
                            	sourceFile.delete();
                                outputFile.renameTo(sourceFile);
                                pw.println("+OK message deleted");
                            } else {
                            	writer.write(myStr1);
                                writer.newLine();
                                reader.close();
                                writer.close();
                                sourceFile.delete();
                                outputFile.renameTo(sourceFile);
                                pw.println("+OK message deleted");
                            }
                            

                        } catch (Exception e) {
                            System.err.println("Error in file cleaning: " + e.getMessage());
                        }
                    }
                    count++;
                    b = b.valueOf(count);
                    i += 4;
                    cnt = i;
                }
                i++;
            }
            if(!flag){
                pw.println();
                pw.println("-ERR no such message");
                pw.println();
            }
            read();
        }
        else if(COMMAND.contains("STAT")) {
            int count = 0;
            int i = 0;
            while(i < buf.length){
            	if(buf[i] == '\r' && buf[i+1] == '\n' && buf[i+2] == '\r' && buf[i+3] == '\n'){
                    count++;
                    i += 4;
                }
                i++;
            }
            if(count == 0){
                pw.println("EMPTY");
            }
            else{
                pw.print(count);
                pw.println(" MESSAGES");
            }
        }
        else if(COMMAND.contains("TOP")) {
            int count = 0;
            int i = 0;
            int cnt = 0;
            int mood = 0;
            boolean flag = false;
            String b = String.valueOf(count);
            String c = String.valueOf(mood);
            System.out.println(COMMAND.substring(6, 7));
            while(i < buf.length){
            	if(buf[i] == '\r' && buf[i+1] == '\n' && buf[i+2] == '\r' && buf[i+3] == '\n'){
                    if(COMMAND.substring(4, 5).equals(b)){
                        flag = true;
                        pw.println(count);
                        for(int k = cnt; k < i; k++){
                            pw.print(buf[k]);
                            if(buf[k] == '\r'){
                                if(COMMAND.substring(6,7).equals(c)){
                                    break;
                                }
                                else{
                                    mood++;
                                    c = c.valueOf(mood);
                                }
                            }

                        }
                    }
                    count++;
                    b = b.valueOf(count);
                    i += 4;
                    cnt = i;
                }
                i++;
            }
            if(!flag){
                pw.println();
                pw.println("-ERR no such message");
                pw.println();
            }
            pw.println();
        }
        else {
            systemSend("-ERR");
        }
    }

    public static String receive() throws IOException
    {
        String response = br.readLine();
        System.out.println("Client send:  " + response);
        return response;
    }

    public Server() {}

    public void setSocket(int num, Socket socket)
    {

        this.num    = num;
        this.socket = socket;

        setDaemon(true);

        setPriority(NORM_PRIORITY);

        start();
    }
    public void run()
    {

        try {
            br = new BufferedReader ( new InputStreamReader(this.socket.getInputStream()));
            pw = new PrintWriter(new BufferedWriter(new	OutputStreamWriter(this.socket.getOutputStream())), true);
            String Input = null;
            systemSend("USER: ");
            while(true) {
                Input = receive();
                if(Input.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    System.out.println(String.format(TEMPL_CONN, num));
                    stop();
                }
                if(Input.equals(USR)) {
                    systemSend("+OK name is a valid mailbox");
                    break;
                }
                else {
                    systemSend("Invalid username!\r\nUSER: ");
                }
            }

            systemSend("PASS: ");
            while(true) {
                Input = receive();
                if(Input.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    System.out.println(String.format(TEMPL_CONN, num));
                    stop();
                }
                if(Input.equals(PASS)) {
                    systemSend("+OK maildrop locked and ready");
                    break;
                }
                else {
                    systemSend("Invalid Password!\r\nPASSWORD: ");
                }
            }
            systemSend("Connection successfull: server waiting for a command");
            while(true) {
                Input = receive();
                System.out.println();
                if (Input.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    System.out.println(String.format(TEMPL_CONN, num));
                    stop();
                }
                work(Input);
            }
        } catch(Exception e) {
            System.out.println("Exception : " + e);
        }
    }
    //-------------------------------------------------------------------
    public static void read(){
        try(FileReader reader = new FileReader("c:\\Users\\Алексей\\eclipse-workspace\\serverpost\\src\\by\\vsu\\mail.txt"))
        {
            int c;
            while((c = reader.read(buf))>0){

                if(c < 1000){
                    buf = Arrays.copyOf(buf, c);
                }
            }
            //reader.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] ar)
    {
        read();
        for (int i = 0 ; i < LIST.length ; i++) {
            MESSAGE[0][i] = "TEST";
        }
        for (int i = 0 ; i < LIST.length ; i++) {
            LIST[0][i] = i + " " + MESSAGE[0][i].length();
        }

        ServerSocket srvSocket = null;
        try {
            try {
                int i = 0;
                String inet = "127.0.0.1";
                InetAddress ia = InetAddress.getByName(inet);
                //System.out.println(ia);
           
                srvSocket = new ServerSocket(port, 0, ia);

                System.out.println("Server started\n\n");

                while(true) {
                    Socket socket = srvSocket.accept();
                    System.out.println("Client accepted");
                    new Server().setSocket(++i, socket);
                }
            } catch(Exception e) {
                System.out.println("Exception : " + e);
            }
        } finally {
            try {
                if (srvSocket != null)
                    srvSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
