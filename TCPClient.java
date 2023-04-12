import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String... args) {
        String host = args[0];
        int port = Integer.valueOf(args[1]);

        try (Socket sock = new Socket(host, port)) {
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            String get = "GET / HTTP/1.0\n\n";
            out.write(get.getBytes());
            int readChar = 0;
            while ((readChar = in.read()) != -1) {
                System.out.write(readChar);
            }
        }
        // catch exception: Just prints out throwable with other diagnostic info
        catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
}
