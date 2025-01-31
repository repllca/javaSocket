import java.io.*;
import java.net.*;
public class Main {
  public static void main(String[] args) {
    // -----------------------------------------
    // -----------------------------------------
    try (ServerSocket server = new ServerSocket(10000)) {
      while (true) {
        try {
          // -----------------------------------------
          // -----------------------------------------
          Socket sc = server.accept();
          System.out.println("There was a connection from a client.");
          BufferedReader reader = null;
          PrintWriter writer = null;
          // -----------------------------------------
          // -----------------------------------------
          try {
            reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            writer = new PrintWriter(sc.getOutputStream(), true);
            String line = null;
            while (true) {
              line = reader.readLine();
              if (line.equals("exit")) {
                break;
              }
              System.out.println("Message from client =" + line);
              writer.println("Please input:");              
            }
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            // リソースの解放
            if (reader != null)
              reader.close();
            if (writer != null)
              writer.close();
            if (sc != null)
              sc.close();
          }
        } catch (Exception ex) {
          ex.printStackTrace();
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}