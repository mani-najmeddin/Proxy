import java.io.*;
import java.net.*;

public class SimpleProxy {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(1080);

        System.out.println("Proxy running on port 1080");

        while (true) {
            Socket client = server.accept();
            new Thread(() -> handle(client)).start();
        }
    }

    static void handle(Socket client) {
        try {

            BufferedReader reader =
                new BufferedReader(new InputStreamReader(client.getInputStream()));

            String firstLine = reader.readLine();

            String host = firstLine.split(" ")[1];

            String[] parts = host.split(":");

            Socket target =
                new Socket(parts[0], Integer.parseInt(parts[1]));

            relay(client, target);
            relay(target, client);

        } catch (Exception e) {
        }
    }

    static void relay(Socket in, Socket out) {
        new Thread(() -> {
            try {
                InputStream is = in.getInputStream();
                OutputStream os = out.getOutputStream();

                byte[] buffer = new byte[8192];
                int len;

                while ((len = is.read(buffer)) != -1) {
                    os.write(buffer, 0, len);
                    os.flush();
                }

            } catch (Exception e) {
            }
        }).start();
    }
}
