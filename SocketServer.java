
package socketserver;
import java.io.*;
import java.net.*;

public class SocketServer {

    public static void main(String[] args) throws IOException{
        String clienGelen;
        ServerSocket serverSocket=null;
        Socket clientSocket=null;
        
        int sayi;
        
        try{
            serverSocket=new ServerSocket(7845);
        }catch(Exception ex){
            System.out.println("Port Hatasi");
        }
        System.out.println("Server başlamak için hazır..");
        clientSocket=serverSocket.accept();
        PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while((clienGelen = in.readLine())!=null){
            System.out.println("Clientten gelen veri ="+clienGelen);
            sayi=Integer.valueOf(clienGelen);
            out.println(sayi*sayi);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
       
        
        
    }
    
}
