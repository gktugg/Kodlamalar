
package socketapp;
import java.io.*;
import java.net.*;
public class SocketApp {

    public static void main(String[] args) throws IOException {
     islem();
    }
    public static void islem() throws UnknownHostException,IOException{
  
Socket socket=null;
PrintWriter out=null;
BufferedReader in=null;
String deger;
try{
    socket=new Socket("170.20.10.4",7845);

}catch(Exception ex){
    System.out.println("Port Hatası");
}
out=new PrintWriter(socket.getOutputStream(),true);
in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Server'a gönderilecek sayı giriniz");
        
BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
while((deger=data.readLine()) != null){
    out.println(deger);
    System.out.println("Serverdan gelen sonuç"+in.readLine());
    System.out.println("Servara gönderilecek sayı giriniz");
}
    out.close();
    in.close();
    data.close();
    socket.close();
}

}
